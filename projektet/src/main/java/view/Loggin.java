package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import model.User;

public class Loggin extends JFrame {

    private JLabel usernameLabel = new JLabel("Användare: ");
    private JLabel passwordLabel = new JLabel("Lösenord:   ");
    private JTextField username = new JTextField("Matias", 10);
    private JPasswordField password = new JPasswordField("1234", 10);
    private JComboBox<String> role = new JComboBox<String>(new String[] { "Student", "Lärare", "Admin" });
    private JButton login = new JButton("Logga in");
    private JButton skapakonto = new JButton("Skapa konto");
    private JButton Avsluta = new JButton("Avsluta");
    private JPanel namndel, passdel, roledel, loginPanel;
    private String namn, pass, roleVal, personnummer;

    public Loggin(UserCon uc, LärareCon lc, AdminCon ac, StudentCon sc, KursCon kc, KurstillfälleCon kfc, BetygCon bc, RapporteringCon rc, LärarTilldelningCon ltc, RegistreringCon rpc) {
        setSize(450, 500);
        initComponents();

        login.addActionListener(e -> loginFunction(uc, sc, lc, ac, kc, kfc, bc, rc, ltc, rpc));
        skapakonto.addActionListener(e -> CreatAccount(uc, sc, lc, ac));
        Avsluta.addActionListener(e -> dispose());

        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        stil(passwordLabel);
        stil(usernameLabel);
        stil(username);
        stil(password);
        stil(login);
        stil(role);
        stil(skapakonto);
        stil(Avsluta);

        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBackground(Color.DARK_GRAY);
        namndel = new JPanel();
        passdel = new JPanel();
        roledel = new JPanel();

        ImageIcon icon = new ImageIcon(getClass().getResource("/image.png"));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(Box.createVerticalStrut(40));
        loginPanel.add(imageLabel);
        loginPanel.add(Box.createVerticalStrut(5));

        namndel.add(usernameLabel);
        namndel.add(username);
        namndel.setOpaque(false);

        passdel.add(passwordLabel);
        passdel.add(password);
        passdel.setOpaque(false);

        roledel.add(role);
        roledel.add(login);
        roledel.add(skapakonto);
        roledel.setOpaque(false);
        roledel.setAlignmentX(Component.CENTER_ALIGNMENT);
        Avsluta.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(Box.createVerticalGlue());
        loginPanel.add(namndel);
        loginPanel.add(passdel);
        loginPanel.add(roledel);
        loginPanel.add(Avsluta);
        loginPanel.add(Box.createVerticalGlue());

        add(loginPanel);

    }

    private void stil(JComponent label) {
        if (label instanceof JLabel) {
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.BOLD, 22));
        }

        if (label instanceof JButton) {
            label.setBackground(Color.DARK_GRAY);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.BOLD, 20));
            label.setFocusable(false);
        }

        if (label instanceof JComboBox) {
            label.setBackground(Color.DARK_GRAY);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            label.setFocusable(false);
        }

        if (label instanceof JTextField textField) {
            label.setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
            label.setFont(new Font("Segoe UI", Font.BOLD, 22));
            textField.setHorizontalAlignment(JTextField.CENTER);
        }
    }

    private void initFields() {
        namn = username.getText();
        pass = new String(password.getPassword());
        roleVal = role.getSelectedItem().toString();
    }

    private void loginFunction(UserCon uc, StudentCon sc, LärareCon lc, AdminCon ac, KursCon kc, KurstillfälleCon kfc, BetygCon bc, RapporteringCon rc, LärarTilldelningCon ltc, RegistreringCon rpc) {
        initFields();
        if (uc.userExists(namn)) {

            if (uc.loggin(namn, pass, roleVal)) {
                dispose();
                switch (roleVal) {
                    case "Student" -> new StudentView(namn, sc, kfc);
                    case "Lärare" -> new LärareView(namn, lc, rc, rpc);
                    case "Admin" -> new AdminView(namn, ac, lc, sc, kc, kfc, bc, rc, ltc);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Fel Roll eller lösenord!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Användaren finns inte!");
        }
    }

    private void CreatAccount(UserCon uc, StudentCon sc, LärareCon lc, AdminCon ac) {
        initFields();
        if (namn.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ange användarnamn och lösenord!");
            return;
        }

        if (roleVal.equals("Student")) {
            personnummer = JOptionPane.showInputDialog(this, "Ange ditt personnummer:");
            if (personnummer == null || personnummer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Personnummer krävs för studenter.");
                return;
            }
        }

        if (uc.userExists(namn)) {
            JOptionPane.showMessageDialog(this, "Användaren finns redan!");
            return;
        }

        try {
            uc.createUser(namn, pass, roleVal, personnummer, sc, lc, ac);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fel: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Användaren har skapats!");
    }
}
