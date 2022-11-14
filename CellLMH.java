/**
 * A Class representing a cell in Legends: Monsters and Heroes game.
 */
public class CellLMH extends Cell {
    private boolean isObstacle;
    private boolean isMarket;
    private boolean isMonster;

    public CellLMH(Object content) {
        super(content);
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }

    public boolean isMarket() {
        return isMarket;
    }

    public void setMarket(boolean market) {
        isMarket = market;
    }

    public boolean isMonster() {
        return isMonster;
    }

    public void setMonster(boolean monster) {
        isMonster = monster;
    }
}
