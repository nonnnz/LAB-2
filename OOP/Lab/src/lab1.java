
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;
 
class lab1 {
    static void i_i() {
        NumberFormat formatter = new DecimalFormat("#0.00");  
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Fahrenheit: ");
        double Fahrenheit = input.nextDouble();
        double Celsius = (5.0/9)*(Fahrenheit-32);
        
        // Display results
        System.out.println("The Celsius is " + formatter.format(Celsius) + " degrees Celsius");
        input.close();
    }

    static void i_ii() {
        NumberFormat formatter = new DecimalFormat("#0.00");  
        
        while (true) {
            String fahrenheitInput = JOptionPane.showInputDialog(null, "Enter Fahrenheit (or Cancel to exit):");
            
            // Check if user clicked "Cancel" or closed the dialog
            if (fahrenheitInput == null) {
                break; // Exit the loop if input is canceled
            }
            
            try {
                double fahrenheit = Double.parseDouble(fahrenheitInput);
                double celsius = (5.0 / 9) * (fahrenheit - 32);
                
                // Display results
                String message = "The Celsius is " + formatter.format(celsius) + " degrees Celsius";
                JOptionPane.showMessageDialog(null, message);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
    }

    static void ii() {
        Scanner input = new Scanner(System.in);
        double rate = 0.05;
        System.out.print("Enter the monthly saving amount: ");
        double saving = input.nextDouble();
        int times = 6;
        double result = 0;
        for (int i = 0; i < times; i++) {
            System.out.println(result);
            result = (saving + result) * (1 + (rate/12));
        }
        System.out.println("After the sixth month, the account value is $" + String.format("%,.2f", result));
        input.close();
    }

    static void iii() {
        Scanner input = new Scanner(System.in);
        double x1,x2,x3,y1,y2,y3,side1,side2,side3,s, area;
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        x3 = input.nextDouble();
        y3 = input.nextDouble();
        side1 = Math.sqrt(Math.pow(x1-x2, 2) +
                          Math.pow(y1-y2, 2)
        );
        side2 = Math.sqrt(Math.pow(x2-x3, 2) +
                          Math.pow(y2-y3, 2)
        );
        side3 = Math.sqrt(Math.pow(x3-x1, 2) +
                          Math.pow(y3-y1, 2)
        );
        
        s = ( side1+side2+side3 )/2;
        
        area = Math.sqrt(s*( s-side1 )*( s-side2 )*( s-side3 ));
        
        System.out.println("The area of the triangle is "+ String.format("%,.1f", area));
        input.close();
    }

    static void iv() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter balance and interest rate: ");
        double balance = input.nextDouble();
        double interest_rate = input.nextDouble();
        double interest = balance * (interest_rate / 1200);
        System.out.println("The interest is "+ String.format("%,.5f", interest));
        input.close();
    }

    static void v() {
        char x = 'a';
        char y = 'c';
        System.out.println(++x);
        System.out.println(y++);
        System.out.println(x - y);
    }

    static void vi() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input number of columns and rows: ");
        int r = in.nextInt();
        int c = in.nextInt();
        System.out.println();
        for (int j =  1; j <= r; j++) {
              if(j == 1) System.out.format("%s", " ");
              else System.out.format("%d", j);
              for (int i = 2; i <= c; i++) {
                  if(j == 1) System.out.format("%3d", i);
                  else System.out.format("%3d", i * j );
              }
              System.out.println();
        }
        in.close();
    }
    
    static void vii() {
          Scanner in = new Scanner(System.in);
          System.out.print("Please input x, n: ");
          int x = in.nextInt();
          int n = in.nextInt();
          int sum = 0;
          for(int i = 0; i <= n; i++) {
              sum += Math.pow(x, i);
          }
          System.out.println("Output is: " + sum);
          in.close();
    }
    
    static void viii() {
          Scanner in = new Scanner(System.in);
          System.out.print("Please input n, a0 and a1: ");
          int n = in.nextInt();
          int a0 = in.nextInt();
          int a1 = in.nextInt();
          System.out.println();
          System.out.print("Output is: " + a0 + " " + a1 + " ");
          for (int k = 2; k <= n; k++) {
              int ak = (int) (Math.pow(k, 2) * a1 - a0 +Math.pow(3, k));
              if(k == n)System.out.print(ak);
              else System.out.print(ak + " ");
              a0 = a1; 
              a1 = ak;
          }
          System.out.println();
          in.close();
    }
    
    static void ix() {
        Scanner in = new Scanner(System.in);
        int max = -99999;
        int n = 1;
        int count = 0;
        while(n != 0) {
            n = in.nextInt();
            if(n > max) {
                  max = n;
                  count = 1;
            } else if (n == max) {
                count++;
            }
        }
        System.out.println(max+" "+count);
        in.close();
        
    }

    public static void main(String[] args)
    {
        i_i();
        i_ii();
        ii();
        iii();
        iv();
        v();
        vi();
        vii();
        viii();
        ix();
    }
}