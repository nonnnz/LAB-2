//abstract class GeometricObject {
//    private String color = "white";
//    private boolean filled;
//
//    protected GeometricObject() {
//    }
//
//    protected GeometricObject(String color, boolean filled) {
//        this.color = color;
//        this.filled = filled;
//    }
//    public String getColor() {
//        return color;
//    }
//    public void setColor(String color) {
//        this.color = color;
//    }
//    public boolean isFilled() {
//        return filled;
//    }
//    public void setFilled(boolean filled) {
//        this.filled = filled;
//    }
//    public abstract double findArea();
//    public abstract double findPerimeter();
//}
//
//class Circle extends GeometricObject {
//    private double radius;
//
//    public Circle() {
//        this(1.0);
//    }
//
//    public Circle(double radius) {
//        this(radius, "white", false);
//    }
//
//    public Circle(double radius, String color, boolean filled) {
//        super(color, filled);
//        this.radius = radius;
//    }
//
//    public double getRadius() {
//        return radius;
//    }
//
//    public void setRadius(double radius) {
//        this.radius = radius;
//    }
//
//    public double findArea() {
//        return radius * radius * Math.PI;
//    }
//
//    public double findPerimeter() {
//        return 2 * radius * Math.PI;
//    }
//
//    public String toString() {
//        return "Circle: radius = " + radius;
//    }
//}
//
//class ExRectangle extends GeometricObject {
//    private double width;
//    private double height;
//
//    public ExRectangle() {
//        this(1.0, 1.0);
//    }
//    public ExRectangle(double width, double height) {
//        this(width, height, "white", false);
//    }
//
//    public ExRectangle(double width, double height, String color, boolean filled) {
//        super(color, filled);
//        this.width = width;
//        this.height = height;
//    }
//
//    public double getWidth() {
//        return width;
//    }
//
//    public void setWidth(double width) {
//        this.width = width;
//    }
//
//    public double getHeight() {
//        return height;
//    }
//
//    public void setHeight(double height) {
//        this.height = height;
//    }
//
//    public double findArea() {
//        return width * height;
//    }
//
//    public double findPerimeter() {
//        return 2 * (width + height);
//    }
//
//    public String toString() {
//        return "Rectangle: width = " + width + ", height = " + height;
//    }
//}
//
//class MyRectangle2D extends ExRectangle {
//    private double x;
//    private double y;
//
//    public MyRectangle2D() {
//        this(0, 0, 1, 1);
//    }
//
//    public MyRectangle2D(double x, double y, double width, double height) {
//        super(width, height);
//        this.x = x;
//        this.y = y;
//    }
//
//    public double getX() {
//        return x;
//    }
//
//    public void setX(double x) {
//        this.x = x;
//    }
//
//    public double getY() {
//        return y;
//    }
//
//    public void setY(double y) {
//        this.y = y;
//    }
//
//    public double getArea() {
//        return super.findArea();
//    }
//
//    public double getPerimeter() {
//        return super.findPerimeter();
//    }
//
//    public boolean contains(double x, double y) {
//        double minX = this.x - (super.getWidth() / 2);
//        double minY = this.y - (super.getHeight() / 2);
//        double maxX = this.x + (super.getWidth() / 2);
//        double maxY = this.y + (super.getHeight() / 2);
//
//        return (x >= minX && x <= maxX) && (y >= minY && y <= maxY);
//    }
//
//    public boolean contains(MyRectangle2D r) {
//        double minX1 = this.x - (super.getWidth() / 2);
//        double minY1 = this.y - (super.getHeight() / 2);
//        double maxX1 = this.x + (super.getWidth() / 2);
//        double maxY1 = this.y + (super.getHeight() / 2);
//
//        double minX2 = r.x - (r.getWidth() / 2);
//        double minY2 = r.y - (r.getHeight() / 2);
//        double maxX2 = r.x + (r.getWidth() / 2);
//        double maxY2 = r.y + (r.getHeight() / 2);
//
//        return (minX1 <= minX2 && maxX1 >= maxX2 && minY1 <= minY2 && maxY1 >= maxY2);
//    }
//
//    public boolean overlaps(MyRectangle2D r) {
//        double minX1 = this.x - (super.getWidth() / 2);
//        double minY1 = this.y - (super.getHeight() / 2);
//        double maxX1 = this.x + (super.getWidth() / 2);
//        double maxY1 = this.y + (super.getHeight() / 2);
//
//        double minX2 = r.x - (r.getWidth() / 2);
//        double minY2 = r.y - (r.getHeight() / 2);
//        double maxX2 = r.x + (r.getWidth() / 2);
//        double maxY2 = r.y + (r.getHeight() / 2);
//
//        return !(maxX1 < minX2 || maxX2 < minX1 || maxY1 < minY2 || maxY2 < minY1);
//    }
//}

