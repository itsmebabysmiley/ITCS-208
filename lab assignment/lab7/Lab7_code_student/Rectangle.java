
/*
 * The Rectangle class, subclass of Shape
 */
public class Rectangle extends Shape {
   // Private member variables
   //add your code here
   private double length;
   private double width;


   // Constructors
   public Rectangle()
   {
	  //add your code here

   }
   public Rectangle(String color, double length, double width) {
      //add your code here
      super(color);
      this.length = length;
      this.width = width;
   }

   @Override
   public String toString() {
      //add your code here
      return (getClass().getName()+" [length="+this.length+","+" width="+this.width+","+super.toString()+"]");
   }
   

   // Override the inherited getArea() to provide the proper implementation
   @Override
   public double getArea() {
      //add your code here
      return this.length * this.width;
   }

   public double getArea(double length, double width) {
          //add your code here
          this.length = length;
          this.width = width;
          return getArea();
      }
   
}
