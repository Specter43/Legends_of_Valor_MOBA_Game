/**
 * An abstract class representing a general equipment.
 */
public abstract class Equipment extends Item {
    public Equipment(String name, double price, int level) {
        super(name, price, level);
    }

    public abstract void equip(Hero currentHero, int equipmentIndex);
}
