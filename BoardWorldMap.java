import java.util.*;

/**
 * A Class representing a world map for Legends: Monsters and Heroes game.
 */

public class BoardWorldMap<T extends CellLV> extends Board implements BoardFunction {
    private T[][] board;
    private int _boardCellWidth;
    private int _boardCellHeight;
    private double obstaclePercentage;
    private double marketPercentage;
    private double monsterPercentage;

    private double bushPercentage;

    private double cavePercentage;

    private double koulouPercentage;
    private int[] heroPosition;
    private HashMap<String, Market> markets;
    private int laneWidth;
    private int inaccessibleWidth;
    private int[][] heroPositions;
    private ArrayList<int[]> monsterPositions;
    Printer pr = new Printer();

    /**
     * Create an instance of the board for board games only.
     *
     * @param h side length of a board
     */
    public BoardWorldMap(int h, int w) {
        super(h, w);
        this._boardCellHeight = 2;
        this._boardCellWidth = 4;
        this.laneWidth = 2;
        this.inaccessibleWidth = 1;
        this.bushPercentage = 0.2;
        this.cavePercentage = 0.1;
        this.koulouPercentage= 0.1;
        this.obstaclePercentage = 0.2;
        this.marketPercentage = 0.3;
        this.monsterPercentage = 0.2;
        this.heroPosition = new int[]{0, 0};
        this.heroPositions = new int[][]{{h, 0}, {h, 3}, {h, 6}};
        this.markets = new HashMap<String, Market>();
        this.board = (T[][]) new CellLV[_boardCellHeight*h+1][_boardCellWidth*w+1];
    }

    public int get_boardCellWidth() {
        return _boardCellWidth;
    }
    public int get_boardCellHeight() {
        return _boardCellHeight;
    }
    public HashMap<String, Market> getMarkets() {
        return markets;
    }
    public int[] getHeroPosition() {
        return heroPosition;
    }

    /**
     * Initialize an empty world map.
     */
    @Override
    public void initializeBoard() {
        // Initialize board shape
        for (int i = 0; i < _boardCellHeight * height + 1; i++) {
            for (int j = 0; j < _boardCellWidth * width + 1; j++) {
                if (i % _boardCellHeight == 0 && j % _boardCellWidth == 0) {
                    board[i][j] = (T) new CellLVBorder('+');
                    board[i][j].setEmpty(false);
                } else if (i % _boardCellHeight == 0) {
                    board[i][j] = (T) new CellLVBorder('-');
                    board[i][j].setEmpty(false);
                } else if (j % _boardCellWidth == 0) {
                    board[i][j] = (T) new CellLVBorder('|');
                    board[i][j].setEmpty(false);
                } else {
                    board[i][j] = (T) new CellLVPlain();
                }
            }
        }
    }

