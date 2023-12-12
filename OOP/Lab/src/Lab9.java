import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Lab9 extends JFrame{
    public static void main(String[] args) {
//        exGraphics();
//        four();
//        six();
//        three();
//        five();
//        seven();
//        nine();
        eight();

    }

    static void eight() {
        AngryBirds frame = new AngryBirds();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    static void nine() {
        ArrayList<Integer> arr= new ArrayList<Integer>();
        int max_cli = -999;
        int min_point;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i<n; i++) {
            int value = sc.nextInt();
            arr.add(value);
        }
        while (arr.size() > 1){
            for (int l = 0; l < arr.size() - 1; l++) {
                if(Math.abs(arr.get(l) - arr.get(l+1)) > max_cli) {
                    max_cli = Math.abs(arr.get(l) - arr.get(l+1));
                    min_point = l;
                }
            }
            if(arr.size() > 2) {
                count += max_cli;
                max_cli = -999;
                min_point = 0;
                arr.remove(min_point);
                arr.remove(min_point);
            }
        }
        System.out.println(count);
    }
    static void three() {
        LoanCalculator frame = new LoanCalculator();
        frame.pack();
        frame.setTitle("LoanCalculator");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void five() {
        CalculatorGUI frame = new CalculatorGUI();
        frame.pack();
        frame.setTitle("Calculator");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void seven() {
        AccountGUI frame = new AccountGUI();
        frame.setTitle("Show Detail of Account");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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

class AngryBirds extends JFrame {
    JLabel scene, lbScore;
    JTextField score, tfPosY, tfSpeed, tfAngle;
    JButton ok;
    GamePanel p_game = new GamePanel();

    AngryBirds() {
        setLayout(new FlowLayout());
        setSize(500, 500);

        scene = new JLabel("SCENE 1: At Tokyo");
        scene.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(scene, BorderLayout.WEST);

        JPanel p_s = new JPanel(new GridLayout(0, 2, 4, 0));
        lbScore = new JLabel("SCORE");
        lbScore.setFont(new Font("Arial", Font.PLAIN, 24));
        p_s.add(lbScore);

        score = new JTextField();
        score.setEditable(false);
        p_s.add(score);

        p1.add(p_s, BorderLayout.EAST);

        JPanel gap = new JPanel();
        gap.setPreferredSize(new Dimension(10,18));

        JPanel p_input = new JPanel(new GridLayout(0, 3, 4, 4));
        p_input.add(new JLabel("")); p_input.add(new JLabel("")); p_input.add(new JLabel(""));
        p_input.add(new JLabel("Bird Position in y-axis"));
        tfPosY = new JTextField();
        p_input.add(tfPosY);
        p_input.add(new JLabel("m"));

        p_input.add(new JLabel("Shooting speed"));
        tfSpeed = new JTextField();
        p_input.add(tfSpeed);
        p_input.add(new JLabel("m/s"));

        p_input.add(new JLabel("Angle"));
        tfAngle = new JTextField();
        p_input.add(tfAngle);
        p_input.add(new JLabel("degree"));

        p_game.setPreferredSize(new Dimension(500-60, 300-60));
        p1.add(gap, BorderLayout.SOUTH);

        JPanel main_p = new JPanel(new BorderLayout());
        main_p.setBorder(new EmptyBorder(10, 30, 30, 30));
        main_p.add(p1, BorderLayout.NORTH);
        main_p.add(p_input, BorderLayout.SOUTH);
        main_p.add(p_game, BorderLayout.CENTER);

        add(main_p);

        listener l = new listener();

        ok = new JButton("OK");
        ok.addActionListener(l);
        add(ok);
    }

    int score_c = 0;

    class listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int y = Integer.parseInt(tfPosY.getText());
            int speed = Integer.parseInt(tfSpeed.getText());
            int angle = Integer.parseInt(tfAngle.getText());
            p_game.Fby = Math.abs(y-240);
            p_game.speed = speed;
            p_game.angle = angle;
            p_game.cal();
            System.out.println(p_game.Px);
            Timer t = new Timer(p_game.time * 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(p_game.Fbx < p_game.Px+20 && p_game.Fbx > p_game.Px-20) {
                        score_c+=100;
                        score.setText(Integer.toString(score_c));
                        p_game.reset();
                    }
                }
            });
            t.setRepeats(false);
            t.start();
        }
    }

    class GamePanel extends JPanel{
        URL bgURL = this.getClass().getResource("./asset/tokyo.jpg");
        Image bg = new ImageIcon(bgURL).getImage();
        URL birdURL = this.getClass().getResource("./asset/bird.png");
        Image bird = new ImageIcon(birdURL).getImage();
        URL pigURL = this.getClass().getResource("./asset/pig.png");
        Image pig = new ImageIcon(pigURL).getImage();

        int Bx=50, By=240-100, angle, speed, Px=390, Py=50;
        int Fbx=0, Fby=0;
        int old_Bx, old_By;

        public GamePanel(int y, int speed, int angle) {
            y = y;
            angle = angle;
            speed = speed;
        }

        GamePanel() {
            ran();
         }

        Timer timer = new Timer(10, new Listener());
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            timer.start();
            // 440x240
            g.drawImage(bg,0,0,this);
            g.drawImage(bird, Bx, By, 50,50, this);
            g.drawImage(pig, Px, Py, 50,50, this);
            if(Bx < Fbx) Bx+=2;
            if(Fby > 0) if(By < 240-50) By+=1;
//            System.out.println(Bx+" "+By);
            if(Bx >= Fbx && Fbx != 0) p_game.missReset();

        }

        class Listener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }

        void ran() {
            Random rand = new Random();
            int rand_bx = rand.nextInt(0, 50);
            Bx = rand_bx;
            int rand_px = rand.nextInt(100, 440-50);
            int rand_py = rand.nextInt(50,240-50);
            Py = rand_py;
            Px = rand_px;
            old_Bx = Bx;
            old_By = By;
        }
        void reset() {
            Fbx=0;
            Fby=0;
            ran();
        }
        void missReset() {
            Fbx=0;
            Fby=0;
            Bx = old_Bx;
            By = old_By;
        }

        int time;
        void cal() {
            double Sy = Fby;
            double U = speed;
            double sAngle = Math.toRadians(angle);
            double g = 9.81;
            By = Fby;

            // time
            double t;
            if (Sy > 0) t = (U * Math.sin(sAngle) + Math.sqrt(Math.pow(U*Math.sin(sAngle), 2) + 2 * g * Sy)) / g;
            else t = 2 * U * Math.sin(sAngle) / g;

            // distance (Sx)
            double Sx = U * Math.cos(sAngle) * t;

            Fbx = (int)Sx;
            time = (int)t;

            System.out.println("Time: " + t + " s");
            System.out.println("Sx: " + Sx + " m");
        }
    }

}
class AccountGUI extends JFrame {
    private JTextField idField, moneyField, annualInterestRateField, firstNameField, lastNameField, ageField;
    private JComboBox<Integer> dayOpenField, monthOpenField, yearOpenField, dayBirthField, monthBirthField, yearBirthField;
    private JTextArea displayArea;
    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountGUI() {
        add(new JLabel("ACCOUNT MONEY"));
        TitledBorder border = BorderFactory.createTitledBorder("Enter Data Account Money");
        border.setTitleJustification(TitledBorder.LEFT);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 1));  // 0 rows for dynamic row creation, 2 columns
        inputPanel.setBorder(border);
        JPanel r1 = new JPanel();
        JPanel r2 = new JPanel();
        JPanel r3 = new JPanel();
        JPanel r4 = new JPanel();
        JPanel r5 = new JPanel();
        JPanel r6 = new JPanel();
        JPanel r7 = new JPanel();

        setLayout(new FlowLayout());

        idField = new JTextField(10);
        moneyField = new JTextField(10);
        annualInterestRateField = new JTextField(10);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        ageField = new JTextField(10);

        dayOpenField = new JComboBox<>(getDays());
        monthOpenField = new JComboBox<>(getMonths());
        yearOpenField = new JComboBox<>(getYears());

        dayBirthField = new JComboBox<>(getDays());
        monthBirthField = new JComboBox<>(getMonths());
        yearBirthField = new JComboBox<>(getYears());

        JButton saveButton = new JButton("Save");
        JButton showButton = new JButton("Show");

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        r1.add(new JLabel("ID: "));
        r1.add(idField);
        r1.add(new JLabel("Money: "));
        r1.add(moneyField);
        r1.add(new JLabel("Bath:"));
        r2.add(new JLabel("Annual Interest Rate: "));
        r2.add(annualInterestRateField);

        r4.add(new JLabel("First Name: "));
        r4.add(firstNameField);
        r5.add(new JLabel("Last Name: "));
        r5.add(lastNameField);
        r7.add(new JLabel("Age: "));
        r7.add(ageField);
        r7.add(new JLabel("Year"));

        r3.add(new JLabel("Day Open Account: "));
        r3.add(dayOpenField);
        r3.add(monthOpenField);
        r3.add(yearOpenField);

        r6.add(new JLabel("Birth Date: "));
        r6.add(dayBirthField);
        r6.add(monthBirthField);
        r6.add(yearBirthField);

        inputPanel.add(r1);
        inputPanel.add(r2);
        inputPanel.add(r3);
        inputPanel.add(r4);
        inputPanel.add(r5);
        inputPanel.add(r6);
        inputPanel.add(r7);

        add(inputPanel);

        add(saveButton);
        add(showButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAccount();
            }
        });

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllAccounts();
            }
        });
    }

    private void saveAccount() {
        int id = Integer.parseInt(idField.getText());
        double money = Double.parseDouble(moneyField.getText());
        double annualInterestRate = Double.parseDouble(annualInterestRateField.getText());

        int dayOpen = (int) dayOpenField.getSelectedItem();
        int monthOpen = (int) monthOpenField.getSelectedItem();
        int yearOpen = (int) yearOpenField.getSelectedItem();

        int dayBirth = (int) dayBirthField.getSelectedItem();
        int monthBirth = (int) monthBirthField.getSelectedItem();
        int yearBirth = (int) yearBirthField.getSelectedItem();

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        int age = Integer.parseInt(ageField.getText());

        Account account = new Account(id, money);
        account.setAnnualInterestRate(annualInterestRate);
        Date openDate = new Date(dayOpen, monthOpen, yearOpen);
        account.setDateCreated(openDate);

        Person person = new Person(firstName, lastName);
        person.setBdate(new Date(dayBirth, monthBirth, yearBirth));
        person.setAge(age);

        account.setPerson(person);
        accounts.add(account);

        clearFields();
    }

    private void clearFields() {
        idField.setText("");
        moneyField.setText("");
        annualInterestRateField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        dayOpenField.setSelectedIndex(0);
        monthOpenField.setSelectedIndex(0);
        yearOpenField.setSelectedIndex(0);
        dayBirthField.setSelectedIndex(0);
        monthBirthField.setSelectedIndex(0);
        yearBirthField.setSelectedIndex(0);
    }

    private void showAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }

    private Integer[] getDays() {
        Integer[] days = new Integer[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = i;
        }
        return days;
    }

    private Integer[] getMonths() {
        Integer[] months = new Integer[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = i;
        }
        return months;
    }

    private Integer[] getYears() {
        Integer[] years = new Integer[100];
        for (int i = 1924; i <= 2023; i++) {
            years[i - 1924] = i;
        }
        return years;
    }
}

