import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;

class GUIEx extends JFrame {
    JLabel jlbName = new JLabel("Name");
    JLabel jlbSurname = new JLabel("Surname");
    JLabel jlbAge = new JLabel("Age");
    JLabel jlbInfo = new JLabel("Details:");
    JLabel jlbInfoFromText = new JLabel("");
    JTextField jtfName = new JTextField(10);
    JTextField jtfSurname = new JTextField(10);
    JTextField jtfAge = new JTextField(10);
    JButton jbtOk = new JButton("OK");
    JButton jbtCancel = new JButton("Cancel");
    JPanel p = new JPanel();

    GUIEx() {
        p.setLayout(new GridLayout(5, 2, 5, 5));
        p.add(jlbName);
        p.add(jtfName);
        p.add(jlbSurname);
        p.add(jtfSurname);
        p.add(jlbAge);
        p.add(jtfAge);
        p.add(jlbInfo);
        p.add(jlbInfoFromText);
        p.add(jbtOk);
        p.add(jbtCancel);

        add(p);
        Listener spyObj = new Listener();
        jbtCancel.addActionListener(spyObj);
        jbtOk.addActionListener(spyObj);
    }

    // inner class
    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand()=="OK") {
                jlbInfoFromText.setText(jtfName.getText()+" "+jtfSurname.getText()+" "+jtfAge.getText());
            } else {
                jtfName.setText("");
                jtfSurname.setText("");
                jtfAge.setText("");
                jlbInfoFromText.setText("");
            }
        }
    }
}

class ExGraphics extends JFrame {
    ExGraphics() {
        add(new DrawArea());
    }

    // inner-class
    class DrawArea extends JPanel {
        URL impageURL = this.getClass().getResource("./asset/huh.png");
        URL impageBgURL = this.getClass().getResource("./asset/er-ER-FOR-A4-UPDATE.drawio.png");
        Image image = new ImageIcon(impageURL).getImage();
        Image imageBg = new ImageIcon(impageBgURL).getImage();
        Timer timer = new Timer(0, new Listener());
        int x = 0;
        int y = 250;
        DrawArea() {
            timer.start();
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(x>getWidth()) x =0;
            else x+=10;
            g.drawImage(imageBg,0,0,500,500,this);
            g.drawImage(image,x,y,100,100,this);
        }

        // inner-class
        class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }
    }
}

class DollarsConvert extends JFrame {
    JLabel jlbUs = new JLabel("US Dollars");
    JLabel jlbCd = new JLabel("Canadian Dollars");
    JTextField jtfUs = new JTextField(10);
    JTextField jtfCd = new JTextField(10);
    JButton jbtConvert = new JButton("Convert");
    JPanel p = new JPanel();

    DollarsConvert() {
        p.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new GridLayout(2, 1));
        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p1.add(p3, BorderLayout.CENTER);
        p1.add(p4, BorderLayout.WEST);
        p4.add(jlbUs);
        p4.add(jlbCd);
        p3.add(jtfUs);
        p3.add(jtfCd);
        jtfUs.setHorizontalAlignment(JTextField.RIGHT);
        jtfCd.setHorizontalAlignment(JTextField.RIGHT);
        jtfCd.setEditable(false);
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(jbtConvert, BorderLayout.EAST);
        add(p2, BorderLayout.SOUTH);
        add(p1, BorderLayout.CENTER);
        Listener l = new Listener();
        jbtConvert.addActionListener(l);
    }

    // inner class
    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand()=="Convert") {
                if(!Objects.equals(jtfUs.getText(), "")) {
                    jtfCd.setText(""+Double.parseDouble(jtfUs.getText())*1.5);
                }
            }
        }
    }
}

class Hangman extends JFrame {
    Hangman() {
        add(new DrawArea());
    }

    // inner-class
    class DrawArea extends JPanel {
        URL impageURL = this.getClass().getResource("./asset/huh.png");
        URL impageBgURL = this.getClass().getResource("./asset/er-ER-FOR-A4-UPDATE.drawio.png");
        Image image = new ImageIcon(impageURL).getImage();
        Image imageBg = new ImageIcon(impageBgURL).getImage();
        Timer timer = new Timer(10, new Listener());
        int x = 0;
        int y = 0;
        int a = 1;
        boolean c = true;
        int radius = 20;
        DrawArea() {
            timer.start();
            setFocusable(true);
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.red);
            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(20 + 40, 220, 20 + 40, 20);
            g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);
            if(160 - x == 200 || 160+y == 120) a=1;
            if(160 - x == 120 || 160+y == 200) a=0;
            g.drawLine(20 + 40 + 100, 20, 20 + 40 + 100 - x, 40);
            g.drawOval(20 + 40 + 100 - x - radius, 40, 2 * radius, 2 * radius);
            // hands
            g.drawLine(20 + 40 - x + 100 - (int)(radius * Math.cos(Math.toRadians(45))),
                    40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
                    20 + 40 + 100 - 60 - x * 2,
                    40 + radius + 60);
            g.drawLine(20 + 40 - x + 100 + (int)(radius * Math.cos(Math.toRadians(45))),
                    40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
                    20 + 40 + 100 + 60 - x * 2,
                    40 + radius + 60);
            // body
            g.drawLine(20 + 40 - x + 100,
                    40 + 2* radius,
                    20 + 40 + 100 - x * 2,
                    40 + radius + 80);
            // legs
            g.drawLine(20 + 40 + 100 - x * 2,
                    40 + radius + 80,
                    20 + 40 + 100 - 40 - x * 2 ,
                    40 + radius + 80 + 40);
            g.drawLine(20 + 40 + 100 - x * 2,
                    40 + radius + 80,
                    20 + 40 + 100 + 40  - x * 2,
                    40 + radius + 80 + 40);
            if(a==0) {
                x--;
                y--;
            } else {
                x++;
                y++;
            }
        }

        // inner-class
        class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }
    }
}

public class Lab9 extends JFrame{
    public static void main(String[] args) {
//        exGraphics();
        four();
//        six();
    }
    static void six() {
        Hangman frame = new Hangman();
        frame.setTitle("Hangman");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static  void four() {
        DollarsConvert frame = new DollarsConvert();
        frame.setTitle("Convert US Dollars to Canadian Dollars");
        frame.setSize(500, 150);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void exGraphics() {
        ExGraphics frame = new ExGraphics();
        frame.setTitle("Graphics");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void guiEx() {
        GUIEx frame = new GUIEx();
        frame.setTitle("Ex");
        frame.setSize(250, 150);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
