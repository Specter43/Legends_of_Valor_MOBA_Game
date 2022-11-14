import java.util.*;

/**
 * A Class representing the inventory of a hero.
 *
 * @param <T> any Item class or subclass instance.
 */
public class Inventory<T extends Item> {
    private Map<String, ArrayList<T>> inventory;
    Printer pr = new Printer();
    public Inventory() {
        this.inventory = new HashMap<>();
        this.inventory.put("Weapons", new ArrayList<>());
        this.inventory.put("Armors", new ArrayList<>());
        this.inventory.put("Potions", new ArrayList<>());
        this.inventory.put("Spells", new ArrayList<>());
    }

    public void showInventory() {
        for (String itemType : inventory.keySet()) {
            System.out.println("\n                                                              " + pr.BLUE + itemType + pr.RESET);
            for (Item item : inventory.get(itemType)) {
                item.showItemInfo();
            }
        }
    }

    public void showTypeItems(String itemType) {
        System.out.println("\n                                                              " + pr.BLUE + itemType + pr.RESET);
        for (Item item : inventory.get(itemType)) {
            System.out.printf("(%d) ", inventory.get(itemType).indexOf(item));
            item.showItemInfo();
        }
    }
    public void addItem(String itemType, T item) {
        inventory.get(itemType).add(item);
    }

    public void removeItem(String itemType, int itemIndex) {
        inventory.get(itemType).remove(itemIndex);
    }

    public ArrayList<T> getTypeItems(String itemType) {
        return inventory.get(itemType);
    }
}
