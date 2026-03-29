package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.AppData;
import model.HealthLog;
import model.AppData;
public class HealthLogUI extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Health Log");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2196F3;");

        // Date field
        Label dateLabel = new Label("Date:");
        TextField dateField = new TextField();
        dateField.setPromptText("e.g. 2026-03-29");
        dateField.setPrefHeight(36);

        // BP field
        Label bpLabel = new Label("Blood Pressure:");
        TextField bpField = new TextField();
        bpField.setPromptText("e.g. 120");
        bpField.setPrefHeight(36);

        // Sugar field
        Label sugarLabel = new Label("Sugar Level:");
        TextField sugarField = new TextField();
        sugarField.setPromptText("e.g. 95");
        sugarField.setPrefHeight(36);

        // Buttons
        Button saveBtn = new Button("Save Log");
        saveBtn.setPrefSize(150, 40);
        saveBtn.setStyle(
            "-fx-background-color: #2196F3; -fx-text-fill: white; " +
            "-fx-font-size: 13px; -fx-background-radius: 8;"
        );

        Button backBtn = new Button("Back");
        backBtn.setPrefSize(100, 40);
        backBtn.setStyle(
            "-fx-background-color: #9E9E9E; -fx-text-fill: white; " +
            "-fx-font-size: 13px; -fx-background-radius: 8;"
        );

        Label msgLabel = new Label("");

        // Log display area
        TextArea logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPromptText("Saved logs will appear here...");
        logArea.setPrefHeight(150);
        logArea.setStyle("-fx-font-size: 12px;");

        // Grid for inputs
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setPadding(new Insets(10));
        grid.addRow(0, dateLabel,  dateField);
        grid.addRow(1, bpLabel,    bpField);
        grid.addRow(2, sugarLabel, sugarField);

        HBox buttons = new HBox(12, saveBtn, backBtn);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(14, title, grid, buttons, msgLabel, logArea);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #F5F8FF;");

        // SAVE ACTION
        saveBtn.setOnAction(e -> {
            String date  = dateField.getText().trim();
            String bpStr = bpField.getText().trim();
            String sgStr = sugarField.getText().trim();

            if (date.isEmpty() || bpStr.isEmpty() || sgStr.isEmpty()) {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Please fill in all fields.");
            } else {
                try {
                    double bp    = Double.parseDouble(bpStr);
                    double sugar = Double.parseDouble(sgStr);

                    HealthLog log = new HealthLog(date, bp, sugar);
                    log.displayRecord();

                    AppData.addHealthLog(log); // ✅ save to shared store

                    logArea.appendText(
                        "Date: " + date +
                        " | BP: " + bp +
                        " | Sugar: " + sugar + "\n"
                    );

                    msgLabel.setStyle("-fx-text-fill: green;");
                    msgLabel.setText("Log saved successfully!");

                    dateField.clear();
                    bpField.clear();
                    sugarField.clear();

                } catch (NumberFormatException ex) {
                    msgLabel.setStyle("-fx-text-fill: red;");
                    msgLabel.setText("BP and Sugar must be numbers.");
                }
            }
        });

        // BACK ACTION
        backBtn.setOnAction(e -> stage.close());

        Scene scene = new Scene(layout, 420, 500);
        stage.setTitle("Health Log");
        stage.setScene(scene);
        stage.show();
    }
}