//class Rectangle {
//    double width;
//    double height;
//    double x;
//    double y;
//
//    public Rectangle(double width, double height, double x, double y) {
//        this.width = width;
//        this.height = height;
//        this.x = x;
//        this.y = y;
//    }
//
//    public double getArea() {
//        return width * height;
//    }
//}

class Line {
    double x1;
    double y1;
    double x2;
    double y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLong() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private Person objPerson;

    Account() {}

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    public void setPerson(Person p) {
        this.objPerson = p;
    }

    public Person getPerson() {
        return this.objPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setDateCreated(Date d) {
        this.dateCreated = d;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate/12);
    }

    public double getMonthlyInterest() {
        Date current = new Date(6,9,2003);

        return ((this.getMonthlyInterestRate()/100) * balance) * (current.m - this.dateCreated.m);
    }

    public void transfermoney(Account acc, double amt) {
        this.setBalance(this.getBalance()-amt);
        acc.setBalance(acc.getBalance()+amt);
    }

    public void withdraw(double amt) {
        this.setBalance(this.getBalance()-amt);
    }

    public void deposit(double amt) {
        this.setBalance(this.getBalance()+amt);
    }

    @Override
    public String toString() {
        if(this.objPerson != null) return this.objPerson.toString()+"\n"+"balance = "+this.getBalance()+" MonthlyInterest = "+this.getMonthlyInterest();
        else return "balance = "+this.getBalance()+" MonthlyInterestRate = "+this.getMonthlyInterestRate();
    }
}

class Date{
    int d, m, y;

    public Date(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }

    @Override
    public String toString() {
        return d+"/"+m+"/"+y;
    }
}

class Person {
    private String name;
    private String surname;
    private int age;
    private Date bDate;

    Person() {}
    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setBdate(Date d) {
        this.bDate = d;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name = "+name+" surname = "+surname+" age = "+age+" bDate = "+bDate;
    }
}

class SavingAccount extends Account {
    public SavingAccount() {
        super();
    }
    public SavingAccount(int id, double amt) {
        super(id, amt);
    }

    public void setPerson(Person p) {
        super.setPerson(p);
    }

    @Override
    public void transfermoney(Account acc, double amt) {
        super.transfermoney(acc, amt);
        this.setBalance(this.getBalance()-20);
    }

    public void setDateCreate(Date d) {
        super.setDateCreated(d);
    }
}

class FixAccount extends Account {
    public FixAccount() {
        super();
    }
    public FixAccount(int id, double amt) {
        super(id, amt);
    }

    @Override
    public void transfermoney(Account acc, double amt) {
        System.out.println("Cannot transfer money");
    }

    @Override
    public void withdraw(double amt) {
        Date current = new Date(6,9,2023);
        int year = Math.abs(this.getDateCreated().y-current.y);
//        System.out.println(year);
        if(year>1) {
            super.withdraw(amt);
        }
        else {
            System.out.println("Cannot withdraw");
        }
    }

    public void setDateCreate(Date d) {
        super.setDateCreated(d);
    }
}

