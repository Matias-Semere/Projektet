package view;

import javax.swing.SwingUtilities;

import controller.AdminCon;
import controller.LärareCon;
import controller.StudentCon;
import dao.AdminDAO;
import dao.LärareDAO;
import dao.StudentDAO;

public class Test {
    public static void main(String[] args) {

        // AdminCon ac = new AdminCon(new AdminDAO());
        // SwingUtilities.invokeLater(() -> new MainFrame(ac).setVisible(true));

        // Kurs kurs = new Kurs(1, "Test", 12.34, "Testort", 1, "123456", 123.45);
        // KursDAO kDAO = new KursDAO();

        LärareCon lc = new LärareCon(new LärareDAO());
        SwingUtilities.invokeLater(() -> new MainFrame(lc).setVisible(true));
    }
}
