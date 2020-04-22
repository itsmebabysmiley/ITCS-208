/**
 * Member
 */
import java.util.ArrayList;

public class Member {
    private String email;
    private String password;
    private ArrayList<Video> vdoList = new ArrayList<Video>();

    Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

   
   
   
    public boolean addVideo(Video vdo) {
        if(vdo != null){
            vdoList.add(vdo);
            return true;
        }else {
            return false;
        }

    }
    public boolean removeVideo(Video vdo) {
        for(int i = 0 ; i<vdoList.size();i++){
            if(vdoList.get(i).equals(vdo)){
                System.out.println(vdoList.get(i));
                vdoList.remove(i);
                System.out.println("is successfully removed");
                return true;
            }
        }
        return false;

    }
    public void printMemberInfo() {
        System.out.println("Email: "+this.email+" (pw: "+this.password+")");
        System.out.println("List of Videos");
        for (int i = 0; i < vdoList.size(); i++) {
            System.out.println("["+(i+1)+"]"+vdoList.get(i));            
        }

    }

    public ArrayList<Video> getVdoList() {
        return vdoList;
    }

    public void setVdoList(ArrayList<Video> vdoList) {
        this.vdoList = vdoList;
    }

    

    
}