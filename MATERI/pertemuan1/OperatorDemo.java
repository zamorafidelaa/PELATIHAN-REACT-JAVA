public class OperatorDemo {
    public static void main(String[] args) {
        // Aritmatika
        int a = 10, b = 3;
        System.out.println("Aritmatika:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Penugasan
        System.out.println("\nPenugasan:");
        int c = a;
        c += b;
        System.out.println("c += b = " + c);
        c -= b;
        System.out.println("c -= b = " + c);
        c *= b;
        System.out.println("c *= b = " + c);
        c /= b;
        System.out.println("c /= b = " + c);
        c %= b;
        System.out.println("c %= b = " + c);

        // Perbandingan
        System.out.println("\nPerbandingan:");
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));

        // Logika
        System.out.println("\nLogika:");
        boolean x = true, y = false;
        System.out.println("x && y : " + (x && y));
        System.out.println("x || y : " + (x || y));
        System.out.println("!x     : " + (!x));

        // Bitwise
        System.out.println("\nBitwise:");
        int m = 5, n = 3;
        System.out.println("m & n  = " + (m & n));
        System.out.println("m | n  = " + (m | n));
        System.out.println("m ^ n  = " + (m ^ n));
        System.out.println("~m     = " + (~m));
        System.out.println("m << 1 = " + (m << 1));
        System.out.println("m >> 1 = " + (m >> 1));
        System.out.println("m >>> 1 = " + (m >>> 1));

        // Increment/Decrement
        System.out.println("\nIncrement/Decrement:");
        int z = 5;
        System.out.println("z = " + z);
        System.out.println("z++ = " + (z++)); // pakai sebelum tambah
        System.out.println("++z = " + (++z)); // tambah dulu baru pakai
        System.out.println("z-- = " + (z--));
        System.out.println("--z = " + (--z));

        // Ternary
        System.out.println("\nTernary:");
        int max = (a > b) ? a : b;
        System.out.println("Max dari a dan b adalah: " + max);

        // instanceof
        System.out.println("\nInstanceof:");
        String text = "Hello";
        System.out.println("text instanceof String: " + (text instanceof String));
    }
}