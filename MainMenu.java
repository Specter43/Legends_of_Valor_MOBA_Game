import java.util.Scanner;
import static java.lang.System.exit;

/**
 * A Class representing the main menu of a game.
 */
public class MainMenu {
    Printer pr = new Printer();
    /**
     * Prompt for ongoing session asking players about which game do they want to play
     *
     * @return A game instance of their selected game
     */
    public String selectGame() {
        Scanner in = new Scanner(System.in);
        System.out.print("Good Day! Which game are we playing today? Type " + pr.BLUE + "1 for Legends of Valor" + pr.RESET + " or EXIT to exit game:  ");
        String gameSelection = in.nextLine();
        while (!gameSelection.equals("1") &&
               !gameSelection.equals("EXIT")) {
            System.out.print("That did not look like a valid choice. Please type 1/EXIT: ");
            gameSelection = in.nextLine();
        }
        String currentGame = null;
        if (gameSelection.equals("1")) {
            currentGame = "Legends of Valor";
        } else {
            exit(0);
        }
        System.out.println("Welcome to " + pr.BLUE + currentGame + "!" + pr.RESET);
        return currentGame;
    }

    public Team<?> selectTeamMembers(String currentGame) {
        switch (currentGame) {
            case "Legends of Valor":
                TeamHero team = new TeamHero("Heroes");
                team.initializeTeamHeroes();
                return team;
        }
        return null;
    }

    public Game createGame(String currentGame, Team<?> team) {
        Game game = null;
        switch (currentGame) {
            case "Legends of Valor":
                game = new GameLV((TeamHero) team);
                game.initializeGame();
                break;
        }
        return game;
    }

    public void announceGameEnd() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print(pr.BLUE + "Would you like to play another game? Y/N: " + pr.RESET);
        String choice = in.nextLine();
        while (!choice.equals("Y") && !choice.equals("N")) {
            System.out.print("That did not look like a valid choice, please enter Y/N: ");
            choice = in.nextLine();
        }
        if (choice.equals("Y")) {
            Main.gameStart();
        } else {
            exit(0);
        }
    }
}
