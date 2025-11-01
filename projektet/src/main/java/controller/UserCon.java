package controller;

import model.*;
import dao.UserDAO;

public class UserCon extends BaseController<User> {
    UserDAO customDao;

    public UserCon(UserDAO dao) {
        super(dao);
        customDao = dao;
    }

    public boolean userExists(String username) {
        User user = customDao.getByUsername(username);
        if (user != null) {
            return true;
        }
        System.out.println("User does not exist");
        return false;
    }

    public boolean loggin(String username, String lösen, String role) {
        User user = customDao.getByUsername(username);
        if (user.getPassword().equals(lösen) && user.getRole().equalsIgnoreCase(role)) {
            return true;
        } else {
            System.out.println("Wrong password or role");
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
                sc.insert(student);
                break;
            case "Lärare":
                Lärare lärare = new Lärare(user.getID(), username);
                lc.insert(lärare);
                break;
            case "Admin":
                Admin admin = new Admin(user.getID(), username);
                ac.insert(admin);
                break;
            default:
                throw new Exception("Unknown role: " + role);
        }
        return user;
    }

}
