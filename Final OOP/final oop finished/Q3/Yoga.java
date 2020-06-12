/**
 * @author Nopparat Pengsuk 6288103
 */
public class Yoga extends Exercise {
    private double duration;
    /**
     * assign duration and type
     * @param i
     */
    public Yoga(int i) {
        super("Yoga");
        if (i < 0)
            this.duration = 0;
        else
            this.duration = i;

    }
    /**
     * calculate calrories
     */
    public void calculateCalories() {
        double cal = this.duration * 10;
        super.setCalories(cal);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString()+" ["+duration+"]";
    }

    
}