/**
 * An abstract class representing a general item.
 */
public abstract class Item {
    private String name;
    private double price;
    private int level;

    public Item(String name, double price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract void showItemInfo();
}
