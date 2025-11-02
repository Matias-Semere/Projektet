package view.lists;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class BaseList<T> extends JPanel {

    protected DefaultListModel<T> listModel = new DefaultListModel<>();
    protected JList<T> listView = new JList<>(listModel);
    protected JScrollPane scrollPane = new JScrollPane(listView);
    protected String style = "<html><style> h2 {color: White; border: 4px solid black; padding: 7px;}</style> <h2>";
    protected JButton updateButton = new JButton("Updatera");
    JPanel actionPanel = new JPanel();

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
        listView.setFont(new Font("Segoe UI", Font.BOLD, 18));

        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setFont(new Font("Segoe UI", Font.BOLD, 18));
        renderer.setForeground(Color.WHITE);
        renderer.setBackground(Color.DARK_GRAY);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        listView.setCellRenderer(renderer);
        
        scrollPane.setPreferredSize(new Dimension(400, 750));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        actionPanel.setBackground(Color.DARK_GRAY);
        styleButton(updateButton);
        actionPanel.add(updateButton);
        add(actionPanel, BorderLayout.SOUTH);
    }

    protected String formatItem(T item) {
        return item.toString();
    }

    protected void styleButton(JButton button) {
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusable(false);
    }

    public T getSelectedEntity() {
        return listView.getSelectedValue();
    }
}
