package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Withdraw extends JFrame {

    String username;
    JTextField amountField;

    Withdraw(String username) {

        this.username = username;

        setTitle("Bank Management System - Withdraw");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // ================= TITLE =================

        JLabel title = new JLabel("WITHDRAW MONEY");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(100, 30, 300, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        // ================= AMOUNT LABEL =================

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        amountLabel.setBounds(60, 110, 130, 30);
        add(amountLabel);

        // ================= AMOUNT FIELD =================

        amountField = new JTextField();
        amountField.setBounds(200, 110, 200, 30);
        add(amountField);

        // ================= WITHDRAW BUTTON =================

        JButton withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setBounds(175, 180, 140, 40);
        add(withdrawButton);

        withdrawButton.addActionListener(e -> withdrawMoney());

        setVisible(true);
    }

    // =========================================================
    // WITHDRAW MONEY
    // =========================================================

    private void withdrawMoney() {

        String amountText = amountField.getText().trim();

        // Check empty field
        if (amountText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter amount!"
            );

            return;
        }

        try {

            double amount = Double.parseDouble(amountText);

            // Check positive amount
            if (amount <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Amount must be greater than 0!"
                );

                return;
            }

            // =================================================
            // DATA FOLDER
            // =================================================

            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            // =================================================
            // BALANCE FILE
            // =================================================

            File balanceFile = new File(
                    "data/" + username + "_balance.txt"
            );

            double currentBalance = 0;

            // Read current balance
            if (balanceFile.exists()) {

                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(balanceFile)
                        );

                String line = reader.readLine();

                if (line != null && !line.isEmpty()) {

                    currentBalance =
                            Double.parseDouble(line);
                }

                reader.close();
            }

            // =================================================
            // CHECK BALANCE
            // =================================================

            if (amount > currentBalance) {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient Balance!\n\n"
                                + "Available Balance: ₹"
                                + String.format(
                                        "%.2f",
                                        currentBalance
                                )
                );

                return;
            }

            // =================================================
            // CALCULATE NEW BALANCE
            // =================================================

            double newBalance =
                    currentBalance - amount;

            // Save new balance
            FileWriter balanceWriter =
                    new FileWriter(balanceFile);

            balanceWriter.write(
                    String.valueOf(newBalance)
            );

            balanceWriter.close();

            // =================================================
            // DATE AND TIME
            // =================================================

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy HH:mm"
                    );

            String dateTime =
                    LocalDateTime.now().format(formatter);

            // =================================================
            // TRANSACTION HISTORY
            // =================================================

            File historyFile = new File(
                    "data/" + username + "_transactions.txt"
            );

            FileWriter historyWriter =
                    new FileWriter(
                            historyFile,
                            true
                    );

            historyWriter.write(
                    dateTime
                            + " | WITHDRAW | ₹"
                            + String.format(
                                    "%.2f",
                                    amount
                            )
                            + " | Balance: ₹"
                            + String.format(
                                    "%.2f",
                                    newBalance
                            )
                            + "\n"
            );

            historyWriter.close();

            // =================================================
            // SUCCESS MESSAGE
            // =================================================

            JOptionPane.showMessageDialog(
                    this,
                    "₹"
                            + String.format(
                                    "%.2f",
                                    amount
                            )
                            + " withdrawn successfully!\n\n"
                            + "Remaining Balance: ₹"
                            + String.format(
                                    "%.2f",
                                    newBalance
                            )
            );

            // Clear field
            amountField.setText("");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number!"
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error processing withdrawal!"
            );

            ex.printStackTrace();
        }
    }
}