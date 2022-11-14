/**
 * A Class representing an equipment armor.
 */
public class EquipmentArmor extends Equipment {
    private double damageReduction;
    Printer pr = new Printer();

    public EquipmentArmor(String name, double price, int level, double damageReduction) {
        super(name, price, level);
        this.damageReduction = damageReduction;
    }

    @Override
    public void showItemInfo() {
        System.out.printf(pr.GREEN + "Name: %s\n" + pr.RESET, getName());
        System.out.printf("      Level: %s  |  Defence: %s  |  Price: %s\n",
                getLevel(),
                damageReduction,
                getPrice());
    }

    @Override
    public void equip(Hero currentHero, int armorIndex) {
        currentHero.getArmors().equipArmor(this);
        currentHero.getInventory().removeItem("Armors", armorIndex);
        currentHero.setDefense(currentHero.getDefense()+this.damageReduction);
    }
}
