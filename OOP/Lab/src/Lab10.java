import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.*;
import javax.swing.Timer;

public class Lab10 extends JFrame{
    /** Main method */
    public static void main(String[] args) {
//        two();
//        three();
//        four();
        five();
//        fan();
//        rain();
    }

    static void five() {
        NewClass6 a = new NewClass6();
        a.setSize(600,500);
        a.setVisible(true);
    }

    static void four() {
        multiCar frame=new multiCar();
        frame.setTitle("Exercise");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
    static void three() {
        singleCar frame = new singleCar();
        frame.setTitle("Exercise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    static void two() {
        JFrame frame = new ClockAnimation();
        frame.setTitle("ClockAnimation");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void fan() {
        DrawArcs frame = new DrawArcs();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 300);
        frame.setVisible(true);
    }

    static void rain() {
        umbrellaMan frame = new umbrellaMan();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }
}

class NewClass6 extends JFrame {
    private BalloonPanel paintPanel = new BalloonPanel();
    public NewClass6(){
        setLayout(new BorderLayout());
        add(paintPanel);
        setSize(500,500);
    }
    class BalloonPanel extends JPanel {
        final static int BALLOON_RADIUS = 10;
        final static int BALL_RADIUS = 5;
        final static int GUN_LENGTH = 25;
        final static int PANEL_WIDTH = 200;
        final static int PANEL_HEIGHT = 100;

        private int x_Balloon = (int)(Math.random() * PANEL_WIDTH);
        private int y_Balloon = (int)(Math.random() * PANEL_HEIGHT);

        private int angle = 90;

        private LinkedList<SmallBall> list = new LinkedList<SmallBall>();

        class SmallBall {
            int length;
            int angle;

            SmallBall(int length, int angle) {
                this.length = length;
                this.angle = angle;
            }
        }

        private Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });



        public BalloonPanel() {
            setFocusable(true);

            this.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if (angle < 180) angle += 3;
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if (angle > 0) angle -= 3;
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        // Launch a small ball
                        list.add(new SmallBall(GUN_LENGTH, angle));
                    }

                    repaint();
                }
            });
            timer.start();
        }

        boolean hit = false;

        /** Paint message */
        public void paint(Graphics g) {
            super.paintComponent(g);

            // Display the gun
            int x = (int)(GUN_LENGTH * Math.cos(Math.toRadians(angle)) +
                    getWidth() / 2);
            int y = (int)(getHeight() -
                    GUN_LENGTH * Math.sin(Math.toRadians(angle)));
            g.drawLine(getWidth() / 2, getHeight(), x, y);
            g.drawLine(getWidth() / 2 - 1, getHeight(), x - 1, y);
            g.drawLine(getWidth() / 2 - 2, getHeight(), x - 2 , y);
            g.drawLine(getWidth() / 2 + 1, getHeight(), x + 1, y);
            g.drawLine(getWidth() / 2 + 2, getHeight(), x + 2, y);

            if (hit) {
                // Display three small pieces
                g.drawOval(x_Balloon - BALLOON_RADIUS / 2 - 5,
                        y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon  + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2,
                        y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon - BALLOON_RADIUS / 2,
                        y_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon - BALLOON_RADIUS / 2,
                        y_Balloon - 2 * BALLOON_RADIUS - 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);

                hit = false;

                // New random location
                x_Balloon = (int)(Math.random() * PANEL_WIDTH);
                y_Balloon = (int)(Math.random() * PANEL_HEIGHT);

                return;
            }

            g.drawOval(x_Balloon - BALLOON_RADIUS,
                    y_Balloon- BALLOON_RADIUS, 2 * BALLOON_RADIUS,
                    2 * BALLOON_RADIUS);//love ajansatid;

            // Draw small hitting balls
            for (int i = 0; i < list.size(); i++) {
                SmallBall ball = list.get(i);//eiei
                ball.length += 5;//yeye

                x = (int)(ball.length * Math.cos(Math.toRadians(ball.angle)) +
                        getWidth() / 2);
                y = (int)(getHeight() -
                        ball.length * Math.sin(Math.toRadians(ball.angle)));

                g.fillOval(x - BALL_RADIUS, y - BALL_RADIUS, 2 * BALL_RADIUS,
                        2 * BALL_RADIUS);

                if (overlaps(x, y, BALL_RADIUS,
                        x_Balloon, y_Balloon, BALLOON_RADIUS)) {
                    list.remove(i);
                    hit = true;
                }

                if (x > getWidth() || x < 0 || y < 0)
                    list.remove(i);
            }
        }
    }
    public static boolean overlaps(double x1, double y1, double radius1,
                                   double x2, double y2, double radius2) {
        return Math.sqrt((x1 - x2) * (x1 - x2)
                + (y1 - y2) * (y1 - y2)) <= radius1 + radius2;
    }
}

