import java.io.*;
import java.util.*;

public class Sorting {

    public static void main(String[] args) throws IOException {
        String[] a = loadfile("name.txt");
        pStrings(a);
        descendingSort(a);

    }

    public static String[] loadfile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/baby/Documents/GitHub/java/lab assignment/lab12/name.txt"));
        String s = "";
        while ((s = reader.readLine()) != null) {
                String[] word = s.split("\\s");
                return word;
        }
        reader.close();
        return null;
    }

    public static void pStrings(String[] word) {
        System.out.print("Original: [");
        for (String string : word) {
            System.out.print(string + ",");
        }
        System.out.print("]");
        System.out.println();
    }

    static void descendingSort(String[] arr) { //selection sort
        
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) > 0) {

                    String t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
            System.out.print("Swap(" + (i+1) + ") [");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

    }
    
    

}