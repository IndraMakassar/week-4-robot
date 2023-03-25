public class Robot {
    private final String type;
    private final int maxHealth;
    private String name;
    private int health;
    private int power;
    private int location = 0;
    // tiapkali lakukan sesuatu kasih defend jadi false
    private boolean defend = false;

    public Robot(String name, String type, int health, int maxHealth, int power) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.maxHealth = maxHealth;
        this.power = power;
    }

    public void move(boolean maju) {
        // kalau maju tambah lokasi kalau tidak kurangi
        if (maju) {
            location += 1;
        } else {
            location -= 1;
        }
        defend = false;
    }

    public void attack(Monster monster) {
        // cek monster masih punya nyawa tida
        if (monster.getHealth() <= 0) {
            System.out.println("monster sudah mati");
        } else {
            System.out.print("nyawa monster berkurang dari " + monster.getHealth());
            monster.setHealth(monster.getHealth() - power);
            System.out.print(" menjadi " + monster.getHealth() + "\n");
            defend = false;
        }
        // kalau diserang sampai habis nyawanya monster
        if (monster.getHealth() <= 0) {
            System.out.println("monster mati");
        }
    }

    public void defend() {
        defend = true;
    }

    public void heal() {
        // kalau kurang dari maxhealth isi
        if (health < maxHealth) {
            health += health + 50;
        }
        // kalau kelebihan lansung kasih max saja
        if (health > maxHealth) {
            health = maxHealth;
        }
        defend = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean isDefend() {
        return defend;
    }

    public void setDefend(boolean defend) {
        this.defend = defend;
    }
}
