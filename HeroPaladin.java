/**
 * A Class representing a Paladin.
 */
public class HeroPaladin extends Hero {
    private double strengthBonus;
    private double dexterityBonus;

    public HeroPaladin(String name, int level, double HP, double strength, double defence, double agility, double MP, double experience, double dexterity, double gold, Inventory<Item> inventory, HeroWeapons weapons, int handsLeft, HeroArmors armors) {
        super(name, level, HP, strength, defence, agility, MP, experience, dexterity, gold, inventory, weapons, handsLeft, armors);
        strengthBonus = 1.15;
        dexterityBonus = 1.15;
        setStrength(getStrength()*strengthBonus);
        setDexterity(getDexterity()*dexterityBonus);
    }
}
