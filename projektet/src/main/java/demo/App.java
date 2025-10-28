package demo;

import javax.swing.SwingUtilities;

import controller.StudentCon;
import dao.KursDAO;
import dao.KurstilfälleDAO;
import dao.StudentDAO;
import model.Kurs;
import model.Kurstillfälle;
import view.MainFrame;   

public class App {    
    public static void main(String a[]) {

        // new fillDatabase();

        // Kurs kurs = new Kurs(2, "Test", 12.34, "Testort", 1, "123456", 123.45);
        // KursDAO kDAO = new KursDAO();
        
        // kDAO.insertKurs(kurs);
        // kDAO.getAllKurs();

        Kurstillfälle k = new Kurstillfälle(2, 1, "2021-01-01");
        KurstilfälleDAO kDAO = new KurstilfälleDAO();

        kDAO.insertKurstillfälle(k);
        kDAO.getAllKurstillfälle();

        // Lärare lärare = new Lärare(1, "Test", 12345678, "1");
        // LärareDAO l = new LärareDAO();

        // l.insertLärare(lärare);

        // l.getAllLärare();

        // StudentCon sc = new StudentCon(new StudentDAO());
        
        // SwingUtilities.invokeLater(() -> new MainFrame(sc).setVisible(true));
    }
}
