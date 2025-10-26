package view;

import javax.swing.*;
import java.awt.*;

// import controller.StudentCon;
// import model.Student;

public class Loggin extends JDialog {
    public Loggin() {
        setSize(500, 500);
        setBackground(Color.GREEN);
        setModal(false);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Logga in");
        JTextField username = new JTextField("Skrev ditt användarnamn");
        JPasswordField password = new JPasswordField("Skriv ditt lösenord");
        JButton login = new JButton("Logga in");

        login.addActionListener(e -> {
            System.out.println("Loggade in");
            dispose();
        });

        add(label);
        add(username);
        add(password);        
        add(login);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
}
