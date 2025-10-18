package controller;

import dao.StudentDAO;
import model.Student;

public class StudentCon {
    static StudentDAO dao = new StudentDAO();
    // public static void main(String[] args) {
    //     StudentCon sc = new StudentCon();
    //     Student s = new Student(4, "Matias", 12345678, 1);
        // sc.insertStudent(s);
        // sc.getStudentNamebyID(2);

    // }

    public int getStudentCount() {
        return dao.getAllStudents().size();
    }

    public void insertStudent(Student student) {
        dao.insertStudent(student);
    }

    public String getStudentbyID(int studentID) {
        return dao.getAllStudents().get(studentID).toString();
    }

    public void getStudentNamebyID(int studentID) {
        String howl = getStudentbyID(studentID);
        System.out.println(howl.substring(howl.indexOf("Name: ") + 6, howl.indexOf(", SSN: ")));
    }


}
