package view;

import javax.swing.*;
import java.awt.*;

public class DashboardUI {

    public DashboardUI() {

        JFrame frame = new JFrame("Dashboard");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(new Color(245, 248, 255));

        JLabel title = new JLabel("Dashboard", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton addMedicineBtn = new JButton("Add Medicine");
        JButton reportBtn = new JButton("View Report");
        JButton exitBtn = new JButton("Exit");

        panel.add(title);
        panel.add(addMedicineBtn);
        panel.add(reportBtn);
        panel.add(exitBtn);

        frame.add(panel);
        frame.setVisible(true);

        // Button Actions
        addMedicineBtn.addActionListener(e -> {
            frame.dispose(); // close dashboard
            new MainUI();    // open add medicine screen
        });

        reportBtn.addActionListener(e -> {
            ReportUI.showReport();
        });

        exitBtn.addActionListener(e -> {
            System.exit(0);
        });
    }
}