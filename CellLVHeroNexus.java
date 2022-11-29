/**
 * A Class representing a hero nexus cell in Legends of Valor.
 */
public class CellLVHeroNexus extends CellLVNexus{
    Printer pr = new Printer();

    public CellLVHeroNexus(String content) {
        super("");
        setContent(pr.BLUE_BG + content + pr.RESET);
    }
}
