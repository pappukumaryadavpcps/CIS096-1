package view;

import javax.swing.*;
import java.awt.*;

public class LoginUI {

    public LoginUI() {

        JFrame frame = new JFrame("Login");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(240, 242, 245));

        // Card Panel
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(300, 380));
        card.setBackground(Color.WHITE);
        card.setLayout(null);

        // Title
        JLabel title = new JLabel("Welcome Back");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(70, 30, 200, 30);

        JLabel subtitle = new JLabel("Login to your account");
        subtitle.setBounds(80, 60, 200, 20);

        // Email
        JLabel emailLabel = new JLabel("Name");
        emailLabel.setBounds(30, 100, 100, 20);

        JTextField emailField = new JTextField();
        emailField.setBounds(30, 125, 240, 35);

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(30, 170, 100, 20);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(30, 195, 240, 35);

        // Login Button
        JButton loginBtn = new JButton("Sign In");
        loginBtn.setBounds(30, 260, 240, 40);
        loginBtn.setBackground(new Color(76, 175, 80));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);

        // Signup Button
        JButton signupBtn = new JButton("Create Account");
        signupBtn.setBounds(30, 310, 240, 35);

        // Add components
        card.add(title);
        card.add(subtitle);
        card.add(emailLabel);
        card.add(emailField);
        card.add(passLabel);
        card.add(passField);
        card.add(loginBtn);
        card.add(signupBtn);

        mainPanel.add(card);
        frame.add(mainPanel);
        frame.setVisible(true);

        // LOGIN ACTION
        loginBtn.addActionListener(e -> {

            String email = emailField.getText();
            String pass = new String(passField.getPassword());

            if (email.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                frame.dispose();
                new DashboardUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
            }
        });

        // SIGNUP ACTION
        signupBtn.addActionListener(e -> {
            frame.dispose();
            new SignupUI();
        });
    }
}