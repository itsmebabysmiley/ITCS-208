/**
 * @author Nopparat Pengsuk 6288103
 */
public class Running extends Exercise {
    private double speed;
    private double duration;
    /**
     * assign speed and duration and type
     * @param i
     * @param j
     */
    public Running(int i, int j) {
        super("Running");
        this.speed = i;
        this.duration = j;
    }
    /**
     * calculate calories
     */
    public void calculateCalories() {
        double cal = this.speed * this.duration * 2;
        super.setCalories(cal);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString()+" ["+speed+","+duration+"]";
    }
    
}