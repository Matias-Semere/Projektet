package controller;

import dao.StudentDAO;
import model.Student;
public class StudentCon extends BaseController<Student> {

    public StudentCon(StudentDAO dao) {
        super(dao);
    }   
}
