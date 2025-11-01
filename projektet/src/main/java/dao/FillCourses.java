package dao;

import java.io.*;
import java.util.*;
import model.*;
import controller.*;

public class FillCourses {

    public FillCourses(KursCon kc, KurstillfälleCon kfc) {
        try {
            InputStream in = getClass().getResourceAsStream("/kurser.txt");
            if (in == null) {
                System.out.println();
                throw new FileNotFoundException("Could not find resource: kurser.txt");
            }

            Scanner sc = new Scanner(new InputStreamReader(in));
            int kursID = 1;
            int tillfälleID = 1;
            sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length < 8) {
                    System.err.println("Invalid line: " + line);
                    continue;
                }

                String kurskod = parts[0];
                String kursnamn = parts[1];
                double högskolepoäng = Double.parseDouble(parts[2]);
                // String anmalningskod = parts[3];
                int år = Integer.parseInt(parts[4]);
                int vecka = Integer.parseInt(parts[5]);
                int studieplatser = Integer.parseInt(parts[6]);
                double studietakt = Double.parseDouble(parts[7]);

                Kurs kurs = new Kurs(
                        kursID++,
                        kursnamn,
                        studietakt,
                        "Hig",
                        studieplatser,
                        kurskod,
                        högskolepoäng
                );

                Kurstillfälle tillfälle = new Kurstillfälle(
                        tillfälleID++,
                        kurs.getKursID(),
                        år + " Vecka: " + vecka
                );

                kc.insertKurs(kurs);
                kfc.insertKurstillfälle(tillfälle);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
