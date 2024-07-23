import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class BookForm {
    private JFrame frame;
    private JTextField bookIdField;
    private JTextField bookTitleField;
    private JTextField bookPriceField;
    private JTextField bookAuthorField;


    public BookForm() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Book Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdField = new JTextField(20);
        frame.add(bookIdLabel);
        frame.add(bookIdField);

        JLabel bookTitleLabel = new JLabel("Book Title:");
        bookTitleField = new JTextField(20);
        frame.add(bookTitleLabel);
        frame.add(bookTitleField);

        JLabel bookPriceLabel = new JLabel("Book Price:");
        bookPriceField = new JTextField(20);
        frame.add(bookPriceLabel);
        frame.add(bookPriceField);

        JLabel bookAuthorLabel = new JLabel("Book Author:");
        bookAuthorField = new JTextField(20);
        frame.add(bookAuthorLabel);
        frame.add(bookAuthorField);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String bookId = bookIdField.getText();
                String bookTitle = bookTitleField.getText();
                String bookPrice = bookPriceField.getText();
                String bookAuthor = bookAuthorField.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
    
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "Meet@123");

                    String sql = "insert into book_store values (?, ?, ?, ?)";

                    PreparedStatement ps = connection.prepareStatement(sql); 
                    ps.setString(1, bookId);
                    ps.setString(2, bookTitle);
                    ps.setString(3, bookPrice);
                    ps.setString(4, bookAuthor);

                    int rowInserted = ps.executeUpdate();
                    if(rowInserted > 0){
                        JOptionPane.showMessageDialog(null, "Book Added Successfully");
                    }

                    connection.close();
                    ps.close();
                    
                } catch (Exception err) {
                    err.getStackTrace();
                }
            }
        });
        

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BookForm();
    }
}