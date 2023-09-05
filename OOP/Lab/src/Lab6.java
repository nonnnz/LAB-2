abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    /** Default constructor */
    protected GeometricObject() {
    }
    /** Convenience constructor */
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double findArea();
    public abstract double findPerimeter();
}

class Circle extends GeometricObject {
    private double radius;
    /** Default constructor */
    public Circle() {
        this(1.0);
    }
    /** Radius convenience constructor */
    public Circle(double radius) {
        this(radius, "white", false);
    }
    /** Convenience constructor for all properties */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    /**
    * Return the radius
    * @return radius Current radius of Circle
    */
    public double getRadius() {
        return radius;
    }
    /**
    * Set the radius of the circle
    */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    /**
    * Returns the area of the current circle
    * Implemention of abstract method in GeometricObject
    * @return area of the circle
    */
    public double findArea() {
        return radius * radius * Math.PI;
    }
    /**
    * Returns the perimeter of the current circle
    * Implemention of abstract method in GeometricObject
    * @return perimeter of the circle
    */
    public double findPerimeter() {
        return 2 * radius * Math.PI;
    }
    /**
    * Provide a string representation of the object
    */
    public String toString() {
        return "Circle: radius = " + radius;
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    /** Default constructor */
    public Rectangle() {
        this(1.0, 1.0);
    }

    /** Convenience constructor with width and height */
    public Rectangle(double width, double height) {
        this(width, height, "white", false);
    }

    /** Convenience constructor with width, height, color, and filled */
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    /** Get the width of the rectangle */
    public double getWidth() {
        return width;
    }

    /** Set the width of the rectangle */
    public void setWidth(double width) {
        this.width = width;
    }

    /** Get the height of the rectangle */
    public double getHeight() {
        return height;
    }

    /** Set the height of the rectangle */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Calculate and return the area of the rectangle */
    public double findArea() {
        return width * height;
    }

    /** Calculate and return the perimeter of the rectangle */
    public double findPerimeter() {
        return 2 * (width + height);
    }

    /** Provide a string representation of the object */
    public String toString() {
        return "Rectangle: width = " + width + ", height = " + height;
    }
}

class MyRectangle2D extends Rectangle {
    private double x;
    private double y;

    /** Default constructor */
    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    /** Constructor with x, y, width, and height */
    public MyRectangle2D(double x, double y, double width, double height) {
        super(width, height);
        this.x = x;
        this.y = y;
    }

    /** Get the x-coordinate of the center of the rectangle */
    public double getX() {
        return x;
    }

    /** Set the x-coordinate of the center of the rectangle */
    public void setX(double x) {
        this.x = x;
    }

    /** Get the y-coordinate of the center of the rectangle */
    public double getY() {
        return y;
    }

    /** Set the y-coordinate of the center of the rectangle */
    public void setY(double y) {
        this.y = y;
    }

    /** Calculate and return the area of the rectangle */
    public double getArea() {
        return super.findArea();
    }

    /** Calculate and return the perimeter of the rectangle */
    public double getPerimeter() {
        return super.findPerimeter();
    }

    /** Check if a point (x, y) is inside the rectangle */
    public boolean contains(double x, double y) {
        double minX = this.x - (super.getWidth() / 2);
        double minY = this.y - (super.getHeight() / 2);
        double maxX = this.x + (super.getWidth() / 2);
        double maxY = this.y + (super.getHeight() / 2);

        return (x >= minX && x <= maxX) && (y >= minY && y <= maxY);
    }

    /** Check if a given rectangle is inside this rectangle */
    public boolean contains(MyRectangle2D r) {
        double minX1 = this.x - (super.getWidth() / 2);
        double minY1 = this.y - (super.getHeight() / 2);
        double maxX1 = this.x + (super.getWidth() / 2);
        double maxY1 = this.y + (super.getHeight() / 2);

        double minX2 = r.x - (r.getWidth() / 2);
        double minY2 = r.y - (r.getHeight() / 2);
        double maxX2 = r.x + (r.getWidth() / 2);
        double maxY2 = r.y + (r.getHeight() / 2);

        return (minX1 <= minX2 && maxX1 >= maxX2 && minY1 <= minY2 && maxY1 >= maxY2);
    }

    /** Check if a given rectangle overlaps with this rectangle */
    public boolean overlaps(MyRectangle2D r) {
        double minX1 = this.x - (super.getWidth() / 2);
        double minY1 = this.y - (super.getHeight() / 2);
        double maxX1 = this.x + (super.getWidth() / 2);
        double maxY1 = this.y + (super.getHeight() / 2);

        double minX2 = r.x - (r.getWidth() / 2);
        double minY2 = r.y - (r.getHeight() / 2);
        double maxX2 = r.x + (r.getWidth() / 2);
        double maxY2 = r.y + (r.getHeight() / 2);

        // Check if the rectangles do not overlap
        return !(maxX1 < minX2 || maxX2 < minX1 || maxY1 < minY2 || maxY2 < minY1);
    }
}

public class Lab6 {
    public static void main(String[] args) {

    }
}
