package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateCustomerTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/agriculture";
        String user = "root";
        String password = "";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS customer ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "firstname VARCHAR(100) NOT NULL, "
                + "lastname VARCHAR(100) NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "username VARCHAR(100) NOT NULL, "
                + "mobile VARCHAR(15) NOT NULL, "
                + "password VARCHAR(100) NOT NULL, "
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'customer' created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}