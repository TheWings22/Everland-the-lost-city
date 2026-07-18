import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Enemy {
    int CrystalHunters = 50;
    int Breeze = 100;
    int LostSouls = 150;
    int WilloWisps = 200;
}

class Player {
    String name;
    double health;
    int crystals;
    int WindRing;
    int BreezeHearts;
    int level = 1;
    int damage = 1;
    int Magic = 1;
    int Healing;
    int damageAccuracy = -1;
    int baseDamage = 0;
    int bonusDamage = 0;
    double DamageAccuracyBonus = 0;
    int baseDefense = 0;
    int bonusDefense = 0;
    int defense = 0;
    int Money = 0;
    int ElationCoin = 0;
    int MaskOfElation = 0;
}

public class Main {

    static boolean Ahmed = false;

    static Enemy enemy = new Enemy();

    static Scanner input = new Scanner(System.in);


    static Player p = new Player();

    static Random random = new Random();

    static boolean North = false;
    static boolean IvoryCastle = false;
    static boolean RainbowCloud = false;
    static boolean StormCloud = false;
    static boolean WindRing = false;
    static boolean East = false;
    static boolean West = false;
    static boolean TrainingCap = false;
    static boolean Flowery = true;
    static boolean CaveShop = true;
    static boolean CaveShopHint = true;

    static boolean CaveShopSword = true;
    static boolean CaveShopArmor = true;

    static volatile boolean pressed = false;
    static volatile boolean Minepressed = false;
    static boolean accuracyRunning = false;
    static boolean accuracyMining = false;
    static boolean miningExit = false;

    static boolean EastAccess = true;
    static boolean SouthAccess = true;
    static boolean WestAccess = true;


    static int Hunters = random.nextInt(3) + 1;
    static int Breeze = random.nextInt(3) + 3;
    static int LostSouls = random.nextInt(3) + 5;
    static int WilloWisps = random.nextInt(3) + 7;


    static int Coal = 0;
    static int Iron = 0;
    static int Gold = 0;
    static int Diamond = 0;
    static int Ruby = 0;
    static int Obsidian = 0;
    static int Amethyst = 0;
    static int MiningAccuracy = 0;

    static int pickaxeLuck = 0;
    static int pickaxeTier = 0;

    static boolean IronPik = true;
    static boolean GoldPik = true;
    static boolean DiamondPik = true;
    static boolean RubyPik = true;
    static boolean EmeraldPik = true;
    static boolean CharoitePik = true;

    static int totalTraining = 0;

    static void updateStats() {

        if (Ahmed) {
            return;
        }


        p.baseDamage = Math.max(1, (int) (p.level * 0.3));
        p.damage = p.baseDamage + p.bonusDamage + (int) Math.ceil(p.DamageAccuracyBonus);

        p.baseDefense = (int) (p.level * 0.2);
        p.defense = p.baseDefense + p.bonusDefense;


        p.Magic = Math.max(1, (int) (p.level * 0.5));
        p.Healing = Math.max(5, (int) (p.Magic * 1.5 + 5));


    }

    static int AeolusHealth = 500;
    static int AeolusDamage = 50;

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

    static String[] Inventory = new String[10];

//region TextOutput

