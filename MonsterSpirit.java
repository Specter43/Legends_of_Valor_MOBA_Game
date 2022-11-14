/**
 * A Class representing a spirit.
 */
public class MonsterSpirit extends Monster {
    private double agilityBonus;
    public MonsterSpirit(String name, int level, double HP, double strength, double defence, double agility) {
        super(name, level, HP, strength, defence, agility);
        this.agilityBonus = 1.15;
        setAgility(getAgility()*agilityBonus);
    }
}
