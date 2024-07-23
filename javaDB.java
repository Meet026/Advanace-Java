import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class javaDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/";
            String databaseName = "book_store";
            String username = "root";
            String password = "Meet@123";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "CREATE DATABASE " + databaseName;

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Database Created");

            Connection connectionDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "Meet@123");

            String createTableSql = "CREATE TABLE book_store ("
            + "id INT PRIMARY KEY, "
            + "title VARCHAR(50), "
            + "price INT, "
            + "author VARCHAR(50));";

            Statement statementDB = connectionDB.createStatement();
            statementDB.executeUpdate(createTableSql);

            JOptionPane.showMessageDialog(null, "Table Created");

            statement.close();
            connection.close();
            statementDB.close();
            connectionDB.close();
            
        } catch (Exception e) {
            e.printStackTrace();
    }
}
}
