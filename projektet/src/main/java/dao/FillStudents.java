package dao;

import java.io.*;
import java.util.Scanner;

import controller.UserCon;
import model.User;

public class FillStudents {
    int count = 2;
    public FillStudents(UserCon uc) {
        try {
            InputStream in = getClass().getResourceAsStream("/celebrities.txt");
            Scanner sc = new Scanner(new InputStreamReader(in));
            
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(";");
                User user = new User(count++, line[0], line[1], "Student");
                uc.insertUser(user);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}