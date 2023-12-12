import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class Lab10_1 extends JFrame{
    public static void main(String[] args) {
//        one_one();
//        one_two();
        one_three();
    }

    static void one_one() {
        TestPaintComponent frame = new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(220, 120);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void one_two() {
        One_two applet = new One_two();
    }

    static void one_three() {
        One_three obj = new One_three();
    }
}

class TestPaintComponent extends JFrame {
    public TestPaintComponent() {
        add(new NewPanel());
    }
}
class NewPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(10, 10, 60, 40);
        g.drawLine(60, 10, 10, 40);

        g.drawOval(10,45,50,30);

        g.setColor(Color.blue);
        g.drawRect(65,10,60,30);
        g.fillRect(65,45,60,30);

        g.setColor(Color.red);
        g.drawRoundRect(65+60+5,10,60,30,10,10);
        g.fillRoundRect(65+60+5,45,60,30,10,10);
    }
}

class One_two extends JApplet {
    public void init() {
        add(new JLabel("OK"));
    }
}

class One_three extends JApplet {
    public One_three() {
        System.out.println("Default constructor is invoked");
    }
    public void init() {
        System.out.println("Init method is invoked");
    }
}