class multiCar extends JFrame {
    JLabel c1 = new JLabel("Car 1:");
    JLabel c2 = new JLabel("Car 2:");
    JLabel c3 = new JLabel("Car 3:");
    JLabel c4 = new JLabel("Car 4:");
    JTextField ca1 = new JTextField(10);
    JTextField ca2 = new JTextField(10);
    JTextField ca3 = new JTextField(10);
    JTextField ca4 = new JTextField(10);
    RaceCar rc1 = new RaceCar();
    RaceCar rc2 = new RaceCar();
    RaceCar rc3 = new RaceCar();
    RaceCar rc4 = new RaceCar();
    listener list1 = new listener();

    multiCar() {
        ca1.addActionListener(list1);
        ca2.addActionListener(list1);
        ca3.addActionListener(list1);
        ca4.addActionListener(list1);
        JPanel p1 = new JPanel();
        p1.add(c1);
        p1.add(ca1);
        p1.add(c2);
        p1.add(ca2);
        p1.add(c3);
        p1.add(ca3);
        p1.add(c4);
        p1.add(ca4);
        JPanel p2 = new JPanel(new GridLayout(4, 1));

        p2.add(rc1);

        p2.add(rc2);

        p2.add(rc3);

        p2.add(rc4);


        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

    }

    class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ca1) {
                int v1 = Integer.parseInt(ca1.getText());
                rc1.speed = v1;
            }
            if (e.getSource() == ca2) {
                int v2 = Integer.parseInt(ca2.getText());
                rc2.speed = v2;
            }
            if (e.getSource() == ca3) {
                int v3 = Integer.parseInt(ca3.getText());
                rc3.speed = v3;
            }
            if (e.getSource() == ca4) {
                int v4 = Integer.parseInt(ca4.getText());
                rc4.speed = v4;
            }
        }

    }
}

class singleCar extends JFrame {
    public singleCar() {
        add(new RaceCar());
    }
}

class RaceCar extends JPanel{
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

    }
    int xBase=0;
    int speed=0;
    Timer timer=new Timer(10,new Listener());
    //        @Override
    RaceCar(){
        timer.start();
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_UP) {
                    speed++;
                }
                else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DOWN)
                    speed--;
            }
        });
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int yBase=getHeight();
        if(xBase>getWidth()){
            xBase=-20;
        }else{
            xBase+=speed;
        }

        g.setColor(Color.BLACK);
        g.fillOval(xBase+10, yBase-10, 10, 10);
        g.fillOval(xBase+30, yBase-10, 10, 10);
        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase-20, 50, 10);

        g.setColor(Color.RED);
        Polygon polygon=new Polygon();
        polygon.addPoint(xBase+10, yBase-20);
        polygon.addPoint(xBase+20, yBase-30);
        polygon.addPoint(xBase+30, yBase-30);
        polygon.addPoint(xBase+40, yBase-20);
        g.fillPolygon(polygon);

        // road
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, getWidth(), 0);
    }
}

class ClockAnimation extends JFrame {
    String country = "";
    JLabel jlbThai = new JLabel("THAI");
    JLabel jlbOther = new JLabel("JAPAN");
    StillClock thai = new StillClock();
    StillClock other = new StillClock();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel(new GridLayout(1,2,5,5));
    JPanel p3 = new JPanel();
    JTextField jtfCountry = new JTextField("JAPAN");
    JButton jbtButton = new JButton("OK");
    Timer timer = new Timer(1000, new TimerListener());
    JRadioButton radioJapan = new JRadioButton("JAPAN",true);
    JRadioButton radioUs = new JRadioButton("US",false);
    JRadioButton radioUk = new JRadioButton("UK",false);
    JPanel radioButtonsPanel = new JPanel();
    JPanel p = new JPanel(new GridLayout(3,1,5,5));
    public ClockAnimation() {

//        radioButtonsPanel.add(radioJapan);
//        radioButtonsPanel.add(radioUs);
//        radioButtonsPanel.add(radioUk);
//        radioJapan.addItemListener(new ItemListen());
//        radioUs.addItemListener(new ItemListen());
//        radioUk.addItemListener(new ItemListen());
        p1.add(jlbThai);
        p1.add(jlbOther);
        p2.add(thai);
        p2.add(other);
        p3.add(jtfCountry);
        p3.add(jbtButton);

        TimerListener tl = new TimerListener();
        p.add(p1);
        p.add(p2);
        p.add(p3);
        jbtButton.addActionListener(tl);
        add(p);

        // Create a timer with delay 1000 ms
        Timer timer = new Timer(1000, new TimerListener());
        timer.start();
    }
    private class TimerListener implements ActionListener {
        @Override /** Handle the action event */
        public void actionPerformed(ActionEvent e) {
            country = jtfCountry.getText();
            System.out.println(""+country);
            thai.setCurrentTime();
            thai.repaint();
            if(jtfCountry.getText().equals("JAPAN")) {
                other.setCurrentTime();
                other.setHour(thai.getHour()+2);
                other.repaint();
                jlbOther.setText(jtfCountry.getText());
            }
            else if(jtfCountry.getText().equals("US")) {
                other.setCurrentTime();
                other.setHour(thai.getHour()-10);
                other.repaint();
                jlbOther.setText(jtfCountry.getText());
            }
            else if(jtfCountry.getText().equals("UK")) {
                other.setCurrentTime();
                other.setHour(thai.getHour()-6);
                other.repaint();
                jlbOther.setText(jtfCountry.getText());
            }
            else {
                // default
                other.setCurrentTime();
                other.setHour(thai.getHour()+2);
                other.repaint();
            }
        }
    }
}

