package view;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

// import controller.StudentCon;
// import model.Student;

public class Loggin extends JDialog {
    public Loggin() {
        setSize(500, 500);
        setBackground(Color.GREEN);
        setModal(false);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Logga in");
        JLabel usernameLabel = new JLabel("Användarnamn");
        JLabel passwordLabel = new JLabel("Lösenord");
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton login = new JButton("Logga in");

        username.setColumns(10);
        password.setColumns(10);

        login.addActionListener(e -> {
            System.out.println("Loggade in");
            dispose();
        });

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel.add(usernameLabel);
        panel.add(username);
        panel2.add(passwordLabel);
        panel2.add(password);
        panel2.add(login);
        
        panel3.add(panel);
        panel3.add(panel2);

        add(panel3);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
}
