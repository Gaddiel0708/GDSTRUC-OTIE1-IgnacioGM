package Midterms;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 3 stacks required: Player Deck, Player Hand, Discarded Pile
        ArrayStack playerDeck = new ArrayStack(30);
        ArrayStack playerHand = new ArrayStack(30);
        ArrayStack discardedPile = new ArrayStack(30);

        // Initialize Player Deck with 30 cards
        for (int i = 1; i <= 30; i++) {
            playerDeck.push(new Card("Card " + i));
        }

        System.out.println("=== Card Game Started ===");
        System.out.println("The game will continue until the player deck is emptied.\n");

        int turnCount = 1;

        // The program ends when the player deck is emptied.
        while (!playerDeck.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("Turn " + turnCount);

            // Generate a random command type:
            // 0: Draw x cards from deck to hand
            // 1: Discard x cards from hand
            // 2: Get x cards from discarded pile to hand
            int commandType = random.nextInt(3);
            int x = random.nextInt(5) + 1; // Random value from 1 to 5

            switch (commandType) {
                case 0:
                    System.out.println("Command: Draw " + x + " card(s) from the deck.");
                    int drawnCount = 0;
                    for (int i = 0; i < x; i++) {
                        if (playerDeck.isEmpty()) break;
                        playerHand.push(playerDeck.pop());
                        drawnCount++;
                    }
                    System.out.println("-> Successfully drew " + drawnCount + " card(s).");
                    break;

                case 1:
                    System.out.println("Command: Discard " + x + " card(s) from your hand.");
                    int discardedCount = 0;
                    for (int i = 0; i < x; i++) {
                        if (playerHand.isEmpty()) break;
                        discardedPile.push(playerHand.pop());
                        discardedCount++;
                    }
                    System.out.println("-> Successfully discarded " + discardedCount + " card(s).");
                    break;

                case 2:
                    System.out.println("Command: Get " + x + " card(s) from the discarded pile into your hand.");
                    int retrievedCount = 0;
                    for (int i = 0; i < x; i++) {
                        if (discardedPile.isEmpty()) break;
                        playerHand.push(discardedPile.pop());
                        retrievedCount++;
                    }
                    System.out.println("-> Successfully retrieved " + retrievedCount + " card(s).");
                    break;
            }

            // Display required round info
            System.out.println("\n--- Status Info ---");
            System.out.println("List of cards that the player is currently holding:");
            playerHand.printStack(); // Using your class's printStack method!
            System.out.println("\nNumber of remaining cards in the player deck: " + playerDeck.size());
            System.out.println("Number of cards in the discarded pile: " + discardedPile.size());

            // Check if player deck is empty before asking for Enter
            if (playerDeck.isEmpty()) {
                System.out.println("\n[Notice] The player deck is now empty!");
                break;
            }

            // Prompt player to press Enter to proceed to the next turn
            System.out.print("\nPress **Enter** to proceed to the next turn...");
            scanner.nextLine();
            turnCount++;
        }

        System.out.println("\n=== Game Over: Player deck is completely emptied. ===");
        scanner.close();
    }
}