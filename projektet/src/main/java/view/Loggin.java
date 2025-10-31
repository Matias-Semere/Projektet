package view;

import java.awt.*;
import javax.swing.*;
import controller.*;

public class Loggin extends JDialog {

    private JLabel usernameLabel = new JLabel("Användare: ");
    private JLabel passwordLabel = new JLabel("Lösenord:  ");
    private JTextField username = new JTextField("Matias", 10);
    private JPasswordField password = new JPasswordField("1234", 10);
    private JComboBox<String> role = new JComboBox<String>(new String[] { "Student", "Lärare", "Admin" });
    private JButton login = new JButton("Logga in");
    private JButton skapakonto = new JButton("Skapa konto");
    private JPanel namndel, passdel, roledel, loginPanel;

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
        styleinit();

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

    private void styleinit() {
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
    }

    private void stil(JComponent label) {
        if (label instanceof JLabel) {
            label.setForeground(Color.WHITE);
        }
        label.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void loginFunction(UserCon uc, StudentCon sc, LärareCon lc, AdminCon ac) {
        String val = (String) role.getSelectedItem();
        String userText = username.getText().trim();
        char[] passChars = password.getPassword();

        if (uc.loggin(userText, passChars, val)) {
            dispose();
            switch (val) {
                case "Student" -> new MainFrame(new StudentView(sc), userText);
                case "Lärare"  -> new MainFrame(new LärareView(lc), userText);
                case "Admin"   -> new MainFrame(new AdminView(ac), userText);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fel användarnamn eller lösenord!");
        }
    }

    private void CreatAccount(UserCon uc, StudentCon sc, LärareCon lc, AdminCon ac) {
    String usernameText = username.getText().trim();
    String passwordText = new String(password.getPassword());
    String roleVal = (String) role.getSelectedItem();

    if (usernameText.isEmpty() || passwordText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ange användarnamn och lösenord!");
        return;
    }

    String personnummer = null;
    if (roleVal.equals("Student")) {
        personnummer = JOptionPane.showInputDialog(this, "Ange ditt personnummer:");
        if (personnummer == null || personnummer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Personnummer krävs för studenter.");
            return;
        }
    }

    try {
        uc.createUser(usernameText, passwordText, roleVal, usernameText, personnummer, sc, lc, ac);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Fel: " + e.getMessage());
        return;
    }
    JOptionPane.showMessageDialog(this, "Användaren har skapats!");
}


}
