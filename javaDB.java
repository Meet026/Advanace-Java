import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class javaDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/";
            String databaseName = "JDBC";
            String username = "root";
            String password = "Meet@123";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "CREATE DATABASE " + databaseName;
    
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
    }
}
}
