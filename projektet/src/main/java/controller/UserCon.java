package controller;

import model.*;
import dao.UserDAO;
import java.util.List;

public class UserCon {
    UserDAO dao;

    public UserCon(UserDAO dao) {
        this.dao = dao;
    }

    public boolean userExists(String username) {
        for (User user : dao.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        System.out.println("User does not exist");
        return false;
    }

    public boolean loggin(String username, char[] password, String role) {
        String lösen = "";
        for (char a : password) {
            lösen += a;
        }

        if (userExists(username)) {
            for (User user : dao.getAllUsers()) {
                if (user.getUsername().equals(username)) {
                    if (user.getPassword().equals(lösen)) {
                        if (user.getRole().equalsIgnoreCase(role)) {
                            return true;
                        }
                    }
                }
            }
            System.out.println("Wrong password");
        }
        return false;
    }

    public User createUser(String username, String password, String role, String namn, String personnummer, StudentCon sc, LärareCon lc, AdminCon ac) throws Exception {
    User user = new User(0, username, password, role);
    user = dao.insertUser(user);

    if (user.getUserId() == 0) {
        throw new Exception("Failed to create user in User table: " + username);
    }

    switch (role) {
        case "Student":
            Student student = new Student(0, user.getUserId(), namn, personnummer);
            sc.insertStudent(student);
            break;
        case "Lärare":
            Lärare lärare = new Lärare(0, user.getUserId(), namn);
            lc.insertLärare(lärare);
            break;
        case "Admin":
            Admin admin = new Admin(0, user.getUserId(), namn);
            ac.insertAdmin(admin);
            break;
        default:
            throw new Exception("Unknown role: " + role);
    }
    return user;
}

    public void insertUser(User user) { dao.insertUser(user); }

    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

}
