import java.util.Scanner;

/**
 * A Class representing an equipment weapon.
 */
public class EquipmentWeapon extends Equipment {
    private double damageValue;
    private int handValue;

    private int range;
    Printer pr = new Printer();

    public EquipmentWeapon(String name, double price, int level, double damageValue, int handValue, int range) {
        super(name, price, level);
        this.damageValue = damageValue;
        this.handValue = handValue;
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    @Override
    public void showItemInfo() {
        System.out.printf(pr.GREEN + "Name: %s\n" + pr.RESET, getName());
        System.out.printf("      Level: %s  |  Damage: %s  |  Require: %s hands   |  Range: %s  |  Price: %s\n",
                getLevel(),
                damageValue,
                handValue,
                range,
                getPrice());
    }

    @Override
    public void equip(Hero currentHero, int weaponIndex) {
        Scanner in = new Scanner(System.in);
        if (currentHero.getHandsLeft() >= this.handValue) {
            currentHero.getWeapons().equipWeapon(this);
            currentHero.getInventory().removeItem("Weapons", weaponIndex);
            currentHero.setStrength(currentHero.getStrength()+damageValue);
            currentHero.setHandsLeft(currentHero.getHandsLeft()-this.handValue);
        } else {
            while (currentHero.getHandsLeft() < this.handValue) {
                StringBuilder equippedWeapons = new StringBuilder();
                for (int i = 0; i < currentHero.getWeapons().getWeapons().size(); i++) {
                    EquipmentWeapon weapon = currentHero.getWeapons().getWeapons().get(i);
                    equippedWeapons.append("(").append(i).append(") ").append(weapon.getName()).append(" ");
                }
                System.out.println("You can't equip this weapon because you hands are too full!");
                System.out.print("Select one equipped weapon to take off " + equippedWeapons + ": ");
                String takeOffWeaponIndexLine = in.nextLine();
                try {
                    int takeOffWeaponIndex = Integer.parseInt(takeOffWeaponIndexLine);
                    EquipmentWeapon weaponTakenOff = currentHero.getWeapons().takeOffWeapon(takeOffWeaponIndex);
                    currentHero.getInventory().addItem("Weapons", weaponTakenOff);
                    currentHero.setStrength(currentHero.getStrength()-weaponTakenOff.damageValue);
                    currentHero.setHandsLeft(currentHero.getHandsLeft()+weaponTakenOff.handValue);
                } catch (Exception e) {
                    System.out.print("This did not look like a valid choice, please enter weapon's index: ");
                    takeOffWeaponIndexLine = in.nextLine();
                }
            }
            currentHero.getWeapons().equipWeapon(this);
            currentHero.getInventory().removeItem("Weapons", weaponIndex);
            currentHero.setStrength(currentHero.getStrength()+damageValue);
            currentHero.setHandsLeft(currentHero.getHandsLeft()-this.handValue);
        }
    }
}
