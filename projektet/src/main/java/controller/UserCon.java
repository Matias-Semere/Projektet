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
        for (User user : dao.getAll()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        System.out.println("User does not exist");
        return false;
    }

    public boolean loggin(String username, char[] password, String role) {
        String lösen = new String(password);

        if (userExists(username)) {
            for (User user : dao.getAll()) {
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

    public User createUser(String username, String password, String role, String personnummer, StudentCon sc, LärareCon lc, AdminCon ac) throws Exception {
    User user = new User(username, password, role);
    user = dao.insert(user);

    if (user.getID() == 0) {
        throw new Exception("Failed to create user in User table: " + username);
    }

    switch (role) {
        case "Student":
            Student student = new Student(user.getID(), username, personnummer);
            sc.insertStudent(student);
            break;
        case "Lärare":
            Lärare lärare = new Lärare(user.getID(), username);
            lc.insertLärare(lärare);
            break;
        case "Admin":
            Admin admin = new Admin(user.getID(), username);
            ac.insertAdmin(admin);
            break;
        default:
            throw new Exception("Unknown role: " + role);
    }
    return user;
}

    public void insertUser(User user) { dao.insert(user); }

    public void deleteUser(User user) {
        dao.delete(user);
    }

    public List<User> getAllUsers() {
        return dao.getAll();
    }

}
