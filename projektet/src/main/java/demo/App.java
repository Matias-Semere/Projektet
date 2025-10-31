package demo;

import javax.swing.*;
import controller.*;
import dao.*;
import model.*;
import view.*;   

public class App {
    
    public App() {
        main(null);
    }
    public static void main(String a[]) {
        UserCon uc = new UserCon(new UserDAO());
        LärareCon lc = new LärareCon(new LärareDAO());
        AdminCon ac = new AdminCon(new AdminDAO());
        StudentCon sc = new StudentCon(new StudentDAO());



        SwingUtilities.invokeLater(() -> new Loggin(uc, lc, ac, sc).setVisible(true));
    }
}
