
package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import controller.MedicineController;
import model.Medicine;

public class MainUI extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Add Medicine");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField nameField   = new TextField(); nameField.setPromptText("Medicine name");
        TextField dosageField = new TextField(); dosageField.setPromptText("Dosage e.g. 500mg");
        TextField timeField   = new TextField(); timeField.setPromptText("Time e.g. 08:00 AM");

        Button addButton  = new Button("Add Medicine");
        addButton.setStyle(
            "-fx-background-color: #4CAF50; -fx-text-fill: white; " +
            "-fx-background-radius: 6; -fx-font-size: 13px;"
        );
        addButton.setPrefWidth(150);

        Button backButton = new Button("Back");
        backButton.setStyle(
            "-fx-background-color: #9E9E9E; -fx-text-fill: white; " +
            "-fx-background-radius: 6; -fx-font-size: 13px;"
        );
        backButton.setPrefWidth(100);

        Label msgLabel = new Label("");

        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(12);
        grid.setPadding(new Insets(20));
        grid.addRow(0, new Label("Name:"),   nameField);
        grid.addRow(1, new Label("Dosage:"), dosageField);
        grid.addRow(2, new Label("Time:"),   timeField);

        HBox buttons = new HBox(12, addButton, backButton);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(16, title, grid, buttons, msgLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #F5F8FF;");

        MedicineController controller = new MedicineController();

        addButton.setOnAction(e -> {
            if (nameField.getText().isEmpty() || dosageField.getText().isEmpty()
                    || timeField.getText().isEmpty()) {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Please fill in all fields.");
            } else {
                Medicine m = new Medicine(
                    nameField.getText(),
                    dosageField.getText(),
                    timeField.getText()
                );
                controller.addMedicine(m);
                msgLabel.setStyle("-fx-text-fill: green;");
                msgLabel.setText("Medicine saved successfully!");
                nameField.clear(); dosageField.clear(); timeField.clear();
            }
        });

        backButton.setOnAction(e -> stage.close());

        Scene scene = new Scene(layout, 420, 320);
        stage.setTitle("Add Medicine");
        stage.setScene(scene);
        stage.show();
    }
}