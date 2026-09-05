package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Login extends JFrame {

    JTextField usernameField;
    JPasswordField pinField;

    // =====================================================
    // COLORS
    // =====================================================

    static final Color DARK_BLUE = new Color(13, 42, 78);
    static final Color BLUE = new Color(35, 105, 175);
    static final Color LIGHT_BLUE = new Color(235, 243, 250);
    static final Color DARK_TEXT = new Color(30, 45, 60);
    static final Color GRAY_TEXT = new Color(100, 110, 120);

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    Login() {

        setTitle("Bank Management System - Login");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // =================================================
        // MAIN PANEL
        // =================================================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BLUE);

        setContentPane(mainPanel);

        // =================================================
        // LEFT PANEL
        // =================================================

        JPanel leftPanel = new JPanel();

        leftPanel.setBackground(DARK_BLUE);

        leftPanel.setPreferredSize(
                new Dimension(430, 0)
        );

        leftPanel.setLayout(
                new GridBagLayout()
        );

        // =================================================
        // BRANDING PANEL
        // =================================================

        JPanel brandingPanel = new JPanel();

        brandingPanel.setOpaque(false);

        brandingPanel.setLayout(
                new BoxLayout(
                        brandingPanel,
                        BoxLayout.Y_AXIS
                )
        );

        // =================================================
        // BANK LOGO
        // =================================================

        BankLogo logo = new BankLogo();

        logo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        logo.setPreferredSize(
                new Dimension(150, 150)
        );

        logo.setMaximumSize(
                new Dimension(150, 150)
        );

        logo.setMinimumSize(
                new Dimension(150, 150)
        );

        brandingPanel.add(logo);

        brandingPanel.add(
                Box.createVerticalStrut(20)
        );

        // =================================================
        // BANK NAME
        // =================================================

        JLabel bankName = new JLabel("BANK");

        bankName.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        34
                )
        );

        bankName.setForeground(
                Color.WHITE
        );

        bankName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        brandingPanel.add(bankName);

        brandingPanel.add(
                Box.createVerticalStrut(5)
        );

        // =================================================
        // SYSTEM NAME
        // =================================================

        JLabel systemName =
                new JLabel("MANAGEMENT SYSTEM");

        systemName.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );

        systemName.setForeground(
                new Color(190, 215, 235)
        );

        systemName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        brandingPanel.add(systemName);

        brandingPanel.add(
                Box.createVerticalStrut(40)
        );

        // =================================================
        // SECURITY CHECK
        // =================================================

        JLabel securityIcon =
                new JLabel("✓");

        securityIcon.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        36
                )
        );

        securityIcon.setForeground(
                new Color(70, 180, 255)
        );

        securityIcon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        brandingPanel.add(securityIcon);

        brandingPanel.add(
                Box.createVerticalStrut(8)
        );

        JLabel secureText =
                new JLabel(
                        "<html><center>" +
                        "Secure banking made<br>" +
                        "simple and convenient." +
                        "</center></html>"
                );

        secureText.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        secureText.setForeground(
                new Color(190, 210, 230)
        );

        secureText.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        brandingPanel.add(secureText);

        leftPanel.add(brandingPanel);

        mainPanel.add(
                leftPanel,
                BorderLayout.WEST
        );

        // =================================================
        // RIGHT PANEL
        // =================================================

        JPanel rightPanel = new JPanel();

        rightPanel.setBackground(
                Color.WHITE
        );

        rightPanel.setLayout(
                new GridBagLayout()
        );

        // =================================================
        // LOGIN CARD
        // =================================================

        JPanel loginCard = new JPanel();

        loginCard.setBackground(
                Color.WHITE
        );

        loginCard.setLayout(null);

        loginCard.setPreferredSize(
                new Dimension(500, 570)
        );

        // =================================================
        // TITLE
        // =================================================

        JLabel title =
                new JLabel("Welcome Back!");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(
                DARK_TEXT
        );

        title.setBounds(
                60,
                35,
                380,
                45
        );

        loginCard.add(title);

        // =================================================
        // SUBTITLE
        // =================================================

        JLabel subtitle =
                new JLabel(
                        "Login to access your bank account"
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setForeground(
                GRAY_TEXT
        );

        subtitle.setBounds(
                62,
                80,
                380,
                25
        );

        loginCard.add(subtitle);

        // =================================================
        // USERNAME LABEL
        // =================================================

        JLabel usernameLabel =
                new JLabel("USERNAME");

        usernameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        usernameLabel.setForeground(
                DARK_TEXT
        );

        usernameLabel.setBounds(
                60,
                135,
                380,
                25
        );

        loginCard.add(usernameLabel);

        // =================================================
        // USERNAME FIELD
        // =================================================

        usernameField =
                new JTextField();

        usernameField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );

        usernameField.setBounds(
                60,
                162,
                380,
                48
        );

        usernameField.setBackground(
                Color.WHITE
        );

        usernameField.setForeground(
                DARK_TEXT
        );

        usernameField.setCaretColor(
                BLUE
        );

        usernameField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(190, 205, 220),
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                5,
                                12,
                                5,
                                12
                        )
                )
        );

        loginCard.add(usernameField);

        // =================================================
        // PIN LABEL
        // =================================================

        JLabel pinLabel =
                new JLabel("PIN");

        pinLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        pinLabel.setForeground(
                DARK_TEXT
        );

        pinLabel.setBounds(
                60,
                230,
                380,
                25
        );

        loginCard.add(pinLabel);

        // =================================================
        // PIN FIELD
        // =================================================

        pinField =
                new JPasswordField();

        pinField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );

        pinField.setBounds(
                60,
                257,
                380,
                48
        );

        pinField.setBackground(
                Color.WHITE
        );

        pinField.setForeground(
                DARK_TEXT
        );

        pinField.setCaretColor(
                BLUE
        );

        pinField.setEchoChar(
                '•'
        );

        pinField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(190, 205, 220),
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                5,
                                12,
                                5,
                                12
                        )
                )
        );

        loginCard.add(pinField);

        // =================================================
        // SHOW PIN
        // =================================================

        JCheckBox showPin =
                new JCheckBox("Show PIN");

        showPin.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        showPin.setForeground(
                GRAY_TEXT
        );

        showPin.setBackground(
                Color.WHITE
        );

        showPin.setFocusPainted(
                false
        );

        showPin.setBounds(
                60,
                315,
                120,
                25
        );

        loginCard.add(showPin);

        showPin.addActionListener(e -> {

            if (showPin.isSelected()) {

                pinField.setEchoChar(
                        (char) 0
                );

            } else {

                pinField.setEchoChar(
                        '•'
                );
            }
        });

        // =================================================
        // LOGIN BUTTON
        // =================================================

        JButton loginButton =
                new JButton("LOGIN");

        loginButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        loginButton.setForeground(
                Color.WHITE
        );

        loginButton.setBackground(
                BLUE
        );

        loginButton.setFocusPainted(
                false
        );

        loginButton.setBorderPainted(
                false
        );

        loginButton.setBounds(
                60,
                355,
                380,
                50
        );

        loginCard.add(loginButton);

        loginButton.addActionListener(
                e -> login()
        );

        // =================================================
        // ACCOUNT TEXT
        // =================================================

        JLabel accountText =
                new JLabel(
                        "Don't have an account?"
                );

        accountText.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        accountText.setForeground(
                GRAY_TEXT
        );

        accountText.setBounds(
                75,
                425,
                150,
                25
        );

        loginCard.add(accountText);

        // =================================================
        // SIGNUP BUTTON
        // =================================================

        JButton signupButton =
                new JButton(
                        "CREATE ACCOUNT"
                );

        signupButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        signupButton.setForeground(
                BLUE
        );

        signupButton.setBackground(
                Color.WHITE
        );

        signupButton.setBorderPainted(
                false
        );

        signupButton.setFocusPainted(
                false
        );

        signupButton.setBounds(
                225,
                422,
                190,
                30
        );

        loginCard.add(signupButton);

        signupButton.addActionListener(
                e -> new Signup()
        );

        // =================================================
        // EXIT BUTTON
        // =================================================

        JButton exitButton =
                new JButton("EXIT");

        exitButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        exitButton.setForeground(
                new Color(190, 60, 60)
        );

        exitButton.setBackground(
                Color.WHITE
        );

        exitButton.setBorderPainted(
                false
        );

        exitButton.setFocusPainted(
                false
        );

        exitButton.setBounds(
                60,
                475,
                80,
                30
        );

        loginCard.add(exitButton);

        exitButton.addActionListener(
                e -> System.exit(0)
        );

        // ENTER KEY
        pinField.addActionListener(
                e -> login()
        );

        rightPanel.add(loginCard);

        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER
        );

        setVisible(true);
    }

    // =====================================================
    // LOGIN METHOD
    // =====================================================

    private void login() {

        String username =
                usernameField.getText().trim();

        String pin =
                new String(
                        pinField.getPassword()
                );

        if (username.isEmpty() ||
                pin.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter username and PIN.",
                    "Login",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        File userFile =
                new File(
                        "data/users.txt"
                );

        if (!userFile.exists()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No registered users found.\n" +
                    "Please create an account first.",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        boolean loginSuccess = false;

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(userFile)
                    );

            String line;

            while ((line =
                    reader.readLine()) != null) {

                String[] userData =
                        line.split(",");

                if (userData.length >= 2) {

                    String savedUsername =
                            userData[0].trim();

                    String savedPin =
                            userData[1].trim();

                    if (username.equals(
                            savedUsername)
                            &&
                            pin.equals(
                                    savedPin)) {

                        loginSuccess = true;

                        break;
                    }
                }
            }

            reader.close();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error reading user data.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            ex.printStackTrace();

            return;
        }

        // =================================================
        // LOGIN SUCCESS
        // =================================================

        if (loginSuccess) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login successful!",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE
            );

            dispose();

            new Dashboard(username);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or PIN.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // CUSTOM BANK LOGO
    // =====================================================

    static class BankLogo extends JPanel {

        BankLogo() {

            setOpaque(false);
        }

        @Override
        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int w = getWidth();
            int h = getHeight();

            // =================================================
            // OUTER BLUE CIRCLE
            // =================================================

            g2.setColor(BLUE);

            g2.fillOval(
                    5,
                    5,
                    w - 10,
                    h - 10
            );

            // =================================================
            // WHITE CIRCLE
            // =================================================

            g2.setColor(
                    Color.WHITE
            );

            g2.fillOval(
                    13,
                    13,
                    w - 26,
                    h - 26
            );

            // =================================================
            // BLUE BORDER
            // =================================================

            g2.setColor(
                    new Color(
                            60,
                            145,
                            220
                    )
            );

            g2.setStroke(
                    new BasicStroke(3)
            );

            g2.drawOval(
                    13,
                    13,
                    w - 26,
                    h - 26
            );

            // =================================================
            // BANK ROOF
            // =================================================

            g2.setColor(
                    DARK_BLUE
            );

            Polygon roof =
                    new Polygon();

            roof.addPoint(
                    w / 2,
                    32
            );

            roof.addPoint(
                    32,
                    62
            );

            roof.addPoint(
                    w - 32,
                    62
            );

            g2.fillPolygon(
                    roof
            );

            // =================================================
            // ROOF LINE
            // =================================================

            g2.setColor(
                    BLUE
            );

            g2.fillRect(
                    30,
                    62,
                    w - 60,
                    7
            );

            // =================================================
            // BANK TEXT
            // =================================================

            g2.setColor(
                    Color.WHITE
            );

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            14
                    )
            );

            FontMetrics fm =
                    g2.getFontMetrics();

            String text = "BANK";

            int textWidth =
                    fm.stringWidth(text);

            g2.drawString(
                    text,
                    (w - textWidth) / 2,
                    55
            );

            // =================================================
            // PILLARS
            // =================================================

            g2.setColor(
                    DARK_BLUE
            );

            int pillarTop = 70;
            int pillarBottom = 105;

            int[] positions = {
                    42,
                    64,
                    86,
                    108
            };

            for (int x : positions) {

                // Pillar
                g2.fillRect(
                        x,
                        pillarTop,
                        10,
                        pillarBottom -
                                pillarTop
                );

                // Top
                g2.fillRect(
                        x - 3,
                        pillarTop - 4,
                        16,
                        5
                );

                // Bottom
                g2.fillRect(
                        x - 3,
                        pillarBottom,
                        16,
                        5
                );
            }

            // =================================================
            // BASE
            // =================================================

            g2.fillRect(
                    35,
                    110,
                    w - 70,
                    7
            );

            g2.fillRect(
                    28,
                    118,
                    w - 56,
                    5
            );

            g2.dispose();
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> new Login()
        );
    }
}