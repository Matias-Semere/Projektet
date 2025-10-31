package controller;

import model.User;
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

    public void insertUser(User user) {
        dao.insertUser(user);
    }

    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

}
