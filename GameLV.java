import java.util.*;
import static java.lang.System.exit;

/**
 * A Class representing an instance of a Legends: Monsters and Heroes game.
 */
public class GameLV extends BattleTurnBasedGame {
    private static final HashMap<String, ArrayList<String>> GAMEINPUTMAPPING = new HashMap<String, ArrayList<String>>() {{
        put("move", new ArrayList<String>(){{add("w"); add("W"); add("a"); add("A"); add("s"); add("S"); add("d"); add("D");}});
        put("utility", new ArrayList<String>(){{add("q"); add("Q"); add("i"); add("I"); add("m"); add("M");}});
    }};
    Printer pr = new Printer();

    private BoardWorldMap currentWorldMap;
    private TeamHero currentHeroTeam;
    private BattleQueue currentBattleQueue;
    private double encounterBattleChance;

    public GameLV(TeamHero currentHeroTeam) {
        this.currentWorldMap = new BoardWorldMap(8, 8);
        this.currentHeroTeam = currentHeroTeam;
        this.encounterBattleChance = 0.2;
    }

    @Override
    public void initializeGame() {
        Scanner in = new Scanner(System.in);
        this.currentWorldMap.initializeBoard();
        this.currentWorldMap.initializeWorld();
        this.currentWorldMap.printBoard();
        System.out.println(pr.BLUE + "Welcome to this new world full of opportunity, danger, and of course, FUN! ENJOY!" + pr.RESET);
        System.out.println(pr.GREEN +"H" + pr.RESET + " : This represents your team and they will be starting at the ? North West Corner.");
        System.out.println(pr.WHITE_BG +"X" + pr.RESET + " : This represents terrains of the world that have seen no one crossing them over the eons.");
        System.out.println(pr.YELLOW +"$" + pr.RESET + " : This represents markets spread across the world, they trade supplies and loots.");
        System.out.println(pr.RED_BG +"?" + pr.RESET + " : This represents an known monster group, your team HAS TO battle once encountered.");
        System.out.println(pr.GREEN +"''" + pr.RESET + ": This represents an unknown place, your team MAY encounter a battle once stepped in.");
        System.out.print("Do you think this is a reasonable world to play? Enter N to regenerate a world, Y to adventure: ");
        String confirmLine = in.nextLine();
        while (!confirmLine.equals("Y") && !confirmLine.equals("N")) {
            System.out.print("That did not look like a valid choice, please re-enter Y/N: ");
            confirmLine = in.nextLine();
        }
        if (confirmLine.equals("Y")) {
            LMHFileReader fileReader = new LMHFileReader();
            HashMap<String, List<String>> allWeapons = fileReader.readFile("Legends_Monsters_and_Heroes/Weaponry.txt");
            HashMap<String, List<String>> allArmors = fileReader.readFile("Legends_Monsters_and_Heroes/Armory.txt");
            HashMap<String, List<String>> allPotions = fileReader.readFile("Legends_Monsters_and_Heroes/Potions.txt");
            HashMap<String, List<String>> allFireSpells = fileReader.readFile("Legends_Monsters_and_Heroes/FireSpells.txt");
            HashMap<String, List<String>> allIceSpells = fileReader.readFile("Legends_Monsters_and_Heroes/IceSpells.txt");
            HashMap<String, List<String>> allLightningSpells = fileReader.readFile("Legends_Monsters_and_Heroes/LightningSpells.txt");
//            for (String pos : currentWorldMap.getMarkets().keySet()) {
//                currentWorldMap.getMarkets().get(pos).initializeMarket(allWeapons, allArmors, allPotions, allFireSpells, allIceSpells, allLightningSpells);
//            }
            System.out.println("RULE: The game only ends when all of your team faint. Stay Alive!");
        } else {
            initializeGame();
        }
    }

