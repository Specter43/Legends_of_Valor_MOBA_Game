public class CellLVBush extends CellLV {
    private double dexterityBonus;
    Printer pr = new Printer();

    public CellLVBush(Object content) {
        super("");
        setContent(pr.GREEN + content + pr.RESET);
        dexterityBonus = 0.15;
    }

    public void buff(Hero hero) {
        hero.setDexterity(hero.getDexterity() * (1+dexterityBonus));
    }

    public void removeBuff(Hero hero) {
        hero.setDexterity(hero.getDexterity() * (1.0/1.15));
    }
}
