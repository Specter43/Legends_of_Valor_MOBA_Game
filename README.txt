# CS611-<3>
## <Legends: Monsters and Heroes>
---------------------------------------------------------------------------
<ZHEYU YANG>
<yangzhey@bu.edu>
<U41174832>

## Files
---------------------------------------------------------------------------
Attack.java: An Interface to instruct that a Role class should be able to attack.
BattleQueue.java: A Class representing a queue for turn based battle game.
BattleTurnBasedGame.java: An abstract class representing a turn based battle game.
Board.java: A Class representing a board.
BoardFunction.java: An Interface restricting behaviors of every board.
BoardWorldMap.java: A Class representing a world map for Legends: Monsters and Heroes game.
Cell.java: An abstract class representing a general cell in a board.
CellLMH.java: A Class representing a cell in Legends: Monsters and Heroes game.
Equipment.java: An abstract class representing a general equipment.
EquipmentArmor.java: A Class representing an equipment armor.
EquipmentWeapon.java: A Class representing an equipment weapon.
Game.java: An abstract class representing a general game.
GameLMH.java: A Class representing an instance of a Legends: Monsters and Heroes game.
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
LMHFileReader.java: A Class representing file reader for Legends: Monsters and Heroes game.
Main.java: Main Class
MainMenu.java: A Class representing the main menu of a game.
Market.java: A Class representing a market.
Monster.java: An abstract class representing a general monster.
MonsterDragon.java: A Class representing a dragon.
MonsterExoskeleton.java: A Class representing an exoskeleton.
MonsterSpirit.java: A Class representing a spirit.
Printer.java: A Class for storing color strings.
Role.java: An abstract class representing a general role.
Team.java: A Class representing a Team.
TeamHero.java: A Class representing a team of heroes.
TeamMonster.java: A Class representing a team of monsters.

## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>
2. <Bonus Done:
    (1): Colorful Output
    (2): Regenerate Map if not wanted
>
3. <Notes to grader>
    (1): Did not follow the game balance rules instructed by the handout,
         since the rules are heavily in favor of the monsters, leaving
         heroes very little room to enjoy the game.

## How to compile and run
---------------------------------------------------------------------------
1. Unzip folder if needed
2. Navigate to Assignment3_ZHEYUYANG
3. RUN "javac Main.java"
4. RUN "java Main"

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>
e.g.:

Good Day! Which game are we playing today? Type 1 for Legends: Monsters and Heroes or EXIT to exit game:  1
Welcome to Legends: Monsters and Heroes!
How many heroes will we be having today? Please enter 1~3: 3

                                                              WARRIORS
(0) Name: Gaerdal_Ironhand
      Level: 1  |  Health: 100  |  Mana: 100  |  Strength: 700  |  Agility: 500  |  Dexterity: 600  |  Money: 1354  |  Experience: 7
(1) Name: Sehanine_Monnbow
      Level: 1  |  Health: 100  |  Mana: 600  |  Strength: 700  |  Agility: 800  |  Dexterity: 500  |  Money: 2500  |  Experience: 8
(2) Name: Muamman_Duathall
      Level: 1  |  Health: 100  |  Mana: 300  |  Strength: 900  |  Agility: 500  |  Dexterity: 750  |  Money: 2546  |  Experience: 6
(3) Name: Flandal_Steelskin
      Level: 1  |  Health: 100  |  Mana: 200  |  Strength: 750  |  Agility: 650  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(4) Name: Undefeated_Yoj
      Level: 1  |  Health: 100  |  Mana: 400  |  Strength: 800  |  Agility: 400  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(5) Name: Eunoia_Cyn
      Level: 1  |  Health: 100  |  Mana: 400  |  Strength: 700  |  Agility: 800  |  Dexterity: 600  |  Money: 2500  |  Experience: 6

                                                              SORCERERS
(0) Name: Rillifane_Rallathil
      Level: 1  |  Health: 100  |  Mana: 1300  |  Strength: 750  |  Agility: 450  |  Dexterity: 500  |  Money: 2500  |  Experience: 9
(1) Name: Segojan_Earthcaller
      Level: 1  |  Health: 100  |  Mana: 900  |  Strength: 800  |  Agility: 500  |  Dexterity: 650  |  Money: 2500  |  Experience: 5
(2) Name: Reign_Havoc
      Level: 1  |  Health: 100  |  Mana: 800  |  Strength: 800  |  Agility: 800  |  Dexterity: 800  |  Money: 2500  |  Experience: 8
(3) Name: Reverie_Ashels
      Level: 1  |  Health: 100  |  Mana: 900  |  Strength: 800  |  Agility: 700  |  Dexterity: 400  |  Money: 2500  |  Experience: 7
