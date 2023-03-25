public class Ranged extends Robot {
    public Ranged(String name) {
        super(name, "Ranged", 500, 500, 200);
    }

    // buat monster tidak bisa buat apa apa di 1 turn
    public void distract(Monster monster) {
        monster.setStun(true);
    }

    // cek lokasi saja ini unutk range tapi sisanya sih sama
    @Override
    public void attack(Monster monster) {
        if ((monster.getLocation() - getLocation()) < 2) {
            super.attack(monster);
        }
    }
}
