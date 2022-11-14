import java.util.*;

/**
 * A Class representing a team of heroes.
 */
public class TeamHero extends Team<Hero> {
    private static final ArrayList<String> VALIDTEAMNUMS = new ArrayList<String>() {
        {add("1"); add("2"); add("3");}
    };
    Printer pr = new Printer();
    public TeamHero(String teamName) {
        super(teamName);
    }

    public void printHeroesStats(String className, HashMap<String, List<String>> data) {
        System.out.println("\n                                                              " + pr.BLUE + className + pr.RESET);
        for (int i = 0; i < data.get("Name").size(); i++) {
            System.out.printf(pr.GREEN + "(%s) Name: %s\n" + pr.RESET, i, data.get("Name").get(i));
            System.out.printf("      Level: 1  |  Health: %s  |  Mana: %s  |  Strength: %s  |  Agility: %s  |  Dexterity: %s  |  Money: %s  |  Experience: %s\n",
                    300,
                    data.get("mana").get(i),
                    data.get("strength").get(i),
                    data.get("agility").get(i),
                    data.get("dexterity").get(i),
                    data.get("starting money").get(i),
                    data.get("starting experience").get(i));
        }
    }

    public void initializeTeamHeroes() {
        // Read Files
        LMHFileReader fileReader = new LMHFileReader();
        HashMap<String, List<String>> warriors = fileReader.readFile("Legends_Monsters_and_Heroes/Warriors.txt");
        HashMap<String, List<String>> sorcerers = fileReader.readFile("Legends_Monsters_and_Heroes/Sorcerers.txt");
        HashMap<String, List<String>> paladins = fileReader.readFile("Legends_Monsters_and_Heroes/Paladins.txt");
        
        // Prompt for initializing team members
        Scanner in = new Scanner(System.in);
        System.out.printf(pr.BLUE + "How many heroes will we be having today? Please enter %s~%s: " + pr.RESET, VALIDTEAMNUMS.get(0), VALIDTEAMNUMS.get(VALIDTEAMNUMS.size()-1));
        String teamSizeLine = in.nextLine();
        while (!VALIDTEAMNUMS.contains(teamSizeLine)) {
            System.out.printf("That did not look like a valid number. Please enter %s~%s: ", VALIDTEAMNUMS.get(0), VALIDTEAMNUMS.get(VALIDTEAMNUMS.size()-1));
            teamSizeLine = in.nextLine();
        }
        
        // Prompt Hero choices
        printHeroesStats("WARRIORS", warriors);
        printHeroesStats("SORCERERS", sorcerers);
        printHeroesStats("PALADINS", paladins);
        System.out.printf(pr.BLUE + "\nRecruit %s Heroes and Assemble your squad!\n" + pr.RESET, teamSizeLine);
        
        // Select Hero into Team
        List<Hero> teamMembers = new ArrayList<>();
        while (teamMembers.size() < Integer.parseInt(teamSizeLine)) {
            System.out.print("Select the class of Heroes you want to recruit, please type W/S/P: ");
            HashMap<String, List<String>> classHeroes = null;
            String classLine = in.nextLine();
            Hero hero = null;
            while (!classLine.equals("W") && !classLine.equals("S") && !classLine.equals("P")) {
                System.out.print("That did not look like a valid choice, please re-enter W/S/P: ");
                classLine = in.nextLine();
            }
            switch (classLine) {
                case "W":
                    classHeroes = warriors;
                    break;
                case "S":
                    classHeroes = sorcerers;
                    break;
                case "P":
                    classHeroes = paladins;
                    break;
            }
            System.out.printf("Now select the hero you want to recruit, please type their corresponding index 0~%d: ", classHeroes.get("Name").size()-1);
            int heroLine;
            while (true) {
                try {
                    heroLine = Integer.parseInt(in.nextLine());
                    if (heroLine < 0 || heroLine > classHeroes.get("Name").size()-1) {
                        System.out.printf("No such hero exist, please re-enter 0~%d: ", classHeroes.get("Name").size()-1);
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.printf("That did not look like a number, please re-enter 0~%d: ", classHeroes.get("Name").size()-1);
                }
            }
            // Add new Hero into team
            switch (classLine) {
                case "W":
                    hero = new HeroWarrior(
                            classHeroes.get("Name").get(heroLine),
                            1, 300.0,
                            Double.parseDouble(classHeroes.get("strength").get(heroLine)),
                            0,
                            Double.parseDouble(classHeroes.get("agility").get(heroLine)),
                            Double.parseDouble(classHeroes.get("mana").get(heroLine)),
                            Double.parseDouble(classHeroes.get("starting experience").get(heroLine)),
                            Double.parseDouble(classHeroes.get("dexterity").get(heroLine)),
                            Double.parseDouble(classHeroes.get("starting money").get(heroLine)),
                            new Inventory<>(), new HeroWeapons(), 2, new HeroArmors());
                    break;
                case "S":
                    hero = new HeroSorcerer(
                            classHeroes.get("Name").get(heroLine),
                            1, 300.0,
                            Double.parseDouble(classHeroes.get("strength").get(heroLine)),
                            0,
                            Double.parseDouble(classHeroes.get("agility").get(heroLine)),
                            Double.parseDouble(classHeroes.get("mana").get(heroLine)),
                            Double.parseDouble(classHeroes.get("starting experience").get(heroLine)),
                            Double.parseDouble(classHeroes.get("dexterity").get(heroLine)),
                            Double.parseDouble(classHeroes.get("starting money").get(heroLine)),
                            new Inventory<>(), new HeroWeapons(), 2, new HeroArmors());
                    break;
                case "P":
                    hero = new HeroPaladin(
                            classHeroes.get("Name").get(heroLine),
                            1, 300.0,
                            Double.parseDouble(classHeroes.get("strength").get(heroLine)),
                            0,
                            Double.parseDouble(classHeroes.get("agility").get(heroLine)),
                            Double.parseDouble(classHeroes.get("mana").get(heroLine)),
                            Double.parseDouble(classHeroes.get("starting experience").get(heroLine)),
                            Double.parseDouble(classHeroes.get("dexterity").get(heroLine)),
                            Double.parseDouble(classHeroes.get("starting money").get(heroLine)),
                            new Inventory<>(), new HeroWeapons(), 2, new HeroArmors());
                    break;
            }
            System.out.printf(pr.GREEN + "%s" + pr.RESET + " has joined the team!\n", classHeroes.get("Name").get(heroLine));
            teamMembers.add(hero);
        }
        this.setTeamMembers(teamMembers);
        this.setTeamSize(teamMembers.size());
    }

    public void showTeamStatus() {
        System.out.println(pr.GREEN + "                                 CURRENT HERO TEAM STATUS" + pr.RESET);
        for (Hero hero : getTeamMembers()) {
            hero.showHeroStatus();
        }
    }

    public int highestLevel() {
        int highest = 0;
        for (Hero hero : getTeamMembers()) {
            if (hero.getLevel() > highest) {
                highest = hero.getLevel();
            }
        }
        return highest;
    }

    public boolean allHeroesFainted() {
        int c = 0;
        for (Hero hero : getTeamMembers()) {
            if (hero.getHP() <= 0) {
                c++;
            }
        }
        return c == this.getTeamSize();
    }
}
