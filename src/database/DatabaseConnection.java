package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        System.out.println("Database bağlantısı yoxlanılır...");

        try {
            Connection connection = DriverManager.getConnection(
                    URL, USER, PASSWORD
            );

            System.out.println("Database connection successful!");
            return connection;

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}