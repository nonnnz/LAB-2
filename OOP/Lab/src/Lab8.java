import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab8 extends JFrame {

    public static void main(String[] args) throws CloneNotSupportedException {
//        abstractDrawFunction();
//        employee();
//        two();
//        five();
//        six();
        seven();
    }
    static void five() throws CloneNotSupportedException {
//        Circle c1 = new Circle(5);
//        Circle c2 = new Circle(5);
//        System.out.println(c1.compareTo(c2));

        Rectangle r1 = new Rectangle(20, 10);
        Rectangle r2 = new Rectangle(10, 20);
        System.out.println(r1.compareTo(r2));

        Octagon o1 = new Octagon(5);
        System.out.println(o1.getPerimeter());
        Octagon o2 = (Octagon)o1.clone();
        System.out.println(o2.getPerimeter());

        ComparableCircle cc1 = new ComparableCircle(5);
        ComparableCircle cc2 = new ComparableCircle(7);
        if (cc1.compareTo(cc2) > 0) System.out.println(cc1.toString());
        else if (cc1.compareTo(cc2) < 0) System.out.println(cc2.toString());
        else System.out.println("equal");
    }
    static int count = 1000000000, end;
    static void seven() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[m][n];
        for(int i=0; i<m; i++){
            int s = sc.nextInt();
            for(int j=0;j<s;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int begin;
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            begin = sc.nextInt();
            end = sc.nextInt();
            find(a,begin,0);
            if(count == 1000000000){
                System.out.println("Impossible");
            }
            else{
                System.out.println(count);
            }
            count=1000000000;
        }
    }

    static void find(int[][] t,int station,int time){
        int[][] train = new int[t.length][t[0].length];
        ArrayList<Integer> check=new ArrayList<Integer>();
        boolean c1 = false, c2 = false;
        for(int i=0; i<t.length; i++){
            for(int j=0; j<t[i].length; j++){
                train[i][j] = t[i][j];
                if(train[i][0]!=-1){
                    if(train[i][j] == station){
                        c1 = true;
                    }
                    else if(train[i][j] == end){
                        c2 = true;
                    }
                    if(c1 && c2){
                        if(time == 0){
                            count = time;
                            return;
                        }
                        else if(count>time){
                            count = time;
                        }
                    }
                    else if(train[i][j] == station&&!check.contains(i)){
                        check.add(i);
                    }
                }
            }
            c1 = false;
            c2 = false;
        }

        for(int i=0; i<check.size(); i++){
            int j=0,temp=train[check.get(i)][0];
            train[check.get(i)][0] = -1;
            while(train[check.get(i)][j] != 0){
                if(j == 0) find(train, temp, time+1);
                else find(train, train[check.get(i)][j], time+1);
                j++;
            }
        }

    }
    static void six() {
        Movable m1 = new MovablePoint(15, 30, 2, 4);
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(20, 40, 2, 5, 8);
        System.out.println(m2);
        m2.moveLeft();
        System.out.println(m2);
    }
    static void two() {
        House house1 = new House(1, 1750.50);
        House house2 = (House)house1.clone();
        System.out.println(house2.getArea());
    }
    
    static void employee() {
        ArrayList<Employee> arr = new ArrayList<Employee>();
        SalariedEmployee s1 = new SalariedEmployee("A", "A", "0000", 10000);
        SalariedEmployee s2 = new SalariedEmployee("A", "A", "0000", 10000);
        ComEmployee s3 = new ComEmployee("A", "A", "0000", 10000.0, 10.0);
        ComEmployee s4 = new ComEmployee("A", "A", "0000",10000, 10);
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        printEmp(arr);

    }
    
    public static void printEmp(ArrayList<Employee> a) {
        double[] arrayEarn = new double[a.size()];
        double[] arrayBonus = new double[a.size()];
        for(int i=0;i<a.size(); i++) {
            Employee obj = a.get(i);
            arrayEarn[i] = obj.earning();
            arrayBonus[i] = obj.bonus(10);
            System.out.println(obj.getName()+" "+obj.getLastname()+" "+arrayEarn[i]+" "+arrayBonus[i]);
        }
    }
    
    static void abstractDrawFunction() {
        Test frame = new Test();
        frame.setSize(400, 400);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
}

interface Movable{
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}

class MovablePoint implements Movable{
    public int x;
    public int y;
    public int xSpeed;
    public int ySpeed;
    MovablePoint(){}
    MovablePoint(int x, int y, int xSpeed ,int ySpeed){
        this.x=x;
        this.y=y;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public void moveUp(){
        y+=ySpeed;
    }
    public void moveLeft(){
        x-=xSpeed;
    }
    public void moveRight(){
        x+=xSpeed;
    }
    public void moveDown(){
        y-=ySpeed;
    }
    public String toString(){
        return x+", "+y;
    }
}

class MovableCircle extends MovablePoint{
    public int radius;
    public MovablePoint center;
    MovableCircle(){}
    MovableCircle(int x, int y,int xSpeed,int ySpeed,int r){
        super(x ,y, xSpeed, ySpeed);
        radius=r;
    }
    public String toString(){
        return x+", "+y+", r="+radius;
    }
    public void moveUp(){
        y+=ySpeed;
    }
    public void moveLeft(){
        x-=xSpeed;
    }
    public void moveRight(){
        x+=xSpeed;
    }
    public void moveDown(){
        y-=ySpeed;
    }
}

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    protected GeometricObject() {
    }
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends GeometricObject {
    private double radius;

    public Circle() {
        this(1.0);
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public Circle(double radius) {
        this(radius, "white", false);
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public String toString() {
        return "Circle: radius = " + radius;
    }

//    @Override
//    public int compareTo(Circle o) {
//        if(radius == o.radius) return 1;
//        else return 0;
//    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

class Rectangle extends GeometricObject implements Comparable<Rectangle> {
    private double width;
    private double height;

    public Rectangle() {
        this(1.0, 1.0);
    }
    public Rectangle(double width, double height) {
        this(width, height, "white", false);
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return "Rectangle: width = " + width + ", height = " + height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public int compareTo(Rectangle o) {
        if (getArea() == o.getArea()) return 1;
        else return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
    private double side;

    public Octagon() {
    }

    public Octagon(double side) {
        this.side = side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon o) {
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + "\nArea: " + getArea() +
                "\nPerimeter: " + getPerimeter();
    }
}

class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArea: " + getArea();
    }
}
abstract class AbstractDrawFunction extends JPanel
{
    /**Polygon to hold the points*/
    private Polygon p = new Polygon();
    /**Default constructor*/
    protected AbstractDrawFunction ()
    {
        drawFunction();
        setBackground(Color.white);
    }
    /**Draw the function*/
    public abstract double f(double x);
    /**Obtain points for x coordinates 100, 101, ..., 300*/
    public void drawFunction()
    {
        for (int x = -100; x <= 100; x++)
        {
            p.addPoint(x+200, 200-(int)f(x));
        }
    }
    /**Paint the function diagram*/
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // Draw x axis
        g.drawLine(10, 200, 390, 200);
        // Draw y axis
        g.drawLine(200,30, 200, 390);
        // Draw arrows on x axis
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);
        // Draw arrows on y axis
        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
        // Draw x, y
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
        // Draw a polygon line by connecting the points in the polygon
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}

class Ex1 extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return x*x;
    }
}

class Ex2 extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.sin(x)*100;
    }
}

