package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) {
        try {
            //1. Driver load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. conn establish
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost", null, null);
            //3. statement create
            //4. execute - query
            //5. conn close
        } catch (Exception e) {
            
        }
        
    }
}