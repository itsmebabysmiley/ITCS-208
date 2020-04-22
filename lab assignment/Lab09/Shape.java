
abstract class Shape implements Comparable {
    static double PI = 3.14;
    public String color;
    public String description;

    Shape(String color, String description) {
        this.color = color;
        this.description = description;

    }

    public abstract double getArea();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return description + "(color=" + color + ", area=" + getArea() + ")";
    }

    @Override
    public int compareTo(Object shape) {
        Shape a = (Shape) shape;
        if(this.getArea() > a.getArea()) {return 1;}else if(this.getArea() == a.getArea()){return 0;}
        return -1;
    }
    
    
}
