import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SimpleInventory extends JFrame {
    private JTextField idField, nameField, qtyField, priceField;
    private DefaultTableModel model;

    public SimpleInventory() {
        setTitle("Inventory Management");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table
        model = new DefaultTableModel(new String[]{"ID", "Name", "Quantity", "Price"}, 0);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Input panel
        JPanel input = new JPanel(new GridLayout(2, 4, 10, 5));
        idField = new JTextField(); nameField = new JTextField();
        qtyField = new JTextField(); priceField = new JTextField();

        input.add(new JLabel("ID")); input.add(new JLabel("Name"));
        input.add(new JLabel("Quantity")); input.add(new JLabel("Price"));
        input.add(idField); input.add(nameField);
        input.add(qtyField); input.add(priceField);
        add(input, BorderLayout.NORTH);

        // Buttons
        JPanel buttons = new JPanel();
        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        buttons.add(add); buttons.add(update); buttons.add(delete);
        add(buttons, BorderLayout.SOUTH);

        // Add Button
        add.addActionListener(e -> {
            try {
                model.addRow(new Object[]{
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        Integer.parseInt(qtyField.getText()),
                        Double.parseDouble(priceField.getText())
                });
                clearFields();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        // Update Button
        update.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                try {
                    model.setValueAt(Integer.parseInt(idField.getText()), row, 0);
                    model.setValueAt(nameField.getText(), row, 1);
                    model.setValueAt(Integer.parseInt(qtyField.getText()), row, 2);
                    model.setValueAt(Double.parseDouble(priceField.getText()), row, 3);
                    clearFields();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input!");
                }
            } else JOptionPane.showMessageDialog(this, "Select a row to update.");
        });

        // Delete Button
        delete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) model.removeRow(row);
            else JOptionPane.showMessageDialog(this, "Select a row to delete.");
            clearFields();
        });

        // Table click = load row data
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                idField.setText(model.getValueAt(r, 0).toString());
                nameField.setText(model.getValueAt(r, 1).toString());
                qtyField.setText(model.getValueAt(r, 2).toString());
                priceField.setText(model.getValueAt(r, 3).toString());
            }
        });

        setVisible(true);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        qtyField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleInventory::new);
    }
}
