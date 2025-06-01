public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7, "Merah");
        circle.draw();
        System.out.println("Luas lingkaran: " + circle.area());
        System.out.println("Luas lingkaran dari diameter 14: " + circle.area(14));

        System.out.println();

        Square square = new Square(5, "Biru");
        square.draw();
        System.out.println("Luas persegi: " + square.area());
        System.out.println("Luas persegi panjang 5x6: " + square.area(5, 6));
    }
}
