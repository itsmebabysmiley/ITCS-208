import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Movie {
	public int mid = -1;
	public String title = null;
	public Set<String> tags = null;
	public Movie(int _mid, String _title)
	{
		mid = _mid;
		String[] word = _title.split(",");
		title = word[0];
		String[] t = word[1].split("\\|");
		tags = new HashSet<String>(Arrays.asList(t));
	}
	
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" "+tags+"]";
	}
	
}
