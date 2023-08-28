import java.util.ArrayList;
import java.util.Scanner;

class Employee{
    private String firstname;
    private String lastname;
    private String id;
    private double salary;
    int year;
        
    public Employee(String firstname,String lastname,String id, double sal){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.salary = sal;
    }
        
    public double earning() {
        return salary - (salary * 0.05);
    }
        
    public double bonus(int year) {
        return year > 5 ? 12 * salary :  6 * salary;
    }
        
    @Override
    public String toString() {
        return ""+firstname+" "+lastname+" "+earning()+" "+bonus(year);
    }
}

class Star{
    public void addStars(ArrayList<String> arr) {
        for(int i = 0; i<arr.size();i++){
            i++;
            arr.add(i,"*");
        }
    }
    
    public void removeStars(ArrayList<String> arr) {
        for(int i = 1; i<arr.size();i++){
            if(!"*".equals(arr.get(i))) break;
            arr.remove(i);
        }
    }
}

public class Lab5 {
    public static void main(String[] args) {
                // one();
                // star();
               emp();
            }
            
    public static void star() {
        String str;
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<n;i++) {
            str = sc.nextLine();
            arr.add(str);
        }
        Star sr = new Star();
        
        int c = sc.nextInt();
        while(c != 0) {
            if(c == 1) sr.addStars(arr);
            else if (c == 2) sr.removeStars(arr);
            System.out.println(arr);
            c = sc.nextInt();
        }
    }
    
    public static void one() {
        int num, max=-9999, min=9999;
        double sum =0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int n = sc.nextInt();
        for(int i = 0;i<n;i++) {
            num = sc.nextInt();
            arr.add(num);
        }
        
        // range, max, min
        for(int i = 0;i<arr.size();i++) {
            sum += arr.get(i);
            if(arr.get(i) > max) max = arr.get(i);
            if(arr.get(i) < min) min = arr.get(i);
        }
        System.out.println(sum/n);
        System.out.println(max);
        System.out.println(min);
        
        //remove even
        for(int i = 0;i<arr.size();i++) {
            if(arr.get(i)%2 == 0) {
                arr.remove(i);
                i--;
            }
        }       
        
        for(int i = 0;i<arr.size();i++) {
            System.out.print(arr.get(i)+" ");
        }
    }
    
    public static void emp() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> arrayEarn = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++) {
            String firstname = sc.nextLine();
            String lastname = sc.nextLine();
            String id = sc.nextLine();
            double salary = sc.nextDouble();
            int year = sc.nextInt();
            sc.nextLine();
            Employee obj = new Employee(firstname, lastname, id, salary);
            obj.year = year;
            arrayEarn.add(obj);
        }
        
        printEmp(arrayEarn);
    }
    
    public static void printEmp(ArrayList<Employee> arr) {
        for(int i=0;i<arr.size();i++){
            System.out.println(""+arr.get(i).toString());
        }
    }
}
