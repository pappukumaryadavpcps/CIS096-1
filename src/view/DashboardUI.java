package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardUI extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Dashboard");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2196F3;");

        Button addMedicineBtn = createBtn("💊  Add Medicine", "#4CAF50");
        Button healthLogBtn   = createBtn("🩺  Health Log",   "#2196F3");
        Button reportBtn      = createBtn("📊  View Report",  "#FF9800");
        Button exitBtn        = createBtn("🚪  Exit",         "#F44336");

        addMedicineBtn.setOnAction(e -> {
            Stage mainStage = new Stage();
            new MainUI().start(mainStage);
        });

        healthLogBtn.setOnAction(e -> {
            Stage healthStage = new Stage();
            new HealthLogUI().start(healthStage);
        });

        reportBtn.setOnAction(e -> {
            ReportUI.showReport(new Stage());
        });

        exitBtn.setOnAction(e -> stage.close());

        VBox layout = new VBox(14, title, addMedicineBtn, healthLogBtn, reportBtn, exitBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.setStyle("-fx-background-color: #F5F8FF;");

        Scene scene = new Scene(layout, 380, 360);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    private Button createBtn(String text, String color) {
        Button btn = new Button(text);
        btn.setPrefSize(220, 42);
        btn.setStyle(
            "-fx-background-color: " + color + "; -fx-text-fill: white; " +
            "-fx-font-size: 13px; -fx-background-radius: 8;"
        );
        return btn;
    }
}