import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;


public class Lab11 extends JFrame {
    public static void main(String[] args) {
        thread();
//        two();
//        three();
//        four();
//        five();
    }

    static void thread() {
        new Thread1("A").start();
        new Thread1("B").start();
    }
    static void four() {
        multiCarThread frame=new multiCarThread();
        frame.setTitle("Exercise");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

    static void two() {
        ClockAnimationThread frame = new ClockAnimationThread();
        frame.setTitle("ClockAnimation");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void three() {
        Exercise frame = new Exercise();
        frame.setTitle("Exercise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    static void five() {
        Five a = new Five();
        a.setSize(600,500);
        a.setVisible(true);
    }
}

class Thread1 extends Thread{
    Thread1(String name){
        super(name);
    }
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(getName()+" ");
        }
    }
}

class multiCarThread extends JFrame {
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

    multiCarThread() {
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

class ClockAnimationThread extends JFrame {
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
//    Timer timer = new Timer(1000, new TimerListener());
    Thread timer;
    JRadioButton radioJapan = new JRadioButton("JAPAN",true);
    JRadioButton radioUs = new JRadioButton("US",false);
    JRadioButton radioUk = new JRadioButton("UK",false);
    JPanel radioButtonsPanel = new JPanel();
    JPanel p = new JPanel(new GridLayout(3,1,5,5));
    public ClockAnimationThread() {
        timer = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    try {
                        repaint();
                        Thread.sleep(10);

                    } catch (Exception ex) {

                    }
                }
            }
        });
        timer.start();
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
class Exercise extends JFrame {
    public Exercise() {
        add(new RaceCarThread());
    }
}

class RaceCarThread extends JPanel{
    private int xBase = 0;
    private Thread timer;
    int sleeptime = 100;
    //    private Timer timer = new Timer(10, new Listener());
    public RaceCarThread() {
//        timer.start();
        timer = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true) {
                    try {
                        repaint();
                        Thread.sleep(sleeptime);

                    } catch (Exception ex) {

                    }
                }
            }
        });
        timer.start();
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == 61) {
                    if (sleeptime > 5)
                        sleeptime -= 5;
                }
                else if (e.isControlDown() && e.getKeyCode() == 45)
                    sleeptime += 1;
            }
        });
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();
        if (xBase > getWidth())
            xBase = -20;
        else
            xBase += 1;
        g.setColor(Color.BLACK);
        g.fillOval(xBase + 10, yBase - 10, 10, 10);
        g.fillOval(xBase + 30, yBase - 10, 10, 10);
        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase - 20, 50, 10);
        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(xBase + 10, yBase - 20);
        polygon.addPoint(xBase + 20, yBase - 30);
        polygon.addPoint(xBase + 30, yBase - 30);
        polygon.addPoint(xBase + 40, yBase - 20);
        g.fillPolygon(polygon);

        // road
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, getWidth(), 0);
    }
}

class Five extends JFrame {
    private BalloonPanel paintPanel = new BalloonPanel();
    public Five(){
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
        private Thread gameThread;
        int sleeptime = 10;
//        private Timer timer = new Timer(10, new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                repaint();
//            }
//        });



        public BalloonPanel() {
            gameThread = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            repaint();
                            Thread.sleep(sleeptime);

                        } catch (Exception ex) {

                        }
                    }
                }
            };
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
            gameThread.start();
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
                sleeptime = 1000;
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
                sleeptime = 10;
                return;
            }

            g.drawOval(x_Balloon - BALLOON_RADIUS,
                    y_Balloon- BALLOON_RADIUS, 2 * BALLOON_RADIUS,
                    2 * BALLOON_RADIUS);//love ajansatid;

            // Draw small hitting balls
            for (int i = 0; i < list.size(); i++) {
                SmallBall ball = list.get(i);//eiei
                ball.length += 5;//yeye
                g.setColor(Color.red);

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
