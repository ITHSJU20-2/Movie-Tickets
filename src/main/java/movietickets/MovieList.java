package movietickets;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

    private final List<Movie> movieList;

    public MovieList() {
        movieList = new ArrayList<>();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : movieList) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }
}
