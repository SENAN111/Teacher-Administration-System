
import database.DatabaseConnection;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try (Connection connection =
                     DatabaseConnection.getConnection()) {

            if (connection != null) {
                System.out.println("Connection test successful!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
