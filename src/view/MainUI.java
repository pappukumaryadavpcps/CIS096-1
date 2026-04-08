
// Package for view layer (UI)
package view;

//Import JavaFX classes
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import controller.MedicineController;
import model.Medicine;

//MainUI class for adding medicine (OOP: Inheritance)
public class MainUI extends Application {


    // Start method (JavaFX entry point)
    @Override
    public void start(Stage stage) {

    	  // Title label
        Label title = new Label("Add Medicine");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Input fields
        TextField nameField   = new TextField(); nameField.setPromptText("Medicine name");
        TextField dosageField = new TextField(); dosageField.setPromptText("Dosage e.g. 500mg");
        TextField timeField   = new TextField(); timeField.setPromptText("Time e.g. 08:00 AM");

        // Buttons
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

        // Message label for feedback
        Label msgLabel = new Label("");
        
        // Layout using GridPane (form structure)
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(12);
        grid.setPadding(new Insets(20));
        grid.addRow(0, new Label("Name:"),   nameField);
        grid.addRow(1, new Label("Dosage:"), dosageField);
        grid.addRow(2, new Label("Time:"),   timeField);

        // Button layout
        HBox buttons = new HBox(12, addButton, backButton);
        buttons.setAlignment(Pos.CENTER);


        // Main layout
        VBox layout = new VBox(16, title, grid, buttons, msgLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #F5F8FF;");


        // Create controller object (MVC: Controller)
        MedicineController controller = new MedicineController();

        // --- ADD BUTTON EVENT ---
        addButton.setOnAction(e -> {
        	
            // Validation check
            if (nameField.getText().isEmpty() || dosageField.getText().isEmpty()
                    || timeField.getText().isEmpty()) {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Please fill in all fields.");
            } else {

                // Create Medicine object (OOP: Object Creation)
                Medicine m = new Medicine(
                    nameField.getText(),
                    dosageField.getText(),
                    timeField.getText()
                );

                // Call controller method (MVC interaction)
                controller.addMedicine(m);
                msgLabel.setStyle("-fx-text-fill: green;");
                msgLabel.setText("Medicine saved successfully!");
                // Clear fields
                nameField.clear(); dosageField.clear(); timeField.clear();
            }
        });

        // BACK BUTTON EVENT
        backButton.setOnAction(e -> stage.close());

        // Scene setup
        Scene scene = new Scene(layout, 420, 320);
        stage.setTitle("Add Medicine");
        stage.setScene(scene);
        stage.show();
    }
}