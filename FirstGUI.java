import javax.swing.*;
import java.awt.*;

public class FirstGUI{
    public static void main(String[] args) {
        Abc obj = new Abc();
    }
}

class Abc extends JFrame{
    public Abc(){
        JLabel l = new JLabel("Hello World");
        JLabel l1 = new JLabel("Hello Meet");
        add(l);
        add(l1);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(3); //3 or JFrame.EXIT_ON_CLOSE
    }
} 