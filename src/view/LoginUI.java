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
import util.UserDAO;
public class LoginUI extends Application {

    @Override
    public void start(Stage stage) {
        // Title
        Label title = new Label("Welcome Back");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Label subtitle = new Label("Login to your account");
        subtitle.setFont(Font.font("Arial", 13));
        subtitle.setTextFill(Color.GRAY);

        // Email
        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setPrefHeight(38);

        // Password
        Label passLabel = new Label("Password");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter your password");
        passField.setPrefHeight(38);

        // Login Button
        Button loginBtn = new Button("Sign In");
        loginBtn.setPrefSize(240, 42);
        loginBtn.setStyle(
            "-fx-background-color: #4CAF50; -fx-text-fill: white; " +
            "-fx-font-size: 14px; -fx-background-radius: 6;"
        );

        // Signup Button
        Button signupBtn = new Button("Create Account");
        signupBtn.setPrefSize(240, 38);
        signupBtn.setStyle(
            "-fx-background-color: #2196F3; -fx-text-fill: white; " +
            "-fx-font-size: 13px; -fx-background-radius: 6;"
        );

        Label msgLabel = new Label("");
        msgLabel.setTextFill(Color.RED);

        // Card layout
        VBox card = new VBox(10,
            title, subtitle,
            emailLabel, emailField,
            passLabel, passField,
            loginBtn, signupBtn,
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

        // LOGIN ACTION
        loginBtn.setOnAction(e -> {
            String email = emailField.getText().trim();
            String pass  = passField.getText();

            if (UserDAO.validate(email, pass)) { // ✅ checks DB
                msgLabel.setStyle("-fx-text-fill: green;");
                msgLabel.setText("Login Successful!");
                Stage dashboard = new Stage();
                new DashboardUI().start(dashboard);
                stage.close();
            } else {
                msgLabel.setStyle("-fx-text-fill: red;");
                msgLabel.setText("Invalid email or password.");
            }
        });

        // SIGNUP ACTION
        signupBtn.setOnAction(e -> {
            Stage signupStage = new Stage();
            new SignupUI().start(signupStage);
            stage.close();
        });

        Scene scene = new Scene(root, 420, 500);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}