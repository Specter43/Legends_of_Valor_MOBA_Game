/**
 * An abstract class representing a general cell in a board.
 */
public abstract class Cell {
    private Object content;
    private boolean isEmpty;

    public Cell(Object content) {
        this.content = content;
        this.isEmpty = true;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
