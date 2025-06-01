public class Square extends Shape {
    private double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    public double area(double panjang, double lebar) {
        return panjang * lebar;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar persegi berwarna " + color);
    }
}
