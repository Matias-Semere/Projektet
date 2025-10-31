package controller;

import java.util.List;

import dao.StudentDAO;
import model.Student;

public class StudentCon {
    StudentDAO dao;

    public StudentCon(StudentDAO dao) {
        this.dao = dao;
    }

    public void insertStudent(Student student) {
        dao.insertStudent(student);
    }

    public void deleteStudent(Student student) {
        dao.deleteStudent(student);
    }
    
    public void alterStudent(Student student) {
        dao.alterStudent(student);
    }
    
    public List<Student> getListOfStudents() {
        return dao.getAllStudents();
    }
}
