package Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JPanel contentPane;
    private JTextField searchBar;
    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnCart;
    private JLabel lblWelcome;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard frame = new Dashboard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dashboard() {
        setTitle("FarmersShop Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        setResizable(false);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Top panel for search and user actions
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(52, 152, 219));
        contentPane.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(300, 30));
        topPanel.add(searchBar);

        JButton btnSearch = new JButton("Search");
        topPanel.add(btnSearch);

        btnLogin = new JButton("Login");
        topPanel.add(btnLogin);

        btnRegister = new JButton("Register");
        topPanel.add(btnRegister);

        btnCart = new JButton("Cart");
        topPanel.add(btnCart);

        // Left panel for categories
        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setBackground(new Color(236, 240, 241));
        contentPane.add(categoriesPanel, BorderLayout.WEST);
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

        // Center panel for featured products
        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(new GridLayout(2, 3, 10, 10));
        productsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.add(productsPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 6; i++) {
            JPanel productPanel = createProductPanel("Product " + i, "$99.99");
            productsPanel.add(productPanel);
        }

        // Bottom panel for footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(52, 73, 94));
        contentPane.add(footerPanel, BorderLayout.SOUTH);

        JLabel lblFooter = new JLabel("© 2024 FarmersShop Store. All rights reserved.");
        lblFooter.setForeground(Color.WHITE);
        footerPanel.add(lblFooter);

        // Action listeners
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open login frame
                JOptionPane.showMessageDialog(Dashboard.this, "Login functionality to be implemented");
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open registration frame
                JOptionPane.showMessageDialog(Dashboard.this, "Registration functionality to be implemented");
            }
        });

        btnCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open cart
                JOptionPane.showMessageDialog(Dashboard.this, "Cart functionality to be implemented");
            }
        });
    }

    private JPanel createProductPanel(String name, String price) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel lblImage = new JLabel("Product Image");
        lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblImage);

        JLabel lblName = new JLabel(name);
        lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblName);

        JLabel lblPrice = new JLabel(price);
        lblPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblPrice);

        JButton btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btnAddToCart);

        return panel;
    }
}