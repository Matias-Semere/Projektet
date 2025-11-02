package view.lists;

import javax.swing.*;
import java.awt.*;

import model.Student;
import controller.StudentCon;
import java.util.List;

public class StudentLista extends BaseList<Student> {

    private StudentCon sc;

    public StudentLista(StudentCon sc) {
        this.sc = sc;
        updateButton.addActionListener(e -> getAll());
        updateList(sc.getAll());
    }

    @Override
    public void updateList(List<Student> students) {
        listModel.clear();
        for (Student student : students) {
            listModel.addElement(student);
        }
    }

    public void getAll() {
        updateList(sc.getAll());
    }
}
