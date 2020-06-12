import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        int arr[] = {18,34,89,2,0,-10,15,23};
        //Collections.sort()
        //Arrays.sort();
        
        

    }
    public static int[] BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
                
            }
        }
        return arr;
    }
    /**
     * In case for list
     * @param list
     */
    public static void sorting(List<String> list) {
        String temp;
        for (int j=0; j<list.size(); j++){ // bubble sort outer loop
            for (int i= 0; i < list.size() - j - 1; i++) {
                if (list.get(i).compareTo(list.get(i+1)) > 0){
                    temp = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, temp);
                }
            }
            System.out.println(list);
        }
    }
}