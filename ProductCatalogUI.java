package Class;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalogUI extends JFrame {
    private JPanel contentPane;
    private JTextField searchBar;
    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnCart;
    private JLabel lblWelcome;

    private List<Product> products;
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JTextField categoryField, minPriceField, maxPriceField;
    private JButton searchButton, addButton, editButton, deleteButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductCatalogUI frame = new ProductCatalogUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProductCatalogUI() {
        products = new ArrayList<>(); // This would be replaced with actual data from a database
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Farmers shop Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        setResizable(false);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Top panel for search and user actions
        JPanel topPanel = createTopPanel();
        contentPane.add(topPanel, BorderLayout.NORTH);

        // Left panel for categories
        JPanel categoriesPanel = createCategoriesPanel();
        contentPane.add(categoriesPanel, BorderLayout.WEST);

        // Center panel for product catalog
        JPanel catalogPanel = createCatalogPanel();
        contentPane.add(catalogPanel, BorderLayout.CENTER);

        // Bottom panel for footer
        JPanel footerPanel = createFooterPanel();
        contentPane.add(footerPanel, BorderLayout.SOUTH);

        // Initialize with all products
        refreshTable();
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(52, 152, 219));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(300, 30));
        topPanel.add(searchBar);

        searchButton = new JButton("Search");
        topPanel.add(searchButton);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerLogin loginFrame = new CustomerLogin();
                loginFrame.setVisible(true);
                dispose();
            }
        });
        topPanel.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerRegistration registerFrame = new CustomerRegistration();
                registerFrame.setVisible(true);
                dispose();
            }
        });
        topPanel.add(btnRegister);

        btnCart = new JButton("Cart");
        topPanel.add(btnCart);

        return topPanel;
    }

    private JPanel createCategoriesPanel() {
        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setBackground(new Color(236, 240, 241));
        categoriesPanel.setLayout(new BoxLayout(categoriesPanel, BoxLayout.Y_AXIS));
        categoriesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblCategories = new JLabel("Categories");
        lblCategories.setAlignmentX(Component.CENTER_ALIGNMENT);
        categoriesPanel.add(lblCategories);
        categoriesPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] categories = {"Electronics", "Clothing", "Books", "Home & Garden", "Toys", "Sports"};
        for (String category : categories) {
            JButton btnCategory = new JButton(category);
            btnCategory.setAlignmentX(Component.CENTER_ALIGNMENT);
            categoriesPanel.add(btnCategory);
            categoriesPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        return categoriesPanel;
    }

    private JPanel createCatalogPanel() {
        JPanel catalogPanel = new JPanel(new BorderLayout());

        // Search refinement panel
        JPanel searchRefinementPanel = new JPanel(new FlowLayout());
        categoryField = new JTextField(10);
        minPriceField = new JTextField(5);
        maxPriceField = new JTextField(5);

        searchRefinementPanel.add(new JLabel("Category:"));
        searchRefinementPanel.add(categoryField);
        searchRefinementPanel.add(new JLabel("Min Price:"));
        searchRefinementPanel.add(minPriceField);
        searchRefinementPanel.add(new JLabel("Max Price:"));
        searchRefinementPanel.add(maxPriceField);

        catalogPanel.add(searchRefinementPanel, BorderLayout.NORTH);

        // Product table
        String[] columnNames = {"ID", "Name", "Category", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        catalogPanel.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add Product");
        editButton = new JButton("Edit Product");
        deleteButton = new JButton("Delete Product");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        catalogPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        searchButton.addActionListener(e -> searchProducts());
        addButton.addActionListener(e -> addProduct());
        editButton.addActionListener(e -> editProduct());
        deleteButton.addActionListener(e -> deleteProduct());

        return catalogPanel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(52, 73, 94));

        JLabel lblFooter = new JLabel("© 2024 E-commerce Store. All rights reserved.");
        lblFooter.setForeground(Color.WHITE);
        footerPanel.add(lblFooter);

        return footerPanel;
    }

    private void searchProducts() {
        String name = searchBar.getText();
        String category = categoryField.getText();
        String minPrice = minPriceField.getText();
        String maxPrice = maxPriceField.getText();

        List<Product> searchResults = new ArrayList<>();

        for (Product product : products) {
            boolean matches = true;

            if (!name.isEmpty() && !product.getName().toLowerCase().contains(name.toLowerCase())) {
                matches = false;
            }
            if (!category.isEmpty() && !product.getCategory().toLowerCase().contains(category.toLowerCase())) {
                matches = false;
            }
            if (!minPrice.isEmpty()) {
                try {
                    BigDecimal min = new BigDecimal(minPrice);
                    if (product.getPrice().compareTo(min) < 0) {
                        matches = false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid minimum price");
                    return;
                }
            }
            if (!maxPrice.isEmpty()) {
                try {
                    BigDecimal max = new BigDecimal(maxPrice);
                    if (product.getPrice().compareTo(max) > 0) {
                        matches = false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid maximum price");
                    return;
                }
            }

            if (matches) {
                searchResults.add(product);
            }
        }

        updateTable(searchResults);
    }

    private void addProduct() {
        String name = JOptionPane.showInputDialog("Enter product name:");
        String category = JOptionPane.showInputDialog("Enter product category:");
        String price = JOptionPane.showInputDialog("Enter product price:");
        String quantity = JOptionPane.showInputDialog("Enter product quantity:");

        if (name != null && category != null && price != null && quantity != null) {
            try {
                Product newProduct = new Product(
                        (long) (products.size() + 1),
                        name,
                        category,
                        new BigDecimal(price),
                        Integer.parseInt(quantity)
                );
                products.add(newProduct);
                refreshTable();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price or quantity");
            }
        }
    }

    private void editProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            Product selectedProduct = products.get(selectedRow);

            String name = JOptionPane.showInputDialog("Enter product name:", selectedProduct.getName());
            String category = JOptionPane.showInputDialog("Enter product category:", selectedProduct.getCategory());
            String price = JOptionPane.showInputDialog("Enter product price:", selectedProduct.getPrice().toString());
            String quantity = JOptionPane.showInputDialog("Enter product quantity:", String.valueOf(selectedProduct.getQuantity()));

            if (name != null && category != null && price != null && quantity != null) {
                try {
                    selectedProduct.setName(name);
                    selectedProduct.setCategory(category);
                    selectedProduct.setPrice(new BigDecimal(price));
                    selectedProduct.setQuantity(Integer.parseInt(quantity));
                    refreshTable();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid price or quantity");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No product selected");
        }
    }

    private void deleteProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            products.remove(selectedRow);
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "No product selected");
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Product product : products) {
            tableModel.addRow(new Object[]{
                    product.getId(),
                    product.getName(),
                    product.getCategory(),
                    product.getPrice(),
                    product.getQuantity()
            });
        }
    }

    private void updateTable(List<Product> searchResults) {
        tableModel.setRowCount(0);
        for (Product product : searchResults) {
            tableModel.addRow(new Object[]{
                    product.getId(),
                    product.getName(),
                    product.getCategory(),
                    product.getPrice(),
                    product.getQuantity()
            });
        }
    }
}