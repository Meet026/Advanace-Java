import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Callable {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStmt = null;
        ResultSet rs = null;
        Scanner sc = null;

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "Meet@123");

            sc = new Scanner(System.in);

            System.out.print("Enter id for book: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter title for book: ");
            String title = sc.nextLine();

            System.out.print("Enter price for book: ");
            int price = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter author of book: ");
            String author = sc.nextLine();
            
            // Prepare the call to the stored procedure
            String sql = "{CALL InsertAndSelect(?, ?, ?, ?)}";
            callableStmt = connection.prepareCall(sql);

            // Set the parameters for the stored procedure
            callableStmt.setInt(1, id);
            callableStmt.setString(2, title);
            callableStmt.setInt(3, price);
            callableStmt.setString(4, author);

            // Execute the stored procedure
            boolean hasResults = callableStmt.execute();

            System.out.println(hasResults);

            if (hasResults) {
                rs = callableStmt.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
                }

            } else {
                JOptionPane.showMessageDialog(null, "No data found", "Database Results", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the ResultSet
                if (rs != null) rs.close();
                // Close the CallableStatement
                if (callableStmt != null) callableStmt.close();
                // Close the Connection
                if (connection != null) connection.close();
                // Close the Scanner
                if (sc != null) sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

