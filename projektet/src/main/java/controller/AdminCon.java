package controller;

import java.util.List;
import dao.AdminDAO;
import model.Admin;

public class AdminCon {
    AdminDAO dao;

    public AdminCon(AdminDAO amdmindao) {
        this.dao = amdmindao;
    }

    public List<Admin> getListOfAdmins() {
        return dao.getAll();
    }

    public void insertAdmin(Admin admin) {
        dao.insert(admin);
    }

    public void deleteAdmin(Admin admin) {
        dao.delete(admin);
    }

    public void updateAdmin(Admin admin) {
        dao.update(admin);
    }
}
