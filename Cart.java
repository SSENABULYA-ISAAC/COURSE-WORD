package Class;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Class.Order; // Assuming you have an Order class in the same package

public class Cart {
    private List<Order> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Order item) {
        items.add(item);
    }

    public void removeItem(Order item) {
        items.remove(item);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Order item : items) {
            total = total.add(item.getTotalPrice());
        }
        return total;
    }

    public void placeOrder(int userID) {
        // Logic to place an order
        for (Order item : items) {
            // Update product quantities in the database
        }
        items.clear();
    }
}