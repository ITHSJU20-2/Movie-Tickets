package movietickets;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        MovieList movieList = new MovieList();
        movieList.addMovie(new Movie("Star Wars", 140, "Science Fiction", "PG", 100, "In a galaxy far far away."));
        movieList.addMovie(new Movie("Lord of The Rings", 140, "I don't know", "PG", 100, "My precious."));

        Label description = new Label();
        Label length = new Label();
        Label genre = new Label();
        Label rating = new Label();
        Label price = new Label();

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(400, 200);

        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.setVgap(10);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER_LEFT);

        ComboBox<String> dropDown = new ComboBox<>();

        movieList.getMovieList().forEach(movie -> dropDown.getItems().add(movie.getTitle()));

        dropDown.setValue("Select Movie");

        gridPane.add(dropDown, 0, 0);
        gridPane.add(description, 1, 0);
        gridPane.add(length, 1, 1);
        gridPane.add(genre, 1, 2);
        gridPane.add(rating, 1, 3);
        gridPane.add(price, 0, 1, 3, 1);

        Scene scene = new Scene(gridPane);
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Java Filmer");
        stage.setScene(scene);
        stage.show();

        dropDown.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Movie movie = movieList.getMovieByTitle(newValue);
                if (movie == null) {
                    return;
                }
                description.setText(movie.getDescription());
                length.setText(movie.getLength() + "");
                genre.setText(movie.getGenre());
                rating.setText(movie.getRating());
                price.setText(movie.getPrice() + "");
            }
        });

    }
}
