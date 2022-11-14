import java.util.ArrayList;
import java.util.List;

/**
 * A class representing the armors a hero is wearing.
 */
public class HeroArmors {
    private List<EquipmentArmor> armors;

    public HeroArmors() {
        this.armors = new ArrayList<EquipmentArmor>();
    }

    public void equipArmor(EquipmentArmor armor) {
        armors.add(armor);
    }
}
