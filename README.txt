# CS611-<4>
## <Legends of Valor>
---------------------------------------------------------------------------
<ZHEYU YANG>
<yangzhey@bu.edu>
<U41174832>

<DUODUO XU>
<xudd@bu.edu>
<U24826440>

## Files
---------------------------------------------------------------------------
Attack.java: An Interface to instruct that a Role class should be able to attack.
BattleTurnBasedGame.java: An abstract class representing a turn based battle game.
Board.java: A Class representing a board.
BoardFunction.java: An Interface restricting behaviors of every board.
BoardLane.java:  A class representing a lane in a board of Legends of Valor.
BoardWorldMap.java: A Class representing a world map for Legends of Valor game.
Cell.java: An abstract class representing a general cell in a board.
CellLV.java: A Class representing a cell in Legends of Valor game.
CellLVBorder.java: A Class representing a border cell in Legends of Valor.
CellLVBush.java: A Class representing a bush cell in Legends of Valor.
CellLVCave.java: A Class representing a cave cell in Legends of Valor.
CellLVHeroNexus.java: A Class representing a hero nexus cell in Legends of Valor.
CellLVInaccessible.java: A Class representing an inaccessible cell in Legends of Valor.
CellLVKoulou.java: A Class representing a koulou cell in Legends of Valor.
CellLVMonsterNexus.java: A Class representing a monster nexus cell in Legends of Valor.
CellLVNexus.java: An abstract class representing a nexus class.
CellLVPlain.java: A Class representing a plain cell in Legends of Valor.
Equipment.java: An abstract class representing a general equipment.
EquipmentArmor.java: A Class representing an equipment armor.
EquipmentWeapon.java: A Class representing an equipment weapon.
Game.java: An abstract class representing a general game.
GameLV.java: A Class representing an instance of a Legends of Valor game.
GameLVPlayer.java: A Class representing a player of Legends of Valor.
Hero.java: An abstract class representing a general hero.
HeroArmors.java: A class representing the armors a hero is wearing.
HeroPaladin.java: A Class representing a Paladin.
HeroSorcerer.java: A Class representing a Sorcerer.
HeroWarrior.java: A Class representing a Warrior.
HeroWeapons.java: A class representing the weapons a hero is wielding.
Inventory.java: A Class representing the inventory of a hero.
Item.java: An abstract class representing a general item.
ItemConsumable.java: An abstract class representing a general consumable item.
ItemConsumablePotion.java: A Class representing a potion.
ItemConsumableSpell.java: An abstract class representing a general spell.
ItemConsumableSpellFire.java: A Class representing a fire spell.
ItemConsumableSpellIce.java: A Class representing an ice spell.
ItemConsumableSpellLightning.java: A Class representing a lightning spell.
LVFileReader.java: A Class representing file reader for Legends of Valor game.
Main.java: Main Class
MainMenu.java: A Class representing the main menu of a game.
Market.java: A Class representing a market.
Monster.java: An abstract class representing a general monster.
MonsterDragon.java: A Class representing a dragon.
MonsterExoskeleton.java: A Class representing an exoskeleton.
MonsterSpirit.java: A Class representing a spirit.
Player.java: A Class representing a player of Legends of Valor.
Printer.java: A Class for storing color strings.
Queue: A abstract class representing a general queue.
QueueBattle.java: A Class representing a queue for turn based battle game.
Role.java: An abstract class representing a general role.
Team.java: A Class representing a Team.
TeamHero.java: A Class representing a team of heroes.
TeamMonster.java: A Class representing a team of monsters.

## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>
2. <Bonus Done:
    (1): Colorful Output.
    (2): Regenerate Map if not wanted.
    (3): Dynamic attack range.
    (4): Allow for 3-5 heroes to play.
>
3. <Notes to grader>:

## How to compile and run
---------------------------------------------------------------------------
1. Unzip folder if needed
2. Navigate to Legends_of_Valor_MOBA_Game
3. RUN "javac Main.java"
4. RUN "java Main"

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>
e.g.:

