import java.util.Scanner;

public class kuis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        double angka1, angka2, hasil = 0;

        do {
            System.out.println("\n=== KALKULATOR SEDERHANA ===");
            System.out.println("1. Tambah\n2. Kurang\n3. Kali\n4. Bagi\n5. Keluar");
            System.out.print("Pilih operasi (1-5): ");
            pilihan = scanner.nextInt();

            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Masukkan angka pertama: ");
                angka1 = scanner.nextDouble();
                System.out.print("Masukkan angka kedua: ");
                angka2 = scanner.nextDouble();

                switch (pilihan) {
                    case 1:
                        hasil = angka1 + angka2;
                        break;
                    case 2:
                        hasil = angka1 - angka2;
                        break;
                    case 3:
                        hasil = angka1 * angka2;
                        break;
                    case 4:
                        if (angka2 != 0) {
                            hasil = angka1 / angka2;
                        } else {
                            System.out.println("Tidak bisa membagi dengan nol.");
                            continue;
                        }
                        break;
                }
                System.out.println("Hasil: " + hasil);
            } else if (pilihan == 5) {
                System.out.println("Matur Nuwun!");
            } else {
                System.out.println("Pilihan Anda tidak valid.");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}
