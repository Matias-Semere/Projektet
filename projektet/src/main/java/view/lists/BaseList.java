package view.lists;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class BaseList<T> extends JPanel {

    protected DefaultListModel<String> listModel = new DefaultListModel<>();
    protected JList<String> listView = new JList<>(listModel);
    protected JScrollPane scrollPane = new JScrollPane(listView);
    protected String style = "<html><style> h3 {color: White; border: 10px solid black; padding: 10px;}</style> <h3>";

    public BaseList() {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        initComponents();
    }

    private void initComponents() {
        listView.setBackground(Color.DARK_GRAY);
        listView.setForeground(Color.WHITE);
        listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listView.setVisibleRowCount(10);

        scrollPane.setPreferredSize(new Dimension(300, 400));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        // Add common buttons or other elements here if necessary
        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.DARK_GRAY);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> onAddButtonClicked());
        actionPanel.add(addButton);
        add(actionPanel, BorderLayout.SOUTH);
    }

    // This method can be overridden by child classes to define custom actions on "Add"
    protected abstract void onAddButtonClicked();

    // Abstract method to fetch and format the list data, this will be implemented in child classes
    public abstract void updateList(List<T> items);

    // Helper method to format each item as a string, can be overridden by child classes
    protected String formatItem(T item) {
        return item.toString(); // Default behavior, but subclasses can format differently
    }

}
