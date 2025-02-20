import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Supply Chain Management System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Supply Chain Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        JButton productButton = new JButton("Manage Products");
        JButton supplierButton = new JButton("Manage Suppliers");
        JButton orderButton = new JButton("Manage Orders");

        productButton.addActionListener(e -> new ProductFrame().setVisible(true));
        supplierButton.addActionListener(e -> new SupplierFrame().setVisible(true));
        orderButton.addActionListener(e -> new OrderFrame().setVisible(true));

        add(productButton);
        add(supplierButton);
        add(orderButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
