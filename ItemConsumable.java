/**
 * An abstract class representing a general consumable item.
 */
public abstract class ItemConsumable extends Item {
    private double effectAmount;
    private int useNum;

    public ItemConsumable(String name, double price, int level, double effectAmount, int useNum) {
        super(name, price, level);
        this.effectAmount = effectAmount;
        this.useNum = useNum;
    }

    public double getEffectAmount() {
        return effectAmount;
    }

    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }
}
