import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Monster> monsterArena = new ArrayList<>();

        MonsterApi api = new MonsterApi("Agni", 100, 20);
        MonsterAir air = new MonsterAir("Aqua", 120, 15);
        MonsterListrik listrik = new MonsterListrik("Volt", 90, 25);

        monsterArena.add(api);
        monsterArena.add(air);
        monsterArena.add(listrik);

        System.out.println("======== DAFTAR MONSTER ========");
        for (int i = 0; i < monsterArena.size(); i++) {
            System.out.print((i + 1) + ". ");
            monsterArena.get(i).tampilkanInfo();
        }

        System.out.println("\n================ PERTARUNGAN ================");
        System.out.print("Pilih monster penyerang (1-3): ");
        int penyerangIndex = scanner.nextInt() - 1;

        System.out.print("Pilih target serangan (1-3): ");
        int targetIndex = scanner.nextInt() - 1;

        Monster penyerang = monsterArena.get(penyerangIndex);
        Monster target = monsterArena.get(targetIndex);

        if (penyerang instanceof BisaBertarung) {
            System.out.print("Gunakan jurus? (ya/tidak): ");
            String pakaiJurus = scanner.next();

            if (pakaiJurus.equalsIgnoreCase("ya")) {
                System.out.print("Masukkan nama jurus: ");
                scanner.nextLine(); 
                String jurus = scanner.nextLine();
                ((BisaBertarung) penyerang).serang(target, jurus);
            } else {
                ((BisaBertarung) penyerang).serang(target);
            }
        }

        System.out.print("Ingin menyembuhkan monster? (ya/tidak): ");
        String sembuh = scanner.next();
        if (sembuh.equalsIgnoreCase("ya")) {
            System.out.print("Pilih monster untuk disembuhkan (1-3): ");
            int healIndex = scanner.nextInt() - 1;
            Monster m = monsterArena.get(healIndex);
            if (m instanceof BisaMenyembuhkan) {
                ((BisaMenyembuhkan) m).sembuhkan();
            } else {
                System.out.println(m.getNama() + " tidak bisa menyembuhkan!");
            }
        }

        System.out.println("\n======== STATUS AKHIR ========");
        for (Monster m : monsterArena) {
            System.out.println(
                    m.getNama() + " | HP: " + m.getKesehatan() + " | Status: " + (m.masihHidup() ? "Hidup" : "Kalah"));
        }
        scanner.close();
    }
}
