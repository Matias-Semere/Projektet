package controller;

import java.util.List;

import dao.StudentDAO2;
import model.Student;

public class StudentCon {
    StudentDAO2 dao;

    public StudentCon(StudentDAO2 dao) {
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
