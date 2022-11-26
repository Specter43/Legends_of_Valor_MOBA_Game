import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * A Class representing a market.
 */
public class Market {
    private Inventory<Item> inventory;
    private int[] marketPosition;
    Printer pr = new Printer();

    public Market(int[] marketPosition) {
        this.inventory = new Inventory<>();
        this.marketPosition = marketPosition;
    }

    public void initializeMarket(HashMap<String, List<String>> allWeapons, HashMap<String, List<String>> allArmors, HashMap<String, List<String>> allPotions, HashMap<String, List<String>> allFireSpells, HashMap<String, List<String>> allIceSpells, HashMap<String, List<String>> allLightningSpells) {
        double itemPortion = 0.5;
        int[] weaponIndices = IntStream.range(0, (int) Math.ceil(itemPortion*allWeapons.size())).map(i -> ThreadLocalRandom.current().nextInt(allWeapons.get("Name").size())).toArray();
        for (int i : weaponIndices) {
            EquipmentWeapon weapon = new EquipmentWeapon(allWeapons.get("Name").get(i),
                                                         Double.parseDouble(allWeapons.get("cost").get(i)),
                                                         Integer.parseInt(allWeapons.get("level").get(i)),
                                                         Double.parseDouble(allWeapons.get("damage").get(i)),
                                                         Integer.parseInt(allWeapons.get("required hands").get(i)));
            inventory.addItem("Weapons", weapon);
        }
        int[] armorIndices = IntStream.range(0, (int) Math.ceil(itemPortion*allArmors.size())).map(i -> ThreadLocalRandom.current().nextInt(allArmors.get("Name").size())).toArray();
        for (int i : armorIndices) {
            EquipmentArmor armor = new EquipmentArmor(allArmors.get("Name").get(i),
                                                      Double.parseDouble(allArmors.get("cost").get(i)),
                                                      Integer.parseInt(allArmors.get("required level").get(i)),
                                                      Double.parseDouble(allArmors.get("damage reduction").get(i)));
            inventory.addItem("Armors", armor);
        }
        int[] potionIndices = IntStream.range(0, (int) Math.ceil(itemPortion*allPotions.size())).map(i -> ThreadLocalRandom.current().nextInt(allPotions.get("Name").size())).toArray();
        for (int i : potionIndices) {
            ItemConsumablePotion potion = new ItemConsumablePotion(allPotions.get("Name").get(i),
                                                                   Double.parseDouble(allPotions.get("cost").get(i)),
                                                                   Integer.parseInt(allPotions.get("required level").get(i)),
                                                                   Double.parseDouble(allPotions.get("attribute increase").get(i)),
                                                                   allPotions.get("attribute affected").get(i));
            inventory.addItem("Potions", potion);
        }
        int[] fireSpellIndices = IntStream.range(0, (int) Math.ceil(itemPortion*allFireSpells.size())).map(i -> ThreadLocalRandom.current().nextInt(allFireSpells.get("Name").size())).toArray();
        for (int i : fireSpellIndices) {
            ItemConsumableSpellFire fireSpell = new ItemConsumableSpellFire(allFireSpells.get("Name").get(i),
                                                                            Double.parseDouble(allFireSpells.get("cost").get(i)),
                                                                            Integer.parseInt(allFireSpells.get("required level").get(i)),
                                                                            Double.parseDouble(allFireSpells.get("damage").get(i)),
                                                                            4,
                                                                            Double.parseDouble(allFireSpells.get("mana cost").get(i)));
            inventory.addItem("Spells", fireSpell);
        }
        int[] iceSpellIndices = IntStream.range(0, (int) Math.ceil(itemPortion*allIceSpells.size())).map(i -> ThreadLocalRandom.current().nextInt(allIceSpells.get("Name").size())).toArray();
        for (int i : iceSpellIndices) {
            ItemConsumableSpellIce iceSpell = new ItemConsumableSpellIce(allIceSpells.get("Name").get(i),
                                                                         Double.parseDouble(allIceSpells.get("cost").get(i)),
                                                                         Integer.parseInt(allIceSpells.get("required level").get(i)),
                                                                         Double.parseDouble(allIceSpells.get("damage").get(i)),
                                                                         4,
                                                                         Double.parseDouble(allIceSpells.get("mana cost").get(i)));
            inventory.addItem("Spells", iceSpell);
        }
        int[] lightningSpellIndices = IntStream.range(0, (int) Math.ceil(itemPortion*allLightningSpells.size())).map(i -> ThreadLocalRandom.current().nextInt(allLightningSpells.get("Name").size())).toArray();
        for (int i : lightningSpellIndices) {
            ItemConsumableSpellLightning lightningSpell = new ItemConsumableSpellLightning(allLightningSpells.get("Name").get(i),
                                                                                        Double.parseDouble(allLightningSpells.get("cost").get(i)),
                                                                                        Integer.parseInt(allLightningSpells.get("required level").get(i)),
                                                                                        Double.parseDouble(allLightningSpells.get("damage").get(i)),
                                                                                        4,
                                                                                        Double.parseDouble(allLightningSpells.get("mana cost").get(i)));
            inventory.addItem("Spells", lightningSpell);
        }
    }

