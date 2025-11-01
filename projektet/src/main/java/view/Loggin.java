package view;

import java.awt.*;
import javax.swing.*;
import controller.*;

public class Loggin extends JFrame {

    private JLabel usernameLabel = new JLabel("Användare: ");
    private JLabel passwordLabel = new JLabel("Lösenord:  ");
    private JTextField username = new JTextField("Matias", 10);
    private JPasswordField password = new JPasswordField("1234", 10);
    private JComboBox<String> role = new JComboBox<String>(new String[] { "Student", "Lärare", "Admin" });
    private JButton login = new JButton("Logga in");
    private JButton skapakonto = new JButton("Skapa konto");
    private JPanel namndel, passdel, roledel, loginPanel;
    private String namn, pass, roleVal, personnummer;

    public Loggin(UserCon uc, LärareCon lc, AdminCon ac, StudentCon sc) {
        setSize(500, 300);
        initComponents();

        login.addActionListener(e -> loginFunction(uc, sc, lc, ac));
        skapakonto.addActionListener(e -> CreatAccount(uc, sc, lc, ac));

        // pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        stil(passwordLabel);
        stil(usernameLabel);
        stil(username);
        stil(password);
        stil(login);
        stil(role);
        stil(skapakonto);

        namndel = new JPanel();
        passdel = new JPanel();
        roledel = new JPanel();
        loginPanel = new JPanel();

        loginPanel.setBackground(Color.DARK_GRAY);
        namndel.setOpaque(false);
        passdel.setOpaque(false);
        roledel.setOpaque(false);

        namndel.add(usernameLabel, BorderLayout.NORTH);
        namndel.add(username, BorderLayout.SOUTH);

        passdel.add(passwordLabel, BorderLayout.NORTH);
        passdel.add(password, BorderLayout.SOUTH);

        roledel.add(login, BorderLayout.WEST);
        roledel.add(role, BorderLayout.EAST);
        roledel.add(skapakonto, BorderLayout.EAST);

        loginPanel.add(namndel, BorderLayout.NORTH);
        loginPanel.add(passdel, BorderLayout.CENTER);
        loginPanel.add(roledel, BorderLayout.SOUTH);

        add(loginPanel);
    }

    private void stil(JComponent label) {
        if (label instanceof JLabel) {
            label.setForeground(Color.WHITE);
        }
        label.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void initFields() {
        namn = username.getText();
        pass = new String(password.getPassword());
        roleVal = role.getSelectedItem().toString();
    }

    private void loginFunction(UserCon uc, StudentCon sc, LärareCon lc, AdminCon ac) {
        initFields();
        if (uc.userExists(namn)) {

            if (uc.loggin(namn, pass, roleVal)) {
                dispose();
                switch (roleVal) {
                    case "Student" -> new StudentView(sc, namn);
                    case "Lärare" -> new LärareView(lc, sc, namn);
                    case "Admin" -> new AdminView(ac, namn);
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
