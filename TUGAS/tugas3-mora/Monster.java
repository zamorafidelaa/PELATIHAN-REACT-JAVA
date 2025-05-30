public abstract class Monster {
    protected String nama;
    protected int kesehatan;
    protected int kekuatan;

    public Monster(String nama, int kesehatan, int kekuatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
        this.kekuatan = kekuatan;
    }

    public abstract void tampilkanInfo();

    public void terimaSerangan(int damage) {
        kesehatan -= damage;
        if (kesehatan < 0) kesehatan = 0;
    }

    public boolean masihHidup() {
        return kesehatan > 0;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }
}
