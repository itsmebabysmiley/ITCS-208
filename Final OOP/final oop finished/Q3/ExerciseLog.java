//DO NOT MODIFY THIS CLASS

public class ExerciseLog {

	public static void main(String[] args) {
		
		// first log
		Exercise first = new Exercise("Workout");
		first.setCalories(200);
		System.out.println(first.toString());
		
		// second log
		Running second = new Running(4, 30);
		second.calculateCalories();
		System.out.println(second.toString());
		
		// third log
		Yoga third = new Yoga(60);
		third.calculateCalories();
		System.out.println(third.toString());
		
		// invalid log
		Yoga invalid = new Yoga(-10);
		invalid.calculateCalories();
		System.out.println(invalid.toString());
		
	}

}
