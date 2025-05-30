public class MonsterListrik extends Monster implements BisaBertarung {
    public MonsterListrik(String nama, int kesehatan, int kekuatan) {
        super(nama, kesehatan, kekuatan);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[LISTRIK] " + nama + " | HP: " + kesehatan + "  | ATK: " + kekuatan);
    }

    @Override
    public void serang(Monster target) {
        System.out.println(nama + " menyerang " + target.getNama());
        target.terimaSerangan(kekuatan);
    }

    @Override
    public void serang(Monster target, String jurus) {
        int damage = kekuatan + 10;
        System.out.println("⚡ " + nama + " menyerang " + target.getNama() + " dengan jurus " + jurus + "!");
        System.out.println("🔥 " + target.getNama() + " terkena " + damage + " damage!");
        target.terimaSerangan(damage);
    }
}
