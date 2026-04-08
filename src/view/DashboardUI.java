// Package for view layer (UI part)
package view;

//Import JavaFX classes for GUI
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Dashboard UI class (OOP: Inheritance - extends Application)
public class DashboardUI extends Application {

    // Start method is entry point for JavaFX UI
    @Override
    public void start(Stage stage) {

        // Create title label
        Label title = new Label("Dashboard");
        // Styling label using CSS
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2196F3;");

        // Create buttons using helper method
        Button addMedicineBtn = createBtn("💊  Add Medicine", "#4CAF50");
        Button healthLogBtn   = createBtn("🩺  Health Log",   "#2196F3");
        Button reportBtn      = createBtn("📊  View Report",  "#FF9800");
        Button exitBtn        = createBtn("🚪  Exit",         "#F44336");

        // Event handling for Add Medicine button
        addMedicineBtn.setOnAction(e -> {
            Stage mainStage = new Stage();    // create new window
            new MainUI().start(mainStage);  // open MainUI
        });
        // Event handling for Health Log button
        healthLogBtn.setOnAction(e -> {
            Stage healthStage = new Stage();
            new HealthLogUI().start(healthStage); // open HealthLog UI
        });

        // Event handling for Report button
        reportBtn.setOnAction(e -> {
            ReportUI.showReport(new Stage());// show report window
        });

        // Event handling for Exit button
        exitBtn.setOnAction(e -> stage.close());  // close current window


        // Layout to arrange components vertically
        VBox layout = new VBox(14, title, addMedicineBtn, healthLogBtn, reportBtn, exitBtn);
        layout.setAlignment(Pos.CENTER);       // center alignment
        layout.setPadding(new Insets(40));  // spacing
        layout.setStyle("-fx-background-color: #F5F8FF;");


        // Create scene with layout
        Scene scene = new Scene(layout, 380, 360);

        // Set stage properties
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();   // display window
    }


    // Helper method to create styled buttons
    private Button createBtn(String text, String color) {
        Button btn = new Button(text);
        btn.setPrefSize(220, 42);   // set size

        // Apply styling using CSS
        btn.setStyle(
            "-fx-background-color: " + color + "; -fx-text-fill: white; " +
            "-fx-font-size: 13px; -fx-background-radius: 8;"
        );
        return btn;
    }
}