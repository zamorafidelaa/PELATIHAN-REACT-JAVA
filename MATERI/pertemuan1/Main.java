import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final int number = 0; // variabel final

    public static void main(String[] args) throws IOException {
        // ****Method output****
        // System.out.println("Hello world");

        // ArrayList<String> listName = new ArrayList<>();
        // // sebelum di tambah
        // System.out.println("ukuran :"+listName.size());
        // listName.add("Dilan");
        // listName.add("Milea");
        // // mengambil nilai ArrayList
        // System.out.println(listName.get(0));
        // System.out.println(listName.get(1));

        // Main test = new Main();
        // System.out.println("variable : " + test.number);

        // ****Method input****
        // BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // String nama;
        // System.out.print("Masukan nama : ");
        // nama = input.readLine();
        // System.out.println("Selamat datang " + nama);

        // Scanner input = new Scanner(System.in);
        // System.out.print("Nama : ");
        // String nama = input.nextLine();
        // System.out.print("umur: ");
        // Integer umur = input.nextInt();
        // System.out.print("Selamat Datang " + nama);
        // System.out.print(" yang berumur " + umur);

        // PERCABANGAN
        int a = 10;
        // if (a % 2 == 0) {
        // System.out.println("Ini bilangan genap");
        // } else {
        // System.out.println("Ini bilangan ganjil");
        // }

        // System.out.println((a % 2 == 0) ? "ini bilangan genap" : "ini bilangan ganjil");

        // Scanner input = new Scanner(System.in);
        // String lampu;
        // System.out.print("Sekarang lampu apa : ");
        // lampu = input.nextLine();
        // switch (lampu) {
        //     case "merah":
        //         System.out.println("Berhenti!");
        //         break;
        //     case "kuning":
        //         System.out.println("Bersiap!");
        //         break;
        //     case "hijau":
        //         System.out.println("Jalan!");
        //         break;
        //     default:
        //         System.out.println("Inputan salah");
        // }

        String[] name = { "Dimas", "Wahyu", "Anggi", "Rey" };
        for (String n : name) {
            System.out.println(n);
        }
    }
}
