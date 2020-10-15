package movietickets.pages;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import movietickets.Main;

import java.util.ArrayList;
import java.util.List;

public class SeatSelection implements Page {

    private int temp = 0;

    private final Scene scene;

    private final GridPane gridPane;

    private List<String> seats;

    private Text columnA = new Text("   A");
    private Text columnB = new Text("   B");
    private Text columnC = new Text("   C");
    private Text columnD = new Text("   D");

    private Text row1 = new Text("1");
    private Text row2 = new Text("2");
    private Text row3 = new Text("3");
    private Text row4 = new Text("4");
    private Text row5 = new Text("5");

    private Button cancelButton = new Button("Avbryt");
    private Button nextButton = new Button("N\u00E4sta");
    private Button verifyButton = new Button("Verifiera");

    private Label response = new Label();

    private CheckBox checkBox1 = new CheckBox();
    private CheckBox checkBox2 = new CheckBox();
    private CheckBox checkBox3 = new CheckBox();
    private CheckBox checkBox4 = new CheckBox();
    private CheckBox checkBox5 = new CheckBox();
    private CheckBox checkBox6 = new CheckBox();
    private CheckBox checkBox7 = new CheckBox();
    private CheckBox checkBox8 = new CheckBox();
    private CheckBox checkBox9 = new CheckBox();
    private CheckBox checkBox10 = new CheckBox();
    private CheckBox checkBox11 = new CheckBox();
    private CheckBox checkBox12 = new CheckBox();
    private CheckBox checkBox13 = new CheckBox();
    private CheckBox checkBox14 = new CheckBox();
    private CheckBox checkBox15 = new CheckBox();
    private CheckBox checkBox16 = new CheckBox();
    private CheckBox checkBox17 = new CheckBox();
    private CheckBox checkBox18 = new CheckBox();
    private CheckBox checkBox19 = new CheckBox();
    private CheckBox checkBox20 = new CheckBox();

    private Label header = new Label("\tV\u00E4lj plats(er)!");

    public SeatSelection() {

        seats = new ArrayList<>();

        gridPane = new GridPane();

        gridPane.setMinSize(500, 500);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.BASELINE_CENTER);

        header.getStyleClass().add("main-header-label");

        GridPane.setHgrow(cancelButton, Priority.ALWAYS);
        GridPane.setHgrow(verifyButton, Priority.ALWAYS);
        GridPane.setHgrow(nextButton, Priority.ALWAYS);

        cancelButton.setMaxWidth(Double.MAX_VALUE);
        verifyButton.setMaxWidth(Double.MAX_VALUE);
        nextButton.setMaxWidth(Double.MAX_VALUE);

        gridPane.add(header, 0, 0, 5, 1);

        gridPane.add(columnA, 1, 2);
        gridPane.add(columnB, 2, 2);
        gridPane.add(columnC, 3, 2);
        gridPane.add(columnD, 4, 2);

        gridPane.add(row1, 0, 3);
        gridPane.add(row2, 0, 4);
        gridPane.add(row3, 0, 5);
        gridPane.add(row4, 0, 6);
        gridPane.add(row5, 0, 7);

        gridPane.add(checkBox1, 1, 3);
        gridPane.add(checkBox2, 1, 4);
        gridPane.add(checkBox3, 1, 5);
        gridPane.add(checkBox4, 1, 6);
        gridPane.add(checkBox5, 1, 7);
        gridPane.add(checkBox6, 2, 3);
        gridPane.add(checkBox7, 2, 4);
        gridPane.add(checkBox8, 2, 5);
        gridPane.add(checkBox9, 2, 6);
        gridPane.add(checkBox10, 2, 7);
        gridPane.add(checkBox11, 3, 3);
        gridPane.add(checkBox12, 3, 4);
        gridPane.add(checkBox13, 3, 5);
        gridPane.add(checkBox14, 3, 6);
        gridPane.add(checkBox15, 3, 7);
        gridPane.add(checkBox16, 4, 3);
        gridPane.add(checkBox17, 4, 4);
        gridPane.add(checkBox18, 4, 5);
        gridPane.add(checkBox19, 4, 6);
        gridPane.add(checkBox20, 4, 7);

        gridPane.add(cancelButton, 0, 10, 10, 1);
        gridPane.add(verifyButton, 0, 11, 10, 1);
        gridPane.add(nextButton, 0, 12, 10, 1);

