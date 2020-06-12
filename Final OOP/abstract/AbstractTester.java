
abstract class Shape3D {

    protected final double PI = 3.141;

    public String getShapeName() {
        return this.getClass().getName();
    }

    public abstract double getSurfaceArea(); 

    public abstract double getVolume();
}

/**
 * Cubic extends Shape3D
 */

class Cubic extends Shape3D {

    private double mLength;

    public Cubic(double mLength) {
        this.mLength = mLength;
    }

    @Override
    public double getSurfaceArea() {
        return Math.pow(mLength, 2) * 6;
    }

    @Override
    public double getVolume() {
        return Math.pow(mLength, 3);
    }

}
/**
 * Tring extends Shape3D
 */
class Rec extends Shape3D {
    
    private double x;
    public Rec(double x) {
        this.x = x;
    }
	@Override
	public double getSurfaceArea() {
        // TODO Auto-generated method stub
         
		return x+x;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return x*x;
	}

   
    

    
}
/**
 * Test
 */
class AbstractTester {
    
    public static void main(String[] args) {
	//Shape3D shape = new Shape3D(); why I can't write like this?
        Shape3D shape3d = new Cubic(10.0);
        String name = shape3d.getShapeName();
        System.out.println(name);
        Cubic cube = new Cubic(10.0);
        double area = cube.getVolume();
        System.out.println(area);
        Shape3D s = new Rec(2);
        System.out.println(s.getSurfaceArea());

    }
}
