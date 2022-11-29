import java.util.*;
import static java.lang.System.exit;

/**
 * A Class representing an instance of a Legends of Valor game.
 */
public class GameLV extends BattleTurnBasedGame {
    private static final HashMap<String, ArrayList<String>> GAMEINPUTMAPPING = new HashMap<String, ArrayList<String>>() {{
        put("move", new ArrayList<String>(){{add("w"); add("W"); add("a"); add("A"); add("s"); add("S"); add("d"); add("D"); add("k"); add("K");}});
        put("utility", new ArrayList<String>(){{add("b"); add("B"); add("t"); add("T"); add("q"); add("Q"); add("i"); add("I"); add("m"); add("M");}});
    }};
    Printer pr = new Printer();

    private ArrayList<Integer> validLane = new ArrayList<>();
    private int[] laneHeroNum;
    private BoardWorldMap currentWorldMap;
    private TeamHero currentHeroTeam;
    private QueueBattle currentQueueBattle;
    private int monsterSpawnRounds;

    public GameLV(TeamHero currentHeroTeam) {
        this.currentWorldMap = new BoardWorldMap(8, currentHeroTeam.getTeamSize()*2+(currentHeroTeam.getTeamSize()-1));
        this.currentHeroTeam = currentHeroTeam;
        this.monsterSpawnRounds = currentWorldMap.height;
    }

    @Override
    public void initializeGame() {
        Scanner in = new Scanner(System.in);
        this.currentWorldMap.initializeBoard();
        this.currentWorldMap.initializeWorld();
        this.laneHeroNum = new int[currentWorldMap.getNumCreature()];
        this.currentWorldMap.printBoard();
        System.out.println(pr.BLUE + "Welcome to this new world full of opportunity, danger, and of course, FUN! ENJOY!" + pr.RESET);
        System.out.println(pr.PURPLE + "H" + pr.RESET + " : This represents your teams and they will be starting at their Nexuses.");
        System.out.println(pr.GREEN + "B" + pr.RESET + " : This represents a bush area, teams here get a bonus of their dexterity.");
        System.out.println(pr.YELLOW + "C" + pr.RESET + " : This represents a cave area, teams here get a bonus of their agility.");
        System.out.println(pr.CYAN + "K" + pr.RESET + " : This represents a koulou area, teams here get a bonus of their strength.");
        System.out.println(pr.BLUE_BG + "N" + pr.RESET + " : This represents an ally nexus, your teams spawn and can trade here.");
        System.out.println(pr.RED_BG + "N" + pr.RESET + " : This represents an enemy nexus, monster teams spawn here.");
        System.out.println(pr.WHITE_BG + "X" + pr.RESET + " : This represents terrains of the world that have seen no one crossing them over the eons.");
        System.out.println(pr.GREEN + "''" + pr.RESET + ": This represents an unknown place, your team MAY encounter a battle once stepped in.");
        System.out.print("Do you think this is a reasonable world to play? Enter N to regenerate a world, Y to adventure: ");
        String confirmLine = in.nextLine();
        while (!confirmLine.equals("Y") && !confirmLine.equals("N")) {
            System.out.print("That did not look like a valid choice, please re-enter Y/N: ");
            confirmLine = in.nextLine();
        }
        // Initialize Markets once map confirmed
        if (confirmLine.equals("Y")) {
            LVFileReader fileReader = new LVFileReader();
            HashMap<String, List<String>> allWeapons = fileReader.readFile("Legends_Monsters_and_Heroes/Weaponry.txt");
            HashMap<String, List<String>> allArmors = fileReader.readFile("Legends_Monsters_and_Heroes/Armory.txt");
            HashMap<String, List<String>> allPotions = fileReader.readFile("Legends_Monsters_and_Heroes/Potions.txt");
            HashMap<String, List<String>> allFireSpells = fileReader.readFile("Legends_Monsters_and_Heroes/FireSpells.txt");
            HashMap<String, List<String>> allIceSpells = fileReader.readFile("Legends_Monsters_and_Heroes/IceSpells.txt");
            HashMap<String, List<String>> allLightningSpells = fileReader.readFile("Legends_Monsters_and_Heroes/LightningSpells.txt");
            for (String pos : new ArrayList<String>(currentWorldMap.getMarkets().keySet())) {
                Market market = (Market) currentWorldMap.getMarkets().get(pos);
                market.initializeMarket(allWeapons, allArmors, allPotions, allFireSpells, allIceSpells, allLightningSpells);
            }
            System.out.println("RULE: The game ends when one of the heroes reaches the enemies' nexus! ONWARD!");
            for (int i = 0; i < currentWorldMap.getNumCreature(); i++) {
                this.validLane.add(i);
                this.laneHeroNum[i] = 1;
            }
        }
        // Re-initialize map
        else {
            initializeGame();
        }
    }

