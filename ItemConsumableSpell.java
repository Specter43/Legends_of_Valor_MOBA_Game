/**
 * An abstract class representing a general spell.
 */
public abstract class ItemConsumableSpell extends ItemConsumable {
    public double getManaCost() {
        return manaCost;
    }
    private double manaCost;

    public ItemConsumableSpell(String name, double price, int level, double effectAmount, int useNum, double manaCost) {
        super(name, price, level, effectAmount, useNum);
        this.manaCost = manaCost;
    }

    public abstract void cast(Hero hero, Monster monster, int spellIndex);
}
