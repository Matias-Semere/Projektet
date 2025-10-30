package controller;

import java.util.List;
import dao.AdminDAO;
import model.Admin;

public class AdminCon {
    AdminDAO dao;

    public AdminCon(AdminDAO amdmindao) {
        this.dao = amdmindao;
    }

    public List<Admin> getAllAdmins() {
        return dao.getAllAdmins();
    }

    public void insertLärare(Admin admin) {
        dao.insertLärare(admin);
    }

    public void deleteAdmin(Admin admin) {
        dao.deleteAdmin(admin);
    }

    public void alterAdmin(Admin admin) {
        dao.alterAdmin(admin);
    }
}
