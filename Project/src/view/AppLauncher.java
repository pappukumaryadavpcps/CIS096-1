package view;

public class AppLauncher {

    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(
                "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start from Login Screen
        new LoginUI();
    }
}