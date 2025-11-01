package controller;

import dao.AdminDAO;
import model.Admin;

public class AdminCon extends BaseController<Admin> {
    public AdminCon(AdminDAO amdmindao) {
        super(amdmindao);
    }
}