    public void initializeWorld() {
        int topRow = 1;
        int bottomRow = _boardCellHeight*getHeight()-1;
        int numCreature = 0;
        if (getWidth() % 3 == 0)
            numCreature = getWidth() / 3;
        else
            numCreature = getWidth() / 3 + 1;
        int[] heroNexusColPos = new int[numCreature * 2];
        int[] monsterNexusColPos = new int[numCreature * 2];
        int index = 0;
        // Initialize hero nexus positions and setup markets
        for (int i = 0; i < getWidth(); i+=laneWidth+1) {
            for (int j = 0; j < laneWidth; j++) {
                int x = bottomRow;
                int y = _boardCellWidth*i+_boardCellWidth*j+2;
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+1] = (T) new CellLVHeroNexus(" ");
                markets.put(x + " " + y, new Market(new int[]{x, y}));
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+2] = (T) new CellLVHeroNexus("N");
                markets.put(x + " " + y, new Market(new int[]{x, y}));
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+3] = (T) new CellLVHeroNexus(" ");
                markets.put(x + " " + y, new Market(new int[]{x, y}));
                heroNexusColPos[index] = _boardCellWidth*i+_boardCellWidth*j+1;
                index++;
            }
        }
        // Initialize monster nexus positions
        index = 0;
        for (int i = 0; i < getWidth(); i+=laneWidth+1) {
            for (int j = 0; j < laneWidth; j++) {
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+1] = (T) new CellLVMonsterNexus(" ");
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+2] = (T) new CellLVMonsterNexus("N");
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+3] = (T) new CellLVMonsterNexus(" ");
                monsterNexusColPos[index] = _boardCellWidth*i+_boardCellWidth*j+3;
                index++;
            }
        }
        // Initialize inaccessible spaces
        for (int i = laneWidth; i < getWidth(); i+=laneWidth+1) {
            for (int j = 0; j < getHeight(); j++) {
                board[_boardCellHeight*j+1][_boardCellWidth*i+1] = (T) new CellLVInaccessible(" ");
                board[_boardCellHeight*j+1][_boardCellWidth*i+1].setEmpty(false);
                board[_boardCellHeight*j+1][_boardCellWidth*i+2] = (T) new CellLVInaccessible("X");
                board[_boardCellHeight*j+1][_boardCellWidth*i+2].setEmpty(false);
                board[_boardCellHeight*j+1][_boardCellWidth*i+3] = (T) new CellLVInaccessible(" ");
            }
        }
        // Initialize hero positions (random within laneWidth range), in nexus
        Random rand = new Random();
        for (int i = 0; i < numCreature; i++) {
            int rand_pos = rand.nextInt(laneWidth);
            board[bottomRow][heroNexusColPos[rand_pos + i * 2]].setContent("H");
            heroPositions[i] = new int[]{bottomRow, heroNexusColPos[rand_pos + i * 2]};
        }

        // Initialize monster positions (random within laneWidth range), in nexus
        for (int i = 0; i < numCreature; i++) {
            int rand_pos = rand.nextInt(laneWidth);
            board[topRow][monsterNexusColPos[rand_pos + i * 2]].setContent("M");
        }

        // Initialize bush/cave/koulou (random), REASONABLE, not full, enough is the best
        int boardSideLength = getHeight();
        int boardSize = boardSideLength * boardSideLength;
        int numBush = (int) Math.floor(boardSize * bushPercentage);
        int numCave = (int) Math.floor(boardSize * cavePercentage);
        int numKoulou = (int) Math.floor(boardSize * koulouPercentage);
        int x, y;

        // Check number of available space remaining
        List<int[]> availablePositions = new ArrayList<>();
        for (int i = 1; i < height-1; i++) {
            for (int j = 0; j < width; j++) {
                if (board[_boardCellHeight * i + 1][_boardCellWidth * j + 2].isEmpty()) {
                    availablePositions.add(new int[]{_boardCellHeight*i+1, _boardCellWidth*j+2});
                }
            }
        }

        for (int i = 0; i < numBush; i++) {
            int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
            x = availablePosition[0];
            y = availablePosition[1];
            board[x][y] = (T) new CellLVBush("B");
        }

        for (int i = 0; i < numCave; i++) {
            int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
            x = availablePosition[0];
            y = availablePosition[1];
            board[x][y] = (T) new CellLVCave("C");
        }

        for (int i = 0; i < numKoulou; i++) {
            int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
            x = availablePosition[0];
            y = availablePosition[1];
            board[x][y] = (T) new CellLVKoulou("K");
        }

