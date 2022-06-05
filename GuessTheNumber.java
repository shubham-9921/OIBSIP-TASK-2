import java.util.Scanner;
import java.util.Random;

// Game class for functioning
class GuessGame {

    // Genetating Rnadom Number
    GuessGame() {
        Random rand = new Random();
        this.sysInput = rand.nextInt(100) + 1;
    }

    int sysInput, userInput, nGuesses = 0;

    // User input Function
    public boolean getUserInput() {
        if (nGuesses < 10) {
            System.out.print("Guess the Number : ");
            this.userInput = GuessTheNumber.takeIntegerInput(100);
            nGuesses++;
            return false;
        } else {
            System.out.println("You Lose!! :( \n...Better Luck Next Time\n");
            return true;
        }
    }

    // Guessing Status
    public boolean isCorrGuess() {

        if (sysInput == userInput) {
            System.out.println("You Won !! :) , \n Congratulations, you guess the number " + sysInput +
                    " in " + nGuesses + " guesses... ");
            switch (nGuesses) {
                case 1:
                    System.out.println("Your score is 100");
                    break;
                case 2:
                    System.out.println("Your score is 90");
                    break;
                case 3:
                    System.out.println("Your score is 80");
                    break;
                case 4:
                    System.out.println("Your score is 70");
                    break;
                case 5:
                    System.out.println("Your score is 60");
                    break;
                case 6:
                    System.out.println("Your score is 50");
                    break;
                case 7:
                    System.out.println("Your score is 40");
                    break;
                case 8:
                    System.out.println("Your score is 30");
                    break;
                case 9:
                    System.out.println("Your score is 20");
                    break;
                case 10:
                    System.out.println("Your score is 10");
                    break;
            }
            System.out.println();
            return true;
        } else if (nGuesses < 10 && userInput > sysInput) {
            if (userInput - sysInput > 10) {
                System.out.println("Too High Number");
            } else {
                System.out.println("Little Bit High Number");
            }
        } else if (nGuesses < 10 && userInput < sysInput) {
            if (sysInput - userInput > 10) {
                System.out.println("Too low Number");
            } else {
                System.out.println("Little Bit low Number");
            }
        }
        return false;
    }
}

// main class
public class GuessTheNumber {

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        ;
        return input;
    }

    public static void main(String[] args) {

        // input for start the game
        System.out.println("1.Start the Game \n2.Exit");
        System.out.println("Enter your choice:");
        int choice = takeIntegerInput(2);
        int nextRound = 1, rounds = 0;

        if (choice == 1) {

            while (nextRound == 1) {

                GuessGame game = new GuessGame();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + ++rounds + "starts...");

                // Checking Limit
                while (!isMatched && !isLimitCross) {
                    isLimitCross = game.getUserInput();
                    isMatched = game.isCorrGuess();
                }
                // Next Round
                System.out.println("1. Next Round \n2.Exit");
                System.out.println("Enter Your choice : ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
