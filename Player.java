public class Player {
    private String name;
    private TeamHero teamHero;
    private int playerID;

    public Player(String name, TeamHero teamHero, int playerID) {
        this.name = name;
        this.teamHero = teamHero;
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamHero getTeamHero() {
        return teamHero;
    }

    public void setTeamHero(TeamHero teamHero) {
        this.teamHero = teamHero;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
}
