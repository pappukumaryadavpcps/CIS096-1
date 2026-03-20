package view;

import javax.swing.*;
import java.awt.*;
import controller.MedicineController;
import model.Medicine;

public class MainUI {

    public MainUI() {

        JFrame frame = new JFrame("Add Medicine");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 248, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel title = new JLabel("Add Medicine");
        title.setFont(new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        JTextField nameField = new JTextField(15);
        JTextField dosageField = new JTextField(15);
        JTextField timeField = new JTextField(15);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Dosage:"), gbc);
        gbc.gridx = 1;
        panel.add(dosageField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Time:"), gbc);
        gbc.gridx = 1;
        panel.add(timeField, gbc);

        JButton addButton = new JButton("Add Medicine");
        JButton backButton = new JButton("Back");

        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(addButton, gbc);

        gbc.gridx = 1;
        panel.add(backButton, gbc);

        frame.add(panel);
        frame.setVisible(true);

        MedicineController controller = new MedicineController();

        addButton.addActionListener(e -> {
            Medicine m = new Medicine(
                    nameField.getText(),
                    dosageField.getText(),
                    timeField.getText()
            );
            controller.addMedicine(m);
            JOptionPane.showMessageDialog(frame, "Saved!");
        });

        // 🔙 BACK BUTTON
        backButton.addActionListener(e -> {
            frame.dispose();
            new DashboardUI();
        });
    }
}