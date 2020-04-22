import java.util.ArrayList;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/**
 * FreeMember
 */
public class FreeMember extends Member {

    FreeMember(String email, String password) {
        super(email, password);
    }

    private int FREE_LIMITED_VDOs = 3;
    private int numDownloadedVDO = 0;

    @Override
    public boolean addVideo(Video vdo) {
        if(getVdoList().size()==FREE_LIMITED_VDOs){
            System.out.println(vdo.toString());
            System.out.println("cannot be downloaded because the number of video is reaching the limit.");
            return false;
        }else{
            getVdoList().add(vdo);
            numDownloadedVDO ++;
            return true;
        }
    }
    
	@Override
    public boolean removeVideo(Video vdo) {
        if(super.removeVideo(vdo)){
            numDownloadedVDO --;
            return true;
        }else return false;

    }
    public int getNumVideo(){

        return numDownloadedVDO;
    }

    @Override
    public void printMemberInfo() {
        System.out.println("---- FREE MEMBER ----");
        super.printMemberInfo(); 
    }


    
}