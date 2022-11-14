/**
 * Main Class
 */
public class Main {
    /**
     * Host games
     */
    public static void gameStart() throws InterruptedException {
        MainMenu mainMenu = new MainMenu();

        // Game Selection
        String currentGame = mainMenu.selectGame();

        // Teams Initiation
        Team<?> team = mainMenu.selectTeamMembers(currentGame);

        // Create and initialize selected game
        Game game = mainMenu.createGame(currentGame, team);

        // Playing game
        while (!game.isGameOver()) {
            String operation = game.gamePrompt();
        }

        // Game End Messages
        mainMenu.announceGameEnd(currentGame);
    }

    public static void main(String[] args) throws InterruptedException {
        gameStart();
    }
}
