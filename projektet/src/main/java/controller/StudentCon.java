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
        dao.insert(student);
    }

    public void deleteStudent(Student student) {
        dao.delete(student);
    }
    
    public void updateStudent(Student student) {
        dao.update(student);
    }
    
    public List<Student> getListOfStudents() {
        return dao.getAll();
    }
}