        gridPane.add(response, 1, 15, 5, 5);

        nextButton.setVisible(false);

        scene = new Scene(gridPane);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        registerListeners();
    }

    @Override
    public void registerListeners() {

        cancelButton.setOnAction(event -> {
            Main.getInstance().getStage().setScene(Main.getInstance().getBooking().getScene());
        });

        verifyButton.setOnAction(event -> {
            response.setText("Du har valt platserna: \n" + String.join(", ", seats));
            nextButton.setVisible(true);
        });

        checkBox1.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("1A");
                    } else if (old_val) {
                        seats.remove("1A");
                    }
                    disableBoxes();

                });

        checkBox2.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("2A");
                    } else if (old_val) {
                        seats.remove("2A");
                    }
                    disableBoxes();

                });

        checkBox3.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("3A");
                    } else if (old_val) {
                        seats.remove("3A");
                    }
                    disableBoxes();

                });

        checkBox4.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("4A");
                    } else if (old_val) {
                        seats.remove("4A");
                    }
                    disableBoxes();

                });
        checkBox5.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("5A");
                    } else if (old_val) {
                        seats.remove("5A");
                    }
                    disableBoxes();

                });
        checkBox6.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("1B");
                    } else if (old_val) {
                        seats.remove("1B");
                    }
                    disableBoxes();

                });
        checkBox7.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("2B");
                    } else if (old_val) {
                        seats.remove("2B");
                    }
                    disableBoxes();

                });
        checkBox8.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("3B");
                    } else if (old_val) {
                        seats.remove("3B");
                    }
                    disableBoxes();

                });
        checkBox9.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("4B");
                    } else if (old_val) {
                        seats.remove("4B");
                    }
                    disableBoxes();

                });
        checkBox10.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("5B");
                    } else if (old_val) {
                        seats.remove("5B");
                    }
                    disableBoxes();

                });
        checkBox11.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("1C");
                    } else if (old_val) {
                        seats.remove("1C");
                    }
                    disableBoxes();

                });
        checkBox12.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("2C");
                    } else if (old_val) {
                        seats.remove("2C");
                    }
                    disableBoxes();

                });
        checkBox13.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("3C");
                    } else if (old_val) {
                        seats.remove("3C");
                    }
                    disableBoxes();

                });
        checkBox14.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("4C");
                    } else if (old_val) {
                        seats.remove("4C");
                    }
                    disableBoxes();

                });
        checkBox15.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("5C");
                    } else if (old_val) {
                        seats.remove("5C");
                    }
                    disableBoxes();

                });
        checkBox16.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("1D");
                    } else if (old_val) {
                        seats.remove("1D");
                    }
                    disableBoxes();
                });
        checkBox17.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("2D");
                    } else if (old_val) {
                        seats.remove("2D");
                    }
                    disableBoxes();
                });
        checkBox18.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("3D");
                    } else if (old_val) {
                        seats.remove("3D");
                    }
                    disableBoxes();
                });
        checkBox19.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("4D");
                    } else if (old_val) {
                        seats.remove("4D");
                    }
                    disableBoxes();
                });
        checkBox20.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val) {
                        seats.add("5D");
                    } else if (old_val) {
                        seats.remove("5D");
                    }
                    disableBoxes();
                });

        nextButton.setOnAction(event -> {
            Main.getInstance().getCustomer().setSeats(seats);
            Main.getInstance().getStage().setScene(Main.getInstance().getConfirmation().getScene());
        });
    }

    private void disableBoxes() {
        temp++;
        if (temp >= Main.getInstance().getCustomer().getNumberOfTickets()) {
            checkBox1.setDisable(true);
            checkBox2.setDisable(true);
            checkBox3.setDisable(true);
            checkBox4.setDisable(true);
            checkBox5.setDisable(true);
            checkBox6.setDisable(true);
            checkBox7.setDisable(true);
            checkBox8.setDisable(true);
            checkBox9.setDisable(true);
            checkBox10.setDisable(true);
            checkBox11.setDisable(true);
            checkBox12.setDisable(true);
            checkBox13.setDisable(true);
            checkBox14.setDisable(true);
            checkBox15.setDisable(true);
            checkBox16.setDisable(true);
            checkBox17.setDisable(true);
            checkBox18.setDisable(true);
            checkBox19.setDisable(true);
            checkBox20.setDisable(true);
        }
    }

    public Scene getScene() {
        return scene;
    }
}
