import java.util.Scanner;

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

public class Lab2 {
    public static void main(String[] args) {
        // rectangle();
        linearEquation();

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
}
