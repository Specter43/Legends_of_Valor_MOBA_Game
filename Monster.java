import java.util.Random;

/**
 * An abstract class representing a general monster.
 */
public abstract class Monster extends Role implements Attack<Hero> {
    Printer pr = new Printer();
    
    public Monster(String name, int level, double HP, double strength, double defense, double agility) {
        super(name, level, HP, strength, defense, agility);
    }

    public void showMonsterStatus() {
        System.out.printf(pr.RED + "Name: %s\n" + pr.RESET, getName());
        System.out.printf("      Level: %s  |  Health: %.1f  |  Strength: %.1f  |  defense: %.1f  |  Agility: %.1f\n",
                getLevel(),
                getHP(),
                getStrength(),
                getDefense(),
                getAgility());
    }

    @Override
    public void attack(Hero hero) {
        double heroDodge = hero.getAgility()*0.002;
        Random rand = new Random();
        if (rand.nextInt(100) <= heroDodge) {
            System.out.print("Attack missed!");
        } else {
            double damage = getStrength() - hero.getDefense()*0.5;
            if (damage < 0) {
                damage = 0;
            }
            hero.setHP(hero.getHP() - damage);
            System.out.printf(pr.RED + "%s" + pr.RESET + " attacked " + pr.GREEN + "%s" + pr.RESET + " for %.1f damage!\n", getName(), hero.getName(), damage);
            if (hero.getHP() <= 0) {
                System.out.printf(pr.GREEN + "%s" + pr.RESET + " has fainted!\n", hero.getName());
            }
        }
    }
}
