/**
 * A Class representing an exoskeleton.
 */
public class MonsterExoskeleton extends Monster {
    private double defenceBonus;
    public MonsterExoskeleton(String name, int level, double HP, double strength, double defence, double agility) {
        super(name, level, HP, strength, defence, agility);
        defenceBonus = 1.15;
        setDefense(getDefense()*defenceBonus);
    }
}
