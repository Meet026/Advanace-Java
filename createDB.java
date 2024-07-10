import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class createDB {
    public static void main(String args[]){
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "Meet@123");

            // SQL query to create the table
            String createTableSql = "CREATE TABLE CRUD_OPERATION ("
                                  + "id INT PRIMARY KEY, "
                                  + "name VARCHAR(50), "
                                  + "phone INT)";
            
            // Create the Statement
            Statement statement = connection.createStatement();
            
            // Execute the query to create the table
            statement.executeUpdate(createTableSql);

            // Show success message
            JOptionPane.showMessageDialog(null, "Table created successfully", "System message", JOptionPane.INFORMATION_MESSAGE);
            
            // Close the statement and the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
