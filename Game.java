/**
 * An abstract class representing a general game.
 */
public abstract class Game {
    private String currentGame;
    private boolean gameOver;
    public abstract void initializeGame();
    public abstract String gamePrompt();

    /**
     * Return whether a game has ended due to a move.
     *
     * @return true if ended, false otherwise
     */
    public abstract boolean gameEnd();

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