class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField textField;
    private double num, ans;
    private int calculation;

    public CalculatorGUI() {
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));

        String[] buttonLabels = {
                "√", "x²", "±", "C",
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", ".", "=", "/"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            if(label == "C") button.setForeground(Color.RED);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(textField, BorderLayout.NORTH);
        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("[0-9.]")) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
            num = ans = 0;
        } else if (command.equals("√")) {
            num = Double.parseDouble(textField.getText());
            ans = Math.sqrt(num);
            textField.setText(Double.toString(ans));
        } else if (command.equals("x²")) {
            num = Double.parseDouble(textField.getText());
            ans = num * num;
            textField.setText(Double.toString(ans));
        } else if (command.equals("±")) {
            num = Double.parseDouble(textField.getText());
            ans = -num;
            textField.setText(Double.toString(ans));
        } else if (command.matches("[+\\-*/]")) {
            num = Double.parseDouble(textField.getText());
            calculation = command.charAt(0);
            textField.setText("");
        } else if (command.equals("=")) {
            double secondNum = Double.parseDouble(textField.getText());
            switch (calculation) {
                case '+':
                    ans = num + secondNum;
                    break;
                case '-':
                    ans = num - secondNum;
                    break;
                case '*':
                    ans = num * secondNum;
                    break;
                case '/':
                    ans = num / secondNum;
                    break;
            }
            textField.setText(Double.toString(ans));
        }
        textField.requestFocus();
    }
}

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

