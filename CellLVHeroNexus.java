public class CellLVHeroNexus extends CellLVNexus{
    Printer pr = new Printer();

    public CellLVHeroNexus(String content) {
        super("");
        setContent(pr.BLUE_BG + content + pr.RESET);
    }
}
