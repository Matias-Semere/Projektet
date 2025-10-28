package view;

import javax.swing.SwingUtilities;

import controller.AdminCon;
import controller.StudentCon;
import dao.AdminDAO;
import dao.StudentDAO;

public class Test {
    public static void main(String[] args) {

        AdminCon ac = new AdminCon(new AdminDAO());
        SwingUtilities.invokeLater(() -> new MainFrame(ac).setVisible(true));
    }
}
