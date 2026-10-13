package Quiz3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayQueue playerQueue = new ArrayQueue(10);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int gamesCreated = 0;
        int playerIdCounter = 1;
        String[] sampleNames = {"Goku", "Saitama", "Deku", "Naruto", "Luffy", "Tanjiro", "Asta", "Sasuke", "Zoro", "Baki"};

        System.out.println("=== Matchmaking System Started ===");
        System.out.println("Press ENTER to end each turn. Goal: 10 games created.\n");

        while (gamesCreated < 10) {

            int x = random.nextInt(7) + 1;

            System.out.println("----------------------------------------");
            System.out.println("Turn Events:");
            System.out.println("-> " + x + " new player(s) joined the queue.");

            for (int i = 0; i < x; i++) {
                String name = sampleNames[random.nextInt(sampleNames.length)];
                int level = random.nextInt(900) + 100;
                playerQueue.enqueue(new Player(playerIdCounter, name, level));
                playerIdCounter++;
            }

            System.out.println("-> Current players waiting in queue: " + playerQueue.size());


            while (playerQueue.size() >= 5) {
                gamesCreated++;
                System.out.println("\n[GAME STARTED!] Game #" + gamesCreated + " created with players:");

                for (int i = 0; i < 5; i++) {
                    Player p = playerQueue.dequeue();
                    System.out.println("   - " + p);
                }
                System.out.println("-> Remaining players in queue: " + playerQueue.size());


                if (gamesCreated >= 10) {
                    System.out.println("\n========================================");
                    System.out.println(" SUCCESS: 10 games have been successfully made!");
                    System.out.println(" Program terminating.");
                    System.out.println("========================================");
                    scanner.close();
                    return;
                }
            }


            System.out.println("\nPress [ENTER] to proceed to the next turn...");
            scanner.nextLine();
        }

        scanner.close();
    }
}
