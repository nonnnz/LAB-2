public class Test {
    public static void main(String[] args){
        int[] list= {1,9,3,7,2};
        list=dosomething(list);
    }

    public static int[] dosomething(int[] input){
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
            if(input[j] <input[j-1]){
                temp = input[j];
                input[j] = input[j-1];
                input[j-1] = temp;
                }
            }
            System.out.print(i+": ");
           for(int k=0;k < input.length;k++){
            System.out.print(input[k]+" ");
            }
            System.out.println();
        }
        for(int i=0;i < input.length;i++){
            System.out.print(input[i]+" ");
        }
            return input;
    }
    

    public void m(){}
    public static void x(){}

    public static void metd() {
        B objB = new B();
        A objA = new A();
        objB.var1 = 5;
        objB.var2 = 5;
        System.out.println("var1(before)="+objB.var1);
        System.out.println("var2(before)="+objB.var2);
        objA.methodA(objB);
        System.out.println("var1(after)="+objB.var1);
        System.out.println("var2(after)="+objB.var2);
        x();
        T t1 = new T(4d);
    }
}

class B {
    int var1, var2;
}

class A {
    int x = 10, y = 10;
    void methodA (B objB) {
    objB.var1 = x;
    objB.var2 = y;
}
}

class T {
    static int i = 0;
    int j = 0;
    T() {
        i++;
        j = 1;
    }

    T(double k) {

    }
}