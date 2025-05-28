public class Mahasiswa extends Person { // --Inheritance-- Subclass Mahasiswa yang mewarisi Person
    private String jurusan; // --Enkapsulasi-- atribut jurusan dibikin private

    // --Constructor--
    public Mahasiswa(String nama, String nim, String jurusan) {
        super(nama, nim);
        this.jurusan = jurusan;
    }

    // --Polimorfisme--
    @Override
    public void display() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + id);
        System.out.println("Jurusan: " + jurusan);
    }
}
