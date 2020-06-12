
/**
 * @author Nopparat Pengsuk 6288103;
 */
public class VIPUser extends User implements Searchable {

    @Override
    public int findUserIDByAge(int age, int[][] listAllUser) {
        // TODO Auto-generated method stub
        // for (int i = 0; i < listAllUser.length; i++) {
        //     Arrays.sort(listAllUser[i]);
        // }
			
			int first = 0 , last = listAllUser[0].length-1;
			while(first <= last){
				int mid = (first + last)/2;
				if(listAllUser[1][mid] == age) return listAllUser[0][mid];
				if(listAllUser[1][mid] < age) first = mid +1;
				else last = mid -1; 
			}
		
		return -1;
    }
    
}