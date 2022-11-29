import java.util.Random;

/**
 * An abstract class representing a general hero.
 */
public abstract class Hero extends Role implements Attack<Monster> {
    private double MP;
    private double experience;
    private double experienceUpbound;
    private double dexterity;
    private double gold;
    private Inventory<Item> inventory;
    private HeroWeapons weapons;
    private int handsLeft;
    private HeroArmors armors;

    private int wasAt;
    Printer pr = new Printer();

    public Hero(String name, int level, double HP, double strength, double defense, double agility, double MP, double experience, double dexterity, double gold, Inventory<Item> inventory, HeroWeapons weapons, int handsLeft, HeroArmors armors) {
        super(name, level, HP, strength, defense, agility);
        this.MP = MP;
        this.experience = experience;
        this.experienceUpbound = 10;
        this.dexterity = dexterity;
        this.gold = gold;
        this.inventory = inventory;
        this.weapons = weapons;
        this.handsLeft = handsLeft;
        this.armors = armors;
    }

    public double getMP() {
        return MP;
    }
    public void setMP(double MP) {
        this.MP = MP;
    }
    public double getExperience() {
        return experience;
    }
    public void setExperience(double experience) {
        this.experience = experience;
    }
    public double getGold() {
        return gold;
    }
    public void setGold(double gold) {
        this.gold = gold;
    }
    public Inventory<Item> getInventory() {
        return inventory;
    }
    public double getDexterity() {
        return dexterity;
    }
    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }
    public HeroWeapons getWeapons() {
        return weapons;
    }
    public int getHandsLeft() {
        return handsLeft;
    }
    public void setHandsLeft(int handsLeft) {
        this.handsLeft = handsLeft;
    }
    public HeroArmors getArmors() {
        return armors;
    }
    public int getWasAt() {return wasAt;}
    public void setWasAt(int wasAt) {this.wasAt = wasAt;}

    public void levelUp() {
        if (experience >= experienceUpbound) {
            this.setLevel(this.getLevel() + 1);
            this.experienceUpbound += 10;
            this.setHP(this.getLevel() * 300);
            this.setMP(this.getMP() * 1.1);
            System.out.printf(pr.GREEN + "%s"  + pr.RESET + " has leveled up!\n", getName());
        }
    }

    public void showHeroStatus() {
        System.out.printf(pr.GREEN + "Name: %s\n" + pr.RESET, getName());
        System.out.printf("      Level: %s  |  Health: %.1f  |  Mana: %.1f  |  Strength: %.1f  |  Defense: %.1f  |  Agility: %.1f  |  Dexterity: %.1f  |  Money: %s  |  Experience: %s/%s\n",
                getLevel(),
                getHP(),
                MP,
                getStrength(),
                getDefense(),
                getAgility(),
                dexterity,
                gold,
                experience,
                experienceUpbound);
    }

    @Override
    public void attack(Monster monster) {
        double monsterDodge = monster.getAgility()*100;
        Random rand = new Random();
        if (rand.nextInt(100) <= monsterDodge) {
            System.out.print(pr.RED + "Your attack missed!\n" + pr.RESET);
        } else {
            double damage = getStrength() - monster.getDefense()*0.1;
            monster.setHP(monster.getHP() - damage);
            System.out.printf(pr.GREEN + "%s" + pr.RESET + " attacked " + pr.RED + "%s" + pr.RESET + " for %.1f damage!\n", getName(), monster.getName(), damage);
            if (monster.getHP() <= 0) {
                System.out.printf(pr.RED + "%s" + pr.RESET + " has fainted!\n", monster.getName());
            }
        }
    }
}
