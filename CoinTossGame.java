//Name:Sabah Sayed
//Roll No.37
//Title:Toss the coin game.
//Start Date:5.08.24
//Modified Date:19.08.24
//Decription:Toss the coin game.The player has the to guess whether the coin tossed the result was heads or tails.

import java.util.Random;
import java.util.Scanner;

public class CoinTossGame {
    private enum Coin { HEADS, TAILS }
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        while (true) {
            System.out.print("Guess (h for heads, t for tails, q to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) break;

            // Check for valid input
            if (!input.equalsIgnoreCase("h") && !input.equalsIgnoreCase("t")) {
                System.out.println("Invalid input! Please enter 'h', 't', or 'q'.");
                continue; // Skip to the next iteration of the loop
            }

            Coin guess = input.equalsIgnoreCase("h") ? Coin.HEADS : Coin.TAILS;
            Coin result = tossCoin();

            if (guess == result) {
                score += 10; // Win: add 10 points
                System.out.println("You won! Score: " + score);
            } else {
                score -= 5; // Lose: subtract 5 points
                System.out.println("You lost! Score: " + score);
            }
        }
        scanner.close();
    }

    private static Coin tossCoin() {
        return random.nextBoolean() ? Coin.HEADS : Coin.TAILS;
    }
}