import java.util.ArrayList;

public class SortingMovie {

	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie(1, "The Intern", 2009));
		movieList.add(new Movie(2, "The Gift", 2009));
		movieList.add(new Movie(3, "The Lost Room", 2009));
		movieList.add(new Movie(4, "The Gift", 2012));
		movieList.add(new Movie(5, "Pasolini", 2012));
		movieList.add(new Movie(6, "The Intern", 2009));
		movieList.add(new Movie(7, "American Ultra", 2019));
		movieList.add(new Movie(8, "Sweet Red Bean Paste", 2019));
		
		sort(movieList);
	}
	
	public static void sort (ArrayList<Movie>  movies) {
		System.out.println("== unsorted movie list ==");
		for (Movie movie : movies) {System.out.println(movie);}
		Movie temp;
        for (int j=0; j<movies.size()-1; j++){ // bubble sort outer loop
            for (int i= 0; i < movies.size() - j - 1; i++) {
                if (movies.get(i).compareTo(movies.get(i+1)) > 0){
                    temp = movies.get(i);
                    movies.set(i,movies.get(i+1) );
                    movies.set(i+1, temp);
                }
            }
		}
		System.out.println("== sorted movie list (ascending) ==");
		for (Movie movie : movies) {System.out.println(movie);}
            
    }
}


