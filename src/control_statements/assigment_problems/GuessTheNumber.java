package control_statements.assigment_problems;
import java.util.Scanner;
public class GuessTheNumber {
    static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {

        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && tries < guesses.length) {

            int guess = guesses[tries];

            if (guess > secretNumber) {
                System.out.println("Too high");
            }
            else if (guess < secretNumber) {
                System.out.println("Too low");
            }
            else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }

            tries++;
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter secret number: ");
        int secretNumber = sc.nextInt();

        System.out.print("Enter maximum number of tries: ");
        int maxTries = sc.nextInt();

        int[] guesses = new int[maxTries];

        System.out.println("Enter your guesses:");

        for (int i = 0; i < maxTries; i++) {
            guesses[i] = sc.nextInt();
        }

        guessTheNumber(secretNumber, maxTries, guesses);
    }
}
