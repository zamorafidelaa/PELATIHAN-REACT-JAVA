public class MonsterApi extends Monster implements BisaBertarung {
    public MonsterApi(String nama, int kesehatan, int kekuatan) {
        super(nama, kesehatan, kekuatan);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[API]     " + nama + " | HP: " + kesehatan + " | ATK: " + kekuatan);
    }

    @Override
    public void serang(Monster target) {
        System.out.println(nama + " menyerang " + target.getNama());
        target.terimaSerangan(kekuatan);
    }

    @Override
    public void serang(Monster target, String jurus) {
        System.out.println("🔥 " + nama + " menggunakan jurus " + jurus + " ke " + target.getNama());
        int damage = kekuatan + 10;
        target.terimaSerangan(damage);
    }
}