    public static void typeWriter(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();

            try {
                Thread.sleep(0); // adjust speed here
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
    //endregion


//region EastCode

    static int Room1 = random.nextInt(10);
    static int Room2 = random.nextInt(10);
    static int Room3 = random.nextInt(10);

    static int EastCode = Integer.parseInt(Room1 + "" + Room2 + "" + Room3);


//endregion


//region EastRooms

    private static void EastRooms(int roomNumber) {
        int Room = roomNumber;

        switch (Room) {
            case 0:
                Room0();
                break;
            case 1:
                Room1();
                break;
            case 2:
                Room2();
                break;
            case 3:
                Room3();
                break;
            case 4:
                Room4();
                break;
            case 5:
                Room5();
                break;
            case 6:
                Room6();
                break;
            case 7:
                Room7();
                break;
            case 8:
                Room8();
                break;
            case 9:
                Room9();
                break;
        }
    }

    private static void Room0() {
        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room0Explore();
        } else if (choice == 2) {
            Room0Statue();
        }
    }

    private static void Room0Explore() {

        typeWriter("The room feels cold, desolate and quite, darkness fills your every vision");
        Room0Statue();
    }

    private static void Room0Statue() {
        typeWriter("The statue of a warrior draped in black and white cloth, a sword on their hips, on it a sign reads");
        typeWriter("\"Now I have become death the destroyer of worlds, I am the enemy of life, I am the end of all things, the Nihility to Beauty\"\n" +
                "What number am I?");
        IvoryHall();
    }

    private static void Room1() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room1Explore();
        } else if (choice == 2) {
            Room1Statue();
        }
    }

    private static void Room1Explore() {

        typeWriter("The room is adored in renaissance celestial imagery. Rich blue walls and shimmering golden stars \n" +
                "On the back wall lies a small soft flowing waterfall");
        Room1Statue();
    }

    private static void Room1Statue() {
        typeWriter("The statue is of a beautiful silver women, on it a sign reads");
        typeWriter("\" I watch from the heavens, guiding all lost souls under the coven of night.\" \n" +
                "\"I come and go, appear and disappear, as I push and pull the oceans\" \n" +
                "What number am I?");
        IvoryHall();
    }

    private static void Room2() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room2Explore();
        } else if (choice == 2) {
            Room2Statue();
        }
    }

    private static void Room2Explore() {

        typeWriter("The room is adored in renaissance celestial imagery. Rich blue walls and shimmering golden stars \n");
        Room2Statue();
    }

    private static void Room2Statue() {
        typeWriter("The statue are twin warriors, one in silver, one in gold, their blade's intertwined with each other\n" +
                "On it a sign reads");
        typeWriter("\"I am the sun, and I am the moon, I am Yin and I am Yang, I govern the balance of life, the passion of love\"\n" +
                "What number am I?");
        IvoryHall();
    }

    private static void Room3() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room3Explore();
        } else if (choice == 2) {
            Room3Statue();
        }
    }

    private static void Room3Explore() {

        typeWriter("The room is cold, the walls dazzle with ice crystals, the ceiling painted with many moons\n" +
                "Some full, some crescents, some gibbous");
        Room3Statue();
    }

    private static void Room3Statue() {
        typeWriter("The statue is an old witch, her hat long and crooked");
        typeWriter("\"I play like the Maiden, I love like the Mother, and I think like the Crone, I am the circle of life and the interconnectedness of nature\"\n" +
                "What number am I?");
        IvoryHall();
    }

    private static void Room4() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room4Explore();
        } else if (choice == 2) {
            Room4Statue();
        }

    }

    private static void Room4Explore() {

        typeWriter("The room is humid, wooden planks adorn the walls, seashells and rocks scattered around, and compass lying around");
        Room4Statue();
    }

    private static void Room4Statue() {
        typeWriter("The statue looks like a pirate, a hand holding a compass, and the other planting a flag, the sign reads");
        typeWriter("\"I travel the sea with the sky, I use the little dipper to find treasure\"\n" +
                "I use the Crux to find land, and I use the sun's birth and death to find my bearings\"\n" +
                "What number am I?");
        IvoryHall();
    }

    private static void Room5() {
        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room5Explore();
        } else if (choice == 2) {
            Room5Statue();
        }
    }

    private static void Room5Explore() {
        typeWriter("The room is dark, only lit up by candles on the walls, on the walls there are paintings of symbols \n" +
                "runes, sigils, and other random symbols, you feel an odd energy coming from them \n" +
                "The ceiling is painted to be the night sky, with stars and constellations shimmering and sparkling");
        Room5Statue();

    }

    private static void Room5Statue() {
        typeWriter("The statue looks like a witch, under it, it looks like a summoning circle, with a sign that reads \n" +
                " \"I am many in the night sky, Twinkling above, I watch over you when I sleep, I am used for magic and connect the elements. What number am I?\"");
        IvoryHall();
    }

    private static void Room6() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room6Explore();
        } else if (choice == 2) {
            Room6Statue();
        }
    }

    private static void Room6Explore() {

        typeWriter("The room is adorned with neon lights flashing, playing cards, poker chips, and dices lying around\n");
        Room6Statue();
    }

    private static void Room6Statue() {

        typeWriter("The statue is a handsome man in a suit, a hat covering his face, a comedy mask hanging from his fingers, he sign reads");
        typeWriter("\"I cast the dice of fate, I laugh at the face of sadness and cry at the face of laughter, I am elation and I am chance\"\n" +
                "\"What side of dice you'll get who knows?\" What number am I? ");
        IvoryHall();
    }

    private static void Room7() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room7Explore();
        } else if (choice == 2) {
            Room7Statue();
        }

    }

    private static void Room7Explore() {

        typeWriter("The room is cold, chilly even, the walls have stars all over, bright and shimmering, the ceiling painted like a galaxy \n" +
                "On the walls are painting of 2 twin bears in dance, one bigger and one smaller, near the tail of the smaller bear is a bright point \n" +
                "The back wall has a giant glowing star high up");
        Room7Statue();
    }

    private static void Room7Statue() {
        typeWriter("The statue in the center look like of 2 twins, one older one younger, draped in bear fur. On it a sign reads\n" +
                " \"I sleep in the heavens with my little brother\" \t \"I sleep in the heavens with my great brother\" " +
                " \"I shine bright with points in the night sky\" \t \"I help people point at north, what number am I?\"");
        IvoryHall();
    }

    private static void Room8() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room8Explore();
        } else if (choice == 2) {
            Room8Statue();
        }

    }

    private static void Room8Explore() {

        typeWriter("The room is humid air thick with the smell of rain and mud, on the wall are framed taxidermy insects \n" +
                "The walls and ceiling are covered in a tapestry of interlinked string and yarn");
        Room8Statue();

    }

    private static void Room8Statue() {
        typeWriter("The statue looks like the vermin god, covered with insects of all shaped, adorned with a crown of butterfly wings, with a sign that reads \n" +
                " \"I am the spinner of fate, I have many legs to help me walk.\" \n" +
                " \"I am the weave maker of the word and have many eyes that help me see. What number am I?\"");
        IvoryHall();
    }

    private static void Room9() {

        System.out.println("1. Explore the room | 2. Go to the statue");
        int choice = input.nextInt();
        if (choice == 1) {
            Room9Explore();
        } else if (choice == 2) {
            Room9Statue();
        }
    }

    private static void Room9Explore() {

        typeWriter("The room smells of lavender and vanilla, yarn balls and catnip lying everywhere");
        Room9Statue();
    }

    private static void Room9Statue() {

        typeWriter("The statue is a cat, sitting on a pile of yarn balls, a sign reads");
        typeWriter("\"I represent death, and magic, I always leave but I comeback everytime\"\n" +
                "What number am I?");
        IvoryHall();
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
        p.Money = 0;
        p.ElationCoin = 0;
        p.MaskOfElation = 0;


        System.out.print("Please enter your name young traveller: ");
        p.name = input.nextLine();

        if (p.name.equalsIgnoreCase("Ahmed")) {

            Ahmed = true;
            p.level = 999;
            p.damage = 999;
            p.Healing = 999;
            p.Money = 999;
            p.defense = 999;
            p.Money = 999999999;

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

        System.out.println("Current Money is: " + p.Money + " Current Heath: " + p.health + " Current Crystals: " + p.crystals + "\n" +
                " Level: " + p.level + " Damage: " + p.damage + " Your Defense: " + p.defense + " Your magic level is " + p.Magic);
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


//region Damage/Attack

    static void takeDamage(double enemyDamage) {

        double reduction = p.defense * 0.02;

        if (reduction > 0.50) {
            reduction = 0.50;
        }

        double damageTaken = enemyDamage * (1 - reduction);

        if (damageTaken < 0) {
            damageTaken = 0;
        }

        p.health -= damageTaken;
        p.health = Math.round(p.health * 10.0) / 10.0;

        checkHealth();
    }

    static void Accuracy() {

        p.damageAccuracy = -1;
        p.DamageAccuracyBonus = 0;
        updateStats();

        pressed = false;

        double time = 3.00;

        DecimalFormat df = new DecimalFormat("0.00");


        Thread inputThread = new Thread(() -> {
            try {

                while (!pressed) {

                    if (System.in.available() > 0) {

                        int key = System.in.read();

                        if (key == '\n' || key == '\r') {
                            pressed = true;
                            break;
                        }
                    }

                    Thread.sleep(1);
                }

            } catch (Exception e) {

            }

        });


        inputThread.start();


        while (time >= 0.00 && !pressed) {

            System.out.print("\rTime: " + df.format(time));
            System.out.flush();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            time = Math.round((time - 0.01) * 100.0) / 100.0;
        }


        try {
            inputThread.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println();


        if (pressed) {

            double accuracy = Math.abs(time);

            if (accuracy <= 0.05)
                p.damageAccuracy = 30;
            else if (accuracy <= 0.10)
                p.damageAccuracy = 28;
            else if (accuracy <= 0.20)
                p.damageAccuracy = 22;
            else if (accuracy <= 0.50)
                p.damageAccuracy = 20;
            else if (accuracy <= 0.80)
                p.damageAccuracy = 13;
            else if (accuracy <= 1.00)
                p.damageAccuracy = 11;
            else
                p.damageAccuracy = 10;


        } else {

            p.damageAccuracy = -1;
            System.out.println("Attack missed");

        }


        // Clear leftover Enter key
        try {

            while (System.in.available() > 0) {
                System.in.read();
            }

        } catch (Exception e) {

        }

    }

    static void Attack() {
        if (p.damageAccuracy == -1) {
            p.DamageAccuracyBonus = 0;
            updateStats();
        } else {
            p.DamageAccuracyBonus = ((p.damage * p.damageAccuracy) / 20.0);

            updateStats();


        }
    }


//endregion


//region GnomeMine

    static void GnomeMine() {

        Minepressed = false;
        miningExit = false;

        MiningAccuracy = -1;


        double time = 3.00;

        DecimalFormat df = new DecimalFormat("0.00");


        Thread inputThread = new Thread(() -> {

            try {

                while (!Minepressed && !miningExit) {

                    if (System.in.available() > 0) {

                        int key = System.in.read();


                        if (key == '\n' || key == '\r') {

                            Minepressed = true;
                            break;

                        }


                        if (key == 'e' || key == 'E') {

                            miningExit = true;
                            break;

                        }

                    }

                    Thread.sleep(1);

                }


            } catch (Exception e) {

            }

        });


        inputThread.start();



        while (time >= 0.00 && !Minepressed && !miningExit) {

            System.out.print("\rTime: " + df.format(time));
            System.out.flush();


            try {

                Thread.sleep(10);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }


            time = Math.round((time - 0.01) * 100.0) / 100.0;

        }



        try {

            inputThread.join(100);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }



        // Player pressed E
        if (miningExit) {


            try {

                while (System.in.available() > 0) {

                    System.in.read();

                }

            } catch (Exception e) {

            }


            return;

        }



        System.out.println();



        if (Minepressed) {


            double accuracy = Math.abs(time);

            int miningQuality;


            if (accuracy <= 0.05) {

                miningQuality = 100;

            } else if (accuracy <= 0.10) {

                miningQuality = 85;

            } else if (accuracy <= 0.20) {

                miningQuality = 70;

            } else if (accuracy <= 0.50) {

                miningQuality = 50;

            } else if (accuracy <= 1.00) {

                miningQuality = 25;

            } else {

                miningQuality = 10;

            }


            MineOres(miningQuality, pickaxeLuck);


        } else {


            System.out.println("You smashed the rock to pieces. The gemstone disintegrated.");


        }


        // Clear leftover Enter key
        try {

            while (System.in.available() > 0) {

                System.in.read();

            }

        } catch (Exception e) {

        }

    }
    static void MineOres(int quality, int luck) {

        int roll = random.nextInt(100);

        // Pickaxe luck pushes the roll toward rarer ores
        roll = Math.min(roll + luck, 99);


        if (roll < 40) {

            System.out.println("Coal was found");
            Coal++;

        } else if (roll < 65) {

            System.out.println("Iron was found");
            Iron++;

        } else if (roll < 80) {

            System.out.println("Gold was found");
            Gold++;

        } else if (roll < 90 + quality / 20) {

            System.out.println("Obsidian was found");
            Obsidian++;

        } else if (roll < 96 + quality / 25) {

            System.out.println("Amethyst was found");
            Amethyst++;

        } else if (roll < 99 + quality / 50) {

            System.out.println("Diamond was found");
            Diamond++;

        } else {

            System.out.println("Ruby was found");
            Ruby++;

        }
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
            System.out.println("Give Up or Restart (G|R)");
            char choice = input.next().charAt(0);
            if (choice == 'R' || choice == 'r') {

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

    static class TimedScanner {

        private String input = null;

        public String readLine(int seconds) {

            Thread inputThread = new Thread(() -> {
                Scanner tempScanner = new Scanner(System.in);
                input = tempScanner.nextLine();
            });

            inputThread.start();


            try {
                inputThread.join(seconds * 1000);

            } catch (InterruptedException e) {

            }


            if (input == null) {
                return null; // no input received
            }

            return input;
        }
    }

//region Timer

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

//endregion


//region Training

    static void Training() {

        if (TrainingCap) {
            System.out.println("The training grounds in inaccessible, come back later");
            mainArea();
        }

        System.out.println("You begin training...");

        int minutes = 20;

        int completed = runTimer("Training", minutes);

        p.level += (int) (completed * 0.5);
        updateStats();

        totalTraining += completed;

        System.out.println("\nTraining complete!");
        System.out.println("Your level is now " + p.level);

        TrainingCap = true;

        mainArea();
    }

//endregion


//region North

    static void cave() {
        if (North) {
            typeWriter("The crystal has already been taken. There is nothing left to find here.");
            mainArea();
            return;
        }
        typeWriter("You enter the underground cave, the crystals on the wall shimmer, but it's too dark to see with the naked eye");
        System.out.print("Do you use a lamp? (Y/N): ");
        char lamp = input.next().charAt(0);
        input.nextLine();
        switch (lamp) {
            case 'Y', 'y' -> lampPath();
            case 'N', 'n' -> noLampPath();
            default -> {
                typeWriter("Invalid input. Please try again.");
                cave();
            }

        }
    }

    static void lampPath() {

        typeWriter("You lit the lamp making you see everything \n" +
                "But oh no! You were spotted by " + Hunters + " crystal hunters \n" +
                "Crystals hunters have " + enemy.CrystalHunters + " health points\n");
        CaveAttack();
    }

    static void CaveAttack() {

        System.out.println("Press enter when the timer is close to 0.00  to get damage bonus");

        for (int i = 0; i < Hunters; i++) {

            int HeavyAttack = 0;

            int CrystalHuntersHP = enemy.CrystalHunters;

            System.out.println("\nFighting Hunter " + (i + 1));

            while (CrystalHuntersHP > 0) {

                HeavyAttack++;


                System.out.println("Crystal HP: " + CrystalHuntersHP +
                        " | Your HP: " + String.format("%.1f", p.health));

                if (HeavyAttack == 4) {
                    typeWriter("Crystal hunter prepares for a heavy attack");
                }

                System.out.println("| 1 Fight | 2 Defend | 3 Prayer heal ");

                String choice = input.nextLine();

                if (HeavyAttack == 5) {
                    typeWriter("Crystal hunter unleashes a heavy attack");
                    switch (choice) {
                        case "1":
                            Accuracy();
                            Attack();
                            if (p.damageAccuracy == -1) {

                                takeDamage(10);

                            } else {

                                CrystalHuntersHP -= p.damage;
                                takeDamage(10);
                            }
                            break;
                        case "2":
                            takeDamage(3);
                            break;
                        case "3":

                            p.health += p.Healing;
                            if (p.health > 100) {
                                p.health = 100;
                            }
                            typeWriter("You tried to heal, but you faltered");
                            takeDamage(10);

                            checkHealth();

                            break;


                    }

                    HeavyAttack = 0;

                } else {
                    switch (choice) {
                        case "1":
                            Accuracy();
                            Attack();
                            if (p.damageAccuracy == -1) {

                                takeDamage(5);

                            } else {

                                CrystalHuntersHP -= p.damage;
                                takeDamage(5);
                            }
                            break;
                        case "2":
                            takeDamage(2);
                            break;
                        case "3":

                            p.health += 10;
                            if (p.health > 100) {
                                p.health = 100;
                            }
                            takeDamage(5);
                            checkHealth();

                            break;


                    }
                }

                checkHealth();


            }

            System.out.println("\nHunter defeated!");

            int intervals = 3;

            int randomValue = (random.nextInt(intervals) + 1) * 5;

            p.Money += randomValue;

            System.out.println("Hunter dropped " + randomValue + " coins");


        }

        System.out.println("\nYou survived, your health is now " + p.health);

        typeWriter("You picked up the armor the hunters have been wearing, your defence increased by 10");
        p.bonusDefense += 10;
        updateStats();
        System.out.println("Your total defense is now " + p.defense);
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
        if (CaveShop) {
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
            return;
        }
        typeWriter("You found yourself at a 3 way crossroad \n" +
                "To the left is the shop\n" +
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
        if (CaveShop) {
            typeWriter("you traversed the dark cave, whispers echoed across the walls, you felt a cold breeze and a shiver ran down your spine \n" +
                    "You felt the looming present of an entity, you thought it was an enemy but then the lights came on and it was just a mannequin \n" +
                    "In front of you lies a small shop, the shopkeeper having a kind face");
            typeWriter("\"Oh sorry there traveler, I didn't mean to scare you, I was just fixing the lights hehe\"");

            CaveShopFirstTime();
            return;
        }
        CaveShopFirstTime();
    }


    static void CaveShopFirstTime() {

        if (CaveShopHint) {
            CaveShop = false;
            typeWriter("\"Is there anything of interest I could be of use to you?\"");
            System.out.println("| 1 talk | 2 buy items | 3 leave shop ");


            TimedScanner timed = new TimedScanner();

            String answer = timed.readLine(60);


            if (answer == null) {
                typeWriter("...");
                SecretBossHint();
                return;
            }


            int choice = Integer.parseInt(answer);


            switch (choice) {

                case 1 -> ShopTalk();

                case 2 -> ShopBuy();

                case 3 -> cave2();

                default -> {
                    System.out.println("Invalid choice.");
                    CaveShopFirstTime();
                }
            }

            CaveShopHint = false;

        } else {

            CaveShop();

        }
    }


    static void CaveShop() {
        typeWriter("\"Is there anything of interest I could be of use to you?\"");
        System.out.println("| 1 talk | 2 buy items | 3 leave shop ");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> ShopTalk();
            case 2 -> ShopBuy();
            case 3 -> {
                typeWriter("\"Take care\"");
                cave2();
            }
            default -> {
                System.out.println("Invalid choice.");
                CaveShop();
            }
        }

    }

    static void ShopTalk() {
        typeWriter("\"What do you want to talk about?\"");
        System.out.println("| 1 What is this place? | 2 Who are you? | 3 How do I get out | 4 How do I get more money |5 go back");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                typeWriter("\"This world was created by twins... At least that's what he says, no one has seen the other one since he decided to defy fate....or even remember their name\"\n" +
                        "\"even the history books didn't cover it hehe. Why don't you ask him yourself for why they created this world");
                ShopTalk();
            }
            case 2 -> {
                typeWriter("\"Who me? Hehe, I am just a shopkeeper, that's all I am, nothing much");
                ShopTalk();
            }
            case 3 -> {
                typeWriter("\"To get out, you need to find special crystals scattered throughout this world. They will help unlock the dark fountain and ultimately send you back.\"");
                ShopTalk();
            }
            case 4 -> {
                typeWriter("\"Past my shop in the center passages there should be a civilisation of gnomes, you could ask them for money... or steal it hehe");
                ShopTalk();
            }
            case 5 -> {
                CaveShop();
            }
            default -> {
                System.out.println("Invalid choice.");
                ShopTalk();
            }
        }
    }

    static void ShopBuy() {
        typeWriter("\"What do you need?\"");
        System.out.println("| 1 Buy wooden sword (10 Money | +5 dmg) | 2 Buy wooden armor (20 Money | +15 def) | 3 Go back");
        System.out.println("Your money is: " + p.Money);
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                if (CaveShopSword) {
                    if (p.Money >= 10) {
                        p.Money -= 10;
                        p.bonusDamage += 5;
                        System.out.println("You bought the wooden sword.");
                        CaveShopSword = false;
                    } else {
                        System.out.println("You don't have enough money.");
                    }
                    ShopBuy();
                }
                typeWriter("\"Sorry, it's out of stock\"");
                ShopBuy();

            }
            case 2 -> {
                if  (CaveShopArmor) {
                    if (p.Money >= 20) {
                        p.Money -= 20;
                        p.bonusDefense += 15;
                        System.out.println("You bought the wooden armor.");
                        CaveShopArmor = false;
                    } else {
                        System.out.println("You don't have enough money.");
                    }
                    ShopBuy();
                }
                typeWriter("\"Sorry, it's out of stock\"");
                ShopBuy();

            }
            case 3 -> CaveShop();
            default -> {
                System.out.println("Invalid choice.");
                ShopBuy();
            }
        }
    }


    static void SecretBossHint() {
        typeWriter("\"Oh.... oh I know what you want... You don't care about the vanity of this word\"\n" +
                "\"Hehe... a kindred spirit. Take this coin of Elation, show it to the bartender at the world's edge tavern, he should give you all that you need... Take care\"");
        p.ElationCoin = 1;
        typeWriter("Coin of Elation was added to your inventory");
        CaveShopHint = false;
        CaveShop();
    }


    static void RightCave() {
        if (Flowery) {
            typeWriter("You entered the right cave, the sound of running water grew louder as you ventured deeper \n" +
                    "You found a small pond with a glowing flower in the center \n" +
                    "You stepped closer, the flower pulsed as it healed you fully.... But you could almost hear the flower say something");
            typeWriter("......glue.......");
            p.health = 100;
            Flowery = false;
            System.out.println("Your health is now: " + p.health);
            typeWriter("You went back to the crossroad");
            cave2();
        }
        typeWriter("You entered the right cave, the sound of running water grew louder as you ventured deeper \n" +
                "You found a small pond with a glowing flower in the center \n" +
                "You stepped closer, the flower pulsed as it healed you fully");
        p.health = 100;


        System.out.println("Your health is now: " + p.health);
        typeWriter("You went back to the crossroad");
        cave2();
    }

    static void CenterCave() {
        typeWriter("You entered the center cave, the crystals shimmered and you felt a sense of calm \n" +
                "You stand in front of a large opening, gnomes trotting all over, doing their duties.\n");
        GnomeCave();
    }

    static void GnomeCave() {

        typeWriter("You can go left to the mines, right to town center, or forward to the gnome's chief\n");
        System.out.println("|L left | C center | R light | B head back | I inventory (Works everywhere in gnome cave)");
        char direction = input.next().charAt(0);
        switch (direction) {
            case 'L', 'l' -> GnomeMines();
            case 'C', 'c' -> GnomeChief();
            case 'R', 'r' -> GnomeTown();
            case 'B', 'b' -> cave2();
            case 'I', 'i' -> {

                System.out.println("Coal: " + Coal + "\n" + "" +
                        "Iron: " + Iron + "\n" +
                        "Gold: " + Gold + "\n" +
                        "Obsidian: " + Obsidian + "\n" +
                        "Amethyst: " + Amethyst + "\n" +
                        "Diamond: " + Diamond + "\n" +
                        "Ruby: " + Ruby);
                GnomeCave();
            }
            default -> {
                typeWriter("Invalid direction.");
                CenterCave();
            }
        }

    }

    static void GnomeMines() {
        typeWriter("You head to the mining area, you pick up a rusty pickaxe from the wall");
        System.out.println("| M to mine | B to head back to upgrade pickaxe | I inventory");
        char Input = input.next().charAt(0);
        input.nextLine();
        switch (Input) {
            case 'M', 'm' -> {
                typeWriter("Press E and enter to cancel mining");

                miningExit = false;

                while (!miningExit) {
                    GnomeMine();
                }

                GnomeMines(); // Go back to the mining menu
                return;
            }
            case 'B', 'b' -> GnomeCave();
            case 'I', 'i' -> {
                System.out.println("Coal: " + Coal + "\n" + "" +
                        "Iron: " + Iron + "\n" +
                        "Gold: " + Gold + "\n" +
                        "Obsidian: " + Obsidian + "\n" +
                        "Amethyst: " + Amethyst + "\n" +
                        "Diamond: " + Diamond + "\n" +
                        "Ruby: " + Ruby);
                GnomeMines();
            }
            default -> {
                typeWriter("Invalid input.");
                GnomeMines();
            }
        }

    }

    static void GnomeChief() {
        typeWriter("You head up the grand tower, the chief gnome on his throne. But above him is the North crystal, he catches you eyeing it and laughs");
        typeWriter("\"Pretty isn't it? found it at the top of the icy mounts. If you want it, well, give me 100,000$ and it's yours. Otherwise it's mine");
        System.out.println("| 1 give the money | 2 fight him and steal it by force | 3 head back");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1 -> {
                if (p.Money >= 100000) {
                    typeWriter("You gave the gnome chief the money. He laughs happily");
                    typeWriter("\"As intended here");
                    System.out.println("North crystal was added to you items");
                    typeWriter("As you begin to walk out you noticed something. It's ony a piece of obsidian, a fake \n" +
                            "You turn back and the throne is empty. You quickly tracked the chief down and entered a fight");
                    GnomeFight();

                }
                typeWriter("\"Are you trying to scam me? GUARDS throw him off the tower\"");
                typeWriter("The orc guards shove you off the tower as you fell to the ground");
                p.health -= 30;
                checkHealth();
                GnomeCave();
            }
            case 2 -> {
                typeWriter("You raise your sword towards the chief");
                typeWriter("\"Oh you wish to fight me? HAHAH get through my orc guards first");
                OrcFight();
            }
            case 3 -> {
                typeWriter("You head back");
                GnomeCave();
            }
            default -> {
                typeWriter("Invalid input.");
                GnomeChief();
            }
        }
    }

    static void OrcFight() {

        int Orc = 250;
        typeWriter("Orcs have 250hp. 20 ATK");

        for (int i = 0; i < 2; i++) {

            int HeavyAttack = 0;

            int OrcHP = Orc;

            System.out.println("\nFighting Orc " + (i + 1));

            while (OrcHP > 0) {

                HeavyAttack++;


                System.out.println("Orc HP: " + OrcHP +
                        " | Your HP: " + String.format("%.1f", p.health));

                if (HeavyAttack == 4) {
                    typeWriter("Orc prepares for a heavy attack");
                }

                System.out.println("| 1 Fight | 2 Defend | 3 Prayer heal ");

                String choice = input.nextLine().trim();

                if (HeavyAttack == 5) {
                    typeWriter("Orc unleashes a heavy attack");
                    switch (choice) {
                        case "1":
                            Accuracy();
                            Attack();
                            if (p.damageAccuracy == -1) {

                                takeDamage(30);

                            } else {

                                OrcHP -= p.damage;
                                takeDamage(30);
                            }
                            break;
                        case "2":
                            takeDamage(5);
                            break;
                        case "3":

                            p.health += p.Healing;
                            if (p.health > 100) {
                                p.health = 100;
                            }
                            typeWriter("You tried to heal, but you faltered");
                            takeDamage(10);

                            checkHealth();

                            break;


                    }

                    HeavyAttack = 0;

                } else {
                    switch (choice) {
                        case "1":
                            Accuracy();
                            Attack();
                            if (p.damageAccuracy == -1) {

                                takeDamage(20);

                            } else {

                                OrcHP -= p.damage;
                                takeDamage(20);
                            }
                            break;
                        case "2":
                            takeDamage(5);
                            break;
                        case "3":

                            p.health += p.Healing;
                            if (p.health > 100) {
                                p.health = 100;
                            }
                            takeDamage(5);
                            checkHealth();

                            break;


                    }
                }

                checkHealth();


            }

            System.out.println("\nOrc defeated!");

            int intervals = 20;

            int randomValue = (random.nextInt(intervals) + 1) * 5;

            p.Money += randomValue;

            System.out.println("Orc dropped " + randomValue + " coins");


        }

        checkHealth();

        System.out.println("\nYou survived, your health is now " + p.health);
        GnomeFight();

    }


    static void GnomeFight() {

        typeWriter("\"Wh-WHAT.. W-wait please HAVE MERCY");
        System.out.println("| 1 fight | 2 show mercy");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                U_R_evil();
            }
            case 2 -> {
                GnomeMercy();
            }
            default -> {
                typeWriter("Invalid input.");
                GnomeFight();
            }
        }
    }

    static void U_R_evil() {
        System.out.println("Gnome chief has 10hp. 1ATK");
        System.out.println("| 1 fight? | 2 show mercy");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1 -> {

                int HeavyAttack = 0;
                int Gnomehp = 10;

                System.out.println("\nFighting Gnome chief");

                while (Gnomehp > 0) {

                    HeavyAttack++;


                    System.out.println("Crystal HP: " + Gnomehp +
                            " | Your HP: " + String.format("%.1f", p.health));

                    if (HeavyAttack == 4) {
                        typeWriter("Gnome chief prepares for a heavy attack");
                    }

                    System.out.println("| 1 Fight | 2 Defend | 3 Prayer heal | 4 show mercy ");

                    String option = input.nextLine();

                    if (HeavyAttack == 5) {
                        typeWriter("Gnome chief attempts to launch a heavy attack. But it does nothing");
                        switch (option) {
                            case "1":
                                Accuracy();
                                Attack();
                                if (p.damageAccuracy == -1) {

                                    takeDamage(1);

                                } else {

                                    Gnomehp -= p.damage;
                                    takeDamage(1);
                                }
                                break;
                            case "2":
                                takeDamage(0);
                                break;
                            case "3":

                                p.health += p.Healing;
                                if (p.health > 100) {
                                    p.health = 100;
                                }
                                takeDamage(1);

                                checkHealth();

                                break;

                            case "4":
                                GnomeMercy();


                        }

                        HeavyAttack = 0;

                    } else {
                        switch (option) {
                            case "1":
                                Accuracy();
                                Attack();
                                if (p.damageAccuracy == -1) {

                                    takeDamage(1);

                                } else {

                                    Gnomehp -= p.damage;
                                    takeDamage(1);
                                }
                                break;
                            case "2":
                                takeDamage(0);
                                break;
                            case "3":

                                p.health += p.Healing;
                                if (p.health > 100) {
                                    p.health = 100;
                                }
                                takeDamage(1);
                                checkHealth();

                                break;
                            case "4":
                                GnomeMercy();

                        }
                    }

                    checkHealth();


                }

                System.out.println("\nGnome defeated........you monster");

                p.Money += 100000;

                typeWriter("Gnome dropped 100000 coins");

                typeWriter("The gnome tribe kicked you out, but before that you managed to snag the real north crystal");
                p.crystals += 1;
                p.level += 10;
                North = true;
                EastAccess = false;
                mainArea();


            }
            case 2 -> {
                GnomeMercy();
            }
        }
    }

    static void GnomeMercy() {
        typeWriter("You laid your sword down. The chief gnome scrambled away, after a while he came back handing you the true north crystal before running away");
        p.crystals += 1;
        p.level += 10;
        North = true;
        EastAccess = false;
        mainArea();
    }


    static void GnomeTown() {
        typeWriter("You enter the town center, gnomes trotting around, you saw 2 shops, a bank to cash your gems and a mining store to upgrade your pickaxe");
        System.out.println("| B Bank | P Pickaxe | H Head back | I inventory");
        char Input = input.next().charAt(0);
        input.nextLine();
        switch (Input) {
            case 'B', 'b' -> GnomeBank();
            case 'P', 'p' -> GnomeShop();
            case 'H', 'h' -> GnomeCave();
            case 'I', 'i' -> {
                System.out.println("Coal: " + Coal + "\n" + "" +
                        "Iron: " + Iron + "\n" +
                        "Gold: " + Gold + "\n" +
                        "Obsidian: " + Obsidian + "\n" +
                        "Amethyst: " + Amethyst + "\n" +
                        "Diamond: " + Diamond + "\n" +
                        "Ruby: " + Ruby);
                GnomeMines();
            }
            default -> {
                typeWriter("Invalid input.");
                GnomeTown();
            }
        }
    }

    static void GnomeShop() {

        typeWriter("Welcome, would you like a new pickaxe?");
        System.out.println("Your money is: " + p.Money);
        System.out.println("Available pickaxe");
        System.out.println("1 | Iron Pickaxe: 50$ + 10 luck boost\n" +
                "2 | Golden Pickaxe: 100$ + 15 luck boost\n" +
                "3 | Diamond Pickaxe: 200$ + 20 luck boost\n" +
                "4 | Ruby Pickaxe: 250$ + 25 luck boost\n" +
                "5 | Emerald Pickaxe: 350$ + 30 luck boost\n" +
                "6 | Charoite Pickaxe: 1000$ + 100 luck boost");
        System.out.println("Please enter which pickaxe you want or | E to go back");
        char Input = input.next().charAt(0);
        switch (Input) {
            case 'E', 'e' -> {
                GnomeTown();
            }
            case '1' -> { // Iron Pickaxe

                if (pickaxeTier < 1) {

                    if (p.Money >= 50) {

                        p.Money -= 50;
                        pickaxeLuck = 10;
                        pickaxeTier = 1;

                        typeWriter("You bought the Iron pickaxe");
                        GnomeShop();

                    } else {

                        typeWriter("You don't have enough money");
                        GnomeShop();

                    }

                } else {

                    typeWriter("You already own this or a better pickaxe.");
                    GnomeShop();

                }
            }


            case '2' -> { // Golden Pickaxe

                if (pickaxeTier < 2) {

                    if (p.Money >= 100) {

                        p.Money -= 100;
                        pickaxeLuck = 15;
                        pickaxeTier = 2;

                        typeWriter("You bought the Golden pickaxe");
                        GnomeShop();

                    } else {

                        typeWriter("You don't have enough money");
                        GnomeShop();

                    }

                } else {

                    typeWriter("You already own this or a better pickaxe.");
                    GnomeShop();

                }
            }


            case '3' -> { // Diamond Pickaxe

                if (pickaxeTier < 3) {

                    if (p.Money >= 200) {

                        p.Money -= 200;
                        pickaxeLuck = 20;
                        pickaxeTier = 3;

                        typeWriter("You bought the Diamond pickaxe");
                        GnomeShop();

                    } else {

                        typeWriter("You don't have enough money");
                        GnomeShop();

                    }

                } else {

                    typeWriter("You already own this or a better pickaxe.");
                    GnomeShop();

                }
            }


            case '4' -> { // Ruby Pickaxe

                if (pickaxeTier < 4) {

                    if (p.Money >= 250) {

                        p.Money -= 250;
                        pickaxeLuck = 25;
                        pickaxeTier = 4;

                        typeWriter("You bought the Ruby pickaxe");
                        GnomeShop();

                    } else {

                        typeWriter("You don't have enough money");
                        GnomeShop();

                    }

                } else {

                    typeWriter("You already own this or a better pickaxe.");
                    GnomeShop();

                }
            }


            case '5' -> { // Emerald Pickaxe

                if (pickaxeTier < 5) {

                    if (p.Money >= 350) {

                        p.Money -= 350;
                        pickaxeLuck = 30;
                        pickaxeTier = 5;

                        typeWriter("You bought the Emerald pickaxe");
                        GnomeShop();

                    } else {

                        typeWriter("You don't have enough money");
                        GnomeShop();

                    }

                } else {

                    typeWriter("You already own this or a better pickaxe.");
                    GnomeShop();

                }
            }

            case '6' -> {
                if (CharoitePik) {
                    if (p.Money >= 1000) {
                        p.Money -= 1000;
                        typeWriter("You held the Charoite pickaxe feeling it's power. You existed the shop to go tested out\n" +
                                "But before you made it 5 feet from the shop, the pickaxe shattered because Charoite if fragile\n" +
                                "As you stare at the broken pieces, you can hear the shopkeeper snickering");
                        CharoitePik = false;
                        GnomeTown();
                    } else {
                        typeWriter("You don't have enough money");
                        GnomeShop();
                    }
                } else {
                    typeWriter("Item is sold out.... Hehe");
                    GnomeShop();
                }
            }
            default -> {
                typeWriter("Invalid input.");
                GnomeShop();
            }
        }
    }

    static void GnomeBank() {
        typeWriter("Welcome, would you like to cash in your gems?");
        System.out.println("Gem prices" + "\n" +
                "Coal: 5$\n" +
                "Iron: 10$\n" +
                "Gold: 20$\n" +
                "Obsidian: 30$\n" +
                "Amethyst: 40$\n" +
                "Diamond: 50$\n" +
                "Ruby: 100$");
        System.out.println("| 1 to cash in | 2 head back");
        int chouce = input.nextInt();
        switch (chouce) {
            case 1 -> {
                SellAllOres();
            }
            case 2 -> GnomeCave();
            default -> {
                typeWriter("Invalid input.");
                GnomeBank();
            }
        }
    }

    static void SellAllOres() {

        int totalMoney = 0;

        totalMoney += Coal * 5;
        totalMoney += Iron * 10;
        totalMoney += Gold * 20;
        totalMoney += Obsidian * 30;
        totalMoney += Amethyst * 40;
        totalMoney += Diamond * 50;
        totalMoney += Ruby * 100;


        if (totalMoney == 0) {
            System.out.println("You have no ores to sell.");
            GnomeTown();
            return;
        }


        System.out.println("You sold your ores for " + totalMoney + " coins!");


        p.Money += totalMoney;


        // Empty inventory after selling
        Coal = 0;
        Iron = 0;
        Gold = 0;
        Obsidian = 0;
        Amethyst = 0;
        Diamond = 0;
        Ruby = 0;


        System.out.println("You now have " + p.Money + " coins.");
        GnomeTown();

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
        typeWriter("After your encounter with the wind god Aeolus you venture off to find the missing ring pieces");
        CloudCrossway();
    }

    static void CloudCrossway() {
        if (p.WindRing == 3) {
            System.out.println("You have collected all 3 pieces of the Wind Ring, you return to Aeolus");
            WindRing = true;
            Aeolus();
        }
        typeWriter("You land at a cloud plateau, in front of you are three large clouds \n" +
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

        if (digit == EastCode) {
            typeWriter("The door opened, the ground shook by the colossal door, as you entered the chamber");
            ThroneRoom();
        } else if (digit == 0) {
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
        typeWriter("You take the left staircase and you see a room, above the door is the number 1. Would you like to explore the room more or go to the statue at the center?");
        EastRooms(Room1);

    }

    static void IvoryCenter() {
        typeWriter("You take the center staircase and you see a room, above the door is the number 2. Would you like to explore the room more or go to the statue at the center?");
        EastRooms(Room2);

    }

    static void IvoryRight() {
        typeWriter("You take the right staircase and you see a room, above the door is the number 3. Would you like to explore the room more or go to the statue at the center?");
        EastRooms(Room3);
    }


    static void ThroneRoom() {
        typeWriter("You entered the chamber, inside there is a chest, you open it and get 2 special item \n" +
                "The Royal Ivory Cloud Sword | +15 Damage and the Royal Ivory Cloud Armor | +10 Defense");
        p.bonusDamage += 15;
        p.bonusDefense += 10;
        updateStats();
        System.out.println("Your damage is now " + p.damage);
        System.out.println("Your defense is now " + p.defense);
        typeWriter("you continue inside and made it to the throne room. On the throne is one of the ring pieces, but it's protected by " + Breeze + " Breezes");
        typeWriter("Do you attack them? Distract them, or they and sneak around them");
        System.out.println("1 Attack them | 2 distract them | 3 Run");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1 -> {
                typeWriter("You beavery lifted your new sword and fought them");
                IvoryAttack();
            }
            case 2 -> {
                typeWriter("You attempted to distract them but the Breezes weren't fooled by you, you take extra damage");
                IvoryDistract();
            }
            case 3 -> {
                typeWriter("You attempted to run but the Breezes caught you and attacked you, you take extra damage");
                IvoryRun();
            }
        }
        char attack = input.next().charAt(0);


    }

    static void IvoryDistract() {

        System.out.println("You bravely attack the Breezes!");

        for (int i = 0; i < Hunters; i++) {

            int HeavyAttack = 0;
            int BreezesHP = enemy.Breeze;

            System.out.println("\nFighting Breeze " + (i + 1));

            while (BreezesHP > 0) {

                HeavyAttack++;

                System.out.println("Breeze HP: " + BreezesHP +
                        " | Your HP: " + String.format("%.1f", p.health));

                if (HeavyAttack == 4) {
                    typeWriter("Breeze prepares for a heavy attack");
                }

                System.out.println("| 1 Fight | 2 Defend | 3 Prayer heal");

                String choice = input.nextLine();


                if (HeavyAttack >= 5) {

                    typeWriter("Breeze unleashes a heavy attack");

                    switch (choice) {

                        case "1":
                            Accuracy();
                            Attack();

                            if (p.damageAccuracy == -1) {
                                takeDamage(25);
                            } else {
                                BreezesHP -= p.damage;
                                takeDamage(25);
                            }
                            break;

                        case "2":
                            takeDamage(10);
                            break;

                        case "3":
                            p.health += p.Healing;

                            if (p.health > 100) {
                                p.health = 100;
                            }

                            typeWriter("You tried to heal, but you faltered");
                            takeDamage(10);
                            break;
                    }

                    HeavyAttack = 0;

                } else {

                    switch (choice) {

                        case "1":
                            Accuracy();
                            Attack();

                            if (p.damageAccuracy == -1) {
                                takeDamage(20);
                            } else {
                                BreezesHP -= p.damage;
                                takeDamage(20);
                            }
                            break;

                        case "2":
                            takeDamage(5);
                            break;

                        case "3":
                            p.health += p.Healing;

                            if (p.health > 100) {
                                p.health = 100;
                            }

                            takeDamage(5);
                            break;
                    }
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

    static void IvoryRun() {

        System.out.println("You bravely attack the Breezes!");

        for (int i = 0; i < Hunters; i++) {

            int HeavyAttack = 0;
            int BreezesHP = enemy.Breeze;

            System.out.println("\nFighting Breeze " + (i + 1));

            while (BreezesHP > 0) {

                HeavyAttack++;

                System.out.println("Breeze HP: " + BreezesHP +
                        " | Your HP: " + String.format("%.1f", p.health));

                if (HeavyAttack == 4) {
                    typeWriter("Breeze prepares for a heavy attack");
                }

                System.out.println("| 1 Fight | 2 Defend | 3 Prayer heal");

                String choice = input.nextLine();

                if (HeavyAttack >= 5) {

                    typeWriter("Breeze unleashes a heavy attack");

                    switch (choice) {

                        case "1":
                            Accuracy();
                            Attack();

                            if (p.damageAccuracy == -1) {

                                takeDamage(25);

                            } else {

                                BreezesHP -= p.damage;
                                takeDamage(25);

                            }
                            break;


                        case "2":
                            takeDamage(10);
                            break;


                        case "3":

                            p.health += p.Healing;

                            if (p.health > 100) {
                                p.health = 100;
                            }

                            typeWriter("You tried to heal, but you faltered");
                            takeDamage(10);

                            break;
                    }

                    HeavyAttack = 0;


                } else {


                    switch (choice) {

                        case "1":

                            Accuracy();
                            Attack();

                            if (p.damageAccuracy == -1) {

                                takeDamage(20);

                            } else {

                                BreezesHP -= p.damage;
                                takeDamage(20);

                            }
                            break;


                        case "2":
                            takeDamage(5);
                            break;


                        case "3":

                            p.health += p.Healing;

                            if (p.health > 100) {
                                p.health = 100;
                            }

                            takeDamage(5);

                            break;
                    }
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

    static void IvoryAttack() {

        System.out.println("You bravely attack the Breezes!");

        for (int i = 0; i < Hunters; i++) {

            int HeavyAttack = 0;
            int BreezesHP = enemy.Breeze;

            System.out.println("\nFighting Breeze " + (i + 1));

            while (BreezesHP > 0) {

                HeavyAttack++;

                System.out.println("Breeze HP: " + BreezesHP +
                        " | Your HP: " + String.format("%.1f", p.health));

                if (HeavyAttack == 4) {
                    typeWriter("Breeze prepares for a heavy attack");
                }

                System.out.println("| 1 Fight | 2 Defend | 3 Prayer heal");

                String choice = input.nextLine();

                if (HeavyAttack >= 5) {

                    typeWriter("Breeze unleashes a heavy attack");

                    switch (choice) {

                        case "1":
                            Accuracy();
                            Attack();

                            if (p.damageAccuracy == -1) {
                                takeDamage(20);
                            } else {
                                BreezesHP -= p.damage;
                                takeDamage(20);
                            }
                            break;

                        case "2":
                            takeDamage(10);
                            break;

                        case "3":
                            p.health += p.Healing;

                            if (p.health > 100) {
                                p.health = 100;
                            }

                            typeWriter("You tried to heal, but you faltered");
                            takeDamage(10);
                            break;
                    }

                    HeavyAttack = 0;

                } else {

                    switch (choice) {

                        case "1":
                            Accuracy();
                            Attack();

                            if (p.damageAccuracy == -1) {
                                takeDamage(15);
                            } else {
                                BreezesHP -= p.damage;
                                takeDamage(15);
                            }
                            break;

                        case "2":
                            takeDamage(5);
                            break;

                        case "3":
                            p.health += p.Healing;

                            if (p.health > 100) {
                                p.health = 100;
                            }

                            takeDamage(5);
                            break;
                    }
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

            int BreezHP = enemy.Breeze;

            System.out.println("\nFighting Breeze " + (i + 1));

            while (BreezHP > 0) {

                // player attacks
                BreezHP -= p.damage;

                String line =
                        "Breeze HP: " + BreezHP +
                                " | Your HP: " + String.format("%.1f", p.health);

                System.out.print("\r" + String.format("%-50s", line));
                System.out.flush();

                // if dead, stop BEFORE enemy turn
                if (BreezHP <= 0) {
                    break;
                }

                // enemy attack only if still alive
                takeDamage(5);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                checkHealth();
            }

            System.out.println("\nBreeze defeated!");

            if (ThreadLocalRandom.current().nextInt(100 + 1) < 10) {
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
        p.Magic += 20;
        updateStats();

        StormCloud = true;
        System.out.println("Your health is now " + p.health);
        System.out.println("Your damage is now " + p.damage);
        System.out.println("Your defense is now " + p.defense);
        System.out.println("Your magic is now " + p.Magic);
        CloudCrossway();
    }

    static void Aeolus() {
        typeWriter("Aeolus: \"You dare to defy me To make me feel shame? No one beats me, no one wins my game, \"");
        typeWriter("\"wind bring them through the wringer\"");
        typeWriter("Show them I'm the judgement call The one who makes her kingdom fall\"");
        System.out.println("You enter a fight with Aeolus");
        AeolusFight();
    }

    static void AeolusFight() {
        System.out.println("You are fighting Aeolus, the wind god");

        int i = 0;

        int HealTimes = 0;

        while (AeolusHealth > 0) {


            if (i > 0 && i % 5 == 0) {
                System.out.println("You feel the power of determination rush into you\n" +
                        "Your damage increases");
                p.bonusDamage += 10;
                updateStats();
                System.out.println("Your damage is now " + p.damage);
            }

            System.out.println("Your HP: " + p.health + " | Aeolus HP: " + AeolusHealth + " | Your Damage: " + p.damage + " | Aeolus Damage: " + AeolusDamage);
            System.out.println("Press 1 to attack | 2 to defend | 3 to heal");
            char choice = input.next().charAt(0);
            input.nextLine();
            switch (choice) {
                case '1' -> {
                    Accuracy();
                    Attack();
                    if (p.damageAccuracy == -1) {

                        takeDamage(AeolusDamage);

                    } else {

                        AeolusHealth -= p.damage;
                        takeDamage(AeolusDamage);
                        typeWriter("You struck Aeolus!");
                        System.out.println("Aeolus's HP is now " + AeolusHealth);
                    }
                }
                case '2' -> {
                    System.out.println("You defended against Aeolus's attack");
                    int defended = random.nextInt(3);

                    switch (defended) {
                        case 0:
                            takeDamage(AeolusDamage - 5);
                            typeWriter("You blocked Aeolus attack!)");
                            System.out.println("Your HP is now " + p.health);
                            break;

                        case 1:
                            takeDamage(AeolusDamage - 10);
                            typeWriter("You hit a hard blocked against Aeolus attack!)");
                            System.out.println("Your HP is now " + p.health);
                            break;

                        case 2:
                            takeDamage(AeolusDamage - 20);
                            typeWriter("You hit a critical blocked against Aeolus attack!)");
                            System.out.println("Your HP is now " + p.health);
                            break;
                    }

                    System.out.println("Current Health: " + p.health);
                    checkHealth();
                }
                case '3' -> {
                    typeWriter("You cupped your hand in prayer, determination filled you of your travels as you got healed");
                    p.health += p.Healing;
                    if (p.health > 100) {
                        p.health = 100;
                    }
                    System.out.println("Aeolus fights!");
                    takeDamage(AeolusDamage - 10);
                    System.out.println("Your HP is now " + p.health);
                    HealTimes += 1;

                    if (HealTimes == 3) {
                        typeWriter("Aeolus is enraged bt your overhaling and sends a tornado towards you");
                        takeDamage(AeolusDamage + 40);
                        System.out.println("Your HP is now " + p.health);
                        HealTimes = 0;
                    }
                }
                default -> {
                    typeWriter("You falter in your attack, Aeolus takes advantage and hits a critical hit");
                    takeDamage(AeolusDamage + 20);
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
        SouthAccess = false;
        TrainingCap = false;
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