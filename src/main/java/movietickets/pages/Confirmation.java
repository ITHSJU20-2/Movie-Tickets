package movietickets.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import movietickets.Customer;
import movietickets.Main;
import movietickets.Movie;
import movietickets.pages.Booking;
import movietickets.pages.Page;

import java.text.DecimalFormat;

public class Confirmation implements Page {


    //private final Label ticketsPurchased = new Label(Main.getInstance().getCustomer().getNumberOfTickets());

    private final Label customerName = new Label();
    private final Label customerEmail = new Label();
    private final Label customerNumber = new Label();


    private Label movie = new Label();
    private Label length = new Label();
    private Label genre = new Label();
    private Label rating = new Label();
    private Label price = new Label();

    private final Label movieLabel = new Label("Film");
    private final Label lengthLabel = new Label("Längd");
    private final Label genreLabel = new Label("Genre");
    private final Label ratingLabel = new Label("Rekommenderat Fr\u00E5n");
    private final Label priceLabel = new Label("Pris");

    private final Label nameLabel = new Label("Namn");
    private final Label emailLabel = new Label("E-Mejl");
    private final Label phoneLabel = new Label("Telefonnummer");
    private final Label ticketsLabel = new Label("Dina platser");

    private final Scene scene;
    private final Button mainMenuButton = new Button("Startsida");

    private final GridPane gridPane = new GridPane();

    private Label ticketsBought = new Label();

    public Confirmation() {

        gridPane.setAlignment(Pos.BASELINE_LEFT);

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setMinSize(400, 200);

        // Label for confirmation that tickets are booked
        Label confirmationReceiptLabel = new Label("Dina biljetter har blivit bokade!");
        confirmationReceiptLabel.setTextFill(Color.GREEN);
        confirmationReceiptLabel.getStyleClass().add("conf-label");

        Label ticketReceipt = new Label("Här är ditt kvitto");
        ticketReceipt.setTextFill(Color.BLUE);
        ticketReceipt.getStyleClass().add("conf-label");

        //Labels And Text Alignment For Receipt

        movieLabel.getStyleClass().add("main-label");
        lengthLabel.getStyleClass().add("main-label");
        genreLabel.getStyleClass().add("main-label");
        ratingLabel.getStyleClass().add("main-label");
        priceLabel.getStyleClass().add("main-label");
        nameLabel.getStyleClass().add("main-label");
        emailLabel.getStyleClass().add("main-label");
        phoneLabel.getStyleClass().add("main-label");
        ticketsLabel.getStyleClass().add("main-label");

        gridPane.add(confirmationReceiptLabel, 0,0);
        gridPane.add(ticketReceipt,0,4);

        gridPane.add(movieLabel, 0, 5);
        gridPane.add(movie, 0, 6);

        gridPane.add(lengthLabel, 0, 7);
        gridPane.add(length, 0, 8);

        gridPane.add(genreLabel, 0, 9);
        gridPane.add(genre, 0, 10);

        gridPane.add(ratingLabel, 0, 11);
        gridPane.add(rating, 0, 12);

        gridPane.add(priceLabel, 0, 13);
        gridPane.add(price, 0, 14);

        gridPane.add(ticketsLabel, 0, 15);
        gridPane.add(ticketsBought, 0, 16);

        gridPane.add(mainMenuButton, 1, 13);

        gridPane.add(nameLabel, 1, 5);
        gridPane.add(customerName, 1,6);

        gridPane.add(emailLabel, 1, 7);
        gridPane.add(customerEmail, 1,8);

        gridPane.add(phoneLabel, 1, 9);
        gridPane.add(customerNumber, 1,10);

        scene = new Scene(gridPane);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        registerListeners();

    }
    public Scene getScene() {
        DecimalFormat df = new DecimalFormat("#,###.##");
        movie.setText(Main.getInstance().getMovie().getTitle());
        rating.setText(Main.getInstance().getMovie().getRating());
        price.setText(df.format(Main.getInstance().getMovie().getPrice()) + "kr " + " x " + Main.getInstance().getCustomer().getNumberOfTickets());
        length.setText(Main.getInstance().getMovie().getLength()+ "");
        genre.setText(Main.getInstance().getMovie().getGenre());
        ticketsBought.setText(String.join(", ", Main.getInstance().getCustomer().getSeats()));
        return scene;
    }


    @Override
    public void registerListeners() {


        mainMenuButton.setOnAction(event -> {
            // CHANGE SCENE TO CONFIRMATION SCENE
            Main.getInstance().getStage().setScene(Main.getInstance().getMainMenu().getScene());
        });



    }

    public Label getCustomerName() {
        return customerName;
    }

    public Label getCustomerEmail() {
        return customerEmail;
    }

    public Label getCustomerNumber() {
        return customerNumber;
    }

    public void setMovie(Label movie) {
        this.movie = movie;
    }

    public void setLength(Label length) {
        this.length = length;
    }

    public void setGenre(Label genre) {
        this.genre = genre;
    }

    public void setRating(Label rating) {
        this.rating = rating;
    }

    public void setPrice(Label price) {
        this.price = price;
    }
}
