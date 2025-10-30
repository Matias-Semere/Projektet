package view;

import java.awt.*;
import java.util.stream.IntStream;

import javax.swing.*;
import controller.*;

public class Loggin extends JDialog {

    private UserCon uc;
    private LärareCon lc;
    private AdminCon ac;
    private StudentCon sc;
    private JLabel usernameLabel = new JLabel("Användarnamn: ");
    private JLabel passwordLabel = new JLabel("Lösenord: ");
    private JTextField username = new JTextField("", 10);
    private JPasswordField password = new JPasswordField("", 10);
    private JComboBox<String> role = new JComboBox<String>(new String[] { "Student", "Lärare", "Admin" });
    private JButton login = new JButton("Logga in");
    private JPanel namndel, passdel, roledel, loginPanel;

    public Loggin(UserCon uc, LärareCon lc, AdminCon ac, StudentCon sc) {
        this.uc = uc;
        this.lc = lc;
        this.ac = ac;
        this.sc = sc;
        setSize(500, 500);
        setModal(false);
        setLayout(new FlowLayout());
        initComponents();

        login.addActionListener(e -> loginFunction());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        namndel = new JPanel();
        passdel = new JPanel();
        roledel = new JPanel();

        loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBackground(Color.DARK_GRAY);

        namndel.add(usernameLabel, BorderLayout.NORTH);
        namndel.add(username, BorderLayout.SOUTH);

        passdel.add(passwordLabel, BorderLayout.NORTH);
        passdel.add(password, BorderLayout.SOUTH);

        roledel.add(login, BorderLayout.WEST);
        roledel.add(role, BorderLayout.EAST);

        loginPanel.add(namndel, BorderLayout.WEST);
        loginPanel.add(passdel, BorderLayout.EAST);
        loginPanel.add(roledel, BorderLayout.SOUTH);

        add(loginPanel);
    }

    private void loginFunction() {

        String lösen = "";
        for (char a : password.getPassword()) {
            lösen += a;
        }

        String val = (String) role.getSelectedItem();

        if (val.equals("Student")) {
            if (username.getText().equals("Matias") && lösen.equals("1234")) {
                System.out.println("Matias: Loggade in som student");
            }
        }
        else if (val.equals("Lärare")) {
            if (username.getText().equals("Matias") && lösen.equals("1234")) {
                System.out.println("Matias är inte lärare");
            }
        }
        else if (val.equals("Admin")) {
            if (username.getText().equals("Matias") && lösen.equals("1234")) {
                System.out.println("Matias är inte admin");
            }
        }
    }

}
