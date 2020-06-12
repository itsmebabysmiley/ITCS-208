@FunctionalInterface
interface Calculator{
    public double perform(double n1, double n2);
}
/**
 * Lamda
 */
public class Lamda {

    public static void main(String[] args) {
        
        Calculator cal = (a , b) -> a + b;
        double r = compute(cal);
        System.out.println("++plus++");
        System.out.println(r);
        cal = (a , b) -> a - b;
        double d = compute(cal);
        System.out.println("--minus--");
        System.out.println(d);
        double c = compute( (a , b) -> a * b );
        System.out.println("**mutiply**");
        System.out.println(c);

        System.out.println("\n------------alternative way------------");
        
        Calculator cal2 = (a , b) -> a + b;
        double r2 = compute(cal2 , 40 , 50);
        System.out.println("++plus++");
        System.out.println(r2);
        cal2 = (a , b) -> a - b;
        double d2 = compute(cal2,100,99);
        System.out.println("--minus--");
        System.out.println(d2);
        double c2 = compute( (a , b) -> a * b , 15 , 2);
        System.out.println("**mutiply**");
        System.out.println(c2);


    }

    private static double compute(Calculator c) {
        return c.perform(10, 20);
    }
    private static double compute(Calculator c, double n1, double n2 ) {
        return c.perform(n1, n2);
    }

}