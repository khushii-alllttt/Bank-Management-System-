package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private String username;

    // =====================================================
    // COLORS
    // =====================================================

    private final Color ATM_BODY = new Color(48, 52, 56);
    private final Color ATM_DARK = new Color(25, 29, 33);
    private final Color ATM_EDGE = new Color(105, 110, 115);

    private final Color NAVY = new Color(7, 35, 62);
    private final Color BLUE = new Color(24, 100, 170);
    private final Color LIGHT_BG = new Color(235, 243, 249);

    private final Color RED = new Color(195, 55, 55);

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    Dashboard(String username) {

        this.username = username;

        setTitle("Bank Management System - Dashboard");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ATMPanel mainPanel = new ATMPanel();
        mainPanel.setLayout(null);

        setContentPane(mainPanel);

        // =================================================
        // ATM SCREEN
        // =================================================

        JPanel screen =
                new JPanel();

        screen.setLayout(null);

        screen.setBackground(
                Color.WHITE
        );

        screen.setBounds(
                55, 55, 1090, 505
        );

        screen.setBorder(
                BorderFactory.createLineBorder(
                        new Color(15, 18, 20),
                        8
                )
        );

        mainPanel.add(screen);

        // =================================================
        // LEFT SIDEBAR
        // =================================================

        JPanel sidebar =
                new JPanel();

        sidebar.setLayout(null);

        sidebar.setBackground(
                NAVY
        );

        sidebar.setBounds(
                0, 0, 210, 489
        );

        screen.add(sidebar);

        // =================================================
        // LOGO
        // =================================================

        BankLogo logo =
                new BankLogo();

        logo.setBounds(
                65, 20, 80, 80
        );

        sidebar.add(logo);

        // =================================================
        // BANK
        // =================================================

        JLabel bank =
                new JLabel("BANK");

        bank.setForeground(
                Color.WHITE
        );

        bank.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        bank.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        bank.setBounds(
                20, 105, 170, 35
        );

        sidebar.add(bank);

        JLabel system =
                new JLabel(
                        "MANAGEMENT SYSTEM"
                );

        system.setForeground(
                new Color(175, 200, 220)
        );

        system.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        11
                )
        );

        system.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        system.setBounds(
                10, 140, 190, 25
        );

        sidebar.add(system);

        // =================================================
        // LINE
        // =================================================

        JSeparator line =
                new JSeparator();

        line.setForeground(
                new Color(55, 80, 105)
        );

        line.setBounds(
                20, 180, 170, 1
        );

        sidebar.add(line);

        // =================================================
        // MAIN MENU
        // =================================================

        JLabel menu =
                new JLabel("MAIN MENU");

        menu.setForeground(
                new Color(150, 180, 205)
        );

        menu.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        10
                )
        );

        menu.setBounds(
                25, 195, 150, 20
        );

        sidebar.add(menu);

        // =================================================
        // DASHBOARD
        // =================================================

        JButton dashboard =
                createMenuButton(
                        "Dashboard",
                        20,
                        225
                );

        sidebar.add(dashboard);

        // =================================================
        // ACCOUNT
        // =================================================

        JButton account =
                createMenuButton(
                        "Account",
                        20,
                        275
                );

        sidebar.add(account);

        // =================================================
        // USER BOX
        // =================================================

        JPanel userBox =
                new JPanel();

        userBox.setLayout(null);

        userBox.setBackground(
                new Color(13, 55, 88)
        );

        userBox.setBounds(
                15, 400, 180, 70
        );

        sidebar.add(userBox);

        JLabel dot =
                new JLabel("●");

        dot.setForeground(
                new Color(60, 190, 245)
        );

        dot.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        dot.setBounds(
                12, 20, 20, 20
        );

        userBox.add(dot);

        JLabel user =
                new JLabel(username);

        user.setForeground(
                Color.WHITE
        );

        user.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        user.setBounds(
                40, 10, 125, 22
        );

        userBox.add(user);

        JLabel active =
                new JLabel(
                        "Active Account"
                );

        active.setForeground(
                new Color(170, 195, 215)
        );

        active.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        10
                )
        );

        active.setBounds(
                40, 32, 125, 20
        );

        userBox.add(active);

        // =================================================
        // MAIN DASHBOARD AREA
        // =================================================

        JPanel content =
                new JPanel();

        content.setLayout(null);

        content.setBackground(
                LIGHT_BG
        );

        content.setBounds(
                210, 0, 872, 489
        );

        screen.add(content);

        // =================================================
        // TITLE
        // =================================================

        JLabel title =
                new JLabel("Dashboard");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        29
                )
        );

        title.setForeground(
                new Color(30, 45, 60)
        );

        title.setBounds(
                35, 25, 400, 40
        );

        content.add(title);

        JLabel welcome =
                new JLabel(
                        "Welcome back, " +
                        username + "!"
                );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        welcome.setForeground(
                new Color(95, 115, 130)
        );

        welcome.setBounds(
                37, 62, 400, 25
        );

        content.add(welcome);

        // =================================================
        // ACCOUNT OVERVIEW
        // =================================================

        JPanel overview =
                new JPanel();

        overview.setLayout(null);

        overview.setBackground(
                BLUE
        );

        overview.setBounds(
                35, 100, 800, 90
        );

        content.add(overview);

        JLabel overviewTitle =
                new JLabel(
                        "ACCOUNT OVERVIEW"
                );

        overviewTitle.setForeground(
                new Color(200, 225, 242)
        );

        overviewTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        overviewTitle.setBounds(
                22, 12, 200, 20
        );

        overview.add(overviewTitle);

        JLabel overviewText =
                new JLabel(
                        "Manage your account securely and easily"
                );

        overviewText.setForeground(
                Color.WHITE
        );

        overviewText.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        overviewText.setBounds(
                22, 38, 500, 30
        );

        overview.add(overviewText);

        JLabel secure =
                new JLabel(
                        "● Secure Banking"
                );

        secure.setForeground(
                new Color(105, 235, 165)
        );

        secure.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        secure.setBounds(
                650, 33, 140, 25
        );

        overview.add(secure);

        // =================================================
        // SERVICES
        // =================================================

        JLabel services =
                new JLabel(
                        "Banking Services"
                );

        services.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        services.setForeground(
                new Color(25, 43, 60)
        );

        services.setBounds(
                35, 210, 300, 30
        );

        content.add(services);

        JLabel serviceText =
                new JLabel(
                        "Choose an operation to continue"
                );

        serviceText.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        serviceText.setForeground(
                new Color(100, 120, 135)
        );

        serviceText.setBounds(
                37, 238, 300, 20
        );

        content.add(serviceText);

        // =================================================
        // ROW 1
        // =================================================

        JButton deposit =
                createServiceButton(
                        "DEPOSIT",
                        "Add money to your account",
                        35,
                        270
                );

        content.add(deposit);

        deposit.addActionListener(
                e -> new Deposit(username)
        );

        JButton withdraw =
                createServiceButton(
                        "WITHDRAW",
                        "Withdraw money from account",
                        305,
                        270
                );

        content.add(withdraw);

        withdraw.addActionListener(
                e -> new Withdraw(username)
        );

        JButton balance =
                createServiceButton(
                        "BALANCE ENQUIRY",
                        "Check your current balance",
                        575,
                        270
                );

        content.add(balance);

        balance.addActionListener(
                e -> new BalanceEnquiry(username)
        );

        // =================================================
        // ROW 2
        // =================================================

        JButton statement =
                createServiceButton(
                        "MINI STATEMENT",
                        "View transaction history",
                        35,
                        360
                );

        content.add(statement);

        statement.addActionListener(
                e -> new MiniStatement(username)
        );

        JButton fastCash =
                createServiceButton(
                        "FAST CASH",
                        "Quickly withdraw fixed amount",
                        305,
                        360
                );

        content.add(fastCash);

        fastCash.addActionListener(
                e -> new FastCash(username)
        );

        JButton changePin =
                createServiceButton(
                        "CHANGE PIN",
                        "Update your security PIN",
                        575,
                        360
                );

        content.add(changePin);

        changePin.addActionListener(
                e -> new ChangePin(username)
        );

        // =================================================
        // LOGOUT
        // =================================================

        JButton logout =
                new JButton("LOGOUT");

        logout.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        logout.setForeground(
                Color.WHITE
        );

        logout.setBackground(
                RED
        );

        logout.setFocusPainted(false);

        logout.setBorderPainted(false);

        logout.setBounds(
                675, 445, 160, 38
        );

        content.add(logout);

        logout.addActionListener(
                e -> {
                    dispose();
                    new Login();
                }
        );

        // =================================================
        // ATM CARD SLOT
        // =================================================

        createCardSlot(mainPanel);

        // =================================================
        // ATM RECEIPT SLOT
        // =================================================

        createReceiptSlot(mainPanel);

        // =================================================
        // ATM KEYPAD
        // =================================================

        createKeypad(mainPanel);

        // =================================================
        // ATM SPEAKER
        // =================================================

        createSpeaker(mainPanel);

        setVisible(true);
    }

    // =====================================================
    // MENU BUTTON
    // =====================================================

    private JButton createMenuButton(
            String text,
            int x,
            int y
    ) {

        JButton button =
                new JButton(text);

        button.setBounds(
                x, y, 170, 42
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                new Color(13, 58, 92)
        );

        button.setBorderPainted(false);
        button.setFocusPainted(false);

        return button;
    }

    // =====================================================
    // SERVICE BUTTON
    // =====================================================

    private JButton createServiceButton(
            String title,
            String description,
            int x,
            int y
    ) {

        JButton button =
                new JButton();

        button.setLayout(null);

        button.setBounds(
                x, y, 250, 75
        );

        button.setBackground(
                Color.WHITE
        );

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(200, 212, 222),
                        1
                )
        );

        button.setFocusPainted(false);

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setForeground(
                new Color(8, 48, 85)
        );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        titleLabel.setBounds(
                16, 13, 215, 22
        );

        button.add(titleLabel);

        JLabel descLabel =
                new JLabel(description);

        descLabel.setForeground(
                new Color(100, 120, 135)
        );

        descLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        10
                )
        );

        descLabel.setBounds(
                16, 40, 220, 20
        );

        button.add(descLabel);

        return button;
    }

    // =====================================================
    // CARD SLOT
    // =====================================================

    private void createCardSlot(
            JPanel mainPanel
    ) {

        JPanel card =
                new JPanel();

        card.setLayout(null);

        card.setBackground(
                new Color(30, 34, 38)
        );

        card.setBorder(
                BorderFactory.createLineBorder(
                        new Color(110, 115, 120),
                        2
                )
        );

        card.setBounds(
                875, 590, 250, 70
        );

        mainPanel.add(card);

        JLabel text =
                new JLabel("INSERT CARD");

        text.setForeground(
                Color.WHITE
        );

        text.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        text.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        text.setBounds(
                0, 8, 250, 20
        );

        card.add(text);

        JPanel slot =
                new JPanel();

        slot.setBackground(
                Color.BLACK
        );

        slot.setBounds(
                35, 40, 180, 10
        );

        card.add(slot);
    }

    // =====================================================
    // RECEIPT SLOT
    // =====================================================

    private void createReceiptSlot(
            JPanel mainPanel
    ) {

        JPanel receipt =
                new JPanel();

        receipt.setLayout(null);

        receipt.setBackground(
                new Color(30, 34, 38)
        );

        receipt.setBorder(
                BorderFactory.createLineBorder(
                        new Color(110, 115, 120),
                        2
                )
        );

        receipt.setBounds(
                55, 590, 250, 70
        );

        mainPanel.add(receipt);

        JLabel text =
                new JLabel("RECEIPT");

        text.setForeground(
                Color.WHITE
        );

        text.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        text.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        text.setBounds(
                0, 8, 250, 20
        );

        receipt.add(text);

        JPanel slot =
                new JPanel();

        slot.setBackground(
                Color.BLACK
        );

        slot.setBounds(
                35, 40, 180, 10
        );

        receipt.add(slot);
    }

    // =====================================================
    // KEYPAD
    // =====================================================

    private void createKeypad(
            JPanel mainPanel
    ) {

        JPanel keypad =
                new JPanel();

        keypad.setLayout(
                new GridLayout(
                        4,
                        3,
                        5,
                        5
                )
        );

        keypad.setBackground(
                new Color(35, 39, 43)
        );

        keypad.setBorder(
                BorderFactory.createLineBorder(
                        new Color(100, 105, 110),
                        2
                )
        );

        keypad.setBounds(
                570, 580, 230, 90
        );

        mainPanel.add(keypad);

        String[] numbers = {
                "1", "2", "3",
                "4", "5", "6",
                "7", "8", "9",
                "*", "0", "#"
        };

        for (String number : numbers) {

            JButton key =
                    new JButton(number);

            key.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            11
                    )
            );

            key.setBackground(
                    new Color(225, 228, 230)
            );

            key.setForeground(
                    new Color(35, 40, 45)
            );

            key.setFocusPainted(false);

            keypad.add(key);
        }
    }

    // =====================================================
    // SPEAKER
    // =====================================================

    private void createSpeaker(
            JPanel mainPanel
    ) {

        JPanel speaker =
                new JPanel();

        speaker.setLayout(null);

        speaker.setBackground(
                new Color(18, 21, 24)
        );

        speaker.setBorder(
                BorderFactory.createLineBorder(
                        new Color(70, 75, 80),
                        1
                )
        );

        speaker.setBounds(
                340, 590, 170, 45
        );

        mainPanel.add(speaker);

        for (int i = 0; i < 9; i++) {

            JPanel hole =
                    new JPanel();

            hole.setBackground(
                    new Color(80, 85, 90)
            );

            hole.setBounds(
                    15 + i * 16,
                    18,
                    7,
                    7
            );

            speaker.add(hole);
        }
    }

    // =====================================================
    // ATM BACKGROUND
    // =====================================================

    static class ATMPanel
            extends JPanel {

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

            // ---------------------------------------------
            // MAIN METAL BODY
            // ---------------------------------------------

            GradientPaint metal =
                    new GradientPaint(
                            0,
                            0,
                            new Color(90, 95, 100),
                            w,
                            h,
                            new Color(35, 39, 43)
                    );

            g2.setPaint(metal);

            g2.fillRect(
                    0,
                    0,
                    w,
                    h
            );

            // ---------------------------------------------
            // OUTER ATM FRAME
            // ---------------------------------------------

            g2.setColor(
                    new Color(
                            120,
                            125,
                            130
                    )
            );

            g2.fillRoundRect(
                    12,
                    12,
                    w - 24,
                    h - 24,
                    25,
                    25
            );

            // ---------------------------------------------
            // INNER FRAME
            // ---------------------------------------------

            g2.setColor(
                    new Color(
                            30,
                            34,
                            38
                    )
            );

            g2.fillRoundRect(
                    20,
                    20,
                    w - 40,
                    h - 40,
                    20,
                    20
            );

            // ---------------------------------------------
            // TOP HEADER
            // ---------------------------------------------

            g2.setColor(
                    new Color(
                            20,
                            24,
                            28
                    )
            );

            g2.fillRoundRect(
                    35,
                    28,
                    w - 70,
                    25,
                    8,
                    8
            );

            // ---------------------------------------------
            // ATM BRAND
            // ---------------------------------------------

            g2.setColor(
                    new Color(
                            210,
                            215,
                            220
                    )
            );

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            12
                    )
            );

            g2.drawString(
                    "BANK ATM",
                    55,
                    45
            );

            // ---------------------------------------------
            // STATUS LIGHT
            // ---------------------------------------------

            g2.setColor(
                    new Color(
                            55,
                            210,
                            120
                    )
            );

            g2.fillOval(
                    w - 145,
                    36,
                    7,
                    7
            );

            g2.setColor(
                    new Color(
                            180,
                            190,
                            195
                    )
            );

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            9
                    )
            );

            g2.drawString(
                    "ONLINE",
                    w - 130,
                    44
            );

            // ---------------------------------------------
            // SIDE BUTTONS
            // ---------------------------------------------

            for (int i = 0; i < 5; i++) {

                int y =
                        120 + i * 75;

                g2.setColor(
                        new Color(
                                50,
                                55,
                                60
                        )
                );

                g2.fillRoundRect(
                        28,
                        y,
                        18,
                        45,
                        5,
                        5
                );

                g2.fillRoundRect(
                        w - 46,
                        y,
                        18,
                        45,
                        5,
                        5
                );

                g2.setColor(
                        new Color(
                                120,
                                125,
                                130
                        )
                );

                g2.drawRoundRect(
                        28,
                        y,
                        18,
                        45,
                        5,
                        5
                );

                g2.drawRoundRect(
                        w - 46,
                        y,
                        18,
                        45,
                        5,
                        5
                );
            }

            // ---------------------------------------------
            // BOTTOM METAL PANEL
            // ---------------------------------------------

            g2.setColor(
                    new Color(
                            42,
                            46,
                            50
                    )
            );

            g2.fillRect(
                    25,
                    570,
                    w - 50,
                    130
            );

            // ---------------------------------------------
            // BOTTOM HIGHLIGHT
            // ---------------------------------------------

            g2.setColor(
                    new Color(
                            115,
                            120,
                            125
                    )
            );

            g2.drawLine(
                    25,
                    570,
                    w - 25,
                    570
            );

            g2.dispose();
        }
    }

    // =====================================================
    // BANK LOGO
    // =====================================================

    static class BankLogo
            extends JPanel {

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

            // Outer circle
            g2.setColor(
                    new Color(
                            35,
                            110,
                            185
                    )
            );

            g2.fillOval(
                    2,
                    2,
                    w - 4,
                    h - 4
            );

            // White circle
            g2.setColor(Color.WHITE);

            g2.fillOval(
                    9,
                    9,
                    w - 18,
                    h - 18
            );

            // Roof
            g2.setColor(
                    new Color(
                            8,
                            45,
                            80
                    )
            );

            Polygon roof =
                    new Polygon();

            roof.addPoint(
                    w / 2,
                    18
            );

            roof.addPoint(
                    17,
                    36
            );

            roof.addPoint(
                    w - 17,
                    36
            );

            g2.fillPolygon(roof);

            // Building
            g2.fillRect(
                    21,
                    37,
                    w - 42,
                    28
            );

            // Pillars
            g2.setColor(Color.WHITE);

            for (int i = 0; i < 4; i++) {

                int x =
                        27 + i * 12;

                g2.fillRect(
                        x,
                        40,
                        7,
                        22
                );
            }

            // Base
            g2.setColor(
                    new Color(
                            8,
                            45,
                            80
                    )
            );

            g2.fillRect(
                    16,
                    65,
                    w - 32,
                    6
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
                () -> new Dashboard("khushi")
        );
    }
}