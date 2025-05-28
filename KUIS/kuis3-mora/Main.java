import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n== Menu CRUD Mahasiswa ==");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Daftar Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    static void tambahMahasiswa() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Umur: ");
        int umur = scanner.nextInt();
        scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();

        Mahasiswa mhs = new Mahasiswa();
        mhs.setNama(nama);
        mhs.setUmur(umur);
        mhs.setNim(nim);
        daftarMahasiswa.add(mhs);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    static void tampilkanMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            daftarMahasiswa.get(i).displayInfo();
        }
    }

    static void updateMahasiswa() {
        tampilkanMahasiswa();
        if (daftarMahasiswa.isEmpty()) return;

        System.out.print("Pilih nomor mahasiswa yang akan diupdate: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= daftarMahasiswa.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        Mahasiswa mhs = daftarMahasiswa.get(index);
        System.out.print("Nama baru: ");
        mhs.setNama(scanner.nextLine());
        System.out.print("Umur baru: ");
        mhs.setUmur(scanner.nextInt());
        scanner.nextLine();
        System.out.print("NIM baru: ");
        mhs.setNim(scanner.nextLine());

        System.out.println("Data mahasiswa berhasil diupdate.");
    }

    static void hapusMahasiswa() {
        tampilkanMahasiswa();
        if (daftarMahasiswa.isEmpty()) return;

        System.out.print("Pilih nomor mahasiswa yang akan dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= daftarMahasiswa.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        daftarMahasiswa.remove(index);
        System.out.println("Data mahasiswa berhasil dihapus.");
    }
}
