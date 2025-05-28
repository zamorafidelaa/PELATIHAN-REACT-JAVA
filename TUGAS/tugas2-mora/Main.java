import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // --Collection--
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Jurusan: ");
            String jurusan = scanner.nextLine();
            daftarMahasiswa.add(new Mahasiswa(nama, nim, jurusan));
        }

        // --Collection--
        HashMap<String, Dosen> daftarDosen = new HashMap<>();

        System.out.print("Masukkan jumlah dosen: ");
        int jumlahDosen = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlahDosen; i++) {
            System.out.println("Masukkan data dosen ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIP: ");
            String nip = scanner.nextLine();
            System.out.print("Bidang: ");
            String bidang = scanner.nextLine();
            daftarDosen.put(nip, new Dosen(nama, nip, bidang));
        }

        System.out.println("\n=== DATA MAHASISWA ===");
        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.display();
            System.out.println();
        }

        System.out.println("=== DATA DOSEN ===");
        for (String nip : daftarDosen.keySet()) {
            daftarDosen.get(nip).display();
            System.out.println();
        }

        scanner.close();
    }
}
