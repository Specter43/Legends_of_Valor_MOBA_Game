public class CellLVInaccessible extends CellLV {
    Printer pr = new Printer();

    public CellLVInaccessible(Object content) {
        super("");
        setContent(pr.WHITE_BG + content + pr.RESET);
    }
}
