import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductFrame extends JFrame {
    private JTextField nameField, priceField, supplierIdField;
    private JTable productTable;

    public ProductFrame() {
        setTitle("Product Management");
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Product Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Supplier ID:"));
        supplierIdField = new JTextField();
        inputPanel.add(supplierIdField);

        JButton addButton = new JButton("Add Product");
        JButton deleteButton = new JButton("Delete Product");

        addButton.addActionListener(e -> addProduct());
        deleteButton.addActionListener(e -> deleteProduct());

        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        add(inputPanel, BorderLayout.NORTH);

        productTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(productTable);
        add(tableScrollPane, BorderLayout.CENTER);
    }

    private void addProduct() {
        String name = nameField.getText();
        String price = priceField.getText();
        String supplierId = supplierIdField.getText();

        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "INSERT INTO products (product_name, price, supplier_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setDouble(2, Double.parseDouble(price));
            stmt.setInt(3, Integer.parseInt(supplierId));
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding product: " + e.getMessage());
        }
    }
}
