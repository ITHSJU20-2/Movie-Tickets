package movietickets;

import javafx.application.Application;
import javafx.stage.Stage;
import movietickets.pages.Booking;
import movietickets.pages.MainMenu;


public class Main extends Application {

    private static final MovieList movieList = new MovieList();
    private static Main INSTANCE;

    private MainMenu mainMenu;
    private Booking booking;

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        INSTANCE = this;
        this.stage = stage;
        // Create the movie list and the movies
        movieList.addMovie(new Movie("Star Wars", 140, "Science Fiction", "15 år", 100, "In a galaxy far far away."));
        movieList.addMovie(new Movie("Lord of The Rings", 140, "I don't know", "15 år", 1000, "My precious."));

        mainMenu = new MainMenu();
        booking = new Booking();

        stage.setTitle("To Be Determined");
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
}