    @Override
    public String gamePrompt() {
        Scanner in = new Scanner(System.in);
        currentWorldMap.printBoard();
        if (currentWorldMap.heroAtHeroNexus()) {
            System.out.print("Move around with W/A/S/D keys, Q to quit, I for hero status, " + pr.YELLOW + "M for market: " + pr.RESET);
        } else {
            System.out.print("Move around with W/A/S/D keys, Q to quit, I for hero status: ");
        }
        String moveLine = in.nextLine();
        while (!GAMEINPUTMAPPING.get("move").contains(moveLine) &&
               !GAMEINPUTMAPPING.get("utility").contains(moveLine)) {
            if (currentWorldMap.heroAtHeroNexus()) {
                System.out.print("That did not look like a valid choice, please enter W/A/S/D/Q/I/M: ");
            } else {
                System.out.print("That did not look like a valid choice, please enter W/A/S/D/Q/I: ");
            }
            moveLine = in.nextLine();
        }

        // Move
        if (GAMEINPUTMAPPING.get("move").contains(moveLine)) {
            boolean canMove = currentWorldMap.heroCanMove(moveLine);

            // Can't move logic
            while (!canMove) {
                System.out.println(pr.RED + "YOU SHALL NOT PASS!"  + pr.RESET);
                if (currentWorldMap.heroAtHeroNexus()) {
                    System.out.print("Move around with W/A/S/D keys, Q to quit, I for hero status, M for market: ");
                } else {
                    System.out.print("Move around with W/A/S/D keys, Q to quit, I for hero status: ");
                }
                moveLine = in.nextLine();
                canMove = currentWorldMap.heroCanMove(moveLine);
            }

            // Move logic
            String moveTo = currentWorldMap.heroMove(moveLine);
            boolean encounterBattle = false;
            if (moveTo.equals("Monster")) {
                encounterBattle = true;
            } else if (moveTo.equals("Empty")) {
                Random rand = new Random();
                if (rand.nextInt(100) < encounterBattleChance*100) {
                    encounterBattle = true;
                }
            }
            if (encounterBattle) {
                battlePrompt();
            }
        }

        // Utility
        else if (GAMEINPUTMAPPING.get("utility").contains(moveLine)) {
            // Quit game
            if (moveLine.equals("q") || moveLine.equals("Q")) {
                exit(0);
            }

            // Heroes Info
            else if (moveLine.equals("i") || moveLine.equals("I")) {
                currentHeroTeam.showTeamStatus();
            }

            // Market
            else if (moveLine.equals("m") || moveLine.equals("M")) {
                String marketKey = Integer.toString(currentWorldMap.get_boardCellHeight()*currentWorldMap.getHeroPosition()[0]+1) + " " +
                                   Integer.toString(currentWorldMap.get_boardCellWidth()*currentWorldMap.getHeroPosition()[1]+2);
//                currentWorldMap.getMarkets().get(marketKey).marketPrompt(currentHeroTeam);
            }
        }
        return null;
    }

