import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc {
    public static void main(String args[]){
        Calculator obj = new Calculator();
    }
}

class Calculator extends JFrame implements ActionListener{
    JTextField t1, t2;
    JButton b1, b2;
    JLabel l;

    public Calculator(){
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        b1 = new JButton("Addition");
        b2 = new JButton("Multiply");
        l = new JLabel();

        t1.setFont(new Font("Arial", Font.BOLD, 18));
        t2.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        l.setFont(new Font("Arial", Font.BOLD, 18));

        t1.setForeground(Color.BLUE);
        t2.setForeground(Color.BLUE);
        b1.setForeground(Color.RED);
        b2.setForeground(Color.RED);
        l.setForeground(Color.black);

        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(l);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(3);
    }

    public void actionPerformed(ActionEvent ae){
        try {
            int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        if(ae.getSource() == b1){
            int sum = a + b;
            l.setText("Addition is : " + sum);
        }
        if(ae.getSource() == b2){
            int mul = a * b;
            l.setText("Multiply is : " + mul);
        }
        } catch (Exception e) {
            l.setText("Input must be Integer");
        }
    }
}

