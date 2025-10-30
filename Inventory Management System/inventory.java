import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class inventory extends JFrame {

    // UI Components
    private JTextField idField, nameField, quantityField, priceField;
    private JTable table;
    private DefaultTableModel tableModel;

    // Inventory data storage
    private java.util.List<InventoryItem> inventoryList = new ArrayList<>();

    // Constructor
    public inventory() {
        setTitle("Inventory Management System");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Table model and JTable
        String[] columns = {"ID", "Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(table);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 5));
        idField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(new JLabel("Price:"));

        inputPanel.add(idField);
        inputPanel.add(nameField);
        inputPanel.add(quantityField);
        inputPanel.add(priceField);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);

        // Add panels to main frame
        add(inputPanel, BorderLayout.NORTH);
        add(tableScroll, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addBtn.addActionListener(e -> addItem());
        updateBtn.addActionListener(e -> updateItem());
        deleteBtn.addActionListener(e -> deleteItem());

        // Table row selection
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                idField.setText(tableModel.getValueAt(row, 0).toString());
                nameField.setText(tableModel.getValueAt(row, 1).toString());
                quantityField.setText(tableModel.getValueAt(row, 2).toString());
                priceField.setText(tableModel.getValueAt(row, 3).toString());
            }
        });

        setVisible(true);
    }

    // Add item to inventory
    private void addItem() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            int qty = Integer.parseInt(quantityField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());

            InventoryItem item = new InventoryItem(id, name, qty, price);
            inventoryList.add(item);
            tableModel.addRow(new Object[]{id, name, qty, price});
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check your data.");
        }
    }

    // Update selected item
    private void updateItem() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                int qty = Integer.parseInt(quantityField.getText().trim());
                double price = Double.parseDouble(priceField.getText().trim());

                InventoryItem item = inventoryList.get(row);
                item.setId(id);
                item.setName(name);
                item.setQuantity(qty);
                item.setPrice(price);

                tableModel.setValueAt(id, row, 0);
                tableModel.setValueAt(name, row, 1);
                tableModel.setValueAt(qty, row, 2);
                tableModel.setValueAt(price, row, 3);
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to update.");
        }
    }

    // Delete selected item
    private void deleteItem() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            inventoryList.remove(row);
            tableModel.removeRow(row);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete.");
        }
    }

    // Clear input fields
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    // Inventory item inner class (POJO)
    static class InventoryItem {
        private int id;
        private String name;
        private int quantity;
        private double price;

        public InventoryItem(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public void setId(int id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setPrice(double price) { this.price = price; }
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(inventory::new);
    }
}