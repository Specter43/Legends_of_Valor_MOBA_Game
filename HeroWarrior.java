/**
 * A Class representing a Warrior.
 */
public class HeroWarrior extends Hero {
    private double strengthBonus;
    private double agilityBonus;

    public HeroWarrior(String name, int level, double HP, double strength, double defence, double agility, double MP, double experience, double dexterity, double gold, Inventory<Item> inventory, HeroWeapons weapons, int handsLeft, HeroArmors armors) {
        super(name, level, HP, strength, defence, agility, MP, experience, dexterity, gold, inventory, weapons, 2, armors);
        strengthBonus = 1.15;
        agilityBonus = 1.15;
        setStrength(getStrength()*strengthBonus);
        setAgility(getAgility()*agilityBonus);
    }
}
