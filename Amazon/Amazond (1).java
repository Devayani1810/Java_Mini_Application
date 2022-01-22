import java.util.*;
class Amazond{
    private static Scanner sc;
    public static void main(String[] args){
        sc=new Scanner(System.in);
        mainfunc();
    }
    static void mainfunc(){
        Amazond.clear();
        System.out.println("********** WELCOME TO AMAZON **********");
        System.out.println();
        System.out.println("PLEASE ENTER 1 IF YOU ARE A ADMIN");
        System.out.println("PLEASE ENTER 2 IF YOU ARE A MERCHANT");
        System.out.println("PLEASE ENTER 3 IF YOU ARE A USER");
        System.out.println("ENTER 4 IF YOU NEED TO EXIT");
        System.out.println();
        System.out.println("PLEASE ENTER ANY OF THE ABOVE OPTIONS");

    int options=sc.nextInt();
    switch(options){
        case 1:
            Admin.admin_login();
            break;
        case 2:
            Merchant.Merchant_land();
            break;
        case 3:
            User.user_land();
            break;
        case 4:
            System.exit(0);
            break;
        default:
             System.out.println("Invalid Input");
             break;                             
            
        }
    }
    static void clear(){
        System.out.println("\033[H\033[2J");
    }
}
class Admin{
    static Scanner sc=new Scanner(System.in);
    static List<String>mer_name=new ArrayList<>();
    static List<String>mer_pass=new ArrayList<>();
    static List<String>mer_sta=new ArrayList<>();
    static List<String>product=new ArrayList<>();
    static List<Integer> count = new ArrayList<>();
    static List<Integer> count1 = new ArrayList<>();
    static List<Integer> cost = new ArrayList<>();
    
    static int user=0;