class Ex3 extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.cos(x)*100;
    }
}

class Ex4 extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.tan(x)*100;
    }
}

class Ex5 extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return (Math.cos(x)+5*Math.sin(x));
    }
}

class Ex6 extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return (5*Math.cos(x)+Math.sin(x));
    }
}

class Ex7 extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.log(x)+x*x;
    }
}

class Test extends JFrame
{
    Test()
    {
        setLayout(new GridLayout(2, 4, 5, 5));
        add(new Ex1());
        add(new Ex2());
        add(new Ex3());
        add(new Ex4());
        add(new Ex5());
        add(new Ex6());
        add(new Ex7());
    }

}
abstract class Employee{
    private String firstname;
    private String lastname;
    private String id;

        
    public Employee(String firstname,String lastname,String id){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }
    
    public String getName() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public String getId() {
        return id;
    }
    
    public double earning(){
        return 0;
    }
        
    public double bonus(int year){
        return 0;
    }
   
    @Override
    public String toString() {
        return ""+firstname+" "+lastname;
    }
}

class SalariedEmployee extends Employee {
    private double salary;
//    int year;
    
    public SalariedEmployee(String firstname, String lastname, String id, double sal) {
        super(firstname, lastname, id);
        this.salary = sal;
    }
    
    public double getSalary() {
        return salary;
    }
    @Override
    public double earning() {
        return salary - (salary * 0.05);
    }
    @Override    
    public double bonus(int year) {
        return year > 5 ? 12 * salary :  6 * salary;
    }
}

class ComEmployee extends Employee {
    private double grossSale;
    private double ComRate;
    public ComEmployee(String firstname, String lastname, String id, double sales, double percent) {
        super(firstname, lastname, id);
        this.grossSale = sales;
        this.ComRate = percent;
    }
    @Override
    public double bonus(int year) {
        return year > 5 ? 6 * grossSale :  3 * grossSale;
    }
    @Override
    public double earning() {
        double comisstion = grossSale*ComRate;
        return grossSale + comisstion;
    }
    
}

class House implements Cloneable, Comparable<House> {
    private int id;
    private double area;
    private java.util.Date whenBuilt;
    public House(int id, double area) {
            this.id = id;
            this.area = area;
            whenBuilt = new java.util.Date();
            }
    public int getId() {
            return id;
            }
    public double getArea() {
            return area;
            }
    public java.util.Date getWhenBuilt() {
            return whenBuilt;
            }
    @Override
    public Object clone() {
            try {
                return super.clone();
                }
            catch (CloneNotSupportedException ex) {
                return null;
                }
    }
    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(House o) {
            if (area > o.area)
                return 1;
            else if (area < o.area)
                return -1;
            else return 0;
    }
}