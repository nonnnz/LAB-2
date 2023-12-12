public class Lab11_1 {
    public static void main(String[] args) {
//        one_one();
        one_two();
    }

    static void one_one() {
        PrintName p1 = new PrintName("Thana");
        PrintName p2 = new PrintName("Somchai");
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        t2.start();
    }

    static void one_two() {
        PrintNameExtend p1 = new PrintNameExtend("Thana");
        PrintNameExtend p2 = new PrintNameExtend("Somchai");
        p1.run(); // priority
        p2.run();
    }
}

class PrintName implements Runnable {
    String name;
    public PrintName(String n) {
        name = n;
    }

    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(name);
        }
    }
}

class PrintNameExtend extends Thread {
    String name;
    public PrintNameExtend(String n) {
        name = n;
    }

    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(name);
        }
    }
}