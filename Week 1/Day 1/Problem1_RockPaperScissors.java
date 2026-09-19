import java.util.Random;
import java.util.Scanner;

public class Problem1_RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Play 5 rounds
        for (int i = 0; i < 5; i++) {

            System.out.print("Round " + (i + 1) +
                    " - Enter your move (Rock/Paper/Scissors): ");

            playerMoves[i] = sc.nextLine();

            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Computer Move: " + computerMoves[i]);
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

        // Calculate win percentage
        double winPercentage = (wins / 5.0) * 100;

        // Display final summary
        System.out.println("========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < 5; i++) {

            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println();
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        sc.close();
    }
}