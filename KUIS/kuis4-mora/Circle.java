public class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    public double area(double diameter) {
        double r = diameter / 2;
        return Math.PI * r * r;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar lingkaran berwarna " + color);
    }
}