    public void battlePrompt() {
        Scanner in = new Scanner(System.in);
        // Initialize monster team and show status
        System.out.println(pr.CYAN + "Your team encounters a team of monsters, let the battle commence!\n" + pr.RESET);
        currentHeroTeam.showTeamStatus();
        System.out.println();
        TeamMonster teamMonster = new TeamMonster("Monsters");
        teamMonster.initializeMonsterTeam(currentHeroTeam.highestLevel(), currentHeroTeam.getTeamSize());
        teamMonster.showTeamStatus();
        System.out.println();

        // Initialize Battle Queue
        BattleQueue battleQueue = new BattleQueue(currentHeroTeam, teamMonster);
        this.currentBattleQueue = battleQueue;

        // Battle takes turns
        while (!currentHeroTeam.allHeroesFainted() && !teamMonster.allMonstersFainted()) {
            ArrayList<Object> currentRole = battleQueue.nextTurn();
            if (currentRole.get(0).equals("Hero")) {
                Hero currentHero = (Hero) currentRole.get(1);
                if (currentHero.getHP() > 0) {
                    System.out.printf("\nIt's " + pr.GREEN + "%s"  + pr.RESET + "'s turn!\n", currentHero.getName());
                    currentHeroTeam.showTeamStatus();
                    teamMonster.showTeamStatus();
                    while (true) {
                        System.out.println("You may choose one of the following actions to perform:");
                        System.out.print("1. Attack  |  2. Cast a spell  |  3. Use a potion  |  4. Equip an equipment: ");
                        String battleActionLine = in.nextLine();
                        while (!battleActionLine.equals("1") && !battleActionLine.equals("2") &&
                               !battleActionLine.equals("3") && !battleActionLine.equals("4")) {
                            System.out.print("That did not look like a valid move, please re-enter 1/2/3/4: ");
                            battleActionLine = in.nextLine();
                        }
                        StringBuilder monsterTeamMembers = new StringBuilder();
                        for (Monster monster : teamMonster.getTeamMembers()) {
                            if (monster.getHP() > 0) {
                                monsterTeamMembers.append("(").append(teamMonster.getTeamMembers().indexOf(monster)).append(")").append(" ").append(monster.getName()).append(", ");
                            }
                        }

                        // Attack
                        if (battleActionLine.equals("1")) {
                            while (true) {
                                System.out.print("Which enemy do you want to attack? " + pr.RED + monsterTeamMembers + pr.RESET + ": ");
                                String monsterToAttackIndexLine = in.nextLine();
                                try {
                                    int monsterToAttackIndex = Integer.parseInt(monsterToAttackIndexLine);
                                    Monster monsterToAttack = teamMonster.getTeamMembers().get(monsterToAttackIndex);
                                    currentHero.attack(monsterToAttack);
                                    break;
                                } catch (Exception e) {
                                    System.out.print("That did not look like a valid choice, please enter monster's index: ");
                                    monsterToAttackIndexLine = in.nextLine();
                                }
                            }
                            break;
                        }

                        // Spell
                        else if (battleActionLine.equals("2")) {
                            ArrayList<Item> spells = currentHero.getInventory().getTypeItems("Spells");
                            if (spells.size() == 0) {
                                System.out.println(pr.RED + "You currently don't have any spells to cast!" + pr.RESET);
                                continue;
                            } else {
                                currentHero.getInventory().showTypeItems("Spells");
                                System.out.print("Which spell do you want to cast? Please enter their index: ");
                                String spellIndexLine = in.nextLine();
                                try {
                                    int spellIndex = Integer.parseInt(spellIndexLine);
                                    ItemConsumableSpell spellToCast = (ItemConsumableSpell) spells.get(spellIndex);
                                    while (true) {
                                        System.out.print("Which enemy do you want to cast the spell on? " + pr.RED + monsterTeamMembers + pr.RESET + ": ");
                                        String monsterToSpellIndexLine = in.nextLine();
                                        try {
                                            int monsterToAttackIndex = Integer.parseInt(monsterToSpellIndexLine);
                                            Monster monsterToSpell = teamMonster.getTeamMembers().get(monsterToAttackIndex);
                                            spellToCast.cast(currentHero, monsterToSpell, spellIndex);
                                            break;
                                        } catch (Exception e) {
                                            System.out.print("That did not look like a valid choice, please enter monster's index: ");
                                            monsterToSpellIndexLine = in.nextLine();
                                        }
                                    }
                                    break;
                                } catch (Exception e) {
                                    System.out.print("That did not look like a valid choice, please enter spell's index: ");
                                    spellIndexLine = in.nextLine();
                                }
                            }
                        }

                        // Use a potion
                        else if (battleActionLine.equals("3")) {
                            ArrayList<Item> potions = currentHero.getInventory().getTypeItems("Potions");
                            if (potions.size() == 0) {
                                System.out.println(pr.RED + "You currently don't have any potions!" + pr.RESET);
                                continue;
                            } else {
                                while (true) {
                                    currentHero.getInventory().showTypeItems("Potions");
                                    System.out.print("Which potion do you want to use? Please enter their index: ");
                                    String potionIndexLine = in.nextLine();
                                    try {
                                        int potionIndex = Integer.parseInt(potionIndexLine);
                                        ItemConsumablePotion potionToUse = (ItemConsumablePotion) potions.get(potionIndex);
                                        potionToUse.affect(currentHero, potionIndex);
                                        break;
                                    } catch (Exception e) {
                                        System.out.print("That did not look like a valid choice, please enter potion's index: ");
                                        potionIndexLine = in.nextLine();
                                    }
                                }
                                break;
                            }
                        }

                        // Equip an equipment
                        else if (battleActionLine.equals("4")) {
                            ArrayList<Item> weapons = currentHero.getInventory().getTypeItems("Weapons");
                            ArrayList<Item> armors = currentHero.getInventory().getTypeItems("Armors");
                            if (weapons.size() + armors.size() == 0) {
                                System.out.println(pr.RED + "You currently don't have any equipment!" + pr.RESET);
                                continue;
                            } else {
                                StringBuilder typesAvailable = new StringBuilder();
                                if (weapons.size() > 0) {
                                    while (true) {
                                        currentHero.getInventory().showTypeItems("Weapons");
                                        System.out.print("Which weapon do you want to equip? Please enter their index: ");
                                        String weaponIndexLine = in.nextLine();
                                        try {
                                            int weaponIndex = Integer.parseInt(weaponIndexLine);
                                            EquipmentWeapon weaponToEquip = (EquipmentWeapon) weapons.get(weaponIndex);
                                            weaponToEquip.equip(currentHero, weaponIndex);
                                            break;
                                        } catch (Exception e) {
                                            System.out.print("That did not look like a valid choice, please enter armor's index: ");
                                            weaponIndexLine = in.nextLine();
                                        }
                                    }
                                }
                                if (armors.size() > 0) {
                                    while (true) {
                                        currentHero.getInventory().showTypeItems("Armors");
                                        System.out.print("Which armor do you want to equip? Please enter their index: ");
                                        String armorIndexLine = in.nextLine();
                                        try {
                                            int armorIndex = Integer.parseInt(armorIndexLine);
                                            EquipmentArmor armorToEquip = (EquipmentArmor) armors.get(armorIndex);
                                            armorToEquip.equip(currentHero, armorIndex);
                                            break;
                                        } catch (Exception e) {
                                            System.out.print("That did not look like a valid choice, please enter armor's index: ");
                                            armorIndexLine = in.nextLine();
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            } else {
                Random rand = new Random();
                Monster monster = (Monster) currentRole.get(1);
                if (monster.getHP() > 0) {
                    System.out.printf("It's " + pr.RED + "%s"  + pr.RESET + "'s turn!\n", monster.getName());
                    Hero heroToAttack = currentHeroTeam.getTeamMembers().get(rand.nextInt(currentHeroTeam.getTeamSize()));
                    monster.attack(heroToAttack);
                }
            }
        }

        // Battle End
        System.out.println(pr.CYAN + "\nThe battle has concluded!" + pr.RESET);
        if (gameEnd()) {
            System.out.println("All heroes have fainted! You lost...");
            setGameOver(true);
            return;
        }

        // Regain health and mana and Gain experience and gold
        for (Hero hero : currentHeroTeam.getTeamMembers()) {
            // Experience and gold
            hero.setExperience(hero.getExperience()+(2*teamMonster.getTeamSize()));
            System.out.printf(pr.GREEN + "%s"  + pr.RESET + " has gained %d experience!\n", hero.getName(), 2*teamMonster.getTeamSize());
            if (hero.getHP() > 0) {
                //Regain 10% HP and MP at end of each round
                hero.setHP(hero.getHP() * 1.1);
                hero.setMP(hero.getMP() * 1.1);

                // Gain gold
                System.out.print(pr.GREEN + hero.getName() + pr.RESET + " has finished the turn! Regain HP and MP by 10%.\n");
                hero.setGold(hero.getGold() + currentHeroTeam.highestLevel()*100);
                System.out.printf(pr.GREEN + "%s"  + pr.RESET + " has gained %d gold!\n", hero.getName(), currentHeroTeam.highestLevel()*100);
            }
            hero.levelUp();
        }
    }

    @Override
    public boolean gameEnd() {
        return currentHeroTeam.allHeroesFainted();
    }
}