    @Override
    public String gamePrompt() {
        Scanner in = new Scanner(System.in);
        currentWorldMap.printBoard();
        int heroIndex = 0;
        while(!isGameOver()) {
            if (currentWorldMap.heroAtHeroNexus(heroIndex)) {
                System.out.printf(pr.GREEN + "%s (lane: %d)" + pr.RESET + ", it's your turn! Move around with W/A/S/D keys, Q to quit, I for hero status, " + pr.YELLOW + "M for market: " + pr.RESET, currentHeroTeam.getTeamMembers().get(heroIndex).getName(), heroIndex+1);
            } else if (currentWorldMap.monsterInRange(heroIndex, currentHeroTeam.getTeamMembers().get(heroIndex).getWeapons().attackRange()) != null) {
                System.out.printf(pr.GREEN + "%s (lane: %d)" + pr.RESET + ", it's your turn! Move around with W/A/S/D keys, " + pr.RED + "K to attack" + pr.RESET + ", " + pr.BLUE + "B to recall" + pr.RESET + ", " + pr.DARK_PURPLE + "T to teleport" + pr.RESET + ", Q to quit, I for hero status: ", currentHeroTeam.getTeamMembers().get(heroIndex).getName(), heroIndex+1);
            } else {
                System.out.printf(pr.GREEN + "%s (lane: %d)" + pr.RESET + ", it's your turn! Move around with W/A/S/D keys, " + pr.BLUE + "B to recall" + pr.RESET + ", " + pr.DARK_PURPLE + "T to teleport" + pr.RESET + ", Q to quit, I for hero status: ", currentHeroTeam.getTeamMembers().get(heroIndex).getName(), heroIndex+1);
            }
            String moveLine = in.nextLine();
            while (!GAMEINPUTMAPPING.get("move").contains(moveLine) &&
                    !GAMEINPUTMAPPING.get("utility").contains(moveLine)) {
                if (currentWorldMap.heroAtHeroNexus(heroIndex)) {
                    System.out.print("That did not look like a valid choice, please enter W/A/S/D/Q/I/M: ");
                } else if (currentWorldMap.monsterInRange(heroIndex, currentHeroTeam.getTeamMembers().get(heroIndex).getWeapons().attackRange()) != null) {
                    System.out.print("That did not look like a valid choice, please enter W/A/S/D/K/B/T/Q/I: ");
                } else {
                    System.out.print("That did not look like a valid choice, please enter W/A/S/D/B/T/Q/I: ");
                }
                moveLine = in.nextLine();
            }

            // Move
            if (GAMEINPUTMAPPING.get("move").contains(moveLine)) {
                boolean canMove = currentWorldMap.heroCanMove(moveLine, heroIndex);

                // Can't move logic
                while (!canMove) {
                    System.out.println(pr.RED + "YOU SHALL NOT PASS!"  + pr.RESET);
                    if (currentWorldMap.heroAtHeroNexus(heroIndex)) {
                        System.out.printf(pr.GREEN + "%s (lane: %d)" + pr.RESET + ", it's your turn! Move around with W/A/S/D keys, Q to quit, I for hero status, " + pr.YELLOW + "M for market: " + pr.RESET, currentHeroTeam.getTeamMembers().get(heroIndex).getName(), heroIndex+1);
                    } else if (currentWorldMap.monsterInRange(heroIndex, currentHeroTeam.getTeamMembers().get(heroIndex).getWeapons().attackRange()) != null) {
                        System.out.printf(pr.GREEN + "%s (lane: %d)" + pr.RESET + ", it's your turn! Move around with W/A/S/D keys, " + pr.RED + "K to attack" + pr.RESET + ", " + pr.BLUE + "B to recall" + pr.RESET + ", " + pr.DARK_PURPLE + "T to teleport" + pr.RESET + ", Q to quit, I for hero status: ", currentHeroTeam.getTeamMembers().get(heroIndex).getName(), heroIndex+1);
                    } else {
                        System.out.printf(pr.GREEN + "%s (lane: %d)" + pr.RESET + ", it's your turn! Move around with W/A/S/D keys, " + pr.BLUE + "B to recall" + pr.RESET + ", " + pr.DARK_PURPLE + "T to teleport" + pr.RESET + ", Q to quit, I for hero status: ", currentHeroTeam.getTeamMembers().get(heroIndex).getName(), heroIndex+1);
                    }
                    moveLine = in.nextLine();
                    canMove = currentWorldMap.heroCanMove(moveLine, heroIndex);
                }

                if (moveLine.equals("K")) {
                    // Attack logic
                    battlePrompt(heroIndex);
                } else {
                    // Move logic
                    String moveToCellStatus = currentWorldMap.heroMove(moveLine, currentHeroTeam, heroIndex);
                    currentWorldMap.printBoard();
                    if (currentWorldMap.heroAtMonsterNexus(heroIndex)) {
                        setGameOver(true);
                        System.out.println(pr.GREEN + "Your team has destroyed their Nexus!" + pr.RESET);
                        return "Game Over";
                    }
                    boolean encounterBattle = moveToCellStatus.equals("Monster");
                    if (encounterBattle) {
                        battlePrompt(heroIndex);
                    }
                }
                // Only consume round when hero make a move
                heroIndex++;
            }
            // Utility
            else if (GAMEINPUTMAPPING.get("utility").contains(moveLine)) {
                // Recall
                if (moveLine.equals("b") || moveLine.equals("B")) {
                    currentWorldMap.heroRecall(heroIndex);
                    laneHeroNum[heroIndex]++;
                    laneHeroNum[currentHeroTeam.getTeamMembers().get(heroIndex).getWasAt()]--;
                    validLane.add(heroIndex);
                    currentWorldMap.printBoard();
                    heroIndex++;
                }

                // Teleport
                else if (moveLine.equals("t") || moveLine.equals("T")) {
                    System.out.print("Where do you want to teleport? 1-" + currentWorldMap.getNumCreature() + ": ");
                    String targetLine = in.nextLine();
                    int targetLine_int = stringToInt(targetLine, in);
                    while (targetLine_int < 1 || targetLine_int > currentWorldMap.getNumCreature()) {
                        System.out.print("That did not look like a valid choice, please enter 1-" + currentWorldMap.getNumCreature() + ": ");
                        targetLine = in.nextLine();
                        targetLine_int = stringToInt(targetLine, in);
                    }
                    while(!validLane.contains(targetLine_int - 1)) {
                        System.out.print("Cannot teleport to that lane, try another one 1-" + currentWorldMap.getNumCreature() + ": ");
                        targetLine = in.nextLine();
                        targetLine_int = stringToInt(targetLine, in);
                    }
                    while (laneHeroNum[targetLine_int - 1] >= 3) {
                        System.out.print("This lane has too many heroes, try another one 1-" + currentWorldMap.getNumCreature() + ": ");
                        targetLine = in.nextLine();
                        targetLine_int = stringToInt(targetLine, in);
                    }
                    if (targetLine_int - 1 == heroIndex) {
                        currentWorldMap.heroRecall(heroIndex);
                        System.out.println(pr.CYAN + "You cannot teleport to the same lane...Sending you back to nexus" + pr.RESET);
                    } else {
                        currentWorldMap.heroTeleport(heroIndex, targetLine_int - 1);
                        currentHeroTeam.getTeamMembers().get(heroIndex).setWasAt(targetLine_int - 1);
                        laneHeroNum[targetLine_int - 1]++;
                        laneHeroNum[heroIndex]--;
                        validLane.remove(Integer.valueOf(heroIndex));
                    }
                    currentWorldMap.printBoard();
                    heroIndex++;
                }

                // Quit game
                else if (moveLine.equals("q") || moveLine.equals("Q")) {
                    exit(0);
                }

                // Heroes Info
                else if (moveLine.equals("i") || moveLine.equals("I")) {
                    currentHeroTeam.showTeamStatus();
                }

                // Market
                else if (moveLine.equals("m") || moveLine.equals("M")) {
                    String marketKey = Integer.toString(currentWorldMap.get_boardCellHeight()*currentWorldMap.getHeroPositions()[heroIndex][0]+1) + " " +
                                       Integer.toString(currentWorldMap.get_boardCellWidth()*currentWorldMap.getHeroPositions()[heroIndex][1]+2);
                    Market market = (Market) currentWorldMap.getMarkets().get(marketKey);
                    market.marketPrompt(currentHeroTeam);
                }
            }
            if (heroIndex > currentWorldMap.getNumCreature() - 1) break;
        }

        // Monster move
        monsterSpawnRounds--;
        for (int i = 0; i < currentWorldMap.getNumCreature(); i++) {
            currentWorldMap.monsterMove(i);
            // Monster spawn
            if (monsterSpawnRounds == 0) {
                currentWorldMap.monsterSpawn(i);
                if (i == currentWorldMap.getNumCreature()-1) {
                    monsterSpawnRounds = currentWorldMap.height;
                }
            }
            // Monster at nexus
            if (currentWorldMap.monsterAtHeroNexus(i)) {
                System.out.println(pr.RED + "Your Nexus has been destroyed!" + pr.RESET);
                setGameOver(true);
                return "Game Over";
            }
        }
        return null;
    }

