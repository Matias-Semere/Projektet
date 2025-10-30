package dao;

import java.io.*;
import java.util.Scanner;
import model.Student;

public class fillDatabase {
    int count = 1;
    public fillDatabase() {
        try {
            InputStream in = getClass().getResourceAsStream("/celebrities.txt");
            Scanner sc = new Scanner(new InputStreamReader(in));
            
            while (sc.hasNextLine()) {
                StudentDAO dao = new StudentDAO();
                String[] line = sc.nextLine().split(";");
                Student student = new Student(count++, count , line[0], 1234);
                dao.insertStudent(student);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}