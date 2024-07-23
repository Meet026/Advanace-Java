import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
  public static void main(String args[]){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meet", "root", "Meet@123");

      String sql = "CREATE TABLE Meet ("
      + "ID INT, "
      + "NAME VARCHAR(255));";

      // Statement st = connection.createStatement();

      // st.executeUpdate(sql);

      PreparedStatement ps = connection.prepareStatement(sql);

      ps.executeUpdate();

      System.out.println("Database cretaed");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
