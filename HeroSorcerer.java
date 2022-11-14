/**
 * A Class representing a Sorcerer.
 */
public class HeroSorcerer extends Hero {
    private double dexterityBonus;
    private double agilityBonus;

    public HeroSorcerer(String name, int level, double HP, double strength, double defence, double agility, double MP, double experience, double dexterity, double gold, Inventory<Item> inventory, HeroWeapons weapons, int handsLeft, HeroArmors armors) {
        super(name, level, HP, strength, defence, agility, MP, experience, dexterity, gold, inventory, weapons, handsLeft, armors);
        dexterityBonus = 1.15;
        agilityBonus = 1.15;
        setDexterity(getDexterity()*dexterityBonus);
        setAgility(getAgility()*agilityBonus);
    }
}