(4) Name: Kalabar
      Level: 1  |  Health: 100  |  Mana: 800  |  Strength: 850  |  Agility: 400  |  Dexterity: 600  |  Money: 2500  |  Experience: 6
(5) Name: Skye_Soar
      Level: 1  |  Health: 100  |  Mana: 1000  |  Strength: 700  |  Agility: 400  |  Dexterity: 500  |  Money: 2500  |  Experience: 5

                                                              PALADINS
(0) Name: Parzival
      Level: 1  |  Health: 100  |  Mana: 300  |  Strength: 750  |  Agility: 650  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(1) Name: Sehanine_Moonbow
      Level: 1  |  Health: 100  |  Mana: 300  |  Strength: 750  |  Agility: 700  |  Dexterity: 700  |  Money: 2500  |  Experience: 7
(2) Name: Skoraeus_Stonebones
      Level: 1  |  Health: 100  |  Mana: 250  |  Strength: 650  |  Agility: 600  |  Dexterity: 350  |  Money: 2500  |  Experience: 4
(3) Name: Garl_Glittergold
      Level: 1  |  Health: 100  |  Mana: 100  |  Strength: 600  |  Agility: 500  |  Dexterity: 400  |  Money: 2500  |  Experience: 5
(4) Name: Amaryllis_Astra
      Level: 1  |  Health: 100  |  Mana: 500  |  Strength: 500  |  Agility: 500  |  Dexterity: 500  |  Money: 2500  |  Experience: 5
(5) Name: Caliber_Heist
      Level: 1  |  Health: 100  |  Mana: 400  |  Strength: 400  |  Agility: 400  |  Dexterity: 400  |  Money: 2500  |  Experience: 8

Recruit 3 Heroes and Assemble your squad!
Select the class of Heroes you want to recruit, please type W/S/P: W
Now select the hero you want to recruit, please type their corresponding index 0~5: -
That did not look like a number, please re-enter 0~5: 0
Gaerdal_Ironhand has joined the team!
Select the class of Heroes you want to recruit, please type W/S/P: S
Now select the hero you want to recruit, please type their corresponding index 0~5: 0
Rillifane_Rallathil has joined the team!
Select the class of Heroes you want to recruit, please type W/S/P: P
Now select the hero you want to recruit, please type their corresponding index 0~5: 0
Parzival has joined the team!
+---+---+---+---+---+---+---+---+
| H | $ |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| X |   | X |   | $ | X | ? |   |
+---+---+---+---+---+---+---+---+
| ? | ? | $ | $ | X | ? |   | $ |
+---+---+---+---+---+---+---+---+
|   |   | $ | $ | X |   |   | ? |
+---+---+---+---+---+---+---+---+
| $ | X | $ | ? | ? | ? |   |   |
+---+---+---+---+---+---+---+---+
| $ | $ | $ | ? | $ | $ |   | $ |
+---+---+---+---+---+---+---+---+
|   | X |   | $ | $ | $ |   |   |
+---+---+---+---+---+---+---+---+
|   | ? | ? | $ |   |   | ? | X |
+---+---+---+---+---+---+---+---+
Welcome to this new world full of opportunity, danger, and of course, FUN! ENJOY!
H : This represents your team and they will be starting at the ? North West Corner.
X : This represents terrains of the world that have seen no one crossing them over the eons.
$ : This represents markets spread across the world, they trade supplies and loots.
? : This represents an known monster group, your team HAS TO battle once encountered.
'': This represents an unknown place, your team MAY encounter a battle once stepped in.
Do you think this is a reasonable world to play? Enter N to regenerate a world, Y to adventure: Y
RULE: The game only ends when all of your team faint. Stay Alive!
+---+---+---+---+---+---+---+---+
| H | $ |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| X |   | X |   | $ | X | ? |   |
+---+---+---+---+---+---+---+---+
| ? | ? | $ | $ | X | ? |   | $ |
+---+---+---+---+---+---+---+---+
|   |   | $ | $ | X |   |   | ? |
+---+---+---+---+---+---+---+---+
| $ | X | $ | ? | ? | ? |   |   |
+---+---+---+---+---+---+---+---+
| $ | $ | $ | ? | $ | $ |   | $ |
+---+---+---+---+---+---+---+---+
|   | X |   | $ | $ | $ |   |   |
+---+---+---+---+---+---+---+---+
|   | ? | ? | $ |   |   | ? | X |
+---+---+---+---+---+---+---+---+
Move around with W/A/S/D keys, Q to quit, I for hero status: d
+---+---+---+---+---+---+---+---+
|   | H |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| X |   | X |   | $ | X | ? |   |
+---+---+---+---+---+---+---+---+
| ? | ? | $ | $ | X | ? |   | $ |
+---+---+---+---+---+---+---+---+
|   |   | $ | $ | X |   |   | ? |
+---+---+---+---+---+---+---+---+
| $ | X | $ | ? | ? | ? |   |   |
+---+---+---+---+---+---+---+---+
| $ | $ | $ | ? | $ | $ |   | $ |
+---+---+---+---+---+---+---+---+
|   | X |   | $ | $ | $ |   |   |
+---+---+---+---+---+---+---+---+
|   | ? | ? | $ |   |   | ? | X |
+---+---+---+---+---+---+---+---+
Move around with W/A/S/D keys, Q to quit, I for hero status, M for market: M

                                                              Armors
