package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.Movie;
import business.MovieCollection;
import util.Console;

public class MovieRatingsApp {

	public static void main(String[] args) {
		//initialize stuff
		MovieCollection mc = new MovieCollection();
		mc.add(new Movie("Avengers Infinity War", 2018, 4.0));
		mc.add(new Movie("Star Wars Episode 5 - Empire Strikes Back", 1980, 5.0));
		mc.add(new Movie("Sixteen Candles", 1984, 4.5));
		mc.add(new Movie("Happy Gilmore", 1996, 4.3));
		mc.add(new Movie("The Jerk", 1979, 3.9));
		mc.add(new Movie("Superbad", 2007, 3.9));
		mc.add(new Movie("Back to the Future Part III", 1990, 2.1));
		mc.add(new Movie("Entourage", 2015, 1.5));
		
		System.out.println("Welcome to the Movie Ratings application!\n");
		
		int choice = 0;
		
		while (choice!=6) {
			displayMenu();
	        choice = Console.getInt("Choose a menu option: ", 0, 7);
	        Console.println();

	        List<Movie> filteredMovies = new ArrayList<>();
	        switch (choice) {
	        	case 1:
	        		int nbrMovies = Console.getInt("How many movies do you want to enter?  ");
	        		for (int i=0; i< nbrMovies; i++) {
	        			Console.println();
	        			Console.println("Movie "+i);
	        			Console.println("==========");
	        			String title = Console.getString("Enter title: ");
	        			int year = Console.getInt("Enter year:  ");
	        			double rating = Console.getDouble("Enter rating:  ");
	        			Movie m = new Movie(title, year, rating);
	        			mc.add(m);
	        		}
	        		break;
	        	case 2:
	        		Console.println("Movies rated 4.0 or higher");
	        		Console.println("==========================");
	        		filteredMovies = mc.filterMovies(c -> c.getRating() >= 4.0);
	        		displayMovies(filteredMovies);
	        		break;
	        	case 3:  // most recent movies
	        		Console.println("Most recent movies");
	        		Console.println("==================");
	        		int currentYear = LocalDate.now().getYear();
	        		int yearCheck = currentYear - 10;
	        		filteredMovies = mc.filterMovies(c -> c.getYear() >= yearCheck);
	        		displayMovies(filteredMovies);
	        		break;
	        	case 4:  // view all movies
	        		Console.println("All movies");
	        		Console.println("==========");
	        		displayMovies(mc.getMovies());
	        		break;
	        	case 5:  // view ratings
	        		Console.println("Movie rating data");
	        		Console.println("=================");
	        		Console.println("# of movies:  "+mc.getSize());
	        		Console.println("highest rating:  "+mc.getHighestRating());
	        		Console.println("lowest rating:  "+mc.getLowestRating());
	        		Console.println("average rating:  "+mc.getAverageRating());
	        		break;
	        	case 6:  // exit
	        		Console.print("Goodbye!");
	        		break;
	        }
		}
		

	}

	public static void displayMenu() {
        Console.println("-----------------------");
        Console.println("What do you want to do?");
        Console.println("-----------------------");
        Console.println("1 - Enter a movie");
        Console.println("2 - View top rated movies");
        Console.println("3 - View most recent movies");
        Console.println("4 - View all movies");
        Console.println("5 - View ratings");
        Console.println("6 - Quit application");
        
        Console.println();
	}
	
    private static void displayMovies(List<Movie> filteredMovies) {
        if (filteredMovies.isEmpty()) {
            Console.println("No movies match the criteria.");
        } else {
            filteredMovies.stream().map(Movie::toString).forEach(Console::println);
        }
    }   

}