    static void admin_login(){
        Amazond.clear();
        System.out.println("********** WELOCME ADMIN **********");
        String username="admind";
        String password="admin";
        System.out.println("PLEASE ENTER YOUR USERNAME");
        String usr=sc.next();
        System.out.println("");
        System.out.println("PLEASE ENTER YOUR PASSWORD");
        String pass=sc.next();
        if((username.equals(usr)) && (password.equals(pass))){
            adminfunc();
        }
        else{
            System.out.println("Invalid Input");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                Amazond.mainfunc();
            }
            catch(Exception e){

            }
            
        }
    }
    static void adminfunc(){
        Amazond.clear();
        System.out.println("PLEASE ENTER 1 APPROVE THE MERCHANT ");
        System.out.println("PLEASE ENTER 2 TO SEE THE LIST OF MERCHANTS");
        System.out.println("PLEASE ENTER 3 TO DELETE THE MERCHANTS");
        System.out.println("PLEASE ENTER 4 TO VIEW ALL PRODUCTS");
        System.out.println("PLEASE ENTER 5 ADD THE PRODUCT");
        System.out.println("PLEASE ENTER 6 TO ADD A MERCHANT");
        System.out.println("PLEASE ENTER 7 TO DELETE THE PRODUCT");
        System.out.println("PLEASE ENTER 8 TO GO BACK");

        int admin_options=sc.nextInt();
        switch(admin_options){
            case 1:
                approve_merchant();
                break;
            case 2:
                show_merchants();
                break;
            case 3:
                delete_merchants();
                break;
            
            case 4:
                view_products();
                break;
            case 5:
                add_product();
                break;
            case 6:
                 add_merchant();
                 break;
            case 7:
                delete_products();
                break;
            case 8:
                Amazond.mainfunc();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
    static void add_merchant(){
        Amazond.clear();
        System.out.println("ENTER THE USERNAME OF THE MERCHANT");
        String u=sc.next();
        System.out.println();
        System.out.println("ENTER THE PASSWORD OF THE MERCHANT");
        String p=sc.next();
        mer_name.add(u);
        mer_pass.add(p);
        mer_sta.add("pass");
        System.out.println("");
        System.out.println("THE MERCHANT"+" "+u+" "+"HAS ADDED SUCCESSFULLY");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }
    } 
    static void show_merchants(){
        Amazond.clear();
        System.out.println("******* THE MERCHANTS ARE *******");
        if(mer_name.size()>0){
            for(int i=0;i<mer_name.size();i++){
                System.out.println(mer_name.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println("THERE IS NO MERCHANTS ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }

        }
    }
    static void approve_merchant(){
        Amazond.clear();
        for(int i=0;i<mer_sta.size();i++){
            if(mer_sta.get(i).equals("fail")){
                System.out.println("DO YOU WANT TO APPROVE THE MERCHNANT "+mer_name.get(i)+" .IF YES TYPE 1");
                int ab=sc.nextInt();
                if(ab==1){
                    mer_sta.set(i,"pass");
                    System.out.println("THE MERCHANT "+mer_name.get(i)+" HAS BEEN APPROVED");
                    System.out.println();
                }
                else{
                    System.out.println();
                    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                    try{
                        System.in.read();
                        adminfunc();
                    }
                    catch(Exception e){

                    }

                }
            }
            else{
                System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");
                try{
                    System.in.read();
                    adminfunc();
                }catch(Exception e){
                }
            }
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            adminfunc();
        }
        catch(Exception e){

        }
    } 
    static void delete_merchants(){
        Amazond.clear();
        System.out.println("ENTER THE MERCHANT USERNAME TO DELETE ");
        String u=sc.next();
        boolean flag=false;
        for(int i=0;i<mer_name.size();i++){
            if(mer_name.get(i).equals(u)){
            flag=true;
            user=i;
            }
        }
        if(flag){
            mer_name.remove(user);
            mer_pass.remove(user);
            mer_sta.remove(user);
            System.out.println();
            System.out.println("THE MERCHANT HAS SUCCESSFULLY REMOVED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println("THE MERCHANT IS NOT FOUND PLEASE ENTER VALID MENCHANT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
        }
    }
    static void view_products(){
        Amazond.clear();
        if(product.size()>0){
            System.out.println("THE PRODUCTS ARE");
            System.out.println();
            System.out.println("PRODUCT"+"\t"+"QUANTITY"+"\t"+"COST");
            System.out.println();
            for(int i=0;i<product.size();i++){
                System.out.println(product.get(i)+"\t"+count.get(i)+"\t"+cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
        }
        else{

            System.out.println("THERE IS NO PRODUCTS AVAILABLE ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
            

        }
    }
    static void add_product(){
        Amazond.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO ADD");
        String pro=sc.next();
        System.out.println();
        System.out.println("ENTER THE NUMBER OF THE PRODUCT TO ADD");
        int num_pro=sc.nextInt();
        System.out.println();
        System.out.println("ENTER THE COST OF THE PRODUCT ");
        int cos_pro=sc.nextInt();
        System.out.println();
        product.add(pro);
        count.add(num_pro);
        count1.add(num_pro);
        cost.add(cos_pro);
        System.out.println();
        System.out.println("THE PRODUCT "+pro+" HAS SUCCESSFULLY ADDED");
        System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
    }
    static void delete_products(){
        Amazond.clear();
        System.out.println("ENTER THE PRODUCT NAME TO DELETE ");
        String u=sc.next();
        boolean flag=false;
        for(int i=0;i<product.size();i++){
            if(product.get(i).equals(u)){
            flag=true;
            user=i;
            }
        }
        if(flag){
            product.remove(user);
            count.remove(user);
            count1.remove(user);
            cost.remove(user);
            System.out.println();
            System.out.println("THE PRODUCT HAS SUCCESSFULLY REMOVED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println("THE PRODUCT IS NOT FOUND PLEASE ENTER VALID PRODUCT");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                adminfunc();
            }
            catch(Exception e){

            }
        }

    }
}
class Merchant{
    static Scanner sc=new Scanner(System.in);
    static void Merchant_land(){
        Amazond.clear();
        System.out.println("********** WELOCME MERCHANT **********");
        System.out.println();
        System.out.println("PLEASE ENTER 1 REGISTER ");
        System.out.println("PLEASE ENTER 2 TO LOGIN ");
        System.out.println("PLEASE ENTER 3 TO GO BACK ");
        int log=sc.nextInt();

        switch(log){
            case 1:
                merchant_reg();
                break;
            case 2:
                merchant_login();
                break;
            case 3:
                Amazond.mainfunc();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
    static void merchant_reg(){
        Amazond.clear();
        System.out.println("ENTER YOUR USERNAME");
        String usr_reg=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String pass_reg=sc.next();
        Admin.mer_name.add(usr_reg);
        Admin.mer_pass.add(pass_reg);
        Admin.mer_sta.add("fail");
        System.out.println();
        System.out.println("MERCHNANT HAS BEEN ADDED AND WAITING FOR APPROVAL");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            Merchant_land();
        }catch(Exception e){

        }

    }
    static void merchant_login(){
        Amazond.clear();
        System.out.println("ENTER YOUR USERNAME");
        String u=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String pass=sc.next();
        int a=0;
        for(int i=0;i<Admin.mer_name.size();i++){
            if(Admin.mer_name.get(i).equals(u)){
                a=i;
            }
        }
        if((Admin.mer_name.get(a).equals(u)) && (pass.equals(Admin.mer_pass.get(a))) && (Admin.mer_sta.get(a).equals("pass"))){
                merchant_func();
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD OR NOT APPROVED");
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                Merchant_land();
            } catch (Exception e) {
            }
        }
    }
    static void merchant_func(){
        Amazond.clear();
        System.out.println("PLEASE ENTER 1 TO ADD A PRODUCT");
        System.out.println("PLEASE ENTER 2 TO UPDATE PRODUCT");
        System.out.println("PLEASE ENTER 3 TO VIEW MOST SOLD PRODUCT");
        System.out.println("PLEASE ENTER 4 TO VIEW SALES REPORT");
        System.out.println("PLEASE ENTER 5 TO VIEW ALL PRODUCTS");
        System.out.println("PLEASE ENTER 6 TO GO BACK");

        int n=sc.nextInt();
        switch(n){
        case 1:
            add_products();
            break;
        case 2:
            update_products();
            break;
        
        case 3:
            most_sold();
            break;
        case 4:
            sales_report();
            break;
        case 5:
            view_all();
            break;
        case 6:
            Merchant_land();
            break;
        default:
            System.out.println("Invalid Input");
            break;
        }
    }
    static void add_products(){
        Amazond.clear();
        System.out.println("ENTER NAME OF THE PRODUCT");
        String name_pro=sc.next();
        System.out.println();
        System.out.println("ENTER NUMBER OF PRODUCT");
        int num_pro=sc.nextInt();
        System.out.println();
        System.out.println("ENTER COST OF THE PRODUCT");
        int cost_pro=sc.nextInt();
        System.out.println();
        Admin.product.add(name_pro);
        Admin.count.add(num_pro);
        Admin.count1.add(num_pro);
        Admin.cost.add(cost_pro);
        System.out.println();
        System.out.println("THE PRODUCT "+name_pro+" HAS SUCCESSFULLY ADDED");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            merchant_func();
        }catch(Exception e){

        }
    }
    static void update_products(){
        Amazond.clear();
        System.out.println("ENTER THE NAME OF THE PRODUCT TO UPDATE");
        String pro=sc.next();
        System.out.println();
        int us=0;
        boolean flag=false;
        for(int i=0;i<Admin.product.size();i++){
            if(Admin.product.get(i).equals(pro)){
                flag=true;
                us=i;
            }
        }
        if(flag){
            System.out.println("ENTER THE NUMBER OF ITEMS NEEDS TO BE UPDATED");
            int items=sc.nextInt();
            System.out.println();
            System.out.println("ENTER THE COST OF ITEM NEED TO BE UPDATED");
            int ct=sc.nextInt();
            Admin.count.set(us,items);
            Admin.cost.set(us,ct);
            System.out.println("THE ITEM "+pro+" HAS SUCCESSFULLY UPDATED");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println("THE PRODUCT IS NOT AVAILABLE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }

        }

    }
    static void most_sold(){
        Amazond.clear();
        int max=0;
        int n=0;
        for(int i=0;i<Admin.count.size();i++){
            if((Admin.count1.get(i)-Admin.count.get(i))>max){
                max=Admin.count1.get(i)-Admin.count.get(i);
                n=i;
            }
        }
        System.out.println("THE MOST SOLD PRODUCT ");
        System.out.println();
        System.out.println(Admin.product.get(n)+" "+max+" SOLD");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            merchant_func();
        }
        catch(Exception e){

        }
    }
    static void sales_report(){
        Amazond.clear();
        System.out.println("THE SALES REPORT");
        System.out.println();
        for(int i=0;i<User.report.size();i++){
            System.out.println(User.report.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try{
            System.in.read();
            merchant_func();
        }
        catch(Exception e){

        }
    }
    static void view_all(){
        Amazond.clear();
        if(Admin.product.size()>0){
            System.out.println("THE PRODUCTS AVAILABLE ARE");
            System.out.println();
            System.out.println("PRODUCT"+"\t"+"QUANTITY"+"  "+"COST");
            System.out.println();
            for(int i=0;i<Admin.product.size();i++){
                System.out.println(Admin.product.get(i)+"\t"+Admin.count.get(i)+"\t"+Admin.cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();;
            }
            catch(Exception e){

            }

        }
        else{

            System.out.println("THERE IS NO PRODUCTS AVAILABLE ");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                merchant_func();
            }
            catch(Exception e){

            }
            

        }

    }
}
class User{
    static List<String>uname=new ArrayList<>();
    static List<String>upass=new ArrayList<>();
    static List<String> cart = new ArrayList<>();
    static List<String> history = new ArrayList<>();
    static List<String> report = new ArrayList<>();

    static Scanner sc=new Scanner(System.in);
    
    static void user_land(){
        Amazond.clear();
        System.out.println("********** WELOCME USER **********");
        System.out.println();
        System.out.println("PLEASE ENTER 1 TO REGISTER ");
        System.out.println("PLEASE ENTER 2 TO LOGIN ");
        System.out.println("PLEASE ENTER 3 TO GO BACK ");
        int sor=sc.nextInt();
        switch(sor){
            case 1:
                user_reg();
                break;
            case 2:
                user_login();
                break;
            case 3:
                Amazond.mainfunc();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
    static void user_reg(){
        Amazond.clear();
        System.out.println("ENTER YOUR USERNAME");
        String reg_name=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String pass=sc.next();
        System.out.println();
        uname.add(reg_name);
        upass.add(pass);
        System.out.println();
        System.out.println("REGISTRATION HAS BEEN COMPLETED ADN YOU CAN LOGIN ");
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
        try {
            System.in.read();
            user_land();
        } catch (Exception e) {
        }
    }
    static void user_login(){
        Amazond.clear();
        int us=0;
        System.out.println("ENTER YOUR USERNAME");
        String u=sc.next();
        System.out.println();
        System.out.println("ENTER YOUR PASSWORD");
        String p=sc.next();
        System.out.println();
        for(int i=0;i<uname.size();i++){
            if(uname.get(i).equals(u) && upass.get(i).equals(p)){
                us=i;
            }
        }
        if(uname.get(us).equals(u) && upass.get(us).equals(p)){
            user_func();
        }
        else{
            System.out.println("INVALID USERNAME OR PASSWORD");
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try {
                System.in.read();
                user_land();
            } catch (Exception e) {
            }
        }
    }
    static void user_func(){
        Amazond.clear();
        System.out.println("PLEASE ENTER 1 TO VIEW AVAILABLE PRODUCTS ");
        System.out.println("PLEASE ENTER 2 TO ADD PRODUCT TO CART");
        System.out.println("PLEASE ENTER 3 TO VIEW CART");
        System.out.println("PLEASE ENTER 4 TO VIEW PREVIOUS PURCHASE HISTORY");
        System.out.println("PLEASE ENTER 5 TO BUY ITEMS");
        System.out.println("PLEASE ENTER 6 TO GO BACK");
        int user_options=sc.nextInt();
        switch(user_options){
            case 1:
                view_products();
                break;
            case 2:
                cart();
                break;
            case 3:
                view_cart();
                break;
            case 4:
                history();
                break;
            case 5:
               buy_iteams();
               break;
            case 6:
                user_land();
                break;
            default:
                System.out.println("Invalid Inputs");
                break;
        }

    }
    static void view_products(){
        Amazond.clear();
        if(Admin.product.size()>0){
            System.out.println("THE PRODUCTS AVAILABLE ARE");
            for(int i=0;i<Admin.product.size();i++){
                System.out.println(Admin.product.get(i)+"\t"+Admin.cost.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");
            try{
                System.in.read();
                user_func();
            }catch(Exception e){

            }
        }
        else{
            System.out.println("THERE IS NO PRODUCTS AVAILABLE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");
            try{
                System.in.read();
                user_func();
            }catch(Exception e){

            }
        }
    }
    static void cart(){
        Amazond.clear();
        System.out.println("ENTER THE PRODUCT TO ADD IN CART");
        String pr=sc.next();
        for(int i=0;i<Admin.product.size();i++){
            if(Admin.product.get(i).equals(pr)){
                cart.add(pr);
                System.out.println();
                System.out.println("THE PRODUCT HAS SUCCESSFULLY ADDED TO THE CART");
            }
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER TO GO PREVIOUS MENU ");
        try{
            System.in.read();
            user_func();
        }
        catch(Exception e){

        }

    }
    static void view_cart(){
        Amazond.clear();
        if(cart.size()>0){
            for(int i=0;i<cart.size();i++){
                System.out.println(cart.get(i));
            }
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
                System.in.read();
                user_func();
            }
            catch(Exception e){

            }
        }
        else{
            System.out.println("THERE IS NO PRODUCT IN THE CART");
            System.out.println();
            System.out.println("LEASE PRESS ENTER FOR PREVIOUS MENU");
            try{
                System.in.read();
                user_func();
            }catch(Exception e){

            }
        }
    }
    static void history(){
        Amazond.clear();
        System.out.println("THE PURCHASED HISTORY");
        System.out.println();
        for(int i=0;i<history.size();i++){
            System.out.println(history.get(i));
        }
        System.out.println();
        System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU");
        try{
            System.in.read();
            user_func();
        }catch(Exception e){

        }
    }
    static void buy_iteams(){
        Amazond.clear();
        int x=0;
        System.out.println("ENTER THE ITEM NAME TO BE PURCHASED");
        String pr=sc.next();
        System.out.println();
        boolean flag=false;
        for(int i=0;i<Admin.product.size();i++){
            if(Admin.product.get(i).equals(pr)){
                flag=true;
                x=i;
            }
        }
        if(flag){
            System.out.println("ENTER THE QUANTITY TO BE PURCHASED");
            int c=sc.nextInt();
            if(c<=Admin.count.get(x)){
                int tot=c*Admin.cost.get(x);
                System.out.println("THE TOTAL AMOUNT IS "+tot);
                System.out.println();
                System.out.println("DO YOU WANT TO BUY (y or n) ");
                String ans=sc.next();
                if(ans.equals("y")){
                    Amazond.clear();
                    System.out.println("THE ITEMS HAS BEEN SUCCESSFULLY PURCHASED ");
                    history.add("THE ITEM "+pr+" OF QUANTITY "+c+" PURCHASED FOR "+tot+" RUPPEES");
                    report.add("THE ITEM "+pr+" OF QUANTITY "+c+" PURCHASED");
                    System.out.println();
                    int y=Admin.count.get(x);
                    y-=c;
                    Admin.count.set(x,y);
                    System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                    try{
                        System.in.read();
                        user_func();
                    }
                    catch(Exception e){

                    }

                }
                else{
                    user_func();
                }
            }
            else{
                Amazond.clear();
                System.out.println("THE PRODUCT IS NOT AVAILABE");
                System.out.println();
                System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
                try{
                    System.in.read();
                    user_func();
                }
                catch(Exception e){
                }

            }
        }
        else{
            Amazond.clear();
            System.out.println("THE PRODUCT IS NOT AVAILABE");
            System.out.println();
            System.out.println("PLEASE PRESS ENTER FOR PREVIOUS MENU ");
            try{
            System.in.read();
            user_func();
            }
            catch(Exception e){
            }

        }

    }

}
    