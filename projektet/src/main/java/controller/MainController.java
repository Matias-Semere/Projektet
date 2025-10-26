package controller;

import model.Student;
import view.MainFrame;
import view.StudentView;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MainController {
    
    // Timer timer;
    List<Runnable> runnables = new ArrayList<>();

    public MainController() {
        // timer = new Timer(500, e -> runnables.forEach(Runnable::run));

    }

    public void addJobb(Runnable jobb) {
        runnables.add(jobb);
        // timer.start();
    }

    public void work() {
        runnables.forEach(Runnable::run);
    }


}
