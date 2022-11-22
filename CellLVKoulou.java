public class CellLVKoulou extends CellLV {
    Printer pr = new Printer();

    public CellLVKoulou(Object content) {
        super("");
        setContent(pr.BLUE + content + pr.RESET);
    }
}
