import java.util.*;

/**
 * A Class representing a Team.
 */
public class Team<T> {
    private int teamSize;
    private String teamName;
    private List<T> teamMembers;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public List<T> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<T> teamMembers) {
        this.teamMembers = teamMembers;
    }

}