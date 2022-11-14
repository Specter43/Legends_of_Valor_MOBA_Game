/**
 * A Class representing a dragon.
 */
public class MonsterDragon extends Monster {
    private double strengthBonus;
    public MonsterDragon(String name, int level, double HP, double strength, double defence, double agility) {
        super(name, level, HP, strength, defence, agility);
        strengthBonus = 1.15;
        setStrength(getStrength()*strengthBonus);
    }
}
