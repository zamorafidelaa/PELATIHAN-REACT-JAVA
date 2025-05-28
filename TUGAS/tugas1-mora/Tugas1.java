import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    double tugas, uts, uas, nilaiAkhir;
    char grade;
}

public class Tugas1 {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        tampilMenu();
    }

    static void tampilMenu() {
        int pilihan;

        do {
            System.out.println("\n=== MENU MANAJEMEN NILAI MAHASISWA ===");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Cari Mahasiswa (berdasarkan NIM)");
            System.out.println("4. Hapus Mahasiswa (berdasarkan NIM)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    inputData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    cariMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan Anda tidak valid.");
            }
        } while (pilihan != 5);
    }

    static void inputData() {
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            Mahasiswa mhs = new Mahasiswa();
            System.out.println("\nMahasiswa ke-" + (i + 1));
            System.out.print("Nama   : ");
            mhs.nama = input.nextLine();
            System.out.print("NIM    : ");
            mhs.nim = input.nextLine();

            do {
                System.out.print("Nilai Tugas  : ");
                mhs.tugas = input.nextDouble();
                if (mhs.tugas < 0 || mhs.tugas > 100) {
                    System.out.println("Nilai harus antara 0 sampai 100!");
                }
            } while (mhs.tugas < 0 || mhs.tugas > 100);

            do {
                System.out.print("Nilai UTS    : ");
                mhs.uts = input.nextDouble();
                if (mhs.uts < 0 || mhs.uts > 100) {
                    System.out.println("Nilai harus antara 0 sampai 100!");
                }
            } while (mhs.uts < 0 || mhs.uts > 100);

            do {
                System.out.print("Nilai UAS    : ");
                mhs.uas = input.nextDouble();
                if (mhs.uas < 0 || mhs.uas > 100) {
                    System.out.println("Nilai harus antara 0 sampai 100!");
                }
            } while (mhs.uas < 0 || mhs.uas > 100);

            input.nextLine();

            mhs.nilaiAkhir = hitungNilaiAkhir(mhs.tugas, mhs.uts, mhs.uas);
            mhs.grade = tentukanGrade(mhs.nilaiAkhir);

            daftarMahasiswa.add(mhs);
        }
    }

    static double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
    }

    static char tentukanGrade(double nilai) {
        if (nilai >= 80)
            return 'A';
        else if (nilai >= 70)
            return 'B';
        else if (nilai >= 60)
            return 'C';
        else if (nilai >= 50)
            return 'D';
        else
            return 'E';
    }

    static void tampilData() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("**Belum ada data mahasiswa.**");
            return;
        }

        System.out.println("\n=== DATA MAHASISWA ===");
        int i = 1;
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.println("Mahasiswa ke-" + i++);
            System.out.println("Nama         : " + mhs.nama);
            System.out.println("NIM          : " + mhs.nim);
            System.out.println("Nilai Akhir  : " + mhs.nilaiAkhir);
            System.out.println("Grade        : " + mhs.grade);
            System.out.println("-----------------------------");
        }
    }

    static void cariMahasiswa() {
        System.out.print("Masukkan NIM yang dicari: ");
        String cariNim = input.nextLine();

        boolean ditemukan = false;
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.nim.equalsIgnoreCase(cariNim)) {
                System.out.println("=== DATA DITEMUKAN ===");
                System.out.println("Nama         : " + mhs.nama);
                System.out.println("NIM          : " + mhs.nim);
                System.out.println("Nilai Akhir  : " + mhs.nilaiAkhir);
                System.out.println("Grade        : " + mhs.grade);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Data mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    static void hapusMahasiswa() {
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        String nimHapus = input.nextLine();

        boolean dihapus = false;
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).nim.equalsIgnoreCase(nimHapus)) {
                daftarMahasiswa.remove(i);
                System.out.println("Data mahasiswa berhasil dihapus.");
                dihapus = true;
                break;
            }
        }

        if (!dihapus) {
            System.out.println("Data dengan NIM tersebut tidak ditemukan.");
        }
    }
}
