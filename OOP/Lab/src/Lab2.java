import java.util.Scanner;
import java.util.Date;

class LinearEquation {
    //attribute
    private double a, b, c, d, e, f;
    
    //constructor
    LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    //method
    public boolean isSolvable() {
        return a * d - b * c != 0;
    }
    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }
    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    } 
    public void cal() {
        if (isSolvable()) {
            System.out.println("x is "+getX()+"  and y is "+getY());
        } else System.out.println("The equation has no solution");
    }
}

class Account {
    private int id;
    private double balance, annualInterestRate;
    private Date dateCreated;

    Account(){}
    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
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

    public void setAnnualInterestRate(double a) {
        this.annualInterestRate = a;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date d) {
        this.dateCreated = d;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return (getMonthlyInterestRate() / 100) * balance;
    }

    public void withdraw(double amt) {
        this.balance -= amt;
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    @Override
    public String toString() {
        return "balance = "+balance+" MonthlyInterestRate = "+getMonthlyInterestRate()+"%";
    }
}

class Rectangle {
    double centerX;
    double centerY;
    double width;
    double height;

    public Rectangle(double centerX, double centerY, double width, double height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
    }

    public boolean contains(Rectangle other) {
        double x1 = this.centerX - this.width / 2;
        double x2 = this.centerX + this.width / 2;
        double y1 = this.centerY - this.height / 2;
        double y2 = this.centerY + this.height / 2;

        double otherX1 = other.centerX - other.width / 2;
        double otherX2 = other.centerX + other.width / 2;
        double otherY1 = other.centerY - other.height / 2;
        double otherY2 = other.centerY + other.height / 2;

        return (x1 <= otherX1) && (x2 >= otherX2) && (y1 <= otherY1) && (y2 >= otherY2);
    }

    public boolean overlaps(Rectangle other) {
        double x1 = this.centerX - this.width / 2;
        double x2 = this.centerX + this.width / 2;
        double y1 = this.centerY - this.height / 2;
        double y2 = this.centerY + this.height / 2;

        double otherX1 = other.centerX - other.width / 2;
        double otherX2 = other.centerX + other.width / 2;
        double otherY1 = other.centerY - other.height / 2;
        double otherY2 = other.centerY + other.height / 2;

        return !(x1 >= otherX2 || x2 <= otherX1 || y1 >= otherY2 || y2 <= otherY1);
    }
}

class RegularPolygon {
    private int n;
    private double side, x, y;

    RegularPolygon() {
        this.n = 3; // sides
        this.side = 1; // length
        this.x = 0;
        this.y = 0;
    }

    RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        this.x = 0;
        this.y = 0;
    }

    RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return (n * Math.pow(side, 2))/(4 * Math.tan(Math.PI/n));
    }

}

class MaximumPrimeNumber {
    public static int _max;
    public static int findMaxPrime() {
        _max = -9999;
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while(i != 0) {
            if(i > _max && i % 2 != 0) _max = i;
            i = sc.nextInt();
        }
        if(_max != -9999) return _max;
        else return -1;
    }
}

public class Lab2 {
    public static void main(String[] args) {
        linearEquation();
        account();
        rectangle();
        regularPolygon();
        max_prime();
    }


    static void linearEquation() {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d, e, f;
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();
        e = sc.nextDouble();
        f = sc.nextDouble();
        LinearEquation s = new LinearEquation(a, b, c, d, e, f);
        s.cal();
    }
    
    static void account() {
        Account Client = new Account(1122, 20000);
        Client.setAnnualInterestRate(4.5);
        Client.withdraw(2500);
        Client.deposit(3000);
        System.out.println(Client.toString());
    }
    
    static void rectangle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        double r1X = scanner.nextDouble();
        double r1Y = scanner.nextDouble();
        double r1Width = scanner.nextDouble();
        double r1Height = scanner.nextDouble();
        Rectangle r1 = new Rectangle(r1X, r1Y, r1Width, r1Height);

        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        double r2X = scanner.nextDouble();
        double r2Y = scanner.nextDouble();
        double r2Width = scanner.nextDouble();
        double r2Height = scanner.nextDouble();
        Rectangle r2 = new Rectangle(r2X, r2Y, r2Width, r2Height);

        if (r1.contains(r2)) {
            System.out.println("r2 is inside r1");
        } else if (r1.overlaps(r2)) {
            System.out.println("r2 overlaps r1");
        } else {
            System.out.println("r2 is outside r1");
        }

        scanner.close();
    }

    static void regularPolygon() {
        RegularPolygon obj = new RegularPolygon();
        RegularPolygon obj2 = new RegularPolygon(6, 4);
        RegularPolygon obj3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Perimeter = "+obj.getPerimeter()+" Area = "+obj.getArea());
        System.out.println("Perimeter = "+obj2.getPerimeter()+" Area = "+obj.getArea());
        System.out.println("Perimeter = "+obj3.getPerimeter()+" Area = "+obj.getArea());
    }

    static void max_prime() {
        System.out.print(MaximumPrimeNumber.findMaxPrime());
    }
}
