package view;

import javax.swing.*;
import java.awt.*;

public class ReportUI {

    public static void showReport() {

        JFrame frame = new JFrame("Health Report Dashboard");
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 248, 255));

        // ===== TITLE =====
        JLabel title = new JLabel("Health Report", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(33, 150, 243));

        mainPanel.add(title, BorderLayout.NORTH);

        // ===== CENTER PANEL =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.setBackground(new Color(245, 248, 255));

        // Cards
        centerPanel.add(createCard("Medicines Taken", "5", new Color(76, 175, 80)));
        centerPanel.add(createCard("Missed Doses", "1", new Color(244, 67, 54)));
        centerPanel.add(createCard("Avg BP", "120/80", new Color(33, 150, 243)));
        centerPanel.add(createCard("Sugar Level", "95", new Color(255, 193, 7)));

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // 🔥 Card UI method
    private static JPanel createCard(String title, String value, Color color) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(color, 2));

        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel valueLabel = new JLabel(value, JLabel.CENTER);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 18));
        valueLabel.setForeground(color);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(valueLabel, BorderLayout.CENTER);

        return panel;
    }
}