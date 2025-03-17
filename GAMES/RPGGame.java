package GAMES;
import java.util.*;

class Player {
    String name;
    int health = 100;
    int attack = 15;
    int xp = 0;
    int level = 1;
    List<String> inventory = new ArrayList<>();

    Player(String name) {
        this.name = name;
        inventory.add("Sword");
        inventory.add("Health Potion");
    }

    void levelUp() {
        if (xp >= level * 20) {
            level++;
            health += 20;
            attack += 5;
            System.out.println("🎉 You leveled up! Now Level: " + level);
        }
    }
}

class Enemy {
    String name;
    int health;
    int attack;

    Enemy(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }
}

public class RPGGame {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.print("Enter your character name: ");
        String name = scanner.nextLine();
        player = new Player(name);
        System.out.println("Welcome, " + name + "! Your adventure begins...");

        while (true) {
            System.out.println("\n🌍 Choose an action: \n1. Explore \n2. Check Status \n3. Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    explore();
                    break;
                case 2:
                    checkStatus();
                    break;
                case 3:
                    System.out.println("Game Over. Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    static void explore() {
        System.out.println("\nYou venture into the unknown...");

        if (random.nextBoolean()) {
            battle(new Enemy("Goblin", 40, 10));
        } else {
            System.out.println("🌲 You found a health potion!");
            player.inventory.add("Health Potion");
        }
    }

    static void battle(Enemy enemy) {
        System.out.println("\n⚔️ A wild " + enemy.name + " appears!");

        while (enemy.health > 0 && player.health > 0) {
            System.out.println("\n🔹 Your Health: " + player.health);
            System.out.println("💀 Enemy Health: " + enemy.health);
            System.out.println("Choose action: 1. Attack 2. Use Potion 3. Run");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    enemy.health -= player.attack;
                    System.out.println("💥 You hit the " + enemy.name + " for " + player.attack + " damage!");
                    break;
                case 2:
                    if (player.inventory.contains("Health Potion")) {
                        player.health += 20;
                        player.inventory.remove("Health Potion");
                        System.out.println("🍷 You used a Health Potion. (+20 HP)");
                    } else {
                        System.out.println("❌ No potions left!");
                    }
                    break;
                case 3:
                    System.out.println("🏃 You ran away!");
                    return;
                default:
                    System.out.println("Invalid action!");
            }

            if (enemy.health > 0) {
                player.health -= enemy.attack;
                System.out.println("💀 The " + enemy.name + " hit you for " + enemy.attack + " damage!");
            }
        }

        if (player.health <= 0) {
            System.out.println("💀 You have been defeated!");
            System.exit(0);
        } else {
            System.out.println("🏆 You defeated the " + enemy.name + "!");
            player.xp += 10;
            player.levelUp();
        }
    }

    static void checkStatus() {
        System.out.println("\n🛡️ Player Status:");
        System.out.println("Name: " + player.name);
        System.out.println("Health: " + player.health);
        System.out.println("Level: " + player.level);
        System.out.println("XP: " + player.xp);
        System.out.println("Inventory: " + player.inventory);
    }
}
