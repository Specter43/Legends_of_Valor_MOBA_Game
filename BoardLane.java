/**
 * A class representing a lane in a board of Legends of Valor
 */
public class BoardLane {
    private int laneWidth;
    private int h;
    private int w;
    private CellLV[][] laneCells;

    public BoardLane(int laneWidth, int h, int w) {
        this.laneWidth = laneWidth;
        this.h = h;
        this.w = w;
    }

    public void initializeLane() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                laneCells[i][j].setContent(" ");
            }
        }
    }

    public int getLaneWidth() {
        return laneWidth;
    }

    public void setLaneWidth(int laneWidth) {
        this.laneWidth = laneWidth;
    }
}
