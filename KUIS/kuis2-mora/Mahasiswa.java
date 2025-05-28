import java.util.Scanner;


public class Mahasiswa {
        private String nama;
        private String nim;
        private double ipk;

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNama() {
            return nama;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public String getNim() {
            return nim;
        }

        public void setIpk(double ipk) {
            this.ipk = ipk;
        }
Ï
        public double getIpk() {
            return ipk;
        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa mhs = new Mahasiswa();

        System.out.println("=== Input Data Mahasiswa ===");
        System.out.print("Masukkan Nama: ");
        mhs.setNama(scanner.nextLine());

        System.out.print("Masukkan NIM: ");
        mhs.setNim(scanner.nextLine());

        System.out.print("Masukkan IPK: ");
        mhs.setIpk(scanner.nextDouble());

        System.out.println("\n=== Data Mahasiswa ===");
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("NIM: " + mhs.getNim());
        System.out.println("IPK: " + mhs.getIpk());

        scanner.close();
    }
}