//        int numObstacles = (int) Math.floor(boardSize * obstaclePercentage);
//        int numMarkets = (int) Math.floor(boardSize * marketPercentage);
//        int numMonsters = (int) Math.floor(boardSize * monsterPercentage);
//
//        for (int i = 0; i < numObstacles; i++) {
//            int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
//            x = availablePosition[0];
//            y = availablePosition[1];
////            board[x][y].setContent(pr.WHITE_BG + "X" + pr.RESET);
//            //board[x][y].setEmpty(false);
//            //board[x][y].setObstacle(true);
//        }
//        for (int i = 0; i < numMarkets; i++) {
//            int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
//            x = availablePosition[0];
//            y = availablePosition[1];
////            board[x][y].setContent(pr.YELLOW + "$" + pr.RESET);
//            //markets.put(x + " " + y, new Market(new int[]{x, y}));
//            //board[x][y].setEmpty(false);
//            //board[x][y].setMarket(true);
//        }
//        for (int i = 0; i < numMonsters; i++) {
//            //int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
//           //x = availablePosition[0];
//            //y = availablePosition[1];
////            board[x][y].setContent(pr.RED_BG + "?" + pr.RESET);
//            //board[x][y].setEmpty(false);
//            //board[x][y].setMonster(true);
//        }
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < _boardCellHeight*height+1; i++) {
            for (int j = 0; j < _boardCellWidth*width+1; j++) {
                System.out.print(board[i][j].getContent());
            }
            System.out.println();
        }
    }

    public int[] calculateNextPosition(String moveDirection) {
        int[] newPos = new int[2];
        switch (moveDirection) {
            case "w":
            case "W":
                newPos = new int[]{heroPosition[0] - 1, heroPosition[1]};
                break;
            case "a":
            case "A":
                newPos = new int[]{heroPosition[0], heroPosition[1] - 1};
                break;
            case "s":
            case "S":
                newPos = new int[]{heroPosition[0] + 1, heroPosition[1]};
                break;
            case "d":
            case "D":
                newPos = new int[]{heroPosition[0], heroPosition[1] + 1};
                break;
        }
        return newPos;
    }

    public boolean heroCanMove(String moveDirection) {
        int[] newPos = calculateNextPosition(moveDirection);
        int new_x = _boardCellHeight*newPos[0]+1;
        int new_y = _boardCellWidth*newPos[1]+2;
        if (newPos[0] < 0 || newPos[0] >= height || newPos[1] < 0 || newPos[1] >= width) {
            return false;
        }
        CellLV newCell = board[new_x][new_y];
        return newCell.isEmpty() || newCell.isMarket() || newCell.isMonster();
    }

    public String heroMove(String moveDirection) {
        int[] newPos = calculateNextPosition(moveDirection);
        int new_x = _boardCellHeight*newPos[0]+1;
        int new_y = _boardCellWidth*newPos[1]+2;
        if (heroAtHeroNexus()) {
            board[_boardCellHeight* heroPosition[0]+1][_boardCellWidth* heroPosition[1]+2].setContent(pr.BLUE_BG + "N" + pr.RESET);
        } else if (heroAtMonsterNexus()) {
            board[_boardCellHeight* heroPosition[0]+1][_boardCellWidth* heroPosition[1]+2].setContent(pr.RED_BG + "N" + pr.RESET);
        } else if (heroAtBush()) {
            board[_boardCellHeight* heroPosition[0]+1][_boardCellWidth* heroPosition[1]+2].setContent(pr.GREEN + "B" + pr.RESET);
        } else if (heroAtCave()) {
            board[_boardCellHeight* heroPosition[0]+1][_boardCellWidth* heroPosition[1]+2].setContent(pr.GREEN + "C" + pr.RESET);
        } else if (heroAtKoulou()) {
            board[_boardCellHeight* heroPosition[0]+1][_boardCellWidth* heroPosition[1]+2].setContent(pr.GREEN + "K" + pr.RESET);
        } else {
            board[_boardCellHeight* heroPosition[0]+1][_boardCellWidth* heroPosition[1]+2].setContent(" ");
        }
        board[new_x][new_y].setContent(pr.GREEN +"H" + pr.RESET);
        heroPosition = newPos;
        if (board[new_x][new_y].isMonster()) {
            return "Monster";
        } else if (board[new_x][new_y].isEmpty()) {
            return "Empty";
        }
        return "Market";
    }

    public void monsterMove() {

    }

    public boolean heroAtHeroNexus() {
        return board[_boardCellHeight*heroPosition[0]+1][_boardCellWidth*heroPosition[1]+2] instanceof CellLVHeroNexus;
    }

    public boolean heroAtBush() {
        return board[_boardCellHeight*heroPosition[0]+1][_boardCellWidth*heroPosition[1]+2] instanceof CellLVBush;
    }

    public boolean heroAtCave() {
        return board[_boardCellHeight*heroPosition[0]+1][_boardCellWidth*heroPosition[1]+2] instanceof CellLVCave;
    }

    public boolean heroAtKoulou() {
        return board[_boardCellHeight*heroPosition[0]+1][_boardCellWidth*heroPosition[1]+2] instanceof CellLVKoulou;
    }

    public boolean heroAtMonsterNexus() {
        return board[_boardCellHeight*heroPosition[0]+1][_boardCellWidth*heroPosition[1]+2] instanceof CellLVMonsterNexus;
    }
}
