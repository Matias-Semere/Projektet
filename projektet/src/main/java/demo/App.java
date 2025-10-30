package demo;

import javax.swing.*;
import controller.*;
import dao.*;
import model.*;
import view.*;   



public class App {    
    public static void main(String a[]) {

        // User user = new User(1, "Matias", "1234", "admin");
        // User user = new User(2, "Desbele", "1234", "student");
        // UserCon uCon = new UserCon(new UserDAO());
        // uCon.insertUser(user);

        // uCon.getAllUsers().forEach(System.out::println);

        // Student s = new Student(1, 2, "Desbele", 2);
        // StudentCon sc = new StudentCon(new StudentDAO());
        // sc.insertStudent(s);

        // new fillDatabase();

        Kurs kurs = new Kurs(2, "Test", 12.34, "Testort", 1, "123456", 123.45);
        KursDAO kDAO = new KursDAO();
        
        // kDAO.insertKurs(kurs);
        // kDAO.getAllKurs();

        // Kurstillfälle k = new Kurstillfälle(1, 1, "2021-01-01");
        // KurstilfälleDAO kDAO = new KurstilfälleDAO();

        // kDAO.insertKurstillfälle(k);
        // kDAO.getAllKurstillfälle();

        // Lärare lärare = new Lärare(1, "Test", 1);
        // LärareDAO l = new LärareDAO();

        // l.insertLärare(lärare);
        // l.getAllLärare();

        UserCon uc = new UserCon(new UserDAO());
        LärareCon lc = new LärareCon(new LärareDAO());
        AdminCon ac = new AdminCon(new AdminDAO());
        StudentCon sc = new StudentCon(new StudentDAO());
        SwingUtilities.invokeLater(() -> new Loggin(uc, lc, ac, sc).setVisible(true));
    }
}