    public void marketPrompt(TeamHero currentHeroTeam) {
        inventory.showInventory();
        Scanner in = new Scanner(System.in);
        System.out.print("Buying or Selling? Press B to Buy, S to Sell, or Q to Leave: ");
        String choiceLine = in.nextLine();
        while (!choiceLine.equals("B") && !choiceLine.equals("S") && !choiceLine.equals("Q")) {
            System.out.print("That did not look like a valid choice, please enter B/S/Q: ");
            choiceLine = in.nextLine();
        }
        // Quit market
        if (choiceLine.equals("Q")) {
            return;
        }

        // Buying/Selling
        List<String> heroIndices = new ArrayList<>();
        StringBuilder teamMembers = new StringBuilder();
        for (Hero hero : currentHeroTeam.getTeamMembers()) {
            heroIndices.add(Integer.toString(currentHeroTeam.getTeamMembers().indexOf(hero)));
            teamMembers.append("(").append(currentHeroTeam.getTeamMembers().indexOf(hero)).append(")").append(" ").append(hero.getName()).append(", ");
        }
        String verb;
        String verbing;
        if (choiceLine.equals("B")) {
            verb = "buy";
            verbing = "buying";
        } else {
            verb = "sell";
            verbing = "selling";
        }
        System.out.print("Which hero is " + verbing + "? " + pr.GREEN + teamMembers + pr.RESET + "Please enter their index: " );
        String heroIndexLine = in.nextLine();
        while (!heroIndices.contains(heroIndexLine)) {
            System.out.print("That did not look like a valid index, please enter hero indices: ");
            heroIndexLine = in.nextLine();
        }
        int heroIndex = Integer.parseInt(heroIndexLine);
        Hero currentHero = currentHeroTeam.getTeamMembers().get(heroIndex);
        Inventory<Item> currentInventory;
        if (choiceLine.equals("B")) {
            currentInventory = inventory;
        } else {
            currentInventory = currentHero.getInventory();
            currentInventory.showInventory();
        }
        boolean continueTrading = true;
        while (continueTrading) {
            String type = null;
            while (true) {
                System.out.printf(pr.GREEN + "\n%s, " + pr.RESET + "which item type do you want to " + verb + "?\n", currentHero.getName());
                System.out.println("W for Weapons");
                System.out.println("A for Armors");
                System.out.println("P for Potions");
                System.out.println("S for Spells");
                System.out.print("Please enter W/A/P/S, or Q to quit market: ");
                List<String> types = new ArrayList<String>() {
                    {add("W"); add("A"); add("P"); add("S"); add("Q");}
                };
                String tradeTypeLine = in.nextLine();
                while (!types.contains(tradeTypeLine)) {
                    System.out.print("That did not look like a valid item type. Please enter W/A/P/S/Q: ");
                    tradeTypeLine = in.nextLine();
                }
                switch (tradeTypeLine) {
                    case "W":
                        type = "Weapons";
                        break;
                    case "A":
                        type = "Armors";
                        break;
                    case "P":
                        type = "Potions";
                        break;
                    case "S":
                        type = "Spells";
                        break;
                    case "Q":
                        return;
                }
                if (currentInventory.getTypeItems(type).size() == 0) {
                    System.out.println(pr.RED + "No item in this category to " + verb + "!" + pr.RESET);
                } else {
                    currentInventory.showTypeItems(type);
                    break;
                }
            }
            System.out.print("Which item do you want to " + verb + "? Please enter their index, or Q to exit market: ");
            String tradeIndexLine = in.nextLine();
            while (true) {
                if (tradeIndexLine.equals("Q")) {
                    return;
                }
                try {
                    int tradeIndex = Integer.parseInt(tradeIndexLine);
                    if (choiceLine.equals("B")) {
                        buy(currentHero, inventory, type, tradeIndex);
                    } else {
                        sell(currentHero, currentHero.getInventory(), type, tradeIndex);
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Incorrect item index, please re-enter index: ");
                    tradeIndexLine = in.nextLine();
                }
            }
            System.out.print("Do you want to continue " + verbing + "? Enter Y/N: ");
            String continueTradeLine = in.nextLine();
            while (!continueTradeLine.equals("Y") && !continueTradeLine.equals("N")) {
                System.out.print("That did not look like a valid choice, please re-enter Y/N: ");
                continueTradeLine = in.nextLine();
            }
            if (continueTradeLine.equals("N")) {
                continueTrading = false;
            } else {
                if (choiceLine.equals("B")) {
                    inventory.showInventory();
                } else {
                    currentHero.getInventory().showInventory();
                }
            }
        }
    }

    public void buy(Hero hero, Inventory<Item> inventory, String itemType, int itemIndex) {
        Item itemToBuy = inventory.getTypeItems(itemType).get(itemIndex);
        if (hero.getLevel() < itemToBuy.getLevel()) {
            System.out.println(pr.RED + "This item is too high level for you." + pr.RESET);
            return;
        }
        if (hero.getGold() < itemToBuy.getPrice()) {
            System.out.println(pr.RED + "This item is too expensive!" + pr.RESET);
        } else {
            hero.setGold(hero.getGold() - itemToBuy.getPrice());
            hero.getInventory().addItem(itemType, itemToBuy);
            this.inventory.removeItem(itemType, itemIndex);
            System.out.printf(pr.GREEN + "%s "  + pr.RESET + "has been added to your inventory! Hero: " + pr.GREEN + "%s" + pr.RESET + " has " + pr.YELLOW + "%.1f" + pr.RESET + " gold left.\n", itemToBuy.getName(), hero.getName(), hero.getGold());
        }
    }

    public void sell(Hero hero, Inventory<Item> inventory, String itemType, int itemIndex) {
        Item itemToSell = inventory.getTypeItems(itemType).get(itemIndex);
        hero.setGold(hero.getGold() + itemToSell.getPrice()/2);
        hero.getInventory().removeItem(itemType, itemIndex);
        this.inventory.addItem(itemType, itemToSell);
        System.out.printf(pr.GREEN + "%s "  + pr.RESET + "has been sold for " + pr.YELLOW + "%.1f" + pr.RESET + " amount of gold. Hero: " + pr.GREEN + "%s" + pr.RESET + " has " + pr.YELLOW + "%.1f" + pr.RESET + " gold left.\n", itemToSell.getName(), itemToSell.getPrice()/2, hero.getName(), hero.getGold());
    }
}