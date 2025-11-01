package demo;

import javax.swing.*;
import controller.*;
import dao.*;
import view.*;   

public class App {
    
    public App() {
        main(null);
    }
    public static void main(String a[]) {
        UserCon uc = new UserCon(new UserDAO());
        LärareCon lc = new LärareCon(new LärareDAO());
        StudentCon sc = new StudentCon(new StudentDAO());
        KursCon kc = new KursCon(new KursDAO());

        
        KurstillfälleCon kfc = new KurstillfälleCon(new KurstillfälleDAO());
        RegistreringCon rpc = new RegistreringCon(new RegistreringDAO());
        BetygCon bc = new BetygCon(new BetygDAO());
        RapporteringCon rc = new RapporteringCon(new RapporteringDAO());
        LärarTilldelningCon ltc = new LärarTilldelningCon(new LärarTilldelningDAO());
        AdminCon ac = new AdminCon(new AdminDAO(), ltc);

        // new FillStudents(uc, sc);
        // new FillCourses(kc, kfc);

        // sc.getAll().forEach(System.out::println);
        // lc.getListOfLärare().forEach(System.out::println);
        // kc.getAll().forEach(System.out::println);
        // kfc.getAll().forEach(System.out::println);
        // kfc.getAllWithCourseNames().forEach(System.out::println);

        SwingUtilities.invokeLater(() -> new Loggin(uc, lc, ac, sc , kc, kfc, bc, rc, ltc, rpc).setVisible(true));
    }
}
