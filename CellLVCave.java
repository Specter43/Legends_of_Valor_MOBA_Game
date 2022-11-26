public class CellLVCave extends CellLV {
    private double agilityBonus;
    Printer pr = new Printer();

    public CellLVCave(Object content) {
        super("");
        setContent(pr.YELLOW + content + pr.RESET);
        agilityBonus = 0.15;
    }

    public void buff(Hero hero) {
        hero.setAgility(hero.getAgility() * (1+agilityBonus));
    }

    public void removeBuff(Hero hero) {
        hero.setAgility(hero.getAgility() * (1.0/1.15));
    }
}
