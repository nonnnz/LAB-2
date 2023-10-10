import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.*;
import javax.swing.Timer;

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
    private class TimerListener implements ActionListener { ;
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

public class Lab10 extends JFrame{
    /** Main method */
    public static void main(String[] args) {
        JFrame frame = new ClockAnimation();
        frame.setTitle("ClockAnimation");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
