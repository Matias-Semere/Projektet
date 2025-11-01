package demo;

import java.io.*;
import java.util.Scanner;
import controller.*;

public class FillStudents {
    public FillStudents(UserCon uc, StudentCon sc) {
        try {
            InputStream in = getClass().getResourceAsStream("/celebrities.txt");
            if (in == null) {
                throw new FileNotFoundException("Could not find resource: celebrities.txt");
            }
            Scanner s = new Scanner(new InputStreamReader(in));
            
            while (s.hasNextLine()) {
                String[] line = s.nextLine().split(";");
                uc.createUser(line[0], "1234", "Student", line[1], sc, null, null);
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}