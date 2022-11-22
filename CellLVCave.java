public class CellLVCave extends CellLV {
    Printer pr = new Printer();

    public CellLVCave(Object content) {
        super("");
        setContent(pr.YELLOW + content + pr.RESET);
    }
}
