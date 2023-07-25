import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Lab1_1 {
    static void console() {
        NumberFormat formatter = new DecimalFormat("#0.00");  
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Fahrenheit: ");
        double Fahrenheit = input.nextDouble();
        double Celsius = (5.0/9)*(Fahrenheit-32);
        
        // Display results
        System.out.println("The Celsius is " + formatter.format(Celsius) + " degrees Celsius");
        input.close();
    }
    static void dialogbox() {
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

    public static void main(String[] args) {
        // console();
        dialogbox();
    }
}
