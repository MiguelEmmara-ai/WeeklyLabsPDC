package Task03_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>MathQuiz</h1>
 * Randomly generate a math
 * Question, and check whether the user can provide the correct answer.
 *
 * @author  Miguel Emmara - 18022146
 * @since   17/03/2021
 */

public class MathQuiz {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int userScore = 0;
        int counter = 0;
        boolean stop = true;
        System.out.println("Math Quiz");
        System.out.println("=========");

        System.out.print("\nWhat Is Your Name: ");
        String userName = scanner.nextLine();
        User user = new User(userName,userScore);

        System.out.println();
        user.getData();
        System.out.println();

        do {
            if (counter <= 0) {
                System.out.print("Start Math Quiz? (y/x): ");
            } else {
                System.out.print("Continue Math Quiz? (y/x): ");
            }
            String answer = scanner.nextLine();

            try {
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println();
                    user.startQuiz();
                    counter++;
                } else if (answer.equalsIgnoreCase("x")) {
                    System.out.println("\nMath Quiz Finished!\n");
                    user.getData();
                    stop = false;
                } else {
                    System.out.println("\nWrong answer, Please Type (y/x)!");
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong answer, Please Type (y/x):");
            }
        } while (stop);
    }
}
