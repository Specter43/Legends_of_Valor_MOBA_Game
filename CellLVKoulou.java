/**
 * A Class representing a koulou cell in Legends of Valor.
 */
public class CellLVKoulou extends CellLV {
    private double strengthBonus;
    Printer pr = new Printer();

    public CellLVKoulou(Object content) {
        super("");
        setContent(pr.CYAN + content + pr.RESET);
        strengthBonus = 0.15;
    }

    public void buff(Hero hero) {
        hero.setStrength(hero.getStrength() * (1+strengthBonus));
    }

    public void removeBuff(Hero hero) {
        hero.setStrength(hero.getStrength() * (1.0/(1+strengthBonus)));
    }
}