//public class Lab6 {
//
//    public static void main(String[] args) {
////        five();
////        six();
////        seven();
//        eight();
//    }
//    static void five() {
//        Account Client1 = new Account(1122, 20000);
//        Client1.setAnnualInterestRate(4.5);
//        Client1.withdraw(2500);
//        Client1.deposit(3000);
//        Client1.setPerson(null);
//        System.out.println(Client1.toString());
//    }
//
//    static void six(){
//        // case 1
//        SavingAccount Client1 = new SavingAccount(1123,20000);
//        Person client1 = new Person("Client1","Client");
//        client1.setAge(20);
//        client1.setBdate(new Date(1,1,2003));
//        Client1.setPerson(client1);
//        Client1.setDateCreate(new Date(6,5,2023));
//        Client1.setAnnualInterestRate(4.5);
//        Client1.withdraw(2500);
//        Client1.deposit(3000);
//
//        SavingAccount Client2 = new SavingAccount(1100,0);
//        Person client2 = new Person("Client2","Client");
//        client2.setAge(21);
//        client2.setBdate(new Date(1,1,2002));
//        Client2.setPerson(client2);
//        Client2.setDateCreate(new Date(6,9,2023));
//        Client1.setAnnualInterestRate(4.5);
//
//        Client1.transfermoney(Client2, 100);
//        System.out.println(Client1.toString());
//        System.out.println(Client2.toString());
//
//        // case 2
//        FixAccount Client3 = new FixAccount(1124,20000);
//        Person client3 = new Person("Client3","Client");
//        client3.setAge(23);
//        client3.setBdate(new Date(1,1,2000));
//        Client3.setPerson(client3);
//        Client3.setDateCreate(new Date(6,5,2023));
//        Client3.setAnnualInterestRate(7);
//        Client3.withdraw(2500);
//        Client3.deposit(3000);
//        Client3.transfermoney(Client2, 100);
//        System.out.println(Client3.toString());
//    }
//
//    static void seven() {
//        MyRectangle2D obj;
//    }
//
//    static void eight() {
//        Rectangle rectangle = new Rectangle(5.0, 4.0, 2.0, 3.0);
//        Line line1 = new Line(1.0, 2.0, 4.0, 6.0);
//        Line line2 = new Line(3.0, 5.0, 8.0, 10.0);
//
//        int containsResult = contains(line1, rectangle);
//        int crossResult = cross(line1, line2);
//        int overlapsResult = overlaps(rectangle, new Rectangle(7.0, 4.0, 5.0, 3.0));
//        double distance = distance(line1, rectangle);
//
//        System.out.println("Contains: " + containsResult);
//        System.out.println("Cross: " + crossResult);
//        System.out.println("Overlaps: " + overlapsResult);
//        System.out.println("Distance: " + distance);
//    }
//
//    public static int contains(Line a, Rectangle b) {
//        double centerX = (b.x + b.width / 2);
//        double centerY = (b.y + b.height / 2);
//
//        if (a.x1 >= b.x && a.y1 >= b.y && a.x2 <= (b.x + b.width) && a.y2 <= (b.y + b.height)) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public static int cross(Line a, Line b) {
//        if (a.x1 <= b.x2 && a.x2 >= b.x1 && a.y1 <= b.y2 && a.y2 >= b.y1) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public static int overlaps(Rectangle a, Rectangle b) {
//        if (a.x + a.width > b.x && b.x + b.width > a.x && a.y + a.height > b.y && b.y + b.height > a.y) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public static double distance(Line a, Rectangle b) {
//        double centerXLine = (a.x1 + a.x2) / 2;
//        double centerYLine = (a.y1 + a.y2) / 2;
//        double centerXRect = b.x + b.width / 2;
//        double centerYRect = b.y + b.height / 2;
//
//        double dx = centerXLine - centerXRect;
//        double dy = centerYLine - centerYRect;
//
//        return Math.sqrt(dx * dx + dy * dy);
//    }
//
//}