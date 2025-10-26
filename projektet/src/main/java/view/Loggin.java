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

        username.setColumns(10);
        password.setColumns(10);

        password.getAccessibleContext().setAccessibleDescription("Lösenord");

        login.addActionListener(e -> {
            String test = password.getAccessibleContext().toString();
            System.out.println(test);
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
