import java.util.*;

/**
 * A Class representing a board.
 */
public abstract class Board {
    public int boardId;
    public int height;
    public int width;

    /**
     * Create an instance of the board for board games only.
     *
     * @param h Height of a board
     * @param w Width of a board
     */
    public Board(int h, int w) {
        Random rand = new Random();
        boardId = rand.nextInt(1000);
        height = h;
        width = w;
    }

    public int getHeight() {
        return height;
    }
}
