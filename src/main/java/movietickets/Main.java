package movietickets;

import javafx.application.Application;
import javafx.stage.Stage;
import movietickets.pages.Booking;
import movietickets.pages.Confirmation;
import movietickets.pages.MainMenu;
import movietickets.pages.SeatSelection;


public class Main extends Application {

    private Movie movie;

    private static final MovieList movieList = new MovieList();
    private static Main INSTANCE;

    private Customer customer;

    private MainMenu mainMenu;
    private Booking booking;
    private SeatSelection seatSelection;
    private Confirmation confirmation;

    private Stage stage;

    char auml = '\u00E4';

    public static void main(String[] args) {
        launch(args);
    }

    public void createMovieData() {
        movieList.addMovie(new Movie("Star Wars", 140, "Science Fiction", "15 \u00E5r", 100, "In a galaxy far far away."));
        movieList.addMovie(new Movie("Lord of The Rings", 140, "I don't know", "15 \u00E5r", 1000, "My precious."));
    }

    @Override
    public void start(Stage stage) throws Exception {
        INSTANCE = this;
        this.stage = stage;
        // Create the movie list and the movies
        createMovieData();

        movie = movieList.getMovieList().get(0);

        mainMenu = new MainMenu();
        booking = new Booking();
        seatSelection = new SeatSelection();
        confirmation = new Confirmation();

        stage.setTitle("Java Filmer️");
        stage.setScene(mainMenu.getScene());
        stage.setResizable(false);
        stage.show();
    }

    public MovieList getMovieList() {
        return movieList;
    }

    public static Main getInstance() {
        return INSTANCE;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Booking getBooking() {
        return booking;
    }

    public Stage getStage() {
        return stage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SeatSelection getSeatSelection() {
        return seatSelection;
    }

    public Confirmation getConfirmation() {
        return confirmation;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
