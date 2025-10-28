package controller;

import dao.StudentInloggDAO;
import model.StudentInlogg;

public class StudentInloggCon {
    
    StudentInloggDAO dao;

    public StudentInloggCon(StudentInloggDAO dao) {
        this.dao = dao;
    }

    public void insertStudentInlogg(StudentInlogg studentInlogg) {
        dao.insertStudentInlogg(studentInlogg);
    }

    public void deleteStudentInlogg(StudentInlogg studentInlogg) {
        dao.deleteStudentInlogg(studentInlogg);
    }

    public void alterStudentInlogg(StudentInlogg studentInlogg) {
        dao.alterStudentInlogg(studentInlogg);
    }

}
