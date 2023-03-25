public class Monster {
    int health = 500;
    int power = 50;
    boolean stun;
    int location = 0;

    public void attack(Robot robot) {
        // cek masih hidup tidak ini monster
        if (health >= 0) {
            // cek lokasi sama tidak
            if (robot.getLocation() == location) {
                // kalau terstun langkahi
                if (stun) {
                    stun = false;
                    System.out.println("monster sedang terstun");
                    return;
                    // kalau tidak di stun attack musuh
                } else {
                    System.out.print("\nnyawa robot dari " + robot.getHealth());
                    // kalau robot defend
                    if (robot.isDefend()) {
                        robot.setHealth(robot.getHealth() - (power / 2));
                    } else {
                        robot.setHealth(robot.getHealth() - power);
                    }
                    System.out.print(" berkurang menjadi " + robot.getHealth() + "\n");
                }
            }
        } else{

            System.out.println("monster sudah mati");}
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
