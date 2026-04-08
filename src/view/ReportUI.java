// Package for view layer (UI)
package view;

//Import JavaFX layout and UI classes
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.AppData;


//Report UI class (View layer)
public class ReportUI {


    // Static method to display report window
    public static void showReport(Stage stage) {

        // Title label
        Label title = new Label("Health Report");
        // Styling using CSS
        title.setStyle(
            "-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2196F3;"
        );


        // --- Fetch data from AppData (Model interaction) ---
        String medTaken  = String.valueOf(AppData.getMedicineTakenCount());
        String missed    = String.valueOf(AppData.getMissedDoses());
        // Conditional check (if no data)
        String avgBP     = AppData.getAvgBP()    == 0 ? "No data" : String.valueOf(AppData.getAvgBP());
        String avgSugar  = AppData.getAvgSugar() == 0 ? "No data" : String.valueOf(AppData.getAvgSugar());

        // Grid layout for cards
        GridPane grid = new GridPane();
        grid.setHgap(16); grid.setVgap(16);
        grid.setPadding(new Insets(24));
        grid.setAlignment(Pos.CENTER);

        // Add report cards (UI components)
        grid.add(createCard("Medicines Added", medTaken, "#4CAF50"), 0, 0);
        grid.add(createCard("Missed Doses",    missed,   "#F44336"), 1, 0);
        grid.add(createCard("Avg BP",          avgBP,    "#2196F3"), 0, 1);
        grid.add(createCard("Avg Sugar",       avgSugar, "#FFC107"), 1, 1);

        // Main layout
        VBox root = new VBox(16, title, grid);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(24));
        root.setStyle("-fx-background-color: #F5F8FF;");

        // Scene setup
        Scene scene = new Scene(root, 440, 340);
        stage.setTitle("Health Report");
        stage.setScene(scene);
        stage.show();
    }

    // Helper method to create styled card UI
    private static VBox createCard(String titleText, String value, String hexColor) {
        // Title of card
        Label titleLabel = new Label(titleText);
        titleLabel.setStyle("-fx-font-size: 13px;");


        // Value label (dynamic data)
        Label valueLabel = new Label(value);
        valueLabel.setStyle(
            "-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: " + hexColor + ";"
        );

        // Layout for card
        VBox card = new VBox(6, titleLabel, valueLabel);
        card.setAlignment(Pos.CENTER);
        card.setPrefSize(160, 90);

        // Styling card with CSS
        card.setStyle(
            "-fx-background-color: white; -fx-background-radius: 10; " +
            "-fx-border-color: " + hexColor + "; -fx-border-radius: 10; " +
            "-fx-border-width: 2; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 8, 0, 0, 2);"
        );
        return card;
    }
}
