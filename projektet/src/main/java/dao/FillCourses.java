package dao;

import java.io.*;
import java.util.*;
import model.*;
import controller.*;

public class FillCourses {

    public FillCourses(KursCon kc, KurstillfälleCon kfc) {
        try {
            InputStream in = getClass().getResourceAsStream("/kurstillfällen.txt");
            if (in == null) {
                throw new FileNotFoundException("Could not find resource: kurstillfällen.txt");
            }

            Scanner sc = new Scanner(new InputStreamReader(in));
            int kursID = 1;
            int tillfälleID = 1;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue; // skip blank lines

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
                        år + "-v" + vecka // example date label
                );

                kc.insertKurs(kurs);
                kfc.insertKurstillfälle(tillfälle);
            }
            sc.close();
            System.out.println("Courses successfully loaded from file.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
