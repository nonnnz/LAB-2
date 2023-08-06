class Complex {
    private double r, i;
    
    Complex(double r, double i) {
        this.r = r; this.i = i;
    }
    
    Complex(Complex c) {
        this(c.r, c.i);
    }

    public void add(Complex c) {
        r += c.r;
        i += c.i;
    }

    public void print() {
        System.out.println(r + "+ i" + i);
    }
}    


public class ComplexTest {
    
}
