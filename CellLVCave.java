public class CellLVCave extends CellLV {
    private double agilityBonus;
    Printer pr = new Printer();

    public CellLVCave(Object content) {
        super("");
        setContent(pr.YELLOW + content + pr.RESET);
        agilityBonus = 0.15;
    }
}
