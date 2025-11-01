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
        updateList(sc.getAll());
    }

    @Override
    public void updateList(List<Student> students) {
        listModel.clear();
        for (Student student : students) {
            listModel.addElement(formatItem(student)); // Format student and add to list
        }
    }

    @Override
    protected void onAddButtonClicked() {
        String name = JOptionPane.showInputDialog(this, "Enter student name:");
        if (name != null && !name.isEmpty()) {
            System.out.println("Adding student: " + name);
        }
    }

    @Override
    protected String formatItem(Student student) {
        return style + student.getNamn() + " (ID: " + student.getID() + ")";
    }
}
