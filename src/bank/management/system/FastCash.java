package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FastCash extends JFrame {

    String username;

    FastCash(String username) {

        this.username = username;

        setTitle("Bank Management System - Fast Cash");
        setSize(550, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // ================= TITLE =================

        JLabel title = new JLabel("FAST CASH");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(125, 25, 300, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        // ================= ₹500 =================

        JButton fiveHundred = new JButton("₹500");
        fiveHundred.setBounds(80, 100, 160, 50);
        add(fiveHundred);

        // ================= ₹1000 =================

        JButton thousand = new JButton("₹1,000");
        thousand.setBounds(300, 100, 160, 50);
        add(thousand);

        // ================= ₹2000 =================

        JButton twoThousand = new JButton("₹2,000");
        twoThousand.setBounds(80, 170, 160, 50);
        add(twoThousand);

        // ================= ₹5000 =================

        JButton fiveThousand = new JButton("₹5,000");
        fiveThousand.setBounds(300, 170, 160, 50);
        add(fiveThousand);

        // ================= ₹10000 =================

        JButton tenThousand = new JButton("₹10,000");
        tenThousand.setBounds(190, 240, 160, 50);
        add(tenThousand);

        // ================= CLOSE =================

        JButton closeButton = new JButton("CLOSE");
        closeButton.setBounds(215, 315, 120, 35);
        add(closeButton);

        // ================= BUTTON ACTIONS =================

        fiveHundred.addActionListener(e -> withdraw(500));

        thousand.addActionListener(e -> withdraw(1000));

        twoThousand.addActionListener(e -> withdraw(2000));

        fiveThousand.addActionListener(e -> withdraw(5000));

        tenThousand.addActionListener(e -> withdraw(10000));

        closeButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    // =========================================================
    // FAST CASH WITHDRAW
    // =========================================================

    private void withdraw(double amount) {

        File balanceFile = new File(
                "data/" + username + "_balance.txt"
        );

        double currentBalance = 0;

        try {

            // ================= READ BALANCE =================

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

            // ================= CHECK BALANCE =================

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

            // ================= NEW BALANCE =================

            double newBalance =
                    currentBalance - amount;

            // Save new balance
            FileWriter balanceWriter =
                    new FileWriter(balanceFile);

            balanceWriter.write(
                    String.valueOf(newBalance)
            );

            balanceWriter.close();

            // ================= DATE & TIME =================

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy HH:mm"
                    );

            String dateTime =
                    LocalDateTime.now().format(formatter);

            // ================= TRANSACTION HISTORY =================

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
                            + " | FAST CASH | ₹"
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

            // ================= SUCCESS MESSAGE =================

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

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid balance data!"
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error processing Fast Cash!"
            );

            ex.printStackTrace();
        }
    }
}