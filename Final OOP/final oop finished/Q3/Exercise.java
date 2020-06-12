// DO NOT MODIFY THIS CLASS

public class Exercise {
	private String type;
	private double calories;
	
	public Exercise(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setCalories(double cal) {
		this.calories = cal;
	}
	
	public double getCalories() {
		return calories;
	}
	
	public String toString() {
		return type + ": " + calories + " kcal";
	}

}
