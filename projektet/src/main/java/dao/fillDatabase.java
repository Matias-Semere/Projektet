package dao;

import java.io.*;
import java.util.Scanner;
import model.User;

public class fillDatabase {
    int count = 2;
    public fillDatabase() {
        try {
            InputStream in = getClass().getResourceAsStream("/celebrities.txt");
            Scanner sc = new Scanner(new InputStreamReader(in));
            
            while (sc.hasNextLine()) {
                // StudentDAO dao = new StudentDAO();
                UserDAO dao = new UserDAO();
                String[] line = sc.nextLine().split(";");
                User user = new User(count++, line[0], line[1], "Student");
                dao.insertUser(user);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}