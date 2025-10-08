package model;

import javax.swing.*;

import view.MainFrame;

public class App {

    public static void main(String[] args) {
        // Model grejer osv



        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
    
}
