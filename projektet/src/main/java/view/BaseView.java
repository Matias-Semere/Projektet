package view;

import javax.swing.*;
import java.awt.*;
import demo.*;

public abstract class BaseView extends JFrame {

    protected JPanel headerPanel, contentPanel, footerPanel;
    protected JButton logout, Show;

    public BaseView(String title) {                 
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);                     
        setVisible(true);
        setLayout(new BorderLayout());
        initComponents();

        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(45, 45, 45));
        JLabel titleLabel = new JLabel(title);
        style(titleLabel);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(logout, BorderLayout.EAST);
        headerPanel.add(Show, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(220, 220, 220));
        // contentPanel.setLayout(new BorderLayout());

        add(contentPanel, BorderLayout.CENTER);

        // Footer
        footerPanel = new JPanel();
        footerPanel.setBackground(new Color(45, 45, 45));
        JLabel footerLabel = new JLabel("Footer");
        style(footerLabel);
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void initComponents() {
        logout = new JButton("Logga ut");
        Show = new JButton("Visa / Dölj");
        style(logout);
        style(Show);
        logout.addActionListener(e -> {
            dispose();
            new App();
        });

        Show.addActionListener(e -> {
            if (contentPanel.isVisible()) contentPanel.setVisible(false);
            else contentPanel.setVisible(true);
        });
    }

    protected void style(JComponent comp) {
        if (comp instanceof JLabel) {
            comp.setForeground(Color.WHITE);
            comp.setFont(new Font("Arial", Font.BOLD, 20));
        } else if (comp instanceof JButton) {
            comp.setBackground(new Color(200, 50, 50));
            comp.setForeground(Color.WHITE);
            comp.setFont(new Font("Arial", Font.BOLD, 18));
            ((JButton) comp).setFocusPainted(false);
        } else if (comp instanceof JTextField) {
            comp.setBackground(Color.WHITE);
            comp.setForeground(Color.BLACK);
            comp.setFont(new Font("Arial", Font.PLAIN, 18));
        }
    }
}
