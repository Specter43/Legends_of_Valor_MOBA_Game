/**
 * A Class representing a player of Legends of Valor.
 */
public class GameLVPlayer {
    private String playerName;
    private TeamHero teamHero;

    public GameLVPlayer(String playerName, TeamHero teamHero) {
        this.playerName = playerName;
        this.teamHero = teamHero;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public TeamHero getTeamHero() {
        return teamHero;
    }

    public void setTeamHero(TeamHero teamHero) {
        this.teamHero = teamHero;
    }
}
