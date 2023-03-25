import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Robot> robots = new ArrayList<>();
        List<Monster> monsters = new ArrayList<>();
        CentralBrain centralBrain = new CentralBrain("otak");

        robots.add(new Melee("Robot 1"));
        robots.add(new Melee("Robot 2"));
        robots.add(new Ranged("Robot 3"));
        robots.add(new Support("Robot 4"));
        robots.add(new Melee("Robot 5"));

        monsters.add(new Monster());
        monsters.add(new Monster());
        monsters.add(new Monster());

        // print lokasi awal
        System.out.println(robots.get(0).getLocation());
        // maju 1 langka
        robots.get(0).move(true);
        System.out.println(robots.get(0).getLocation());

        // maju 2 langkah
        if (robots.get(0) instanceof Melee) {
            ((Melee) robots.get(0)).dash(true);
        }
        System.out.println(robots.get(0).getLocation());

        System.out.println();

        // coba attack monster di luar jangkauan
        System.out.println("lokasi monster " + monsters.get(0).getLocation());
        if (robots.get(0) instanceof Melee) {
            System.out.println("lokasi robot " + robots.get(0).getLocation());
        robots.get(0).attack(monsters.get(0));
        }

        System.out.println();

        // coba attack monster di dalam jangkauan ini juga pakai melee
        System.out.println("lokasi monster " + monsters.get(0).getLocation());
        if (robots.get(1) instanceof Melee) {
            System.out.println("lokasi robot " + robots.get(0).getLocation());
            robots.get(1).attack(monsters.get(0));
        }

        System.out.println();

        // ini coba attack pakai range
        if (robots.get(2) instanceof Ranged) {
            robots.get(2).move(true);
            System.out.println("lokasi robot " + robots.get(0).getLocation());
            robots.get(2).attack(monsters.get(0));
        }

        System.out.println();

        // tes combine
        centralBrain.combine(robots.get(0));
        centralBrain.combine(robots.get(1));
        centralBrain.combine(robots.get(2));
        centralBrain.getRobots();

        System.out.println("\nattack robot besar");
        centralBrain.attack(monsters.get(0));

        System.out.println("\ncoba setelah detach");

        centralBrain.separate(robots.get(0));
        centralBrain.separate(robots.get(1));
        centralBrain.getRobots();

        System.out.println();

        // coba attack pakai monster mati
        monsters.get(0).attack(robots.get(1));

        // attack biasa
        monsters.get(1).attack(robots.get(1));

        // heal robot
        robots.get(1).heal();
        System.out.println(robots.get(1).getHealth());

    }
}