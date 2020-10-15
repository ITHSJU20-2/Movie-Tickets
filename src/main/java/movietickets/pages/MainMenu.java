package movietickets.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import movietickets.Main;
import movietickets.Movie;

import java.text.DecimalFormat;

public class MainMenu implements Page {

    private final Scene scene;

    private final Label descriptionLabel = new Label("Beskrivning");
    private final Label lengthLabel = new Label("L\u00E4ngd");
    private final Label genreLabel = new Label("Genre");
    private final Label ratingLabel = new Label("Rekommenderat Fr\u00E5n");
    private final Label priceLabel = new Label("Pris");

    private final Label description = new Label();
    private final Label length = new Label();
    private final Label genre = new Label();
    private final Label rating = new Label();
    private final Label price = new Label();

    private final ComboBox<String> dropDown = new ComboBox<>();

    private final Button button = new Button("Boka");

    private final GridPane gridPane = new GridPane();

    public MainMenu() {

        // Add the necessary classes for styling through CSS
        descriptionLabel.getStyleClass().add("main-label");
        lengthLabel.getStyleClass().add("main-label");
        genreLabel.getStyleClass().add("main-label");
        ratingLabel.getStyleClass().add("main-label");
        priceLabel.getStyleClass().add("main-label");

        description.getStyleClass().add("main-info");
        length.getStyleClass().add("main-info");
        genre.getStyleClass().add("main-info");
        rating.getStyleClass().add("main-info");
        price.getStyleClass().add("main-info");

        button.getStyleClass().add("main-button");
        button.setVisible(false);

        dropDown.getStyleClass().add("main-drop-down");

        dropDown.setValue("V\u00E4lj Film");
        Main.getInstance().getMovieList().getMovieList().forEach(movie -> dropDown.getItems().add(movie.getTitle()));

        gridPane.setAlignment(Pos.BASELINE_LEFT);

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(5);
        gridPane.setMinSize(400, 200);
        //gridPane.setStyle("-fx-background-color: rgba(207,145,0,81)");

        /*
        GRID LAYOUT
        ---------------------------
        | drop-down | description |
        |   price   |   length    |
        |   button  |    genre    |
        |           |   rating    |
        ---------------------------
         */
        gridPane.add(dropDown, 0, 0);

        gridPane.add(descriptionLabel, 1, 0);
        gridPane.add(description, 1, 1);

        gridPane.add(lengthLabel, 1, 2);
        gridPane.add(length, 1, 3);

        gridPane.add(genreLabel, 1, 4);
        gridPane.add(genre, 1, 5);

        gridPane.add(ratingLabel, 1, 6);
        gridPane.add(rating, 1, 7);

        gridPane.add(priceLabel, 0, 1);
        gridPane.add(price, 0, 2);

        gridPane.add(button, 0, 3);

        scene = new Scene(gridPane);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        registerListeners();
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public void registerListeners() {
        // Change the information label values when changing the value of the drop down (ComboBox)
        dropDown.valueProperty().addListener((observable, oldValue, newValue) -> {
            Movie movie = Main.getInstance().getMovieList().getMovieByTitle(newValue);
            if (movie == null) {
                return;
            }
            DecimalFormat df = new DecimalFormat("#,###.##");
            description.setText(movie.getDescription());
            length.setText(movie.getLength() + " minuter");
            genre.setText(movie.getGenre());
            rating.setText(movie.getRating());
            price.setText(df.format(movie.getPrice()) + " kr");
            button.setVisible(true);
        });

        button.setOnAction(event -> {
            // CHANGE SCENE TO BOOKING SCENE
            Main.getInstance().setMovie(Main.getInstance().getMovieList().getMovieByTitle(dropDown.getValue()));
            Main.getInstance().getStage().setScene(Main.getInstance().getBooking().getScene());
        });
    }
}
