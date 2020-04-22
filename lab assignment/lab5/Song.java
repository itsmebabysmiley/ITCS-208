
public class Song {
	private String title;
	private double duration;

	
	public Song(String title, double duration) {
		// Your code goes here
		this.title = title;
		this.duration =duration;
	}
	
	public String getTitle() {
		// Your code goes here
		return title;
	}
	
	public double getDuration() {
		// Your code goes here
		return duration;
	}
	
	public int getDurationInSec() {
		// Your code goes here
		int min = (int)duration;
		int seconds  = (int)Math.round((duration - min)*100);
		int r = (min*60) + seconds;


		return r;
	}
	
	public String toString() {
		// Your code goes here
		return this.title +", "+this.duration +"minutes"+"("+getDurationInSec()+" seconds)";
	}
}
