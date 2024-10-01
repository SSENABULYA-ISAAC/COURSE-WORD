package Class;

import java.util.HashMap;
import java.util.Map;

public class OrderTracking {
    private Map<Integer, String> orderStatus;

    public OrderTracking() {
        orderStatus = new HashMap<>();
    }

    public void updateOrderStatus(int orderID, String status) {
        orderStatus.put(orderID, status);
        // Notify user via email
        // JavaMailAPI.sendEmail(orderID, status);
    }

    public String getOrderStatus(int orderID) {
        return orderStatus.get(orderID);
    }
}