Name: Breastplate
      Level: 3  |  Defence: 600.0  |  Price: 350.0
Name: Breastplate
      Level: 3  |  Defence: 600.0  |  Price: 350.0

                                                              Potions
Name: Mermaid_Tears
      Level: 5  |  Boost: Health/Mana/Strength/Agility for 100.0  |  Price: 850.0
Name: Luck_Elixir
      Level: 4  |  Boost: Agility for 65.0  |  Price: 500.0

                                                              Weapons
Name: Axe
      Level: 5  |  Damage: 850.0  |  Require: 1 hands |  Price: 550.0
Name: Scythe
      Level: 6  |  Damage: 1100.0  |  Require: 2 hands |  Price: 1000.0

                                                              Spells
Name: Lava_Comet
      Level: 7  |  Damage: 1000.0  |  Reduce defence by 15.0%  |  Mana cost: 550.0  |  Use: 4 times  |  Price: 800.0
Name: Hell_Storm
      Level: 3  |  Damage: 950.0  |  Reduce defence by 15.0%  |  Mana cost: 600.0  |  Use: 4 times  |  Price: 600.0
Name: Arctic_Storm
      Level: 6  |  Damage: 800.0  |  Reduce strength by 15.0%  |  Mana cost: 300.0  |  Use: 4 times  |  Price: 700.0
Name: Snow_Cannon
      Level: 2  |  Damage: 650.0  |  Reduce strength by 15.0%  |  Mana cost: 250.0  |  Use: 4 times  |  Price: 500.0
Name: Lightning_Dagger
      Level: 1  |  Damage: 500.0  |  Reduce agility by 15.0%  |  Mana cost: 150.0  |  Use: 4 times  |  Price: 400.0
Name: Spark_Needles
      Level: 2  |  Damage: 600.0  |  Reduce agility by 15.0%  |  Mana cost: 200.0  |  Use: 4 times  |  Price: 500.0
Buying or Selling? Press B to Buy, S to Sell, or Q to Leave: B
Which hero is buying? (0) Gaerdal_Ironhand, (1) Rillifane_Rallathil, (2) Parzival, Please enter their index: 0

Gaerdal_Ironhand, which item type do you want to buy?
W for Weapons
A for Armors
P for Potions
S for Spells
Please enter W/A/P/S, or Q to quit market: S

                                                              Spells
(0) Name: Lava_Comet
      Level: 7  |  Damage: 1000.0  |  Reduce defence by 15.0%  |  Mana cost: 550.0  |  Use: 4 times  |  Price: 800.0
(1) Name: Hell_Storm
      Level: 3  |  Damage: 950.0  |  Reduce defence by 15.0%  |  Mana cost: 600.0  |  Use: 4 times  |  Price: 600.0
(2) Name: Arctic_Storm
      Level: 6  |  Damage: 800.0  |  Reduce strength by 15.0%  |  Mana cost: 300.0  |  Use: 4 times  |  Price: 700.0
(3) Name: Snow_Cannon
      Level: 2  |  Damage: 650.0  |  Reduce strength by 15.0%  |  Mana cost: 250.0  |  Use: 4 times  |  Price: 500.0
(4) Name: Lightning_Dagger
      Level: 1  |  Damage: 500.0  |  Reduce agility by 15.0%  |  Mana cost: 150.0  |  Use: 4 times  |  Price: 400.0
(5) Name: Spark_Needles
      Level: 2  |  Damage: 600.0  |  Reduce agility by 15.0%  |  Mana cost: 200.0  |  Use: 4 times  |  Price: 500.0
