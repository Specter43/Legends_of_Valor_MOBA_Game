public class CellLVBush extends CellLV {
    Printer pr = new Printer();

    public CellLVBush(Object content) {
        super("");
        setContent(pr.GREEN + content + pr.RESET);
    }
}
