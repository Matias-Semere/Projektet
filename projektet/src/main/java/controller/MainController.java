package controller;

import java.util.*;
import java.util.List;

public class MainController {
    
    List<Runnable> runnables = new ArrayList<>();

    public MainController() {
    }

    public void addJobb(Runnable jobb) {
        runnables.add(jobb);
    }

    public void work() {
        runnables.forEach(Runnable::run);
    }

}
