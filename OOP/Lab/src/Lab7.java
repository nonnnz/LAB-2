public class Lab7 {
    public static void main(String[] args){
//        t_one();
//        t_two();
//        t_three();
//        three();
        four();
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
        System.out.println("3.1 = "+(fruit instanceof Orange)); // false
        System.out.println("3.2 = "+(fruit instanceof Apple));
        System.out.println("3.3 = "+(fruit instanceof GoldenDelicious));
        System.out.println("3.4 = "+(fruit instanceof Macintosh));
        System.out.println("3.5 = "+(orange instanceof Orange));
        System.out.println("3.6 = "+(orange instanceof Fruit));
//        System.out.println("3.7 = "+(orange instanceof Apple)); 
//        fruit.makeApple() can't
//        orange.makeApple() can't
        orange.makeOrangeJuice();
//        fruit.makeOrangeJuice();
        
    }
    
    static void four() {
        Animal x= new Tiger();
        System.out.println("1. x.news is "+ x.news);
        System.out.println("2. ((Tiger)x).news is "+ ((Tiger)x).news);
        System.out.println("3. x.smile() is "+ x.smile());
        System.out.println("4. ((Tiger)x).smile() is "+ ((Tiger)x).smile());
        System.out.println("5. x.getNews() is "+ x.getNews());
        System.out.println("6. x.getMessage() is "+ x.getMessage() );
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