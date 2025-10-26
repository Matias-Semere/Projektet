package model;

import view.MainFrame;
import controller.StudentCon;
import dao.StudentDAO;
import dao.fillDatabase;

import javax.swing.*;   

public class App {    
    public static void main(String a[]) {

        new fillDatabase();

        // StudentDAO dao = new StudentDAO();
        
        // StudentCon sc = new StudentCon(dao);
        
        // SwingUtilities.invokeLater(() -> new MainFrame(sc).setVisible(true));
    }
}
