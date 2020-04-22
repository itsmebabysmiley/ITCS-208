import java.util.*;
import java.io.*;
// import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase  {
	public Map<Integer, Movie> movies = new LinkedHashMap<Integer, Movie>();
	
	public void importMovies(String movieFilename) throws IOException 
	{	//YOUR CODE GOES HERE
		BufferedReader reader = new BufferedReader(new FileReader(movieFilename));
		String s = "";
		while ((s = reader.readLine()) != null) {
			if (s.length() == 0 || !s.matches("[0-9]+,\\S.*,.*")) continue; 
			String[] word = s.split(",",2);
				int x = Integer.parseInt(word[0]);
				movies.put(x, new Movie(x, word[1]));
		}
		reader.close();
	}
	
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> m = new ArrayList<Movie>();
        for (Movie movie : movies.values()) {
			String a = movie.title.toLowerCase();
			String b = query.toLowerCase();
            if(a.contains(b)){
                m.add(movie);
            }
        }
		return m;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> m = new ArrayList<Movie>();
        for (Movie movie : movies.values()) {
            for (String s : movie.tags) {
				String a = s.toLowerCase();
				String b = tag.toLowerCase();
                if(a.contains(b)){
                    m.add(movie);
                }
            }
        }
		return m;
	}
	
	
	public static void main(String[] args) throws IOException 
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		
	}

}
