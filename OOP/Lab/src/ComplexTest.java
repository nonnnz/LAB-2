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

    public void sub(Complex c) {
        r -= c.r;
        i -= c.i;
    }

    public void mul(Complex c) {
        double r = this.r * c.r - this.i * c.i;
        double i = this.r * c.i - this.i * c.r;
        this.r = r;
        this.i = i;
    }

    public void div(Complex c) {
        double r = (this.r * c.r - this.i * c.i) / (Math.pow(c.r, 2) + Math.pow(c.i, 2));
        double i = (this.i * c.r - this.r * c.i) / (Math.pow(c.r, 2) + Math.pow(c.i, 2));
        this.r = r;
        this.i = i;
    }

    public void setR(double r) {
        this.r = r;
    }
    
    public void setI(double i) {
        this.i = i;
    }



    public void print() {
        System.out.println(r + "+ i" + i);
    }
}    

public class ComplexTest {
    public static void main(String args[]) {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);
        Complex c = new Complex(a);
        c.add(b);
        c.print();

        c.setR(1);
        c.setI(2);
        c.sub(b);
        c.print();

        c.setR(1);
        c.setI(2);
        c.mul(b);
        c.print();

        c.setR(1);
        c.setI(2);
        c.div(b);
        c.print();
    }
}
