import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DB_connection {
    public static void main(String args[]){ 
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Meet@123");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter id for student : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name for student : ");
            String name = sc.nextLine();

            System.out.print("Enter mobile no for student : ");
            int phone = sc.nextInt();

            // SQL query to insert data into the database
            String sql = "INSERT INTO crud_operation VALUES (?, ?, ?)";

            // Prepare the SQL statement
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);        // Set the first parameter (id)
            stmt.setString(2, name); // Set the second parameter (name)
            stmt.setInt(3, phone);  // Set the third parameter (phone)

            // Execute the insert statement
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Values inserted successfully");
            }

            // SQL query to select all data from the database
            String selectSql = "SELECT * FROM crud_operation";
            Statement selectStatement = connection.createStatement();
            ResultSet rs = selectStatement.executeQuery(selectSql);

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            JOptionPane.showMessageDialog(null, rs.toString(), "Database Results", JOptionPane.INFORMATION_MESSAGE);

            // Close the statement and the connection
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
