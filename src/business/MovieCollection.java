package business;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MovieCollection {
	List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	// Create a MovieCollection w/ no movies
	public MovieCollection() {
		movies = new ArrayList<>();
	}

	// Create a MovieCollection w/ list of movies
	public MovieCollection(List<Movie> movies) {
		movies = new ArrayList<>();
		this.movies = movies;
	}

	// Create a MovieCollection w/ 1 movie
	public MovieCollection(Movie m) {
		movies = new ArrayList<>();
		movies.add(m);
	}
	
	// add Movie object to internal list
	public void add(Movie m)   {
		movies.add(m);
	}
	
	public List<Movie> filterMovies(Predicate<Movie> condition) {
		List<Movie> filteredMovies = new ArrayList<>();
		for (Movie m: movies) {
			if (condition.test(m)) {
				filteredMovies.add(m);
			}
		}
		return filteredMovies;
	}
	
	public double getLowestRating() {
		double lr = movies.stream()
					.map(r -> r.getRating())
					.reduce(5.0, (a, b) -> Math.min(a, b));
		return lr;
	}
	public double getHighestRating() {
		double hr = movies.stream()
				.map(r -> r.getRating())
				.reduce(1.0, (a, b) -> Math.max(a, b));
		return hr;
	}
	public double getAverageRating() {
		double sum = movies.stream()
				.map(r -> r.getRating())
				.reduce(0.0, (a, b) -> (a+b));
		return sum/movies.size();
	}
	
	//return number of items in internal list
	public int getSize() {
		return movies.size();
	}

	
	
}
