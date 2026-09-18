package class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"rock", "paper", "scissors"};

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Round " + (i + 1) +
                    " - Enter Rock, Paper or Scissors: ");

            playerMoves[i] = sc.nextLine().toLowerCase();

            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(
                    playerMoves[i],
                    computerMoves[i]
            );

            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
            System.out.println();

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (double) wins / n * 100;

        System.out.println("\nFinal Summary");
        System.out.println("---------------------------------------------");
        System.out.println("Round\tPlayer\tComputer\tResult");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    playerMoves[i] + "\t" +
                    computerMoves[i] + "\t\t" +
                    results[i]
            );
        }

        System.out.println("---------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
    }
}