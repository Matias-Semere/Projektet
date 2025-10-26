package model;

import view.MainFrame;
import view.StudentView;
import controller.StudentCon;
import dao.StudentDAO;

import java.awt.*;
import javax.swing.*;   

public class App {    
    public static void main(String a[]) {
        StudentDAO dao = new StudentDAO();
        
        StudentCon sc = new StudentCon(dao);
        
        SwingUtilities.invokeLater(() -> new MainFrame(sc).setVisible(true));
    }
}
