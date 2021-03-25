package Task04_1;

import Task11_1.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
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
    public static final Scanner scanner = new Scanner(System.in);
    public static final String filePath = "./resources/T04_users.txt";
    public static LinkedHashMap < String, Integer > data = new LinkedHashMap <> ();

    public static void main(String[] args) throws FileNotFoundException {
        int userScore = 0;
        int counter = 0;
        boolean stop = true;
        System.out.println("Math Quiz");
        System.out.println("=========");

        readFile(data);
        System.out.print("\nWhat Is Your Name: ");
        String userName = scanner.nextLine();

        if (data.containsKey(userName)) {
            userScore = data.get(userName);
            Questions questions = new Questions(userName,userScore);
            System.out.println();
            questions.getData();
            System.out.println();
        } else {
            Questions questions = new Questions(userName,userScore);
            System.out.println();
            questions.getData();
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
                        questions.startQuiz();
                        counter++;
                    } else if (answer.equalsIgnoreCase("x")) {
                        System.out.println("\nMath Quiz Finished!\n");
                        questions.getData();
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

    private static void readFile(LinkedHashMap < String, Integer > data) throws FileNotFoundException {
        int score;
        String studentFirstName;
        Scanner scanner2 = new Scanner(new BufferedReader(new FileReader(filePath)));

        while (scanner2.hasNext()) {
            studentFirstName = scanner2.next();
            score = scanner2.nextInt();

            data.put(studentFirstName, score);
        }
        scanner2.close();

        /*System.out.println(filePath + "\n");
        for (Map.Entry < String, Integer > e: data.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());*/
    }
}
