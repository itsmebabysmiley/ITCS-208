import java.util.Stack;

public class ToH {

    // Creating Stack array 
    public static Stack<Integer>[] tower = new Stack[4];
    public static void main(String[] args) {
        //** why not use 0 because idk maybe tower 0  */
        tower[1] = new Stack<Integer>(); //s1 
        tower[2] = new Stack<Integer>(); //s2
        tower[3] = new Stack<Integer>(); //s3

        tower[1].push(3); //0
        tower[1].push(2); //1
        tower[1].push(1); //2
        Lop_BaB_Digital(3, 1, 2, 3); //number of stack,s1,s2,s3

    }
    
    public static void Lop_BaB_Digital(int n, int s1, int s2, int s3) {
        if (n > 0) {
            Lop_BaB_Digital(n - 1, s1, s3, s2);      
            int temp = tower[s1].pop();  //temp
            tower[s3].push(temp); //add to top
            Lop_BaB_Digital(n - 1, s2, s1, s3);
        }
        
    }


    public static void display() {
        System.out.println("  1  |  2  |  3");
        System.out.println("---------------");
        for (int i = 3 - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(tower[1].get(i));
            } catch (Exception e) {
            }
            try {
                d2 = String.valueOf(tower[2].get(i));
            } catch (Exception e) {
            }
            try {
                d3 = String.valueOf(tower[3].get(i));
            } catch (Exception e) {
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.println("\n");
    }
}