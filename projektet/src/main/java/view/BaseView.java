package view;

import javax.swing.*;
import java.awt.*;
import demo.*;

public abstract class BaseView extends JFrame {

    protected JPanel headerPanel, contentPanel, footerPanel;
    protected JButton logout, Show;
    protected JLabel titleLabel;

    public BaseView(String title) {
        setSize(800, 800);
        titleLabel = new JLabel(title);        
        initComponents();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        headerPanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel();
        footerPanel = new JPanel();

        headerPanel.setBackground(new Color(45, 45, 45));
        contentPanel.setBackground(new Color(30, 30, 30));
        footerPanel.setBackground(new Color(45, 45, 45));

        
        logout = new JButton("Logga ut");
        Show = new JButton("Visa / Dölj");

        style(logout);
        style(Show);
        style(titleLabel);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));


        logout.addActionListener(e -> {
            dispose();
            new App();
        });
        
        Show.addActionListener(e -> {
            if (contentPanel.isVisible()) {
                contentPanel.setVisible(false);
                footerPanel.setVisible(false);
            } else {
                contentPanel.setVisible(true);
                footerPanel.setVisible(true);
            }
        });

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(logout, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    protected void style(JComponent comp) {
        if (comp instanceof JLabel) {
            comp.setForeground(Color.WHITE);
            comp.setFont(new Font("Arial", Font.BOLD, 20));
        }

        if (comp instanceof JButton) {
            comp.setBackground(new Color(200, 50, 50));
            comp.setForeground(Color.WHITE);
            comp.setFont(new Font("Arial", Font.BOLD, 18));
            ((JButton) comp).setFocusPainted(false);
        }

        if (comp instanceof JTextField) {
            comp.setBackground(Color.WHITE);
            comp.setForeground(Color.BLACK);
            comp.setFont(new Font("Arial", Font.PLAIN, 18));
        }
    }
}
