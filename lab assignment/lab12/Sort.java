import java.io.*;
import java.util.*;

public class Sort {
    public static List<String> list ;
    public static void main(String[] args) throws IOException {
        List<String> a = loadfile("name.txt");
        pStrings(a);
        /**Easy way here */
        //Collections.sort(a,Collections.reverseOrder());
        sorting(a);
    }
    public static List<String> loadfile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String s = "";
        List<String> list = new LinkedList<String>();
        while((s = reader.readLine()) != null){
            String[] word = s.split("\\s");
            list.addAll(Arrays.asList(word));
        }
        reader.close();
        return list;
    }
    public static void pStrings(List<String> a) {
        System.out.println("Original :"+a);
    }
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