package Strings;

import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {

        int choice = (int) (Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public static String findWinner(String player, String computer) {

        if (player.equals(computer)) {
            return "Draw";
        }

        if ((player.equals("Rock") && computer.equals("Scissors"))
                || (player.equals("Paper") && computer.equals("Rock"))
                || (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int playerWins,
                                            int computerWins,
                                            int draws,
                                            int totalGames) {

        double playerPercentage =
                (playerWins * 100.0) / totalGames;

        double computerPercentage =
                (computerWins * 100.0) / totalGames;

        String[][] stats = new String[3][3];

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.format("%.2f%%", playerPercentage);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f%%", computerPercentage);

        stats[2][0] = "Draw";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f%%",
                (draws * 100.0) / totalGames);

        return stats;
    }

    public static void displayResults(String[][] results) {

        System.out.println("\nPlayer\tComputer\tWinner");
        System.out.println("--------------------------------");

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "\t"
                    + results[i][1] + "\t\t"
                    + results[i][2]);
        }
    }

    public static void displayStats(String[][] stats) {

        System.out.println("\nResult\t\tWins\tPercentage");
        System.out.println("-----------------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t\t"
                    + stats[i][1] + "\t"
                    + stats[i][2]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        String[][] results = new String[games][3];

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < games; i++) {

            System.out.println("\nGame " + (i + 1));

            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.next();

            // Convert first letter to uppercase
            player = player.substring(0, 1).toUpperCase()
                    + player.substring(1).toLowerCase();

            String computer = getComputerChoice();

            String winner = findWinner(player, computer);

            results[i][0] = player;
            results[i][1] = computer;
            results[i][2] = winner;

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        displayResults(results);

        String[][] stats = calculateStats(
                playerWins,
                computerWins,
                draws,
                games
        );

        displayStats(stats);

        sc.close();
    }
}