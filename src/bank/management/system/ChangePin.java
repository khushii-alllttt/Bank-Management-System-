package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChangePin extends JFrame {

    String username;

    JPasswordField oldPinField;
    JPasswordField newPinField;
    JPasswordField confirmPinField;

    ChangePin(String username) {

        this.username = username;

        setTitle("Bank Management System - Change PIN");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("CHANGE PIN");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(100, 30, 300, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        // Old PIN
        JLabel oldPin = new JLabel("Old PIN:");
        oldPin.setFont(new Font("Arial", Font.BOLD, 16));
        oldPin.setBounds(70, 100, 120, 30);
        add(oldPin);

        oldPinField = new JPasswordField();
        oldPinField.setBounds(200, 100, 200, 30);
        add(oldPinField);

        // New PIN
        JLabel newPin = new JLabel("New PIN:");
        newPin.setFont(new Font("Arial", Font.BOLD, 16));
        newPin.setBounds(70, 150, 120, 30);
        add(newPin);

        newPinField = new JPasswordField();
        newPinField.setBounds(200, 150, 200, 30);
        add(newPinField);

        // Confirm PIN
        JLabel confirmPin = new JLabel("Confirm PIN:");
        confirmPin.setFont(new Font("Arial", Font.BOLD, 16));
        confirmPin.setBounds(70, 200, 120, 30);
        add(confirmPin);

        confirmPinField = new JPasswordField();
        confirmPinField.setBounds(200, 200, 200, 30);
        add(confirmPinField);

        // Change button
        JButton changeButton = new JButton("CHANGE PIN");
        changeButton.setBounds(170, 260, 160, 40);
        add(changeButton);

        changeButton.addActionListener(e -> changePin());

        setVisible(true);
    }

    private void changePin() {

        String oldPin = new String(oldPinField.getPassword());
        String newPin = new String(newPinField.getPassword());
        String confirmPin = new String(confirmPinField.getPassword());

        if (oldPin.isEmpty() || newPin.isEmpty() || confirmPin.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!"
            );

            return;
        }

        if (!newPin.equals(confirmPin)) {

            JOptionPane.showMessageDialog(
                    this,
                    "New PIN and Confirm PIN do not match!"
            );

            return;
        }

        File file = new File("data/users.txt");

        if (!file.exists()) {

            JOptionPane.showMessageDialog(
                    this,
                    "User data not found!"
            );

            return;
        }

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(file)
            );

            List<String> users = new ArrayList<>();

            String line;
            boolean userFound = false;
            boolean pinCorrect = false;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",", -1);

                if (parts.length == 2 &&
                        parts[0].equals(username)) {

                    userFound = true;

                    if (parts[1].equals(oldPin)) {

                        pinCorrect = true;

                        users.add(
                                username + "," + newPin
                        );

                    } else {

                        users.add(line);
                    }

                } else {

                    users.add(line);
                }
            }

            reader.close();

            if (!userFound) {

                JOptionPane.showMessageDialog(
                        this,
                        "User not found!"
                );

                return;
            }

            if (!pinCorrect) {

                JOptionPane.showMessageDialog(
                        this,
                        "Old PIN is incorrect!"
                );

                return;
            }

            FileWriter writer = new FileWriter(file);

            for (String user : users) {
                writer.write(user + "\n");
            }

            writer.close();

            JOptionPane.showMessageDialog(
                    this,
                    "PIN changed successfully!"
            );

            dispose();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error updating PIN!"
            );

            ex.printStackTrace();
        }
    }
}