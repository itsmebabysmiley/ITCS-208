import java.util.LinkedList;
import java.util.Queue;

public class hi {
    public static void main(String[] args) {
       Queue<String> q = new LinkedList<String>();
       q.add("I have eaten");
       q.add("the plums");
       q.add("HI there");
       System.out.println("Original "+q);
       System.out.println("Reverse ");
       reverseLines(q);


    }
    public static void reverseLines(Queue<String> q) {
       if(!q.isEmpty()){
           String str = q.remove();
           reverseLines(q);
           System.out.println(str);
       }
    }
 }