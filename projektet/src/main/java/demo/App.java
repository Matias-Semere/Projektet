package demo;

import javax.swing.*;
import controller.*;
import dao.*;
import model.*;
import view.*;   



public class App {    
    public static void main(String a[]) {

        // new fillDatabase();

        // Kurs kurs = new Kurs(2, "Test", 12.34, "Testort", 1, "123456", 123.45);
        // KursDAO kDAO = new KursDAO();
        
        // kDAO.insertKurs(kurs);
        // kDAO.getAllKurs();

        // Kurstillfälle k = new Kurstillfälle(1, 1, "2021-01-01");
        // KurstilfälleDAO kDAO = new KurstilfälleDAO();

        // kDAO.insertKurstillfälle(k);
        // kDAO.getAllKurstillfälle();

        // Lärare lärare = new Lärare(1, "Test", 12345678, 1);
        // LärareDAO l = new LärareDAO();

        // l.insertLärare(lärare);
        // l.getAllLärare();

        StudentCon sc = new StudentCon(new StudentDAO());
        SwingUtilities.invokeLater(() -> new MainFrame(sc).setVisible(true));
    }
}
