package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Signup extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JPasswordField confirmPasswordField;

    Signup() {

        setTitle("Bank Management System - Sign Up");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Heading
        JLabel title = new JLabel("CREATE ACCOUNT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(120, 30, 260, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        // Username
        JLabel username = new JLabel("Username:");
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setBounds(60, 100, 110, 30);
        add(username);

        usernameField = new JTextField();
        usernameField.setBounds(180, 100, 220, 30);
        add(usernameField);

        // Password
        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Arial", Font.BOLD, 16));
        password.setBounds(60, 150, 110, 30);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 150, 220, 30);
        add(passwordField);

        // Confirm Password
        JLabel confirm = new JLabel("Confirm:");
        confirm.setFont(new Font("Arial", Font.BOLD, 16));
        confirm.setBounds(60, 200, 110, 30);
        add(confirm);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(180, 200, 220, 30);
        add(confirmPasswordField);

        // Create Account button
        JButton createButton = new JButton("CREATE ACCOUNT");
        createButton.setBounds(155, 260, 190, 35);
        add(createButton);

        // Button action
        createButton.addActionListener(e -> createAccount());

        setVisible(true);
    }

    private void createAccount() {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!"
            );

            return;
        }

        if (!password.equals(confirmPassword)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Passwords do not match!"
            );

            return;
        }

        try {

            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File("data/users.txt");

            // Check if username already exists
            if (file.exists()) {

                BufferedReader reader = new BufferedReader(
                        new FileReader(file)
                );

                String line;

                while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(",");

                    if (parts.length >= 1 &&
                            parts[0].equals(username)) {

                        reader.close();

                        JOptionPane.showMessageDialog(
                                this,
                                "Username already exists!"
                        );

                        return;
                    }
                }

                reader.close();
            }

            // Save account
            FileWriter writer = new FileWriter(file, true);

            writer.write(username + "," + password + "\n");

            writer.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Account created successfully!"
            );

            dispose();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error saving account!"
            );

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Signup();
    }
}