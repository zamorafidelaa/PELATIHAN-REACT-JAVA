public class Person { // --Inheritance-- Ini superclass
    protected String nama; // --Access Modifier: protected
    protected String id; // --Access Modifier: protected

    // --Constructor-- untuk menginisialisasi atribut nama dan id
    public Person(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    // --Polimorfisme-- yang bisa dioverride oleh subclass 
    public void display() {
        System.out.println("Nama: " + nama);
        System.out.println("ID: " + id);
    }
}