Good Day! Which game are we playing today? Type 1 for Legends of Valor or EXIT to exit game:  1
Welcome to Legends of Valor!
How many heroes will we be having today? Please enter 3~5: 3

                                                              WARRIORS
(0) Name: Gaerdal_Ironhand
      Level: 1  |  Health: 300  |  Mana: 100  |  Strength: 700  |  Agility: 500  |  Dexterity: 600  |  Money: 1354  |  Experience: 7
(1) Name: Sehanine_Monnbow
      Level: 1  |  Health: 300  |  Mana: 600  |  Strength: 700  |  Agility: 800  |  Dexterity: 500  |  Money: 2500  |  Experience: 8
(2) Name: Muamman_Duathall
      Level: 1  |  Health: 300  |  Mana: 300  |  Strength: 900  |  Agility: 500  |  Dexterity: 750  |  Money: 2546  |  Experience: 6
(3) Name: Flandal_Steelskin
      Level: 1  |  Health: 300  |  Mana: 200  |  Strength: 750  |  Agility: 650  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(4) Name: Undefeated_Yoj
      Level: 1  |  Health: 300  |  Mana: 400  |  Strength: 800  |  Agility: 400  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(5) Name: Eunoia_Cyn
      Level: 1  |  Health: 300  |  Mana: 400  |  Strength: 700  |  Agility: 800  |  Dexterity: 600  |  Money: 2500  |  Experience: 6

                                                              SORCERERS
(0) Name: Rillifane_Rallathil
      Level: 1  |  Health: 300  |  Mana: 1300  |  Strength: 750  |  Agility: 450  |  Dexterity: 500  |  Money: 2500  |  Experience: 9
(1) Name: Segojan_Earthcaller
      Level: 1  |  Health: 300  |  Mana: 900  |  Strength: 800  |  Agility: 500  |  Dexterity: 650  |  Money: 2500  |  Experience: 5
(2) Name: Reign_Havoc
      Level: 1  |  Health: 300  |  Mana: 800  |  Strength: 800  |  Agility: 800  |  Dexterity: 800  |  Money: 2500  |  Experience: 8
(3) Name: Reverie_Ashels
      Level: 1  |  Health: 300  |  Mana: 900  |  Strength: 800  |  Agility: 700  |  Dexterity: 400  |  Money: 2500  |  Experience: 7
(4) Name: Kalabar
      Level: 1  |  Health: 300  |  Mana: 800  |  Strength: 850  |  Agility: 400  |  Dexterity: 600  |  Money: 2500  |  Experience: 6
(5) Name: Skye_Soar
      Level: 1  |  Health: 300  |  Mana: 1000  |  Strength: 700  |  Agility: 400  |  Dexterity: 500  |  Money: 2500  |  Experience: 5

                                                              PALADINS
(0) Name: Parzival
      Level: 1  |  Health: 300  |  Mana: 300  |  Strength: 750  |  Agility: 650  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(1) Name: Sehanine_Moonbow
      Level: 1  |  Health: 300  |  Mana: 300  |  Strength: 750  |  Agility: 700  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(2) Name: Skoraeus_Stonebones
      Level: 1  |  Health: 300  |  Mana: 250  |  Strength: 650  |  Agility: 600  |  Dexterity: 350  |  Money: 2500  |  Experience: 4
(3) Name: Garl_Glittergold
      Level: 1  |  Health: 300  |  Mana: 100  |  Strength: 600  |  Agility: 500  |  Dexterity: 400  |  Money: 2500  |  Experience: 5
(4) Name: Amaryllis_Astra
      Level: 1  |  Health: 300  |  Mana: 500  |  Strength: 500  |  Agility: 500  |  Dexterity: 500  |  Money: 2500  |  Experience: 5
(5) Name: Caliber_Heist
      Level: 1  |  Health: 300  |  Mana: 400  |  Strength: 400  |  Agility: 400  |  Dexterity: 400  |  Money: 2500  |  Experience: 8