class LoanCalculator extends JFrame {
    // Create text fields for interest rate, years
    // loan amount, monthly payment, and total payment
    private JTextField jtfAnnualInterestRate = new JTextField();
    private JTextField jtfNumberOfYears = new JTextField();
    private JTextField jtfLoanAmount = new JTextField();
    private JTextField jtfMonthlyPayment = new JTextField();
    private JTextField jtfTotalPayment = new JTextField();

    // Create a Compute Payment button
    private JButton jbtComputeLoan = new JButton("Compute Payment");

    public LoanCalculator() {
        // Panel p1 to hold labels and text fields
        JPanel p1 = new JPanel(new GridLayout(5, 2));
        p1.add(new JLabel("Annual Interest Rate"));
        p1.add(jtfAnnualInterestRate);
        p1.add(new JLabel("Number of Years"));
        p1.add(jtfNumberOfYears);
        p1.add(new JLabel("Loan Amount"));
        p1.add(jtfLoanAmount);
        p1.add(new JLabel("Monthly Payment"));
        p1.add(jtfMonthlyPayment);
        p1.add(new JLabel("Total Payment"));
        p1.add(jtfTotalPayment);
        p1.setBorder(new
                TitledBorder("Enter loan amount, interest rate, and years"));
        // Panel p2 to hold the button
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(jbtComputeLoan);
        // Add the panels to the frame
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        // Register listener
        jbtComputeLoan.addActionListener(new ButtonListener());
    }

    /**
     * Handle the Compute Payment button
     */
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get values from text fields
            double interest =
                    Double.parseDouble(jtfAnnualInterestRate.getText());
            int year = Integer.parseInt(jtfNumberOfYears.getText());
            double loanAmount =
                    Double.parseDouble(jtfLoanAmount.getText());
            // Create a loan object
            Loan loan = new Loan(interest, year, loanAmount);

            // Display monthly payment and total payment
            jtfMonthlyPayment.setText(String.format("%.2f",
                    loan.getMonthlyPayment()));
            jtfTotalPayment.setText(String.format("%.2f",
                    loan.getTotalPayment()));
        }
    }
}

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private double loanTermInMonths = 0;
    private java.util.Date loanDate;

    /**
     * Default constructor
     */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate,
     * number of years, and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate / 100;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanTermInMonths = numberOfYears * 12; // add a number of term in months
        loanDate = new java.util.Date();
    }

    /**
     * Return annualInterestRate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return numberOfYears
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    // return a TotalPayment
    public double getTotalPayment() {
        return getMonthlyPayment() * loanTermInMonths;
    }

    // return a MonthlyPayment
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 12;

        return loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTermInMonths) - 1);
    }
}
