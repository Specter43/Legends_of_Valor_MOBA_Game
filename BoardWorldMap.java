import java.util.*;

/**
 * A Class representing a world map for Legends: Monsters and Heroes game.
 */

public class BoardWorldMap<T extends CellLV> extends Board implements BoardFunction {
    private T[][] board;
    private final int _boardCellWidth;
    private final int _boardCellHeight;
    private final double bushPercentage;
    private final double cavePercentage;
    private final double koulouPercentage;
    private final HashMap<String, Market> markets;
    private final int laneWidth;
    private final int inaccessibleWidth;
    private int[][] heroPositions;
    private int[][] monsterPositions;
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
        this.bushPercentage = 0.05;
        this.cavePercentage = 0.05;
        this.koulouPercentage= 0.05;
        this.heroPositions = new int[][]{{h, 0}, {h, 3}, {h, 6}};
        this.monsterPositions = new int[][]{{0, 0}, {0, 3}, {0, 6}};
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
    public int[][] getHeroPositions() {
        return heroPositions;
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
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+1] = (T) new CellLVHeroNexus(" ");
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+2] = (T) new CellLVHeroNexus("N");
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+2].setEmpty(false);
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+2].setHeroNexus(true);
                markets.put(bottomRow + " " + _boardCellWidth*i+_boardCellWidth*j+2, new Market(new int[]{bottomRow, _boardCellWidth*i+_boardCellWidth*j+2}));
                board[bottomRow][_boardCellWidth*i+_boardCellWidth*j+3] = (T) new CellLVHeroNexus(" ");
                heroNexusColPos[index] = _boardCellWidth*i+_boardCellWidth*j+2;
                index++;
            }
        }
        // Initialize monster nexus positions
        index = 0;
        for (int i = 0; i < getWidth(); i+=laneWidth+1) {
            for (int j = 0; j < laneWidth; j++) {
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+1] = (T) new CellLVMonsterNexus(" ");
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+2] = (T) new CellLVMonsterNexus("N");
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+2].setEmpty(false);
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+2].setMonsterNexus(true);
                board[topRow][_boardCellWidth*i+_boardCellWidth*j+3] = (T) new CellLVMonsterNexus(" ");
                monsterNexusColPos[index] = _boardCellWidth*i+_boardCellWidth*j+2;
                index++;
            }
        }

        // Initialize inaccessible spaces
        for (int i = laneWidth; i < getWidth(); i+=laneWidth+1) {
            for (int j = 0; j < getHeight(); j++) {
                board[_boardCellHeight*j+1][_boardCellWidth*i+1] = (T) new CellLVInaccessible(" ");
                board[_boardCellHeight*j+1][_boardCellWidth*i+2] = (T) new CellLVInaccessible("X");
                board[_boardCellHeight*j+1][_boardCellWidth*i+2].setEmpty(false);
                board[_boardCellHeight*j+1][_boardCellWidth*i+3] = (T) new CellLVInaccessible(" ");
            }
        }

        // Initialize hero positions (random within laneWidth range), in nexus
        Random rand = new Random();
        for (int i = 0; i < numCreature; i++) {
            int rand_pos = rand.nextInt(laneWidth);
            board[bottomRow][heroNexusColPos[rand_pos + i * 2]].setContent(pr.BLUE_BG + pr.PURPLE + "H" + pr.RESET);
            board[bottomRow][heroNexusColPos[rand_pos + i * 2]].setHero(true);
            heroPositions[i] = new int[]{getHeight() - 1, rand_pos + i * 3};
        }

        // Initialize monster positions (random within laneWidth range), in nexus
        for (int i = 0; i < numCreature; i++) {
            int rand_pos = rand.nextInt(laneWidth);
            board[topRow][monsterNexusColPos[rand_pos + i * 2]].setContent(pr.RED_BG + "M" + pr.RESET);
            board[topRow][monsterNexusColPos[rand_pos + i * 2]].setMonster(true);
            monsterPositions[i] = new int[]{0, rand_pos + i * 3};
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
            board[x][y].setEmpty(false);
            board[x][y].setBush(true);
        }
        for (int i = 0; i < numCave; i++) {
            int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
            x = availablePosition[0];
            y = availablePosition[1];
            board[x][y] = (T) new CellLVCave("C");
            board[x][y].setEmpty(false);
            board[x][y].setCave(true);
        }
        for (int i = 0; i < numKoulou; i++) {
            int[] availablePosition = availablePositions.remove(rand.nextInt(availablePositions.size()));
            x = availablePosition[0];
            y = availablePosition[1];
            board[x][y] = (T) new CellLVKoulou("K");
            board[x][y].setEmpty(false);
            board[x][y].setKoulou(true);
        }
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

    public int[] calculateNextPosition(String moveDirection, int playerIndex) {
        int[] newPos = new int[2];
        switch (moveDirection) {
            case "w":
            case "W":
                newPos = new int[]{heroPositions[playerIndex][0] - 1, heroPositions[playerIndex][1]};
                break;
            case "a":
            case "A":
                newPos = new int[]{heroPositions[playerIndex][0], heroPositions[playerIndex][1] - 1};
                break;
            case "s":
            case "S":
                newPos = new int[]{heroPositions[playerIndex][0] + 1, heroPositions[playerIndex][1]};
                break;
            case "d":
            case "D":
                newPos = new int[]{heroPositions[playerIndex][0], heroPositions[playerIndex][1] + 1};
                break;
        }
        return newPos;
    }

    public boolean heroCanMove(String moveDirection, int heroIndex) {
        int old_x = _boardCellHeight * heroPositions[heroIndex][0] + 1;
        int old_y = _boardCellWidth * heroPositions[heroIndex][1] + 2;
        int[] newPos = calculateNextPosition(moveDirection, heroIndex);
        int new_x = _boardCellHeight*newPos[0]+1;
        int new_y = _boardCellWidth*newPos[1]+2;
        System.out.printf("old_x: %d, new_x: %d, old_y: %d, new_y: %d\n", old_x, new_x, old_y, new_y);
        // Out of bound
        if (newPos[0] < 0 || newPos[0] >= height || newPos[1] < 0 || newPos[1] >= width) {
            return false;
        }
        // Pass the monster
        if (board[old_x][old_y].isMonster() ||
            (old_y-_boardCellWidth >= 0 && board[old_x][old_y-_boardCellWidth].isMonster()) ||
            (old_y+_boardCellWidth <= _boardCellWidth*width+1 && board[old_x][old_y+_boardCellWidth].isMonster())) {
            if (new_x < old_x) {
                return false;
            }
        }
        // Into another hero's space
        if (board[new_x][new_y].getContent().equals("H")) {
            return false;
        }
        CellLV newCell = board[new_x][new_y];
        return !(newCell instanceof CellLVInaccessible);
    }


    /**
     * Assuming hero can move
     */
    public String heroMove(String moveDirection, TeamHero currentHeroTeam, int heroIndex) {
        int[] newPos = calculateNextPosition(moveDirection, heroIndex);
        int old_x = _boardCellHeight * heroPositions[heroIndex][0] + 1;
        int old_y = _boardCellWidth * heroPositions[heroIndex][1] + 2;
        int new_x = _boardCellHeight * newPos[0] + 1;
        int new_y = _boardCellWidth * newPos[1] + 2;

        // Restore old position and remove buff
        restoreOldPos(old_x, old_y);
        board[old_x][old_y].setHero(false);
        if (board[old_x][old_y].isBush()) {
            ((CellLVBush) board[old_x][old_y]).removeBuff(currentHeroTeam.getTeamMembers().get(heroIndex));
        } else if (board[old_x][old_y].isCave()) {
            ((CellLVCave) board[old_x][old_y]).removeBuff(currentHeroTeam.getTeamMembers().get(heroIndex));
        } else if (board[old_x][old_y].isKoulou()) {
            ((CellLVKoulou) board[old_x][old_y]).removeBuff(currentHeroTeam.getTeamMembers().get(heroIndex));
        }

        // Add new buff if needed
        if (board[new_x][new_y].isBush()) {
            ((CellLVBush) board[new_x][new_y]).buff(currentHeroTeam.getTeamMembers().get(heroIndex));
        } else if (board[new_x][new_y].isCave()) {
            ((CellLVCave) board[new_x][new_y]).buff(currentHeroTeam.getTeamMembers().get(heroIndex));
        } else if (board[new_x][new_y].isKoulou()) {
            ((CellLVKoulou) board[new_x][new_y]).buff(currentHeroTeam.getTeamMembers().get(heroIndex));
        }

        return processNewPos(new_x, new_y, heroIndex, newPos);
    }

    public void monsterMove(int monsterIndex) {
        int[] newPos = new int[]{monsterPositions[monsterIndex][0] + 1, monsterPositions[monsterIndex][1]};
        int old_x = _boardCellHeight * monsterPositions[monsterIndex][0] + 1;
        int old_y = _boardCellWidth * monsterPositions[monsterIndex][1] + 2;
        int new_x = _boardCellHeight * newPos[0] + 1;
        int new_y = _boardCellWidth * newPos[1] + 2;
        // Pass the hero, can't move
        if (board[old_x][old_y].isHero() ||
            (old_y-_boardCellWidth >= 0 && board[old_x][old_y-_boardCellWidth].isHero()) ||
            (old_y+_boardCellWidth <= _boardCellWidth*width+1 && board[old_x][old_y+_boardCellWidth].isHero())) {
            if (new_x > old_x) {
                return;
            }
        }
        restoreOldPos(old_x, old_y);
        board[old_x][old_y].setMonster(false);
        board[new_x][new_y].setContent(pr.RED + "M" + pr.RESET);
        monsterPositions[monsterIndex][0] = newPos[0];
        monsterPositions[monsterIndex][1] = newPos[1];
        board[new_x][new_y].setMonster(true);
    }

    // Restore old positions for heroes and monsters passing
    public void restoreOldPos(int old_x, int old_y) {
        if (board[old_x][old_y].isHeroNexus()) {
            board[old_x][old_y].setContent(pr.BLUE_BG + "N" + pr.RESET);
        } else if (board[old_x][old_y].isMonsterNexus()) {
            board[old_x][old_y].setContent(pr.RED_BG + "N" + pr.RESET);
        } else if (board[old_x][old_y].isBush()) {
            board[old_x][old_y].setContent(pr.GREEN + "B" + pr.RESET);
        } else if (board[old_x][old_y].isCave()) {
            board[old_x][old_y].setContent(pr.YELLOW + "C" + pr.RESET);
        } else if (board[old_x][old_y].isKoulou()) {
            board[old_x][old_y].setContent(pr.CYAN + "K" + pr.RESET);
        } else {
            board[old_x][old_y].setContent(" ");
        }
    }

    // Proceed to new position for heroes only
    public String processNewPos(int new_x, int new_y, int heroIndex, int[] newPos) {
        heroPositions[heroIndex][0] = newPos[0];
        heroPositions[heroIndex][1] = newPos[1];
        board[new_x][new_y].setHero(true);
        if (heroAtHeroNexus(heroIndex)) {
            board[new_x][new_y].setContent(pr.BLUE_BG + pr.PURPLE + "H" + pr.RESET);
        } else {
            board[new_x][new_y].setContent(pr.PURPLE + "H" + pr.RESET);
        }
        String cellStatus = "";
        if (board[new_x][new_y].isMonster()) {
            cellStatus += "Monster";
        }
        return cellStatus;
    }

    public void heroRecall(int heroIndex) {
        int old_x = _boardCellHeight * heroPositions[heroIndex][0] + 1;
        int old_y = _boardCellWidth * heroPositions[heroIndex][1] + 2;
        int new_x = _boardCellHeight * height - 1;
        restoreOldPos(old_x, old_y);
        board[old_x][old_y].setHero(false);
        processNewPos(new_x, old_y, heroIndex, new int[]{height-1, heroPositions[heroIndex][1]});
    }

    public boolean heroAtHeroNexus(int heroIndex) {
        return board[_boardCellHeight*heroPositions[heroIndex][0]+1][_boardCellWidth*heroPositions[heroIndex][1]+2] instanceof CellLVHeroNexus;
    }

    public boolean heroAtBush(int heroIndex) {
        return board[_boardCellHeight*heroPositions[heroIndex][0]+1][_boardCellWidth*heroPositions[heroIndex][1]+2] instanceof CellLVBush;
    }

    public boolean heroAtCave(int heroIndex) {
        return board[_boardCellHeight*heroPositions[heroIndex][0]+1][_boardCellWidth*heroPositions[heroIndex][1]+2] instanceof CellLVCave;
    }

    public boolean heroAtKoulou(int heroIndex) {
        return board[_boardCellHeight*heroPositions[heroIndex][0]+1][_boardCellWidth*heroPositions[heroIndex][1]+2] instanceof CellLVKoulou;
    }

    public boolean heroAtMonsterNexus(int heroIndex) {
        return board[_boardCellHeight*heroPositions[heroIndex][0]+1][_boardCellWidth*heroPositions[heroIndex][1]+2] instanceof CellLVMonsterNexus;
    }
}
