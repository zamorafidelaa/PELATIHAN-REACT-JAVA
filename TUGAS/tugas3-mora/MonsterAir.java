public class MonsterAir extends Monster implements BisaBertarung, BisaMenyembuhkan {
    public MonsterAir(String nama, int kesehatan, int kekuatan) {
        super(nama, kesehatan, kekuatan);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[AIR]     " + nama + " | HP: " + kesehatan + " | ATK: " + kekuatan);
    }

    @Override
    public void serang(Monster target) {
        System.out.println(nama + " menyerang " + target.getNama());
        target.terimaSerangan(kekuatan);
    }

    @Override
    public void serang(Monster target, String jurus) {
        System.out.println("💧 " + nama + " menggunakan jurus " + jurus + " ke " + target.getNama());
        int damage = kekuatan + 5;
        target.terimaSerangan(damage);
    }

    @Override
    public void sembuhkan() {
        System.out.println(nama + " menyembuhkan diri. +20 HP");
        this.kesehatan += 20;
    }
}
