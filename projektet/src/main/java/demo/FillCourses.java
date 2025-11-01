package demo;

import java.io.*;
import java.util.*;
import model.*;
import controller.*;

public class FillCourses {

    public FillCourses(KursCon kc, KurstillfälleCon kfc) {
        try {
            InputStream in = getClass().getResourceAsStream("/kurser.txt");
            if (in == null) {
                throw new FileNotFoundException("Could not find resource: kurser.txt");
            }

            Scanner sc = new Scanner(new InputStreamReader(in));
            sc.nextLine();

            // Map to keep track of inserted courses by name for linking Kurstillfälle later
            Map<String, Kurs> kursByName = new HashMap<>();

            // First pass: read and insert Kurs entries
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String[] parts = line.split(";");

                String kurskod = parts[0];
                String kursnamn = parts[1];
                double högskolepoäng = Double.parseDouble(parts[2]);

                if (!kursByName.containsKey(kursnamn)) {
                    Kurs kurs = new Kurs(kursnamn, kurskod, högskolepoäng);
                    kc.insert(kurs);
                    kursByName.put(kursnamn, kurs);
                }
            }

            in.close();
            in = getClass().getResourceAsStream("/kurser.txt");
            sc = new Scanner(new InputStreamReader(in));
            sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String[] parts = line.split(";");

                String kursnamn = parts[1];
                String datum = parts[4] + " Vecka: " + parts[5];
                int antalPlatser = Integer.parseInt(parts[6]);
                double studietakt = Double.parseDouble(parts[7]);

                Kurs kurs = kursByName.get(kursnamn);
                if (kurs == null) {
                    System.out.println("No kurs found for namn: " + kursnamn);
                    continue;
                }

                Kurstillfälle kurstill = new Kurstillfälle(
                        kurs.getID(),
                        datum,
                        studietakt,
                        antalPlatser);
                kfc.insert(kurstill);
            }

            sc.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
