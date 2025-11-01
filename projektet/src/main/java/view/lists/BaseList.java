package view.lists;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class BaseList<T> extends JPanel {

    protected DefaultListModel<T> listModel = new DefaultListModel<>();
    protected JList<T> listView = new JList<>(listModel);
    protected JScrollPane scrollPane = new JScrollPane(listView);
    protected String style = "<html><style> h2 {color: White; border: 4px solid black; padding: 7px;}</style> <h2>";

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

        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBackground(Color.DARK_GRAY);
                label.setForeground(Color.WHITE);
                return label;
            }
        };
        listView.setCellRenderer(renderer);
        listView.setFont(new Font("Segoe UI", Font.BOLD, 20));

        scrollPane.setPreferredSize(new Dimension(400, 800));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.DARK_GRAY);
        JButton addButton = new JButton("Update");
        styleButton(addButton);
        addButton.addActionListener(e -> onAddButtonClicked());
        actionPanel.add(addButton);
        add(actionPanel, BorderLayout.SOUTH);
    }

    protected String formatItem(T item) {
        return item.toString();
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusable(false);
    }

    public T getSelectedEntity() {
        return listView.getSelectedValue();
    }
}
