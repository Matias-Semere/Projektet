package controller;

import model.User;
import dao.UserDAO;
import java.util.List;

public class UserCon {
    
    UserDAO dao;

    public UserCon(UserDAO dao) {
        this.dao = dao;
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
