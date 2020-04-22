/**
 * Circle
 */
public class Circle extends Shape {
    final double PI = 3.14;
    private double r;

    public Circle(String color, double r) {
        super(color);
        this.r = r;
    }

    public Circle() {
        
	}

	@Override
    public double getArea() {
        
        return PI*r*r;
    }

    @Override
    public String toString() {

        return getClass().getName() +"[ radius="+this.r+","+super.toString()+"]";
    }

    public double getArea(double r,double l) {
        this.r = r;
        return getArea();
     }
     
    

}