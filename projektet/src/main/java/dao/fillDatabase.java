package dao;

import java.io.*;
import java.util.Scanner;
import model.Student;

public class fillDatabase {
    public fillDatabase() {
        try {
            InputStream in = getClass().getResourceAsStream("/celebrities.txt");
            Scanner sc = new Scanner(new InputStreamReader(in));
            
            while (sc.hasNextLine()) {
                StudentDAO dao = new StudentDAO();
                String[] line = sc.nextLine().split(";");
                int year = Integer.parseInt(line[1].substring(0, line[1].indexOf("-")));
                Student student = new Student(line[0], year , 0);
                dao.insertStudent(student);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}