    public void battlePrompt(int heroIndex) {
        Scanner in = new Scanner(System.in);
        // Initialize monster team and show status
        System.out.println(pr.CYAN + "Your team encounters a team of monsters, let the battle commence!" + pr.RESET);
        TeamMonster teamMonster = new TeamMonster("Monsters");
        teamMonster.initializeMonsterTeam(currentHeroTeam.highestLevel(), 1);

        // Initialize Battle Queue
        this.currentQueueBattle = new QueueBattle(currentHeroTeam, teamMonster, heroIndex);

        // Battle takes turns
        Hero currentHero = currentHeroTeam.getTeamMembers().get(heroIndex);
        while (currentHero.getHP() > 0 && !teamMonster.allMonstersFainted()) {
            ArrayList<Object> currentRole = currentQueueBattle.nextTurn();
            if (currentRole.get(0).equals("Hero")) {
                if (currentHero.getHP() > 0) {
                    System.out.printf("\nIt's " + pr.GREEN + "%s"  + pr.RESET + "'s turn!\n\n", currentHero.getName());
                    currentHero.showHeroStatus();
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
                Monster monster = (Monster) currentRole.get(1);
                if (monster.getHP() > 0) {
                    System.out.printf("\nIt's " + pr.RED + "%s"  + pr.RESET + "'s turn!\n\n", monster.getName());
                    monster.attack(currentHero);
                }
            }
        }

        // Battle End
        System.out.println(pr.CYAN + "\nThe battle has concluded!" + pr.RESET);
        if (gameEnd()) {
            System.out.println(pr.RED + "All heroes have fainted! You lost..." + pr.RESET);
            setGameOver(true);
            return;
        }

        // Regain health and mana and Gain experience and gold
        currentHero.setExperience(currentHero.getExperience()+(2*teamMonster.getTeamSize()));
        System.out.printf(pr.GREEN + "%s"  + pr.RESET + " has gained %d experience!\n", currentHero.getName(), 2*teamMonster.getTeamSize());
        if (currentHero.getHP() > 0) {
            //Regain 10% HP and MP at end of each round
            currentHero.setHP(currentHero.getHP() * 1.1);
            currentHero.setMP(currentHero.getMP() * 1.1);

            // Gain gold
            System.out.print(pr.GREEN + currentHero.getName() + pr.RESET + " has finished the turn! Regain HP and MP by 10%.\n");
            currentHero.setGold(currentHero.getGold() + currentHeroTeam.highestLevel()*100);
            System.out.printf(pr.GREEN + "%s"  + pr.RESET + " has gained %d gold!\n", currentHero.getName(), currentHeroTeam.highestLevel()*100);
        } else {
            // Revive
            System.out.printf(pr.GREEN + "%s" + pr.RESET + " has respawned!\n", currentHero.getName());
            currentHero.setHP(300);
            currentWorldMap.heroRecall(heroIndex);
        }
        currentHero.levelUp();

        // Set board
        currentWorldMap.removeMonster(heroIndex);
        currentWorldMap.printBoard();
    }

    @Override
    public boolean gameEnd() {
        return currentHeroTeam.allHeroesFainted();
    }

    private int stringToInt(String s, Scanner in) {
        int input_int = 0;
        while (true) {
            try {
                input_int = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.out.print("That did not look like a valid choice, please enter a integer: ");
                s = in.nextLine();
                continue;
            }
        }
        return input_int;
    }
}
