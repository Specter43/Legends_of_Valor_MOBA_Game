/**
 * An abstract class representing a general role.
 */
public abstract class Role {
    private String name;
    private int level;
    private double HP;
    private double strength;
    private double defense;
    private double agility;

    public Role(String name, int level, double HP, double strength, double defense, double agility) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHP() {
        return HP;
    }
    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
    public double getDefense() {
        return defense;
    }
    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }
}
