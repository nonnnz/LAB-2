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

class SortMergeList{
    public static ArrayList<Integer> intersect(ArrayList<Integer> lst1, ArrayList<Integer> lst2) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < lst1.size() && j < lst2.size()) {
            int num1 = lst1.get(i);
            int num2 = lst2.get(j);
            
            if (num1 == num2) {
                result.add(num1);
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }
        
        return result;        
    }
}

public class Lab5 {
    public static void main(String[] args) {
        // one();
        // star();
        // emp();
        sortMergeList();
        KIB();
        consecutiveFour();
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

    public static void sortMergeList() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();

        int ele = sc.nextInt();
        while(ele != 0) {
            lst1.add(ele);
            ele = sc.nextInt();
        }

        ele = sc.nextInt();
        while(ele != 0) {
            lst2.add(ele);
            ele = sc.nextInt();
        }

        ArrayList<Integer> result = SortMergeList.intersect(lst1, lst2);
        for(int i =0; i<result.size();i++) System.out.print(result.get(i)+" ");
    }

    public static void KIB() {
        Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[][] population = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                population[i][j] = sc.nextInt();
            }
        }
        
        int maxPopulation = 0;
        
        for (int i = 0; i <= M - K; i++) {
            for (int j = 0; j <= N - K; j++) {
                int areaPopulation = 0;
                
                for (int x = i; x < i + K; x++) {
                    for (int y = j; y < j + K; y++) {
                        areaPopulation += population[x][y];
                    }
                }
                
                if (areaPopulation > maxPopulation) {
                    maxPopulation = areaPopulation;
                }
            }
        }
        
        System.out.println(maxPopulation);
    }

    public static void consecutiveFour() {
        Scanner sc = new Scanner(System.in);
        
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        int[][] values = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                values[i][j] = sc.nextInt();
            }
        }
        
        if(isConsecutiveFour(values)) System.out.print(1);
        else System.out.print(0);
        
        sc.close();
    }
    
    public static boolean isConsecutiveFour(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;
        
        // Check horizontally
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (values[i][j] == values[i][j + 1] && 
                    values[i][j] == values[i][j + 2] && 
                    values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }
        
        // Check vertically
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols; j++) {
                if (values[i][j] == values[i + 1][j] && 
                    values[i][j] == values[i + 2][j] && 
                    values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }
        
        // Check diagonally (top-left to bottom-right)
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (values[i][j] == values[i + 1][j + 1] && 
                    values[i][j] == values[i + 2][j + 2] && 
                    values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }
        
        // Check diagonally (bottom-left to top-right)
        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (values[i][j] == values[i - 1][j + 1] && 
                    values[i][j] == values[i - 2][j + 2] && 
                    values[i][j] == values[i - 3][j + 3]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}