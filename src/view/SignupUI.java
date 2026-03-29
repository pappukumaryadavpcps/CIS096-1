
package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.UserStore;
import util.UserDAO;
public class SignupUI extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Create Account");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setPrefHeight(38);

        Label passLabel = new Label("Password");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter your password");
        passField.setPrefHeight(38);

        Label confirmPassLabel = new Label("Confirm Password");
        PasswordField confirmPassField = new PasswordField();
        confirmPassField.setPromptText("Re-enter your password");
        confirmPassField.setPrefHeight(38);

        Button registerBtn = new Button("Register");
        registerBtn.setPrefSize(240, 42);
        registerBtn.setStyle(
            "-fx-background-color: #2196F3; -fx-text-fill: white; " +
            "-fx-font-size: 14px; -fx-background-radius: 6;"
        );

        Button backBtn = new Button("Back to Login");
        backBtn.setPrefSize(240, 38);
        backBtn.setStyle(
            "-fx-background-color: #9E9E9E; -fx-text-fill: white; " +
            "-fx-font-size: 13px; -fx-background-radius: 6;"
        );

        Label msgLabel = new Label("");
        msgLabel.setTextFill(Color.RED);

        VBox card = new VBox(10,
            title,
            emailLabel, emailField,
            passLabel, passField,
            confirmPassLabel, confirmPassField,
            registerBtn, backBtn,
            msgLabel
        );
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(35, 35, 35, 35));
        card.setMaxWidth(320);
        card.setStyle(
            "-fx-background-color: white; -fx-background-radius: 12; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 12, 0, 0, 4);"
        );

        StackPane root = new StackPane(card);
        root.setStyle("-fx-background-color: #F0F2F5;");

        // REGISTER ACTION — saves to UserStore
        registerBtn.setOnAction(e -> {
            String email = emailField.getText().trim();
            String pass  = passField.getText();
            String confirmPass = confirmPassField.getText();

            if (email.isEmpty() || pass.isEmpty()) {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Email and password cannot be empty.");
            } else if (!pass.equals(confirmPass)) {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Passwords do not match.");
            } else if (UserDAO.exists(email)) {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Email already registered.");
            } else if (UserDAO.register(email, pass)) { // ✅ saves to DB
                msgLabel.setStyle("-fx-text-fill: green;");
                msgLabel.setText("Registered! Redirecting to login...");
                new Thread(() -> {
                    try { Thread.sleep(1200); } catch (InterruptedException ex) {}
                    javafx.application.Platform.runLater(() -> {
                        Stage loginStage = new Stage();
                        new LoginUI().start(loginStage);
                        stage.close();
                    });
                }).start();
            } else {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Registration failed. Try again.");
            }
        });

        // BACK ACTION
        backBtn.setOnAction(e -> {
            Stage loginStage = new Stage();
            new LoginUI().start(loginStage);
            stage.close();
        });

        Scene scene = new Scene(root, 420, 520);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }
}