Recruit 3 Heroes and Assemble your squad!
Select the class of Heroes you want to recruit, please type W/S/P: W
Now select the hero you want to recruit, please type their corresponding index 0~5: 0
Gaerdal_Ironhand has joined the team!
Select the class of Heroes you want to recruit, please type W/S/P: S
Now select the hero you want to recruit, please type their corresponding index 0~5: 0
Rillifane_Rallathil has joined the team!
Select the class of Heroes you want to recruit, please type W/S/P: P
Now select the hero you want to recruit, please type their corresponding index 0~5: 0
Parzival has joined the team!
+---+---+---+---+---+---+---+---+
| M | N | X | N | M | X | N | M |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | H | X | H | N | X | H | N |
+---+---+---+---+---+---+---+---+
Welcome to this new world full of opportunity, danger, and of course, FUN! ENJOY!
H : This represents your teams and they will be starting at their Nexuses.
B : This represents a bush area, teams here get a bonus of their dexterity.
C : This represents a cave area, teams here get a bonus of their agility.
K : This represents a koulou area, teams here get a bonus of their strength.
N : This represents an ally nexus, your teams spawn and can trade here.
N : This represents an enemy nexus, monster teams spawn here.
X : This represents terrains of the world that have seen no one crossing them over the eons.
'': This represents an unknown place, your team MAY encounter a battle once stepped in.
Do you think this is a reasonable world to play? Enter N to regenerate a world, Y to adventure: Y
RULE: The game ends when one of the heroes reaches the enemies' nexus! ONWARD!
+---+---+---+---+---+---+---+---+
| M | N | X | N | M | X | N | M |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | H | X | H | N | X | H | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, Q to quit, I for hero status, M for market: w
+---+---+---+---+---+---+---+---+
| M | N | X | N | M | X | N | M |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | H | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | H | N | X | H | N |
+---+---+---+---+---+---+---+---+
Rillifane_Rallathil (lane: 2), it's your turn! Move around with W/A/S/D keys, Q to quit, I for hero status, M for market: w
+---+---+---+---+---+---+---+---+
| M | N | X | N | M | X | N | M |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | H | N |
+---+---+---+---+---+---+---+---+
Parzival (lane: 3), it's your turn! Move around with W/A/S/D keys, Q to quit, I for hero status, M for market: w
+---+---+---+---+---+---+---+---+
| M | N | X | N | M | X | N | M |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
| M |   | X | B | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
| M |   | X | B | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Rillifane_Rallathil (lane: 2), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
| M |   | X | B | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | H |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Parzival (lane: 3), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
| M |   | X | B | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X | H | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| M | C | X |   | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X | H | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| M | C | X |   | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | H |   | X | H | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Rillifane_Rallathil (lane: 2), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| M | C | X |   | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | H | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X | H | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Parzival (lane: 3), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| M | C | X |   | M | X |   | M |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | H | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   | M | X |   | M |
+---+---+---+---+---+---+---+---+
|   | H | X | H | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, K to attack, B to recall, T to teleport, Q to quit, I for hero status: K
Your team encounters a team of monsters, let the battle commence!

It's Gaerdal_Ironhand's turn!

Name: Gaerdal_Ironhand
      Level: 1  |  Health: 300.0  |  Mana: 100.0  |  Strength: 805.0  |  Defense: 0.0  |  Agility: 575.0  |  Dexterity: 600.0  |  Money: 1354.0  |  Experience: 7.0/10.0
                                 CURRENT MONSTER TEAM STATUS
Name: Natsunomeryu
      Level: 1  |  Health: 100.0  |  Strength: 115.0  |  defense: 200.0  |  Agility: 10.0
You may choose one of the following actions to perform:
1. Attack  |  2. Cast a spell  |  3. Use a potion  |  4. Equip an equipment: 1
Which enemy do you want to attack? (0) Natsunomeryu, : 0
Gaerdal_Ironhand attacked Natsunomeryu for 785.0 damage!
Natsunomeryu has fainted!

