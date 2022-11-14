/**
 * A Class representing a potion.
 */
public class ItemConsumablePotion extends ItemConsumable {
    private String attributeAffected;
    Printer pr = new Printer();
    public ItemConsumablePotion(String name, double price, int level, double effectAmount, String attributeAffected) {
        super(name, price, level, effectAmount, 1);
        this.attributeAffected = attributeAffected;
    }

    public String getAttributeAffected() {
        return attributeAffected;
    }

    @Override
    public void showItemInfo() {
        System.out.printf(pr.GREEN + "Name: %s\n" + pr.RESET, getName());
        System.out.printf("      Level: %s  |  Boost: %s for %s  |  Price: %s\n",
                getLevel(),
                attributeAffected,
                getEffectAmount(),
                getPrice());
    }

    public void affect(Hero currentHero, int potionIndex) {
        switch (attributeAffected) {
            case "Health":
                currentHero.setHP(currentHero.getHP()+getEffectAmount());
                break;
            case "Strength":
                currentHero.setStrength(currentHero.getStrength()+getEffectAmount());
                break;
            case "Mana":
                currentHero.setMP(currentHero.getMP()+getEffectAmount());
                break;
            case "Agility":
                currentHero.setAgility(currentHero.getAgility()+getEffectAmount());
                break;
            case "Health/Mana/Strength/Agility":
                currentHero.setHP(currentHero.getHP()+getEffectAmount());
                currentHero.setMP(currentHero.getMP()+getEffectAmount());
                currentHero.setStrength(currentHero.getStrength()+getEffectAmount());
                currentHero.setAgility(currentHero.getAgility()+getEffectAmount());
                break;
            case "All Health/Mana/Strength/Dexterity/Defense/Agility":
                currentHero.setHP(currentHero.getHP()+getEffectAmount());
                currentHero.setMP(currentHero.getMP()+getEffectAmount());
                currentHero.setStrength(currentHero.getStrength()+getEffectAmount());
                currentHero.setDexterity(currentHero.getDexterity()+getEffectAmount());
                currentHero.setDefense(currentHero.getDefense()+getEffectAmount());
                currentHero.setAgility(currentHero.getAgility()+getEffectAmount());
        }
        currentHero.getInventory().removeItem("Potions", potionIndex);
        System.out.printf(pr.GREEN + "%s" + pr.RESET + " used %s, boosted %s by %.1f!\n",
                        currentHero.getName(), getName(), getAttributeAffected(), getEffectAmount());
    }
}