Which item do you want to buy? Please enter their index, or Q to exit market: 4
Lightning_Dagger has been added to your inventory! Hero: Gaerdal_Ironhand has 954.00 gold left.
Do you want to continue buying? Enter Y/N: N
+---+---+---+---+---+---+---+---+
|   | H |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| X |   | X |   | $ | X | ? |   |
+---+---+---+---+---+---+---+---+
| ? | ? | $ | $ | X | ? |   | $ |
+---+---+---+---+---+---+---+---+
|   |   | $ | $ | X |   |   | ? |
+---+---+---+---+---+---+---+---+
| $ | X | $ | ? | ? | ? |   |   |
+---+---+---+---+---+---+---+---+
| $ | $ | $ | ? | $ | $ |   | $ |
+---+---+---+---+---+---+---+---+
|   | X |   | $ | $ | $ |   |   |
+---+---+---+---+---+---+---+---+
|   | ? | ? | $ |   |   | ? | X |
+---+---+---+---+---+---+---+---+
Move around with W/A/S/D keys, Q to quit, I for hero status, M for market: s
Your team encounters a team of monsters, let the battle commence!

                                 CURRENT HERO TEAM STATUS
Name: Gaerdal_Ironhand
      Level: 1  |  Health: 300.0  |  Mana: 100.0  |  Strength: 805.0  |  Defense: 0.0  |  Agility: 575.0  |  Dexterity: 600.0  |  Money: 954.0  |  Experience: 7.0/10.0
Name: Rillifane_Rallathil
      Level: 1  |  Health: 300.0  |  Mana: 1300.0  |  Strength: 750.0  |  Defense: 0.0  |  Agility: 517.5  |  Dexterity: 575.0  |  Money: 2500.0  |  Experience: 9.0/10.0
Name: Parzival
      Level: 1  |  Health: 300.0  |  Mana: 300.0  |  Strength: 862.5  |  Defense: 0.0  |  Agility: 650.0  |  Dexterity: 805.0  |  Money: 2500.0  |  Experience: 7.0/10.0

                                 CURRENT MONSTER TEAM STATUS
Name: Natsunomeryu
      Level: 1  |  Health: 100.0  |  Strength: 115.0  |  defense: 200.0  |  Agility: 10.0
Name: Blinky
      Level: 1  |  Health: 200.0  |  Strength: 450.0  |  defense: 350.0  |  Agility: 40.3
Name: Casper
      Level: 1  |  Health: 600.0  |  Strength: 100.0  |  defense: 100.0  |  Agility: 57.5


It's Gaerdal_Ironhand's turn!
                                 CURRENT HERO TEAM STATUS
Name: Gaerdal_Ironhand
      Level: 1  |  Health: 300.0  |  Mana: 100.0  |  Strength: 805.0  |  Defense: 0.0  |  Agility: 575.0  |  Dexterity: 600.0  |  Money: 954.0  |  Experience: 7.0/10.0
Name: Rillifane_Rallathil
      Level: 1  |  Health: 300.0  |  Mana: 1300.0  |  Strength: 750.0  |  Defense: 0.0  |  Agility: 517.5  |  Dexterity: 575.0  |  Money: 2500.0  |  Experience: 9.0/10.0
Name: Parzival
      Level: 1  |  Health: 300.0  |  Mana: 300.0  |  Strength: 862.5  |  Defense: 0.0  |  Agility: 650.0  |  Dexterity: 805.0  |  Money: 2500.0  |  Experience: 7.0/10.0
                                 CURRENT MONSTER TEAM STATUS
Name: Natsunomeryu
      Level: 1  |  Health: 100.0  |  Strength: 115.0  |  defense: 200.0  |  Agility: 10.0
Name: Blinky
      Level: 1  |  Health: 200.0  |  Strength: 450.0  |  defense: 350.0  |  Agility: 40.3
Name: Casper
      Level: 1  |  Health: 600.0  |  Strength: 100.0  |  defense: 100.0  |  Agility: 57.5
You may choose one of the following actions to perform:
1. Attack  |  2. Cast a spell  |  3. Use a potion  |  4. Equip an equipment: 2

                                                              Spells
(0) Name: Lightning_Dagger
      Level: 1  |  Damage: 500.0  |  Reduce agility by 15.0%  |  Mana cost: 150.0  |  Use: 4 times  |  Price: 400.0
Which spell do you want to cast? Please enter their index: 0
Which enemy do you want to cast the spell on? (0) Natsunomeryu, (1) Blinky, (2) Casper, : 0
Gaerdal_Ironhand casted Lightning_Dagger on Natsunomeryu and dealt 530.0 damage!

It's Rillifane_Rallathil's turn!
                                 CURRENT HERO TEAM STATUS
