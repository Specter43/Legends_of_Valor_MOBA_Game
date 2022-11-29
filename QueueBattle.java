import java.util.ArrayList;
import java.util.List;

/**
 * A Class representing a queue for turn based battle game.
 *
 */
public class QueueBattle extends Queue {
    private ArrayList<List<Role>> battleQueue;
    private ArrayList<String> battleTeamNameQueue;
    private int teamSize;
    private ArrayList<Role> tempTeamMember;

    public QueueBattle(TeamHero teamHero, TeamMonster teamMonster, int heroIndex) {
        this.battleQueue = new ArrayList<>();
        List<Role> copyTeamHero = new ArrayList(){{add(teamHero.getTeamMembers().get(heroIndex));}};
        List<Role> copyTeamMonster = new ArrayList<>(teamMonster.getTeamMembers());
        this.battleQueue.add(copyTeamHero);
        this.battleQueue.add(copyTeamMonster);
        this.battleTeamNameQueue = new ArrayList<>();
        this.battleTeamNameQueue.add("Heroes");
        this.battleTeamNameQueue.add("Monsters");
        this.teamSize = copyTeamHero.size();
        this.tempTeamMember = new ArrayList<>();
    }

    public ArrayList<Object> nextTurn() {
        List<Role> currentTeam = battleQueue.get(0);
        String currentTeamName = battleTeamNameQueue.get(0);
        Role currentRole = currentTeam.remove(0);
        tempTeamMember.add(currentRole);

        if (teamSize == tempTeamMember.size()) {
            battleQueue.remove(0);
            battleTeamNameQueue.remove(0);
            battleQueue.add(tempTeamMember);
            tempTeamMember = new ArrayList<>();
            battleTeamNameQueue.add(currentTeamName);
        }
        ArrayList<Object> ret = new ArrayList<>();
        if (currentTeamName.equals("Heroes")) {
            ret.add("Hero");
        } else {
            ret.add("Monster");
        }
        ret.add(currentRole);
        return ret;
    }
}
