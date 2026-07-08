import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Enemy {
    int CrystalHunters = 20;
    int Breeze = 40;
    int LostSouls = 60;
    int WilloWisps = 130;
}

class Player {
    String name;
    double health;
    int crystals;
    int WindRing;
    int BreezeHearts;
    int level = 1;
    int damage = 1;
    int baseDamage = 0;
    int bonusDamage = 0;
    int baseDefense = 0;
    int bonusDefense = 0;
    int defense = 0;
}

public class Main {

    static boolean Ahmed = false;

    static Enemy enemy = new Enemy();

    static Scanner input = new Scanner(System.in);


    static Player p = new Player();

    static Random random = new Random();

    static boolean goHome = false;
    static boolean North = false;
    static boolean IvoryCastle = false;
    static boolean RainbowCloud = false;
    static boolean StormCloud = false;
    static boolean WindRing = false;
    static boolean East = false;
    static boolean West = false;

    static boolean EastAccess = true;
    static boolean SouthAccess = true;
    static boolean WestAccess = true;


    static int Hunters = random.nextInt(3) + 1;
    static int Breeze = random.nextInt(3) + 3;
    static int LostSouls = random.nextInt(3) + 5;
    static int WilloWisps = random.nextInt(3) + 7;

    static int totalTraining = 0;

    static void updateStats() {

        if (Ahmed) {
            return;
        }


        p.baseDamage = (int) (p.level * 0.3);
        p.damage = p.baseDamage + p.bonusDamage;

        p.baseDefense = (int) (p.level * 0.2);
        p.defense = p.baseDefense + p.bonusDefense;

    }

    static int AeolusHealth = 500;
    static int AelousDamage = 30;

    static String[] RainbowL = new String[3];
    static String[] RainbowR = new String[3];

    static String[] possibleColors = {
            "Red", "Blue", "Green", "Yellow", "Purple", "Orange", "Cyan", "White", "Indigo", "Pink"
    };

    static void generateRainbowCode(String[] code) {

        for (int i = 0; i < code.length; i++) {
            code[i] = possibleColors[random.nextInt(possibleColors.length)];
        }

    }

//region TextOutput

    public static void typeWriter(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();

            try {
                Thread.sleep(15); // adjust speed here
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
    //endregion


//region main class
    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true));

        p.name = "";
        p.health = 100.0;
        p.crystals = 0;
        p.WindRing = 0;
        p.BreezeHearts = 0;

        System.out.print("Please enter your name young traveller: ");
        p.name = input.nextLine();

        if (p.name.equalsIgnoreCase("Ahmed")) {

            Ahmed = true;
            p.level = 999;
            p.damage = 999;

            System.out.println("Aha has joined the game!");
        }

        typeWriter(
                "Welcome to the mystical land " + p.name + "\n" +
                        "Where all creatures lay side by side\n" +
                        "The only way to return home is to find the portal crystals\n");

        mainArea();
    }
//endregion


//region Main Area
    static void mainArea() {

        System.out.println("\n**********************************************\n");

        System.out.println("Current Health: " + p.health + " Current Crystals: " + p.crystals + " Level: " + p.level + " Damage: " + p.damage + " Your Defense: " + p.defense);
        typeWriter("To the north you have the crystal cave \n" +
                "To the east you have the land of wind \n" +
                "To the south is the endless abyss \n" +
                "And to the west is the enchanted forest \n" +
                "The training grounds is to higher your level and damage \n");

        System.out.println("Where would you like to go? (N, E, S, W, T) ");

        char direction = input.next().charAt(0);

        switch (direction) {

            case 't', 'T' -> Training();
            case 'n', 'N' -> cave();
            case 'e', 'E' -> wind();
            case 's', 'S' -> abyss();
            case 'w', 'W' -> forest();
            default -> {
                System.out.println("Invalid direction. Please choose again.");
                mainArea();
            }
        }
    }
//endregion


//region Damage

    static void takeDamage(double enemyDamage) {

        double reduction = p.defense * 0.03;

        if (reduction > 0.75) {
            reduction = 0.75;
        }

        double damageTaken = enemyDamage * (1 - reduction);

        if (damageTaken < 0) {
            damageTaken = 0;
        }

        p.health -= damageTaken;
        p.health = Math.round(p.health * 10.0) / 10.0;

        checkHealth();
    }

    //endregion


