package bank.management.system;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Management System");

        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("BANK MANAGEMENT SYSTEM");
        title.setHorizontalAlignment(JLabel.CENTER);

        frame.add(title);

        frame.setVisible(true);
    }
}