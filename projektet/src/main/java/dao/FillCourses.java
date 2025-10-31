package dao;

import java.io.*;
import java.util.*;

import model.*;
import controller.*;

public class FillCourses {
    
    public FillCourses(KursCon kc, KurstillfälleCon kfc) {
        // Kurskod;Kursnamn;Högskolepoäng;Anmälningskod;Årtal;Vecka;Studieplatser;Studietakt

        try {
            InputStream in = getClass().getResourceAsStream("/kurstillfällen.txt");
            Scanner sc = new Scanner(new InputStreamReader(in));
            KursDAO dao = new KursDAO();
            
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(";");
                
                String kurskod = line[0];
                String kursnamn = line[1];
                int hogskolepoang = Integer.parseInt(line[2]);
                String anmalningskod = line[3];
                int ar = Integer.parseInt(line[4]);
                int vecka = Integer.parseInt(line[5]);
                String studieplatser = line[6];
                int studietakt = Integer.parseInt(line[7]);
                
                // Kurs k = new Kurs(kurskod, kursnamn, hogskolepoang, anmalningskod, ar, vecka, studieplatser, studietakt);
                
            
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
