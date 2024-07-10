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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "Meet@123");

            sc = new Scanner(System.in);

            System.out.print("Enter id for student: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter name for student: ");
            String name = sc.nextLine();

            System.out.print("Enter mobile no for student: ");
            int phone = sc.nextInt();

            // Prepare the call to the stored procedure
            String sql = "{CALL insertAndSelectStudent(?, ?, ?)}";
            callableStmt = connection.prepareCall(sql);

            // Set the parameters for the stored procedure
            callableStmt.setInt(1, id);
            callableStmt.setString(2, name);
            callableStmt.setInt(3, phone);

            // Execute the stored procedure
            boolean hasResults = callableStmt.execute();

            // Process the result set(s)
            StringBuilder result = new StringBuilder();
            if (hasResults) {
                rs = callableStmt.getResultSet();
                while (rs.next()) {
                    result.append(rs.getInt("id")).append(" ")
                          .append(rs.getString("name")).append(" ")
                          .append(rs.getInt("phone")).append("\n");
                }

                System.out.println(result);
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

