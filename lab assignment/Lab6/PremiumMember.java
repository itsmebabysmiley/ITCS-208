/**
 * PremiumMember
 */
import java.util.ArrayList;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class PremiumMember extends Member {

    private double fee;
    public static double Family_FEE = 80.00;
    private ArrayList<String> family = new ArrayList<String>();
    
    
    
    PremiumMember(String email, String password,double fee) {
        super(email, password);
        this.fee = fee;

    }

    public boolean addFamily(String username) {

            if(family.contains(username) || (family.size()==2)){
                System.out.println("user: " + username + "cannot be added, the Family user");
                return false;
            }else{
                family.add(username);
                System.out.println(username + " is added successfully.");
                return true;
            }
       
    }
    public boolean removeFamily(String username){
        if(family.contains(username)){
            System.out.println(username+" is removed successfully.");
            family.remove(username);
            return true;
        }else {
            System.out.println("user: "+ username+" does not exits and cannot be removed.");
            return false;
        }
    }
    public double getMonthlyBill(){

        return fee + Family_FEE;
    }

   
    @Override
    public void printMemberInfo() {
        System.out.println("---- PREMUIM MEMBER ----");
        System.out.println("Member fee: "+fee);
        super.printMemberInfo();
        

        //---------------Challenge--------------\\
        System.out.println("------------------------");
        System.out.println("List of Family");
        for (int i = 0; i < family.size() ; i++) {
            System.out.println(family.get(i));
        }
        
    }
    
}