The battle has concluded!
Gaerdal_Ironhand has gained 2 experience!
Gaerdal_Ironhand has finished the turn! Regain HP and MP by 10%.
Gaerdal_Ironhand has gained 100 gold!
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   | M | X |   | M |
+---+---+---+---+---+---+---+---+
|   | H | X | H | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Rillifane_Rallathil (lane: 2), it's your turn! Move around with W/A/S/D keys, K to attack, B to recall, T to teleport, Q to quit, I for hero status: K
Your team encounters a team of monsters, let the battle commence!

It's Rillifane_Rallathil's turn!

Name: Rillifane_Rallathil
      Level: 1  |  Health: 300.0  |  Mana: 1300.0  |  Strength: 750.0  |  Defense: 0.0  |  Agility: 517.5  |  Dexterity: 661.3  |  Money: 2500.0  |  Experience: 9.0/10.0
                                 CURRENT MONSTER TEAM STATUS
Name: Natsunomeryu
      Level: 1  |  Health: 100.0  |  Strength: 115.0  |  defense: 200.0  |  Agility: 10.0
You may choose one of the following actions to perform:
1. Attack  |  2. Cast a spell  |  3. Use a potion  |  4. Equip an equipment: 1
Which enemy do you want to attack? (0) Natsunomeryu, : 0
Rillifane_Rallathil attacked Natsunomeryu for 730.0 damage!
Natsunomeryu has fainted!

The battle has concluded!
Rillifane_Rallathil has gained 2 experience!
Rillifane_Rallathil has finished the turn! Regain HP and MP by 10%.
Rillifane_Rallathil has gained 100 gold!
Rillifane_Rallathil has leveled up!
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
|   | H | X | H | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Parzival (lane: 3), it's your turn! Move around with W/A/S/D keys, K to attack, B to recall, T to teleport, Q to quit, I for hero status: K
Your team encounters a team of monsters, let the battle commence!

It's Parzival's turn!

Name: Parzival
      Level: 1  |  Health: 300.0  |  Mana: 300.0  |  Strength: 862.5  |  Defense: 0.0  |  Agility: 650.0  |  Dexterity: 805.0  |  Money: 2500.0  |  Experience: 7.0/10.0
                                 CURRENT MONSTER TEAM STATUS
Name: Chrysophylax
      Level: 2  |  Health: 200.0  |  Strength: 230.0  |  defense: 500.0  |  Agility: 20.0
You may choose one of the following actions to perform:
1. Attack  |  2. Cast a spell  |  3. Use a potion  |  4. Equip an equipment: 1
Which enemy do you want to attack? (0) Chrysophylax, : 0
Parzival attacked Chrysophylax for 812.5 damage!
Chrysophylax has fainted!

The battle has concluded!
Parzival has gained 2 experience!
Parzival has finished the turn! Regain HP and MP by 10%.
Parzival has gained 200 gold!
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | H | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   | H | X | H | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | H | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Rillifane_Rallathil (lane: 2), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X | H |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Parzival (lane: 3), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Rillifane_Rallathil (lane: 2), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X | H |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X | H |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Parzival (lane: 3), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   | H | X | B |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Rillifane_Rallathil (lane: 2), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X | H |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Parzival (lane: 3), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   | H | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Gaerdal_Ironhand (lane: 1), it's your turn! Move around with W/A/S/D keys, B to recall, T to teleport, Q to quit, I for hero status: w
+---+---+---+---+---+---+---+---+
| N | H | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
|   |   | X | H |   | X | H |   |
+---+---+---+---+---+---+---+---+
| K | C | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
| K |   | X |   |   | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X | B | C | X |   |   |
+---+---+---+---+---+---+---+---+
|   |   | X |   |   | X |   | K |
+---+---+---+---+---+---+---+---+
|   | C | X |   |   | X | B |   |
+---+---+---+---+---+---+---+---+
| N | N | X | N | N | X | N | N |
+---+---+---+---+---+---+---+---+
Your team has destroyed their Nexus!
Would you like to play another game? Y/N: N

Process finished with exit code 0
