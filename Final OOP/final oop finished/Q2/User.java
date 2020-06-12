
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nopparat Pengsuk 6288103
 */
public class User implements Chattable{
    /**
     * jsut search uin in array if found return true;
     */
    @Override
    public boolean checkValidUserID(int uID, int[][] listAllUser) {
        // TODO Auto-generated method stub
       
        
			int first = 0 , last = listAllUser[0].length-1;
			while(first <= last){
				int mid = (first + last)/2;
				if(listAllUser[0][mid] == uID) return true;
				if(listAllUser[0][mid] <= uID) first = mid +1;
				else last = mid -1; 
			}
		
		return false;
    }
    /**
     * Just print message.
     */
    @Override
    public String msgToUserID(int uID, String message, int[][] listAllUser) {
        // TODO Auto-generated method stub
        
			int first = 0 , last = listAllUser[0].length-1;
			while(first <= last){
				int mid = (first + last)/2;
				if(listAllUser[0][mid] == uID) return uID+"|"+message;
				if(listAllUser[0][mid] <= uID) first = mid +1;
				else last = mid -1; 
			}
		
        return "0";
    }
    /**
     * i don;t have time to finish this one.
     */
    @Override
    public String msgToUserIDs(int[] uID, String message, int[][] listAllUser) {
        // TODO Auto-generated method stub
        List<Integer> ID = new ArrayList<>();
        for (int i  : listAllUser[0]) {
            ID.add(i);
        }
        Collections.sort(ID);
        Set<Integer> valid = new HashSet<>();
        Set<Integer> invalid = new HashSet<>();
        for (int i : uID) invalid.add(i);
        for (int uid : uID) {
            int first = 0 , last = listAllUser[0].length-1;
            while(first <= last){
                int mid = (first + last)/2;

                if(ID.get(mid) == uid){
                    valid.add(uid); 
                    break;
                }
                if(ID.get(mid) > uid) last = mid - 1;
                else first = mid + 1;
            }
        }
        StringBuilder text = new StringBuilder();
        int size = valid.size()-1;
        for (Integer integer : valid) {
            if(size-- != 0 ){
                text.append(integer+",");
            }else{
                text.append(integer);
            }

        }
        text.append("|Test BroadCast");
        invalid.removeAll(valid);
        if(!invalid.isEmpty()){
            size = invalid.size()-1;
            text.append("|");
            for (Integer integer : invalid) {
                if(size-- != 0 ){
                    text.append(integer+",");
                }else{
                    text.append(integer);
                }
            }
        }
        return text.toString();
    }
    
    
}