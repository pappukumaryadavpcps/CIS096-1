
// Package for view layer (UI part)
package view;

//Import JavaFX Application class
import javafx.application.Application;

//Main class to launch the application
public class AppLauncher {
	
    // Entry point of the program
    public static void main(String[] args) {

        // Launch JavaFX application and open LoginUI
        Application.launch(LoginUI.class, args);
    }
}

