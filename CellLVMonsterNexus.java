/**
 * A Class representing a monster nexus cell in Legends of Valor.
 */
public class CellLVMonsterNexus extends CellLVNexus {
    Printer pr = new Printer();

    public CellLVMonsterNexus(String content) {
        super("");
        setContent(pr.RED_BG + content + pr.RESET);
    }
}
