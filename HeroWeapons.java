import java.util.ArrayList;
import java.util.List;

/**
 * A class representing the weapons a hero is wielding.
 */
public class HeroWeapons {
    private List<EquipmentWeapon> weapons;

    public HeroWeapons() {
        this.weapons = new ArrayList<EquipmentWeapon>();
    }

    public List<EquipmentWeapon> getWeapons() {
        return weapons;
    }

    public void equipWeapon(EquipmentWeapon weapon) {
        weapons.add(weapon);
    }

    public EquipmentWeapon takeOffWeapon(int weaponIndex) {
        return weapons.remove(weaponIndex);
    }
}
