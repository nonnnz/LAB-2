import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoachPopulation();
        Palindrome();
        MyTriangle();
        /* Estimate */
        double i = sc.nextDouble();
        System.out.format("%.4f",Estimate(i));
        checkTriangle();
        light();
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

    public static double Estimate(double i) {
        double sum = 0;
        for(int j = 1; j <= i; j++) {
            sum +=  (Math.pow(-1, j+1) / (2*j-1));
        }
        return 4 * sum;
    }

    /* CheckTriangle */
    public static void checkTriangle() {
        Scanner sc = new Scanner(System.in);
        double x0 = sc.nextDouble();
        double y0 = sc.nextDouble();
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        boolean left = leftOfTheLine(x0, y0, x1, y1, x2, y2);
        boolean onTheSameLine = onTheSameLine(x0, y0, x1, y1, x2, y2);

        if (onTheSameLine) {
            System.out.println("0");
        } else if (left) {
            System.out.println("2");
        } else {
            System.out.println("1");
        }

    }
    
    /** Return true if point (x2, y2) is on the left side of the
    * directed line from (x0, y0) to (x1, y1) */
    public static boolean leftOfTheLine(double x0, double y0,
    double x1, double y1, double x2, double y2) {
        double result = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return result > 0;
    }
    /** Return true if point (x2, y2) is on the same
    * line from (x0, y0) to (x1, y1) */
    public static boolean onTheSameLine(double x0, double y0,
    double x1, double y1, double x2, double y2) {
        double result = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return result == 0;
    }
    /** Return true if point (x2, y2) is on the
    * line segment from (x0, y0) to (x1, y1) */
    public static boolean onTheLineSegment(double x0, double y0,
    double x1, double y1, double x2, double y2) {
        boolean onTheSameLine = onTheSameLine(x0, y0, x1, y1, x2, y2);

        if (!onTheSameLine) {
            return false;
        }

        double minX = Math.min(x0, x1);
        double maxX = Math.max(x0, x1);
        double minY = Math.min(y0, y1);
        double maxY = Math.max(y0, y1);

        return x2 >= minX && x2 <= maxX && y2 >= minY && y2 <= maxY;
    }

    /* Light */
    public static void light() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;

        int[][] spacecraft = new int[n][2];
        for(int i = 0; i < n; i++) {
            spacecraft[i][0] = sc.nextInt();
            spacecraft[i][1] = sc.nextInt();
        }

        int[] light = new int[m];
        for(int i = 0; i < m; i++) {
            light[i] = sc.nextInt();
            for(int j = 0; j < n; j++) {
                if(light[i] > spacecraft[j][0] && light[i] < spacecraft[j][1]) count++;
            }
        }

        System.out.print(count);

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
