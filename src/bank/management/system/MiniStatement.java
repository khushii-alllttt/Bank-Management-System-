package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MiniStatement extends JFrame {

    String username;
    JTextArea statementArea;

    MiniStatement(String username) {

        this.username = username;

        setTitle("Bank Management System - Mini Statement");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("MINI STATEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(150, 20, 350, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        JLabel userLabel = new JLabel(
                "Account Holder: " + username
        );
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLabel.setBounds(40, 75, 300, 30);
        add(userLabel);

        statementArea = new JTextArea();
        statementArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        statementArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(statementArea);
        scrollPane.setBounds(40, 115, 560, 280);
        add(scrollPane);

        JButton closeButton = new JButton("CLOSE");
        closeButton.setBounds(260, 420, 120, 35);
        add(closeButton);

        closeButton.addActionListener(e -> dispose());

        loadTransactions();

        setVisible(true);
    }

    private void loadTransactions() {

        File historyFile = new File(
                "data/" + username + "_transactions.txt"
        );

        if (!historyFile.exists()) {

            statementArea.setText(
                    "No transactions found.\n\n"
                            + "Please make a Deposit or Withdraw first."
            );

            return;
        }

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(historyFile)
            );

            StringBuilder statement = new StringBuilder();

            statement.append(
                    "==============================================\n"
            );

            statement.append(
                    "              TRANSACTION HISTORY\n"
            );

            statement.append(
                    "==============================================\n\n"
            );

            String line;

            while ((line = reader.readLine()) != null) {

                statement.append(line);
                statement.append("\n");
            }

            reader.close();

            statement.append(
                    "\n==============================================\n"
            );

            statementArea.setText(statement.toString());

        } catch (IOException ex) {

            statementArea.setText(
                    "Error reading transaction history."
            );

            ex.printStackTrace();
        }
    }
}