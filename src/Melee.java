import java.util.List;

public class Melee extends Robot {

    public Melee(String name) {
        super(name, "Melee", 1000, 1000, 100);
    }

    // dash seperti move tapi 2 langkah
    public void dash(boolean maju) {
        if (maju) {
            setLocation(getLocation() + 2);
        } else {
            setLocation(getLocation() - 2);
        }
    }

    // cek lokasi saja ini unutk range tapi sisanya sih sama
    @Override
    public void attack(Monster monster) {
        if (getLocation() == monster.getLocation()) {
            super.attack(monster);
        } else {
            System.out.println("monster diluar jangkauan");
        }
    }
}