Name: Gaerdal_Ironhand
      Level: 1  |  Health: 300.0  |  Mana: 100.0  |  Strength: 805.0  |  Defense: 0.0  |  Agility: 575.0  |  Dexterity: 600.0  |  Money: 954.0  |  Experience: 7.0/10.0
Name: Rillifane_Rallathil
      Level: 1  |  Health: 300.0  |  Mana: 1300.0  |  Strength: 750.0  |  Defense: 0.0  |  Agility: 517.5  |  Dexterity: 575.0  |  Money: 2500.0  |  Experience: 9.0/10.0
Name: Parzival
      Level: 1  |  Health: 300.0  |  Mana: 300.0  |  Strength: 862.5  |  Defense: 0.0  |  Agility: 650.0  |  Dexterity: 805.0  |  Money: 2500.0  |  Experience: 7.0/10.0
                                 CURRENT MONSTER TEAM STATUS
Name: Natsunomeryu
      Level: 1  |  Health: -430.0  |  Strength: 115.0  |  defense: 200.0  |  Agility: 8.5
Name: Blinky
      Level: 1  |  Health: 200.0  |  Strength: 450.0  |  defense: 350.0  |  Agility: 40.3
Name: Casper
      Level: 1  |  Health: 600.0  |  Strength: 100.0  |  defense: 100.0  |  Agility: 57.5
You may choose one of the following actions to perform:
1. Attack  |  2. Cast a spell  |  3. Use a potion  |  4. Equip an equipment: 1
Which enemy do you want to attack? (1) Blinky, (2) Casper, : 1
Rillifane_Rallathil attacked Blinky for 715.0 damage!
Blinky has fainted!

It's Parzival's turn!
                                 CURRENT HERO TEAM STATUS
Name: Gaerdal_Ironhand
      Level: 1  |  Health: 300.0  |  Mana: 100.0  |  Strength: 805.0  |  Defense: 0.0  |  Agility: 575.0  |  Dexterity: 600.0  |  Money: 954.0  |  Experience: 7.0/10.0
Name: Rillifane_Rallathil
      Level: 1  |  Health: 300.0  |  Mana: 1300.0  |  Strength: 750.0  |  Defense: 0.0  |  Agility: 517.5  |  Dexterity: 575.0  |  Money: 2500.0  |  Experience: 9.0/10.0
Name: Parzival
      Level: 1  |  Health: 300.0  |  Mana: 300.0  |  Strength: 862.5  |  Defense: 0.0  |  Agility: 650.0  |  Dexterity: 805.0  |  Money: 2500.0  |  Experience: 7.0/10.0
                                 CURRENT MONSTER TEAM STATUS
Name: Natsunomeryu
      Level: 1  |  Health: -430.0  |  Strength: 115.0  |  defense: 200.0  |  Agility: 8.5
Name: Blinky
      Level: 1  |  Health: -515.0  |  Strength: 450.0  |  defense: 350.0  |  Agility: 40.3
Name: Casper
      Level: 1  |  Health: 600.0  |  Strength: 100.0  |  defense: 100.0  |  Agility: 57.5
You may choose one of the following actions to perform:
1. Attack  |  2. Cast a spell  |  3. Use a potion  |  4. Equip an equipment: 1
Which enemy do you want to attack? (2) Casper, : 2
Parzival attacked Casper for 852.5 damage!
Casper has fainted!

The battle has concluded!
Gaerdal_Ironhand has gained 6 experience!
Gaerdal_Ironhand has gained 100 gold!
Gaerdal_Ironhand has leveled up!
Rillifane_Rallathil has gained 6 experience!
Rillifane_Rallathil has gained 200 gold!
Rillifane_Rallathil has leveled up!
Parzival has gained 6 experience!
Parzival has gained 200 gold!
Parzival has leveled up!
+---+---+---+---+---+---+---+---+
|   | $ |   | X |   | X | X | X |
+---+---+---+---+---+---+---+---+
| X | H | X |   | $ | X | ? |   |
+---+---+---+---+---+---+---+---+
| ? | ? | $ | $ | X | ? |   | $ |
+---+---+---+---+---+---+---+---+
|   |   | $ | $ | X |   |   | ? |
+---+---+---+---+---+---+---+---+
| $ | X | $ | ? | ? | ? |   |   |
+---+---+---+---+---+---+---+---+
| $ | $ | $ | ? | $ | $ |   | $ |
+---+---+---+---+---+---+---+---+
|   | X |   | $ | $ | $ |   |   |
+---+---+---+---+---+---+---+---+
|   | ? | ? | $ |   |   | ? | X |
+---+---+---+---+---+---+---+---+
Move around with W/A/S/D keys, Q to quit, I for hero status:

