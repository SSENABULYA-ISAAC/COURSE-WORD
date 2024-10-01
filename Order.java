package Class;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int orderID;
    private int userID;
    private int productID;
    private int quantity;
    private BigDecimal totalPrice;
    private Date orderDate;
    private String status;

    public Order(int orderID, int userID, int productID, int quantity, BigDecimal totalPrice, Date orderDate, String status) {
        this.orderID = orderID;
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters and Setters
    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Method to place an order
    public void placeOrder() {
        // Logic to place an order
    }

    // Method to view an order
    public void viewOrder() {
        // Logic to view an order
    }

    // Method to cancel an order
    public void cancelOrder() {
        // Logic to cancel an order
    }
}