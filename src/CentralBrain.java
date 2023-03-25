import java.util.ArrayList;
import java.util.List;

public class CentralBrain extends Robot implements CombiningRobot {

    List<Robot> robots = new ArrayList<>();
    int i = 0;

    public CentralBrain(String name) {
        super(name, "CentralBrain", 0, 10000000, 0);
    }

    // bermaidmen dan bernekeboy bersatu
    @Override
    public void combine(Robot robot) {
        if (i < 5) {
            robots.add(robot);
            robot.setLocation(getLocation());
            setHealth(getHealth() + robot.getHealth());
            setPower(getPower() + robot.getPower());
            i++;
        } else {
            System.out.println("robot besar sudah penuh");
        }
    }

    // berpisah
    @Override
    public void separate(Robot robot) {
        robots.remove(robot);
        setHealth(getHealth() - robot.getHealth());
        setPower(getPower() - robot.getPower());
        i--;
    }

    // attack tapi cuma pakai satu robot
    public void attackOther(Robot robot, Monster monster) {
        if (robots.contains(robot)) {
            monster.setHealth(monster.getHealth() - robot.getPower());
            robot.setDefend(false);
        } else {
            System.out.println("tidak berhasil");
        }
    }

    // print robot yang bersatu
    public void getRobots() {
        for (Robot robot:
             robots) {
            System.out.println(robot.getName());
        }
    }
}
