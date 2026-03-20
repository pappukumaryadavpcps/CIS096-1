package view;

import javax.swing.*;
import java.awt.*;

public class SignupUI {

    public SignupUI() {

        JFrame frame = new JFrame("Signup");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(240, 242, 245));

        JLabel title = new JLabel("Create Account");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(120, 30, 200, 30);

        JTextField email = new JTextField();
        email.setBounds(80, 100, 220, 35);

        JPasswordField password = new JPasswordField();
        password.setBounds(80, 150, 220, 35);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(80, 220, 220, 40);
        registerBtn.setBackground(new Color(33, 150, 243));
        registerBtn.setForeground(Color.WHITE);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(80, 270, 220, 35);

        panel.add(title);
        panel.add(new JLabel("Email")).setBounds(80, 80, 100, 20);
        panel.add(email);
        panel.add(new JLabel("Password")).setBounds(80, 130, 100, 20);
        panel.add(password);
        panel.add(registerBtn);
        panel.add(backBtn);

        frame.add(panel);
        frame.setVisible(true);

        // REGISTER LOGIC (simple for now)
        registerBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Registered Successfully!");
        });

        // BACK TO LOGIN
        backBtn.addActionListener(e -> {
            frame.dispose();
            new LoginUI();
        });
    }
}