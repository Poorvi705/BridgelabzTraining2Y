package Strings;

import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize the deck
    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }

        return deck;
    }

    // Method to shuffle the deck
    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCardNumber =
                    i + (int) (Math.random() * (n - i));

            // Swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int players) {

        if (deck.length % players != 0) {
            System.out.println(
                    "Cards cannot be equally distributed among " +
                            players + " players."
            );
            return null;
        }

        int cardsPerPlayer = deck.length / players;

        String[][] playerCards =
                new String[players][cardsPerPlayer];

        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[index];
                index++;
            }
        }

        return playerCards;
    }

    // Method to print players and their cards
    public static void printPlayers(String[][] playerCards) {

        for (int i = 0; i < playerCards.length; i++) {

            System.out.println("Player " + (i + 1) + ":");

            for (int j = 0; j < playerCards[i].length; j++) {
                System.out.println(playerCards[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] suits = {
                "Hearts", "Diamonds", "Clubs", "Spades"
        };

        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King", "Ace"
        };

        // Calculate number of cards
        int numOfCards = suits.length * ranks.length;

        // Initialize deck
        String[] deck = initializeDeck(suits, ranks);

        // Shuffle deck
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        // Distribute cards
        String[][] playerCards =
                distributeCards(deck, players);

        // Print cards
        if (playerCards != null) {
            printPlayers(playerCards);
        }

        sc.close();
    }
}