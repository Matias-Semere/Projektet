package view.lists;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat.Style;
import java.util.List;

public abstract class BaseList<T> extends JPanel {
    
    protected DefaultListModel<String> listModel = new DefaultListModel<>();
    protected JList<String> listView = new JList<>(listModel);
    protected JScrollPane scrollPane = new JScrollPane(listView);
    protected String style = "<html><style> h2 {color: White; border: 4 px solid black; padding: 7 px;}</style> <h2>";
    
    protected abstract void onAddButtonClicked();
    public abstract void updateList(List<T> items);

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

        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBackground(Color.DARK_GRAY);
        renderer.setForeground(Color.WHITE);
        listView.setCellRenderer(renderer);
        listView.setFont(new Font("Segoe UI", Font.BOLD, 20));

        scrollPane.setPreferredSize(new Dimension(400, 800));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.DARK_GRAY);
        JButton addButton = new JButton("Update");
        Style(addButton);
        addButton.addActionListener(e -> onAddButtonClicked());
        actionPanel.add(addButton);
        add(actionPanel, BorderLayout.SOUTH);
    }

    protected String formatItem(T item) {
        return item.toString();
    }

    private void Style(JButton button) {
        if (button instanceof JButton) {
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Segoe UI", Font.BOLD, 20));
            button.setFocusable(false);
        }
    }

}
