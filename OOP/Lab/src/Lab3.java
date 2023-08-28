import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        // RoachPopulation();
        // Palindrome();
        // MyTriangle();
    }

    public static void RoachPopulation() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        RoachPopulation obj = new RoachPopulation(num);
        int loop = sc.nextInt();
        for(int i=0; i<loop;i++) {
            obj.waitR();
            obj.spray();
        }
        System.out.println(obj.getRoaches());
    }

    public static void Palindrome(){
        Scanner sc = new Scanner(System.in);
        String s = "";
        s+=sc.nextLine();
        sc.close();
//        System.out.println(s); 
        Palindrome obj = new Palindrome(s);
        System.out.println(obj.chkPalindrome());        
    }

    public static void MyTriangle() {
        Scanner sc = new Scanner(System.in);
        double s1 = sc.nextDouble();
        double s2 = sc.nextDouble();
        double s3 = sc.nextDouble();
        MyTriangle obj = new MyTriangle(s1, s2, s3);
        
        if(obj.isValid(s1, s2, s3)) {
            System.out.println(String.format("%.2f",obj.area(s1, s2, s3)));
        }
        else System.out.println(0);
            
    }
}

class RoachPopulation {
        private int numRoach;
        RoachPopulation() {}
        RoachPopulation(int n) {
            this.numRoach = n;
        }
        
        public void waitR() {
            this.numRoach = this.numRoach * 2;
        }
        
        public void spray() {
            
            int p = (int) (this.numRoach * 0.1);
            this.numRoach = this.numRoach - p;
        }
        
        public int getRoaches() {
            return numRoach;
        }
}

class Palindrome {
    private String s;
    
    public Palindrome() {}
    public Palindrome(String s) {
        this.s = s;
    }
    
    public int chkPalindrome() {
        int chk=0;
        String replace = this.s.replaceAll("[^a-zA-Z]", "");
        // String replace = this.s.replaceAll("\\s+", "");
        System.out.println(replace); 
        int j = replace.length()-1;
        for(int i = 0; i < replace.length();i++) {
//                System.out.println(replace.charAt(i)+"="+replace.charAt(j)); 
            if(replace.charAt(i) != replace.charAt(j)) {
//                    System.out.println("imin");
                return 1;
            }
            else {
                j--;
            }
            
        }
        return chk;
    }
}

class MyTriangle {
    double side1;
    double side2;
    double side3;
    
    MyTriangle() {}
    MyTriangle(double s1, double s2, double s3) {
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }
    
    public boolean isValid(double s1, double s2, double s3) {
        return (s1+s2 > s3);
    }
    
    public double area(double s1, double s2, double s3) {
        double s = (s1 + s2 + s3) /2;
        double area = Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
        return area;
    }
}