//region death
    static void checkHealth() {
        if (p.health <= 0) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("          GAME OVER");
            System.out.println("=================================");
            System.out.println("You have succumbed to your situation... As you let the cold embrace of death to take you");
            System.out.println("Do you give up? Or restart");
            System.out.println("Y or N");
            char choice = input.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {

                p.health = 100.0;
                p.bonusDefense = 0;
                p.bonusDamage = 0;
                updateStats();
                mainArea();

            } else {
                System.out.println("You have chosen to give up.");
                System.exit(0); // Ends the program
            }
        }
    }

//endregion


//region TrainingTimer

    static int runTimer(String action, int seconds) {

        for (int i = 1; i <= seconds; i++) {

            System.out.print("\r" + action + " " + i + "/" + seconds);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        return seconds;
    }

    static void sleep() {

        System.out.println("You have exhausted yourself, you laydown under a tree and sleep ");

        runTimer("Sleeping", 20);

        System.out.println("You wake up fully rested and head back to the main area.");
    }
//endregion


//region Training

    static void Training() {

        System.out.print("How many minutes do you want to train for? ");
        int minutes = input.nextInt();

        System.out.println("You begin training...");

        int limit = 180;

        // stop early if it would exceed limit
        if (totalTraining + minutes >= limit) {

            int allowed = limit - totalTraining;

            System.out.println("You are too tired to train that long!");
            System.out.println("You can only train for " + allowed + " more minutes.");

            minutes = allowed;
        }

        int completed = runTimer("Training", minutes);

        p.level += (int) (completed * 0.5);
        updateStats();

        totalTraining += completed;

        System.out.println("\nTraining complete!");
        System.out.println("Your level is now " + p.level);

        if (totalTraining >= limit) {
            totalTraining = 0;
            sleep();
        }

        mainArea();
    }

//endregion


//region North

    static void cave() {
        if (North) {
            typeWriter("The crystal has already been taken. There is nothing left to find here.");
            mainArea();
        }
        typeWriter("You enter the underground cave, the crystals on the wall shimmer, but it's too dark to see with the naked eye");
        System.out.print("Do you use a lamp? (Y/N): ");
        char lamp = input.next().charAt(0);
        if (lamp == 'y' || lamp == 'Y') {
            lampPath();
        } else {
            noLampPath();
        }
    }

    static void lampPath() {

        typeWriter("You lit the lamp making you see everything \n" +
                "But oh no! You were spotted by " + Hunters + " crystal hunters \n" +
                "Crystals hunters have 20 health points, do you \n");
        System.out.println("1 Attack them | 2 distract them | 3 Run");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1 -> attack();
            case 2 -> distract();
            case 3 -> run();
            default -> {
                System.out.println("Invalid choice.");
                lampPath();
            }
        }
    }

    static void attack() {

        System.out.println("You bravely attack the crystal hunters!");

        for (int i = 0; i < Hunters; i++) {

            enemy.CrystalHunters = 20;

            System.out.println("\nFighting Hunter " + (i + 1));

            while (enemy.CrystalHunters > 0) {

                // player attacks
                enemy.CrystalHunters -= p.damage;

                String line =
                        "Crystal HP: " + enemy.CrystalHunters +
                                " | Your HP: " + String.format("%.1f", p.health);

                System.out.print("\r" + String.format("%-50s", line));
                System.out.flush();

                // if dead, stop BEFORE enemy turn
                if (enemy.CrystalHunters <= 0) {
                    break;
                }

                // enemy attack only if still alive
                takeDamage(0.5);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                checkHealth();
            }

            System.out.println("\nHunter defeated!");
        }

        System.out.println("\nYou survived, your health is now " + p.health);

        typeWriter("You picked up the armor the hunters have been wearing, your defence increased by 10");
        p.bonusDefense += 10;
        updateStats();
        System.out.println("Your total defense is now " + p.defense);
        checkHealth();
        cave2();
    }

    static void distract() {
        typeWriter("To your dismay you managed to distract the crystal hunters and escape safely");
        cave2();
    }

    static void run() {
        typeWriter("You attempted to run but the hunter caught you and shot an arrow at you, causing you to lose some health");
        p.health -= 30;
        System.out.println("Your health is now  " + p.health);
        checkHealth();
        cave2();
    }

    static void noLampPath() {
        typeWriter("You traverse the cave in the dark, with only the crystals as your light \n" +
                "But you tripped over a crystal impaling you");

        int damage = random.nextInt(3);

        switch (damage) {
            case 0:
                p.health -= 5;
                System.out.println("You suffered a light wound)");
                break;

            case 1:
                p.health -= 10;
                System.out.println("You suffered a medium wound");
                break;

            case 2:
                p.health -= 20;
                System.out.println("you suffered a Critical hit! The crystal pierced deep into your body!");
                break;
        }

        System.out.println("Current Health: " + p.health);
        checkHealth();
        typeWriter("You dusted yourself off and continue to explore the cave");
        cave2();
    }

    static void cave2() {
        typeWriter("You found yourself at a 3 way crossroad \n" +
                "To the left is a dark passage way with whispers coming from it \n" +
                "To the center is a cave filled with more glowing crystal \n" +
                "To the right is a cave with lush plant and the sound of running water");
        System.out.println("Which path do you choose? (left, center, right) ");
        char C2path = input.next().charAt(0);

        switch (C2path) {
            case 'L', 'l' -> LeftCave();
            case 'C', 'c' -> CenterCave();
            case 'R', 'r' -> RightCave();
            default -> {
                System.out.println("Invalid path choice.");
                cave2();
            }
        }
    }

    static void LeftCave() {
        typeWriter("you traversed the dark cave, whispers echoed across the walls, you felt a cold breeze and a shiver ran down your spine \n" +
                "Suddenly you were ambushed by a group of shadow creatures, they attacked you and you took damage");
        p.health -= 80;
        System.out.println("Your health is now  " + p.health);
        checkHealth();
        typeWriter("You quickly went back to the crossroad");
        cave2();
    }

    static void CenterCave() {
        typeWriter("You entered the center cave, the crystals shimmered and you felt a sense of calm \n" +
                "You found 2 chest, one made of wood, and the other made of diamonds \n");
        System.out.println("Which one do you open? Diamonds or Wood");
        char chest = input.next().charAt(0);
        switch (chest) {
            case 'D', 'd' -> Diamonds();
            case 'W', 'w' -> Wood();
        }

    }

    static void Diamonds() {
        typeWriter("You opened the diamond chest \n" +
                "Congratulations! You found one of the portal crystals, you safely left the crystal cave");
        System.out.println("Your level increased");
        EastAccess = false;
        p.level += 10;
        p.crystals += 1;
        North = true;
        mainArea();

    }

    static void Wood() {
        typeWriter("You opened the wooden chest \n" +
                "Oh no! It was a mimic, it instantly killed you");
        p.health = 0;
        checkHealth();
    }

    static void RightCave() {
        typeWriter("You entered the right cave, the sound of running water grew louder as you ventured deeper \n" +
                "You found a small pond with a glowing flower in the center \n" +
                "You stepped closer, the flower pulsed as it healed you fully");
        p.health = 100;
        System.out.println("Your health is now: " + p.health);
        typeWriter("You went back to the crossroad");
        cave2();
    }


