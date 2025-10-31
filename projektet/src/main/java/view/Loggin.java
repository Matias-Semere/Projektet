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
        
        login.addActionListener(e -> loginFunction(uc, lc, ac, sc));
        skapakonto.addActionListener(e -> CreatAccount(uc));

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

    private void loginFunction(UserCon uc, LärareCon lc, AdminCon ac, StudentCon sc) {
        String val = (String) role.getSelectedItem();
        if (uc.loggin(username.getText(), password.getPassword(), val)) {
            dispose();
            if (val.equals("Student"))new MainFrame(new StudentView(sc), username.getText());
            else if (val.equals("Lärare")) new MainFrame(new LärareView(lc), username.getText());
            else if (val.equals("Admin")) new MainFrame(new AdminView(ac), username.getText());
        }
    }

    private void CreatAccount(UserCon uc) {
    String user = username.getText().trim();
    String pass = new String(password.getPassword());
    String roleVal = (String) role.getSelectedItem();

    if (user.isEmpty() || pass.isEmpty()) {
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

    boolean success = uc.createUser(user, pass, roleVal, user, personnummer);

    if (success) {
        JOptionPane.showMessageDialog(this, "Konto skapat! Du kan nu logga in.");
    } else {
        JOptionPane.showMessageDialog(this, "Fel: användarnamnet finns redan eller databasen kunde inte uppdateras.");
    }
}

}
