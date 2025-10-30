package controller;

import java.util.List;

import dao.StudentDAO;
import model.Student;

public class StudentCon {
    StudentDAO dao;

    public StudentCon(StudentDAO dao) {
        this.dao = dao;
    }

    public List<Student> getListOfStudents() {
        return dao.getAllStudents();
    }

    public void deleteStudent(Student student) {
        dao.deleteStudent(student);
    }

    public void deleteStudentByID(int studentID) {
        dao.deleteStudentByID(studentID);
    }

    public int getStudentCount() {
        return dao.getAllStudents().size();
    }

    public void insertStudent(Student student) {
        dao.insertStudent(student);
    }

    public void insertStudent(Student student, int userId) {
        dao.insertStudentWithUserID(student, userId);
    }

    public String getStudentbyID(int studentID) {
        return dao.getAllStudents().get(studentID).toString();
    }

    public void getStudentNamebyID(int studentID) {
        String howl = getStudentbyID(studentID);
        System.out.println(howl.substring(howl.indexOf("Name: ") + 6, howl.indexOf(", SSN: ")));
    }

    public void alterStudent(Student student) {
        dao.alterStudent(student);
    }

}
