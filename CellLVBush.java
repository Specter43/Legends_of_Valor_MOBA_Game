public class CellLVBush extends CellLV {
    private double dexterityBonus;
    Printer pr = new Printer();

    public CellLVBush(Object content) {
        super("");
        setContent(pr.GREEN + content + pr.RESET);
        dexterityBonus = 0.15;
    }
}