//endregion


//region east
    static void wind() {
        if (EastAccess) {
            System.out.println("You are too weak to go east yet. You need to explore the north first.");
            mainArea();
        }
        if (East) {
            System.out.println("The portal crystal has already been taken. There is nothing left to find here.");
            mainArea();
        }
        typeWriter("Your sore up into the land of wind, cloud mansions fill your every vison \n" +
                "You found a lavish temple, ivory pillars as high as the heavens \n" +
                "Inside at the alter you saw the portal crystal, you thought it was too easy, but suddenly the wind god Aeolus appeared before you \n");
        typeWriter(" Aeolus: \"You dear take the wind crystal? It is not for you to take, if you want it then why not make it a game? \"\n" +
                "Collect 3 pieces of the broken ring of Wind, assemble it and you have the crystal\"\n" +
                "\"What do you say?\"\n" +
                "You accepted the challenge and set off");
        CloudCrossway();
    }

    static void CloudCrossway() {
        if (p.WindRing == 3) {
            System.out.println("You have collected all 3 pieces of the Wind Ring, you return to Aeolus");
            WindRing = true;
            Aeolus();
        }
        typeWriter("After your encounter with the wind god Aeolus you venture off to find the missing ring pieces \n" +
                "You land at a cloud plateau, in front of you are three large clouds \n" +
                "To the left is a large ivory castle. The center is a cloud adorned with rainbows. And to the left is a dark storm cloud.");
        System.out.println("Which cloud do you choose? (left, center, right) ");
        char Cloud = input.next().charAt(0);
        switch (Cloud) {
            case 'L', 'l' -> IvoryCastle();
            case 'C', 'c' -> RainbowCloud();
            case 'R', 'r' -> StormCloud();
            default -> {
                System.out.println("Invalid cloud choice.");
                CloudCrossway();
            }
        }
    }

    static void IvoryCastle() {
        if (IvoryCastle) {
            System.out.println("The ivory castle has already been explored. There is nothing left to find here.");
            CloudCrossway();
        }
        typeWriter("You enter the ivory castle, ivory columns shining bright and dazzling \n" +
                "You made it to the back of the castle but the grand doors are locked with a 3 combination lock\n");
        IvoryCode();

    }

    static void IvoryCode() {

        System.out.println("Enter the 3 digit combination, enter 0 to head back and look for clues");
        int digit = input.nextInt();

        if (digit == 576) {
            typeWriter("The door opened, the ground shook by the colossal door, as you entered the chamber");
            ThroneRoom();
        } else if (digit == 0) {
            typeWriter("You head back");
            IvoryHall();
        } else
            System.out.println("Wrong combination");
        IvoryCode();
    }

    static void IvoryHall() {
        typeWriter("You head back to the main hall, in front of you ara 3 grand staircases, one leading to the left, one to the right, and one to the center");
        System.out.println("Which staircase do you choose? (left, center, right, back) ");
        char Staircase = input.next().charAt(0);
        switch (Staircase) {
            case 'L', 'l' -> IvoryLeft();
            case 'C', 'c' -> IvoryCenter();
            case 'R', 'r' -> IvoryRight();
            case 'B', 'b' -> IvoryCode();
            default -> {
                System.out.println("Invalid staircase choice.");
                IvoryHall();
            }

        }
    }

    static void IvoryLeft() {
        typeWriter("You took the left staircase, you stand in front of a room, inside there is a statue that looks like a witch, with a sign that reads \n" +
                " \"I am many in the night sky, Twinkling above, I watch over you when I sleep, I am used for magic and represent spirit, air, water, earth, and fir. What number am I?\"");
        System.out.println("You head back to the grand hall");
        IvoryHall();
    }

    static void IvoryCenter() {
        typeWriter("You took the center staircase, you stand in front of a room, inside there is a statue that looks like a man with a sword, with a sign that reads \n" +
                " \"I raise my sword up north, the son of the sea, I watch over the earth day and night high up in the heavens. What number am I?\"");
        System.out.println("You head back to the grand hall");
        IvoryHall();
    }

    static void IvoryRight() {
        typeWriter("You took the right staircase, you stand in front of a room, inside there is a statue of the vermin god, with a sign that reads \n" +
                " \"I am the lady of insects. I have eyes that see and legs that walk. What number am I?\"");
        System.out.println("You head back to the grand hall");
        IvoryHall();
    }

    static void ThroneRoom() {
        typeWriter("You entered the chamber, inside there is a chest, you open it and get 2 special item \n" +
                "The Royal Ivory Cloud Sword | +15 Damage and the Royal Ivory Cloud Armor | +10 Defense");
        p.bonusDamage += 15;
        p.bonusDefense += 10;
        updateStats();
        System.out.println("Your damage is now " + p.damage);
        System.out.println("Your defense is now " + p.defense);
        typeWriter("you continue inside and made it to the throne room. On the throne is one of the ring pieces, but it's protected by " + Breeze + "Breezes");
        typeWriter("You beavery lifted your new sword and fought them");
        Ivoryttack();
    }

    static void Ivoryttack() {

        System.out.println("You bravely attack the Breezes!");

        for (int i = 0; i < Breeze; i++) {

            enemy.Breeze = 40;

            System.out.println("\nFighting Hunter " + (i + 1));

            while (enemy.Breeze > 0) {

                // player attacks
                enemy.Breeze -= p.damage;

                String line =
                        "Breeze HP: " + enemy.Breeze +
                                " | Your HP: " + String.format("%.1f", p.health);

                System.out.print("\r" + String.format("%-50s", line));
                System.out.flush();

                // if dead, stop BEFORE enemy turn
                if (enemy.Breeze <= 0) {
                    break;
                }

                // enemy attack only if still alive
                takeDamage(2.5);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                checkHealth();
            }

            System.out.println("\nBreeze defeated!");
        }

        System.out.println("\nYou survived, your health is now " + p.health);
        typeWriter("You obtained the missing ring piece, you head back to the cloud plateau to find the other missing pieces");

        IvoryCastle = true;
        p.WindRing += 1;
        System.out.println("Wind Ring pieces are now " + p.WindRing + "\\3");
        checkHealth();
        CloudCrossway();
    }



    static void RainbowCloud() {

        if (RainbowCloud) {
            System.out.println("The rainbow cloud has already been explored. There is nothing left to find here.");
            CloudCrossway();
        }

        generateRainbowCode(RainbowL);
        generateRainbowCode(RainbowR);

        typeWriter("You enter the colorful rainbow cloud, rainbows arching across the sky. At the back you see the empress of light weeping over a cloud");
        typeWriter("Empress of Light: \"Oh traveller, I have lost the color order for my rainbow spell, could you help me remember it? \n" +
                "There are prism lying around they should help you. But remember the light always shifts so be quick!\"");
        RainbowWand();
    }

    static void RainbowWand() {
        typeWriter("You approach the rainbow wand. Enter the color order, enter E to go back and look for hints");

        String[] answer = new String[6];

        for (int i = 0; i < 3; i++) {
            answer[i] = RainbowL[i];
        }

        for (int i = 0; i < 3; i++) {
            answer[i + 3] = RainbowR[i];
        }

        String[] guess = new String[6];

        for (int i = 0; i < 6; i++) {

            System.out.print("Color " + (i + 1) + ": ");
            String inputValue = input.next();

            if (inputValue.equalsIgnoreCase("E")) {
                RainbowField();
                return;
            }

            guess[i] = inputValue;
        }

        for (int i = 0; i < 6; i++) {

            String correct = answer[i];
            String guessValue = guess[i];

            if (!(guessValue.equalsIgnoreCase(correct) ||
                    guessValue.equalsIgnoreCase(correct.substring(0, 1)))) {

                System.out.println("Incorrect color order, the light shifts and the colors change, you must try again");

                generateRainbowCode(RainbowL);
                generateRainbowCode(RainbowR);

                RainbowField();
                return;
            }
        }

        System.out.println("The rainbow wand erupts with radiant light!");
        EmpressLightRing();
    }

    static void RainbowField() {
        typeWriter("You head back to the rainbow field, rainbows and prisms scattered everywhere \n" +
                "You can go left, or right");
        System.out.println("Which way do you go? (left, right, Back) ");
        char direction = input.next().charAt(0);
        switch (direction) {
            case 'L', 'l' -> RainbowLeft();
            case 'R', 'r' -> RainbowRight();
            case 'B', 'b' -> RainbowWand();
            default -> {
                System.out.println("Invalid direction choice.");
                RainbowField();
            }
        }
    }

    static void RainbowLeft() {
        typeWriter("You head left, on a small ivory column you find a prism shard, on it the number 1 is etched in the column, light shines throw it as a small rainbow appears");

        for (String c : RainbowL) {
            System.out.println(c);
        }

        RainbowField();
    }

    static void RainbowRight() {
        typeWriter("You head right, on a small ivory column you find a prism shard, on it the number 2 is etched in the column, light shines throw it as a small rainbow appears");

        for (String c : RainbowR) {
            System.out.println(c);
        }
        RainbowField();
    }

    static void EmpressLightRing() {
        typeWriter("The Empress of Light gleams with joy as raises the rainbow wand and hundreds and thousands of rainbow shoots out, painting the skt in radiant colors. \n" +
                "\"Oh thank you traveller, you have restored my rainbow spell, as a reward I will give you this trinket I found, it could be of use to you\"");
        p.WindRing += 1;
        System.out.println("Wind Ring pieces are now " + p.WindRing + "\\3");
        RainbowCloud = true;
        CloudCrossway();
    }



    static void StormCloud() {
        if (StormCloud) {
            System.out.println("The storm cloud has already been explored. There is nothing left to find here.");
            CloudCrossway();
        }
        typeWriter("You enter the dark storm cloud, lightning crackling in the distance, in the center there is a large stone temple, the sound of lighting crackling from within \n " +
                "You enter the temple and inside you find Thor training with his hammer the Wind ring pice framed on the wall, as he catches you eyeing it");
        typeWriter("Thor: \"You dare disturb Thor son of Odin? If you want that pice of junk You must prove your worth by fetching me 5 breeze hearts and the ring is yours\"\n" +
                "\"Head to the dungeon and fetch me the hearts\"");
        DungeonEntrance();
    }

    static void DungeonEntrance() {
        typeWriter("You go forward and head to the entrance of the dungeon, the sounds of howling winds grows stronger");
        typeWriter("Inside the dungeon you can go left to fight the endless horde of breeze, to your right is a room with a pound that would heal you of all your wound");
        System.out.println("The chances of getting a breeze heart is 10% tread carefully");
        System.out.println("Your hp is " + p.health);
        System.out.println("Which way do you go? (left, right)");
        char direction = input.next().charAt(0);
        switch (direction) {
            case 'L', 'l' -> Dungeon();
            case 'R', 'r' -> HealingPond();
            default -> {
                System.out.println("Invalid direction choice.");
                DungeonEntrance();
            }
        }
    }

    static void Dungeon() {
        System.out.println("You enter the dungeon there are " + Breeze + " Breezes");

        for (int i = 0; i < Breeze; i++) {

            enemy.Breeze = 40;

            System.out.println("\nFighting Breeze " + (i + 1));

            while (enemy.Breeze > 0) {

                // player attacks
                enemy.Breeze -= p.damage;

                String line =
                        "Breeze HP: " + enemy.Breeze +
                                " | Your HP: " + String.format("%.1f", p.health);

                System.out.print("\r" + String.format("%-50s", line));
                System.out.flush();

                // if dead, stop BEFORE enemy turn
                if (enemy.Breeze <= 0) {
                    break;
                }

                // enemy attack only if still alive
                takeDamage(2.5);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                checkHealth();
            }

            System.out.println("\nBreeze defeated!");

            if (ThreadLocalRandom.current().nextInt(100) < 10) {
                System.out.println("The Breeze dropped a heart");
                p.BreezeHearts += 1;
                if (p.BreezeHearts == 5) {
                    System.out.println("You have collected all 5 Breeze Hearts!");
                    ThorRing();
                    return;
                }
            } else {
                System.out.println("The breeze didn't drop a heart");
            }
            System.out.println("You have " + p.BreezeHearts + " Breeze Hearts.");

        }


        DungeonEntrance();
    }

    static void HealingPond() {
        typeWriter("You enter the healing pond, you drink from the pond and feel your wounds heal");
        p.health = 100;
        System.out.println("Your health is now " + p.health);
        DungeonEntrance();
    }

    static void ThorRing() {
        typeWriter("You return to Thor with the 5 Breeze Hearts");
        typeWriter("Thor: \"AHA! You have proven your worth, here is the Wind Ring piece, may it serve you well\"\n" +
                "\"And here is a little bonus\"");
        p.WindRing += 1;
        p.health = 100;
        p.bonusDamage += 20;
        p.bonusDefense += 20;
        updateStats();

        StormCloud = true;
        System.out.println("Your health is now " + p.health);
        System.out.println("Your damage is now " + p.damage);
        System.out.println("Your defense is now " + p.defense);
        CloudCrossway();
    }

    static void Aeolus() {
        typeWriter("Aeolus: \"You dare to defy me To make me feel shame? No one beats me, no one wins my game, \" \n ");
        typeWriter("\"wind bring them through the wringer\" \n");
        typeWriter("Show them I'm the judgement call The one who makes her kingdom fall\"");
        System.out.println("You enter a fight with Aeolus");
        AeolusFight();
    }

    static void AeolusFight() {
        System.out.println("You are fighting Aeolus, the wind god");

        int i = 0;

        while (AeolusHealth > 0) {

            if (i > 0 && i % 5 == 0) {
                System.out.println("You feel the power of determination rush into you\n" +
                        "Your damage increases");
                p.bonusDamage += 10;
                updateStats();
                System.out.println("Your damage is now " + p.damage);
            }

            System.out.println("Your HP: " + p.health + " | Aeolus HP: " + AeolusHealth + " | Your Damage: " + p.damage + " | Aeolus Damage: " + AelousDamage);
            System.out.println("Press 1 to attack | 2 to defend | 3 to heal");
            char choice = input.next().charAt(0);
            switch (choice) {
                case '1' -> {

                    int Attack = random.nextInt(3);

                    switch (Attack) {
                        case 0:
                            AeolusHealth -= p.damage;
                            typeWriter("You struck Aeolus!");
                            System.out.println("Aeolus's HP is now " + AeolusHealth);

                            typeWriter("Aeolus fights back!");
                            takeDamage(AelousDamage);
                            System.out.println("Your HP is now " + p.health);

                            break;


                        case 1:
                            AeolusHealth -= p.damage + 10;
                            typeWriter("You hit a hard hit on Aeolus!");
                            System.out.println("Aeolus's HP is now " + AeolusHealth);

                            typeWriter("Aeolus fights back!");
                            takeDamage(AelousDamage);
                            System.out.println("Your HP is now " + p.health);

                            break;

                        case 2:
                            AeolusHealth -= p.damage + 20;
                            typeWriter("You hit a critical hit on Aeolus!");
                            System.out.println("Aeolus's HP is now " + AeolusHealth);

                            System.out.println("Aeolus fights back!");
                            takeDamage(AelousDamage);
                            System.out.println("Your HP is now " + p.health);

                            break;
                    }

                    checkHealth();
                }
                case '2' -> {
                    System.out.println("You defended against Aeolus's attack");
                    int defended = random.nextInt(3);

                    switch (defended) {
                        case 0:
                            takeDamage(AelousDamage - 5);
                            typeWriter("You blocked Aeolus attack!)");
                            System.out.println("Your HP is now " + p.health);
                            break;

                        case 1:
                            takeDamage(AelousDamage - 10);
                            typeWriter("You hit a hard blocked against Aeolus attack!)");
                            System.out.println("Your HP is now " + p.health);
                            break;

                        case 2:
                            takeDamage(AelousDamage - 20);
                            typeWriter("You hit a critical blocked against Aeolus attack!)");
                            System.out.println("Your HP is now " + p.health);
                            break;
                    }

                    System.out.println("Current Health: " + p.health);
                    checkHealth();
                }
                case '3' -> {
                    typeWriter("You cupped your hand in prayer, determination filled you of your travels as you got healed");
                    p.health = 100;
                    System.out.println("Aeolus fights!");
                    takeDamage(AelousDamage - 10);
                    System.out.println("Your HP is now " + p.health);
                }
                default -> {
                    typeWriter("You falter in your attack, Aeolus takes advantage and hits a critical hit");
                    takeDamage(AelousDamage + 20);
                    System.out.println("Your HP is now " + p.health);
                }
            }
            if (p.health <= 0) break;
            i++;
        }

        int bonusAdded = (i / 5) * 10;

        p.bonusDamage -= bonusAdded;
        updateStats();

        typeWriter("You have defeated Aeolus, the wind god");
        typeWriter("Aeolus: \"Ugh, take it. I have better things to waist my powers on\"");
        p.crystals += 1;
        p.level += 20;
        p.bonusDefense += 20;
        p.health = 100;
        East = true;
        SouthAccess = true;
        mainArea();
    }

//endregion


//region south
    static void abyss() {
        if (SouthAccess) {
            System.out.println("You are too weak to go south yet. You need to explore the east first.");
            mainArea();
        }
        System.out.println("WIP");
    }
//endregion


//region west
    static void forest() {
        if (WestAccess) {
            System.out.println("You are too weak to go west yet. You need to explore the south first.");
            mainArea();
        }
        System.out.println("WIP");
    }
//endregion


}
