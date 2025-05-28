public class Dosen extends Person { // --Inheritance-- Subclass Dosen yang juga mewarisi Person
    private String bidang; // --Enkapsulasi--

    // --Constructor-- 
    public Dosen(String nama, String nip, String bidang) {
        super(nama, nip);
        this.bidang = bidang;
    }

    // --Polimorfisme--
    @Override
    public void display() {
        System.out.println("Nama: " + nama);
        System.out.println("NIP: " + id);
        System.out.println("Bidang: " + bidang);
    }
}
