package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class BalanceEnquiry extends JFrame {

    String username;

    BalanceEnquiry(String username) {

        this.username = username;

        setTitle("Bank Management System - Balance");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("BALANCE ENQUIRY");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(100, 30, 300, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        JLabel userLabel = new JLabel("Account Holder:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLabel.setBounds(80, 100, 150, 30);
        add(userLabel);

        JLabel nameLabel = new JLabel(username);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setBounds(250, 100, 180, 30);
        add(nameLabel);

        JLabel balanceLabel = new JLabel("Current Balance:");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setBounds(80, 150, 150, 30);
        add(balanceLabel);

        double balance = getBalance();

        JLabel amountLabel = new JLabel("₹ " + String.format("%.2f", balance));
        amountLabel.setFont(new Font("Arial", Font.BOLD, 20));
        amountLabel.setBounds(250, 145, 180, 40);
        add(amountLabel);

        JButton closeButton = new JButton("CLOSE");
        closeButton.setBounds(190, 210, 120, 35);
        add(closeButton);

        closeButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private double getBalance() {

        File balanceFile = new File(
                "data/" + username + "_balance.txt"
        );

        if (!balanceFile.exists()) {
            return 0;
        }

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(balanceFile)
            );

            String line = reader.readLine();
            reader.close();

            if (line != null && !line.isEmpty()) {
                return Double.parseDouble(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}