public class Support extends Robot{
    private final int heal = 500;
    public Support(String name) {
        super(name, "Support", 1500, 1500, 50);
    }

    // heal orang lain
    public void healOther(Robot robot) {
        if (robot.getMaxHealth() > robot.getHealth()) {
            robot.setHealth(robot.getHealth() + heal);
        }
        if (robot.getMaxHealth() > robot.getHealth()) {
            robot.setHealth(robot.getMaxHealth());
        }
        setDefend(false);
    }

    // heal diri sendiri tapi tinggi ki healnya
    @Override
    public void heal() {
        if (getMaxHealth() > getHealth()) {
            setHealth(getHealth() + heal);
        }
        if (getMaxHealth() > getHealth()) {
            setHealth(getMaxHealth());
        }
        setDefend(false);
    }
}