class StillClock extends JPanel {
    private int hour;
    private int minute;
    private int second;

    /** Construct a default clock with the current time*/
    public StillClock() {
        setCurrentTime();
    }

    /** Construct a clock with specified hour, minute, and second */
    public StillClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /** Return hour */
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        repaint();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        repaint();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        repaint();
    }

    @Override /** Draw the clock */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Initialize clock parameters
        int clockRadius = (int)(Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Draw circle
        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius,
                2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        // Draw second hand
        int sLength = (int)(clockRadius * 0.8);
        int xSecond = (int)(xCenter + sLength *
                Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int)(yCenter - sLength *
                Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        // Draw minute hand
        int mLength = (int)(clockRadius * 0.65);
        int xMinute = (int)(xCenter + mLength *
                Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int)(yCenter - mLength *
                Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.blue);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        // Draw hour hand
        int hLength = (int)(clockRadius * 0.5);
        int xHour = (int)(xCenter + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int)(yCenter - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.green);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}

class DrawArcs extends JFrame {
    Timer timer = new Timer(10, new Listener());
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("0");
    int speed = 1;
    int A;
    ArcsPanel arcs = new ArcsPanel();
    public DrawArcs() {
        setTitle("Hatari");
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(1,4));
        p1.add(btn1);
        p1.add(btn2);
        p1.add(btn3);
        p1.add(btn4);
        add(p1, BorderLayout.SOUTH);
        Listener l = new Listener();
        add(arcs);
        btn1.addActionListener(l);
        btn2.addActionListener(l);
        btn3.addActionListener(l);
        btn4.addActionListener(l);
        // Create a timer with delay 1000 ms
        timer.start();
    }
    private class Listener implements ActionListener {
        @Override
        /** Handle the action event */
        public void actionPerformed(ActionEvent e) {
            arcs.repaint();
            if(e.getActionCommand() == "1") {
                arcs.A = 1;
                arcs.repaint();
            } else if (e.getActionCommand() == "2") {
                arcs.A = 2;
                arcs.repaint();
            } else if (e.getActionCommand() == "3") {
                arcs.A = 3;
                arcs.repaint();
            } else if (e.getActionCommand() == "0") {
                arcs.A = 0;
                arcs.repaint();
            }
        }
    }
}

// The class for drawing arcs on a panel
class ArcsPanel extends JPanel {
    public int speed = 0;
    public int A = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
        int x = xCenter - radius;
        int y = yCenter - radius;
        if(A == 1) {
            g.setColor(Color.blue);
            speed+=1;
        } else if(A == 2) {
            g.setColor(Color.green);
            speed+=5;
        } else if (A == 3) {
            g.setColor(Color.red);
            speed += 10;
        } else if (A == 0) {
            speed = 0;
        }
        System.out.println(speed);
        g.fillArc(x, y, 2 * radius, 2 * radius, speed, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, speed+90, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, speed+180, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, speed+270, 30);
    }
}

class umbrellaMan extends JFrame {
    umbrellaMan() {
        add(new DrawUmbrellaMan());
    }
    class DrawUmbrellaMan extends JPanel {
        public int y = 0;
        public int x = 0;

        public int radius = 15;
        public int w = 1000;
        public int a = 1;

        Timer timer = new Timer(100, new Listener());
        DrawUmbrellaMan() {
            timer.start();
            setFocusable(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // umbrella
            g.drawLine(0, y + 365, w, y + 365);
            g.setColor(Color.white);
            g.fillArc(x + 100, y + 100, 200, 150, 0, 180);
            g.setColor(Color.red);

            g.drawString("KMUTNB", x + 140, y + 165);

            // head
            g.setColor(Color.black);
            g.drawOval(x + 140, y + 175, 50, 50);

            // hand
            g.drawLine(x + 170, y + 245, x + 180, y + 275);
            g.setColor(Color.black);
            g.drawLine(x + 170, y + 245, x + 200, y + 260);
            g.drawLine(x + 170, y + 245, x + 180, y + 275);
            g.setColor(Color.white);

            // ubl line
            g.drawLine(x+200,260,x+200,100);

            // body
            g.setColor(Color.black);
            g.fillRect(x+140+50/2-5,175+50,10,100);

            // leg
            if(x%4==0) {
                g.drawLine(140+50/2-5/2+x,
                        175+50+100,
                        140+50/2-5+radius +x,
                        175+50+100 + 40);
            }

            g.drawLine(140 + 50 / 2 - 5 / 2 + x,
                    175 + 50 + 100,
                    140 + 50 / 2 - 5 - radius + x,
                    175 + 50 + 100 + 40);
            // road
            g.drawLine(0,175+50+100+40, w, 175+50+100+40);
            if(w - x < 0 || 160+y == 120) a=0;
            if(w - x > 0 || 160+y == 200) a=1;
            if(a==0) {
                x=0;
//                y--;
            } else {
                x+=1;
                radius *= -1;
//                y++;
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
