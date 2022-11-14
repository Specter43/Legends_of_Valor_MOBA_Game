import java.util.ArrayList;
import java.util.List;

/**
 * A Class representing a queue for turn based battle game.
 *
 */
public class BattleQueue {
    private ArrayList<List<Role>> battleQueue;
    private ArrayList<String> battleTeamNameQueue;
    private int teamSize;
    private ArrayList<Role> tempTeamMember;

    public BattleQueue(TeamHero teamHero, TeamMonster teamMonster) {
        this.battleQueue = new ArrayList<>();
        List<Role> copyTeamHero = new ArrayList<>(teamHero.getTeamMembers());
        List<Role> copyTeamMonster = new ArrayList<>(teamMonster.getTeamMembers());
        this.battleQueue.add(copyTeamHero);
        this.battleQueue.add(copyTeamMonster);
        this.battleTeamNameQueue = new ArrayList<>();
        this.battleTeamNameQueue.add("Heroes");
        this.battleTeamNameQueue.add("Monsters");
        this.teamSize = teamHero.getTeamSize();
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
