/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author student
 */

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

public class Lab8 extends JFrame {

    public static void main(String[] args) {
//        abstractDrawFunction();
        employee();

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