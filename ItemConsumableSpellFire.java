import java.util.Random;

/**
 * A Class representing a fire spell.
 */
public class ItemConsumableSpellFire extends ItemConsumableSpell {
    private double defenceReduction;
    Printer pr = new Printer();

    public ItemConsumableSpellFire(String name,
                                   double price,
                                   int level,
                                   double effectAmount,
                                   int useNum,
                                   double manaCost) {
        super(name, price, level, effectAmount, useNum, manaCost);
        this.defenceReduction = 0.15;
    }

    @Override
    public void showItemInfo() {
        System.out.printf(pr.GREEN + "Name: %s\n" + pr.RESET, getName());
        System.out.printf("      Level: %s  |  Damage: %.1f  |  Reduce defence by %s%%  |  Mana cost: %s  |  Use: %d times  |  Price: %s\n",
                getLevel(),
                getEffectAmount(),
                defenceReduction*100,
                getManaCost(),
                getUseNum(),
                getPrice());
    }

    @Override
    public void cast(Hero hero, Monster monster, int spellIndex) {
        double monsterDodge = monster.getAgility();
        Random rand = new Random();
        if (rand.nextInt(100) <= monsterDodge) {
            System.out.println(pr.RED + "Your spell missed!" + pr.RESET);
        } else {
            double damage = getEffectAmount() + (hero.getDexterity()/10000) * getEffectAmount();
            hero.setMP(hero.getMP()-getManaCost());
            monster.setHP(monster.getHP() - damage);
            monster.setDefense(monster.getDefense() * (1-defenceReduction));
            System.out.printf(pr.GREEN + "%s" + pr.RESET + " casted %s on " + pr.RED + "%s" + pr.RESET + " and dealt %.1f damage!\n", hero.getName(), getName(), monster.getName(), damage);
            if (monster.getHP() <= 0) {
                System.out.printf(pr.RED + "%s" + pr.RESET + " has fainted!\n", monster.getName());
            }
        }
        setUseNum(getUseNum()-1);
        if (getUseNum() == 0) {
            hero.getInventory().removeItem("Spells", spellIndex);
        }
    }
}
