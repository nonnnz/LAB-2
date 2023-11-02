import java.util.ArrayList;
import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
//        t_one();
//        t_two();
//        t_three();
//        three();
//        four();
//        five();
        six();
    }

    static void t_one() {
        Object a1 = new A(); // polymorphism
        Object a2 = new Object();
        System.out.println(a1); // dynamic binding = to string in A
        System.out.println(a2);
    }

    static void t_two() {
        Object a1 = new A();
        Object a2 = new A();
        System.out.println(a1.equals(a2));
    }

    static void t_three() {
        A a1 = new A();
        A a2 = new A();
        System.out.println(a1.equals(a2));
    }

    static void three() {
        Fruit fruit = new GoldenDelicious();
        Orange orange = new Orange();
        System.out.println("3.1 = " + (fruit instanceof Orange)); // false
        System.out.println("3.2 = " + (fruit instanceof Apple));
        System.out.println("3.3 = " + (fruit instanceof GoldenDelicious));
        System.out.println("3.4 = " + (fruit instanceof Macintosh));
        System.out.println("3.5 = " + (orange instanceof Orange));
        System.out.println("3.6 = " + (orange instanceof Fruit));
//        System.out.println("3.7 = "+(orange instanceof Apple));
//        fruit.makeApple() can't
//        orange.makeApple() can't
        orange.makeOrangeJuice();
//        fruit.makeOrangeJuice();

    }

    static void four() {
        Animal x = new Tiger();
        System.out.println("1. x.news is " + x.news);
        System.out.println("2. ((Tiger)x).news is " + ((Tiger) x).news);
        System.out.println("3. x.smile() is " + x.smile());
        System.out.println("4. ((Tiger)x).smile() is " + ((Tiger) x).smile());
        System.out.println("5. x.getNews() is " + x.getNews());
        System.out.println("6. x.getMessage() is " + x.getMessage());
    }

    static void five() {
        Employee emp = new Manager();
        emp.setId(1);
        emp.setName("Jo");
        emp.setSalary(50000.0);
        Address address = new Address();
        address.setStreet("wongsawang11");
        address.setCity("nontaburi");
        emp.setAddress(address);
        ((Manager) emp).setParkingNo("111");

        System.out.println(emp.toString());
    }

    static int xB,yB;
    static int xE,yE;
    static int wallBombC = 0;
    static int minWalk = 0;
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    static boolean isValid(int[][]maze,int x, int y)
    {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length);
    }

    static int BFS(int maze[][])
    {
        boolean [][]visited = new boolean[maze.length][maze[0].length];
        visited[xB][yB] = true;
        ArrayList <mat> k = new ArrayList<mat>();
        k.add(new mat(xB,yB,1));
        while (!k.isEmpty())
        {
            mat curr = k.get(0);

            if (curr.x == xE && curr.y == yE){
                wallBombC++;
                return curr.d;
            }
            k.remove(0);
            for (int i=0;i<4;i++)
            {
                int row = curr.x + rowNum[i];
                int col = curr.y + colNum[i];

                if (isValid(maze,row,col) && maze[row][col] == 1 && !visited[row][col])
                {
                    visited[row][col] = true;
                    k.add(new mat(row,col,curr.d+1));
                }
            }
        }
        return -1;
    }
    static void six() {
        Scanner sc = new Scanner(System.in);
        int[][] maze;
        int maze_width = sc.nextInt();
        int maze_height = sc.nextInt();
        ArrayList<mat> wn = new ArrayList<>();
        maze = new int[maze_width][maze_height];
        xB = sc.nextInt();
        yB = sc.nextInt();
        xE = sc.nextInt();
        yE = sc.nextInt();
        xB--;yB--;
        xE--;yE--;
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                maze[i][j] = sc.nextInt();
                if(maze[i][j]==0) wn.add(new mat(i,j));
            }
        }
        int[][] maze_copy = new int[maze.length][maze[0].length];

        for(mat G : wn){
            for(int i=0;i<maze_copy.length;i++){
                for(int j=0;j<maze_copy[i].length;j++){
                    maze_copy[i][j] = maze[i][j];
                }
            }
            maze_copy[G.x][G.y] = 1;
            int P = BFS(maze_copy);
            if(P!=(-1)){
                if(wallBombC ==1){
                    minWalk = P;
                }
                else{
                    if(minWalk > P) minWalk = P;
                }
            }
        }
        System.out.println(wallBombC +"\n"+ minWalk);
    }
}

class mat {
    int x;
    int y;
    int d;
    mat(int x, int y){
        this.x = x;
        this.y = y;
    }
    mat(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Address {
    private String street;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressInfo() {
        return "Street: " + street + ", City: " + city;
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Address: " + address.getAddressInfo();
    }

    @Override
    public String toString() {
        return "Employee Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Salary: " + salary + "\n" +
                "Address: " + address.getAddressInfo();
    }
}

class Manager extends Employee{
    private String parkingNo;
    private Employee employee;

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDetails() {
        String employeeDetails = (employee != null) ? employee.getDetails() : "No employee assigned";
        return "Parking No: " + parkingNo + ", Employee Info: " + employeeDetails;
    }

    @Override
    public String toString() {
        String managerDetails = "Parking No: " + parkingNo;
        managerDetails += "\n" + super.toString();

        return managerDetails;
    }
}


class Animal{
    public String news= "Animal's news";
    public String message="Animal's message";
    public static String smile(){
        return "smile from Animal";
    }
    public String getNews(){
        return news;
    }
    public String getMessage(){
        return message;
    }
}

class Tiger extends Animal{
    public String news= "Tiger's news";
    public String message="Tiger's message";
    public static String smile(){
        return "smile from Tiger";
    }
    //@overide
    public String getNews(){
        return news;
    }
}

class A {
    int x;
    // 2.1
    public String toString() {
        return "A's x is " + x;
    }
    // 2.2, 2.3
    public boolean equals(A a) {
        return this.x == a.x;
    }
}
class Fruit{

}

class Apple extends Fruit{
    public void makeApple() {}
}

class Orange extends Fruit{
    public void makeOrangeJuice() {}
}

class GoldenDelicious extends Apple {

}

class Macintosh extends Apple{

}