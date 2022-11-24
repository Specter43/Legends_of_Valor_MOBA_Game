public class CellLVKoulou extends CellLV {
    private double strengthBonus;
    Printer pr = new Printer();

    public CellLVKoulou(Object content) {
        super("");
        setContent(pr.BLUE + content + pr.RESET);
        strengthBonus = 0.15;
    }
}
