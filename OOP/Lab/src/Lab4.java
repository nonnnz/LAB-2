import java.util.Scanner;

class AscendSortFreq {
    double[] A;
    AscendSortFreq() {}
    AscendSortFreq(double[] arr) {
        A = new double[arr.length];
        for(int i = 0;i<A.length;i++)
            this.A[i] = arr[i];
    }
    
    public double[] AscendSort(double[] A) {
        double[] B = new double[A.length];
        for(int i = 0;i<B.length;i++)
            B[i] = A[i];        
        //sorting
        double temp;
        for(int i = 0; i < B.length - 1;i++) {
            for(int j = 0; j < B.length - i - 1; j++) {
//                if(B[j] == B[j+1]) B[j+1] = 0;
                if(B[j] > B[j+1]) {
                    temp = B[j];
                    B[j] = B[j+1];
                    B[j+1] = temp;
                }
            }
        }
        return B;
    }
    
    public int[] SortCommuFreq(double[] B) {
        int[] C = new int[B.length];
        //cal
        boolean[] visited = new boolean[B.length];
        int j=0,k=0;
        for(int i = 0; i<B.length; i++) {
            if(visited[i] == true) continue;
            // count freq
            int count = 1;
            for(j = i + 1; j < B.length; j++) {
                if(B[i] == B[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            C[k] = count;
            k++;
        }
        return C;
    }
    
}

class MatrixMultiplication {
    
    int[][] a;
    int[][] b;
    int[][] c;
    
    MatrixMultiplication(int[][] a, int[][] b) {
        this.a = a;
        this.b = b;
        this.c = new int[a.length][b[0].length];
    }
    
    boolean check() {
        return (a[0].length == b.length);
    }
    
    public void cal() {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < b.length; k++) {
                    this.c[i][j] += a[i][k]*b[k][j];
                }
                    
        display();
    }
    
    public void display() {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++)
                System.out.print(c[i][j]+" ");
            System.out.println();
        }
    }
}

public class Lab4 {
    public static void MatrixMultiplication() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][l];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < l; j++)
                a[i][j] = sc.nextInt();
        
        int l2 = sc.nextInt();
        int m = sc.nextInt();
        int[][] b = new int[l2][m];
        for (int i = 0; i < l2; i++)
            for (int j = 0; j < m; j++)
                b[i][j] = sc.nextInt();
        
        MatrixMultiplication mm = new MatrixMultiplication(a, b);
        if(mm.check())mm.cal();

    }
    
    public static int findMinIdx(int[] a) {
        int k, minIdx=0;
        for(k=1;k<a.length;k++){
            if(a[k]<a[minIdx])
            {
            minIdx=k;
            }
        }
        return minIdx;
    }
    
    public static int findMaxIdx(int[] a) {
        int k, maxIdx=0;
        for(k=1;k<a.length;k++){
            if(a[k]>a[maxIdx])
            {
            maxIdx=k;
            }
        }
        return maxIdx;
    }
    
    public static void MinMax() {
        int a[] ={-128, 65, -235, 99, 0, 26};
        int minIndex= findMinIdx(a);
        int maxIndex= findMaxIdx(a);
        System.out.println("min value is a["+minIndex+"]="+a[minIndex]);
        System.out.println("max value is a["+maxIndex+"]="+a[maxIndex]);        
    }
    
    public static void AscendSortFreq() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        for(int i = 0; i<a.length;i++) a[i] = sc.nextDouble();
        
//        double[] a = {9,5,9,5,8};
        AscendSortFreq obj = new AscendSortFreq(a);
        double[] b = obj.AscendSort(a);
        for(int i = 0; i<b.length;i++) {
            if(i < b.length -1) {
                if(b[i] != b[i+1])
                    System.out.print(b[i]+" ");
            } else System.out.print(b[i]);
            
        }
        System.out.println();
        int[] c = obj.SortCommuFreq(b);
        for(int i = 0; i<c.length;i++) {
            if(c[i] != 0)
                System.out.print(c[i]+" ");
        }
        
            
    }
    public static void main(String[] args) {
       
        // MinMax();
        // AscendSortFreq();
        // MatrixMultiplication();
        // FindNearestPoints();
        minTwoSet();
        // findPokemon();
        // consecutiveFour();
    }

    public static void FindNearestPoints(){
        Scanner input = new Scanner(System.in);
        int numberOfPoints = input.nextInt();
    
        // Create an array to store points
        double[][] points = new double[numberOfPoints][2];
        for (int i = 0; i < points.length; i++) {
          points[i][0] = input.nextDouble();
          points[i][1] = input.nextDouble();
        }
    
        // p1 and p2 are the indices in the points array
        int p1 = 0, p2 = 1; // Initial two points
        double shortestDistance = distance(points[p1][0], points[p1][1], 
          points[p2][0], points[p2][1]); // Initialize shortestDistance
        
        // Compute distance for every two points
        for (int i = 0; i < points.length; i++) {
          for (int j = i + 1; j < points.length; j++) {
            double distance = distance(points[i][0], points[i][1],
              points[j][0], points[j][1]); // Find distance
    
            if (shortestDistance > distance) {
              p1 = i; // Update p1
              p2 = j; // Update p2
              shortestDistance = distance; // Update shortestDistance 
            }
          }
        }
    
        // Display result
        System.out.format("%.2f", distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]));
    }

    public static double distance(
        double x1, double y1, double x2, double y2) {
      return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static void minTwoSet(){}

    public static void findPokemon(){}

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