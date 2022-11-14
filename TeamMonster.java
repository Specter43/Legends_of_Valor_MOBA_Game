import java.util.*;
import java.util.stream.IntStream;

/**
 * A Class representing a team of monsters.
 */
public class TeamMonster extends Team<Monster> {
    Printer pr = new Printer();
    
    public TeamMonster(String teamName) {
        super(teamName);
    }

    public void initializeMonsterTeam(int level, int teamSize) {
        if (level > 10) {
            level = 10;
        }
        // Read Files
        LMHFileReader fileReader = new LMHFileReader();
        HashMap<String, List<String>> dragons = fileReader.readFile("Legends_Monsters_and_Heroes/Dragons.txt");
        HashMap<String, List<String>> spirits = fileReader.readFile("Legends_Monsters_and_Heroes/Spirits.txt");
        HashMap<String, List<String>> exoskeletons = fileReader.readFile("Legends_Monsters_and_Heroes/Exoskeletons.txt");

        int finalLevel = level;
        int[] matchingLevelDragons = IntStream.range(0, dragons.get("Name").size())
                .filter(i -> Integer.toString(finalLevel).equals(dragons.get("level").get(i)))
                .toArray();
        int[] matchingLevelSpirits = IntStream.range(0, spirits.get("Name").size())
                .filter(i -> Integer.toString(finalLevel).equals(spirits.get("level").get(i)))
                .toArray();
        int[] matchingLevelExoskeletons = IntStream.range(0, exoskeletons.get("Name").size())
                .filter(i -> Integer.toString(finalLevel).equals(exoskeletons.get("level").get(i)))
                .toArray();
        ArrayList<Monster> allOnLevelMonsters = new ArrayList<>();
        for (int i : matchingLevelDragons) {
            MonsterDragon dragon = new MonsterDragon(dragons.get("Name").get(i),
                                                     Integer.parseInt(dragons.get("level").get(i)),
                                                     Integer.parseInt(dragons.get("level").get(i))*100,
                                                     Double.parseDouble(dragons.get("damage").get(i)),
                                                     Double.parseDouble(dragons.get("defense").get(i)),
                                                     Double.parseDouble(dragons.get("dodge chance").get(i)));
            allOnLevelMonsters.add(dragon);
        }
        for (int i : matchingLevelSpirits) {
            MonsterSpirit spirit = new MonsterSpirit(spirits.get("Name").get(i),
                                                     Integer.parseInt(spirits.get("level").get(i)),
                                                 Integer.parseInt(dragons.get("level").get(i))*100,
                                                     Double.parseDouble(spirits.get("damage").get(i)),
                                                     Double.parseDouble(spirits.get("defense").get(i)),
                                                     Double.parseDouble(spirits.get("dodge chance").get(i)));
            allOnLevelMonsters.add(spirit);
        }
        for (int i : matchingLevelExoskeletons) {
            MonsterExoskeleton exoskeleton = new MonsterExoskeleton(exoskeletons.get("Name").get(i),
                                                                    Integer.parseInt(exoskeletons.get("level").get(i)),
                                                                Integer.parseInt(dragons.get("level").get(i))*100,
                                                                    Double.parseDouble(exoskeletons.get("damage").get(i)),
                                                                    Double.parseDouble(exoskeletons.get("defense").get(i)),
                                                                    Double.parseDouble(exoskeletons.get("dodge chance").get(i)));
            allOnLevelMonsters.add(exoskeleton);
        }
        // Randomly select monsters
        ArrayList<Monster> monsterTeamMembers = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<allOnLevelMonsters.size(); i++) list.add(i);
        Collections.shuffle(list);
        for (int i=0; i<teamSize; i++) monsterTeamMembers.add(allOnLevelMonsters.get(i));
        setTeamSize(teamSize);
        setTeamMembers(monsterTeamMembers);
    }

    public void showTeamStatus() {
        System.out.println(pr.RED + "                                 CURRENT MONSTER TEAM STATUS" + pr.RESET);
        for (Monster monster : getTeamMembers()) {
            monster.showMonsterStatus();
        }
    }

    public boolean allMonstersFainted() {
        int c = 0;
        for (Monster monster : getTeamMembers()) {
            if (monster.getHP() <= 0) {
                c++;
            }
        }
        return c == this.getTeamSize();
    }
}
