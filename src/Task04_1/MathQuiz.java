package Task04_1;

import java.io.*;
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
    public static LinkedHashMap < String, Integer > data = new LinkedHashMap < > ();

    public static void main(String[] args) throws FileNotFoundException {
        int userScore = 0;
        int counter = 0;
        System.out.println("Math Quiz");
        System.out.println("=========");

        readFile(data);
        System.out.print("\nWhat Is Your User Name: ");
        String userName = scanner.nextLine();

        while (userName.isEmpty() || userName.contains(" ")) {
            System.out.println("Please enter a valid name!");
            System.out.print("What Is Your User Name: ");
            userName = scanner.nextLine();
        }

        String UserNameCapitalized = convert(userName);

        if (data.containsKey(UserNameCapitalized)) {
            userScore = data.get(UserNameCapitalized);
            Questions questions = new Questions(UserNameCapitalized, userScore);
            System.out.println();
            questions.getData();
            System.out.println();
            quizPrompt(counter, true, UserNameCapitalized, questions);
        } else {
            Questions questions = new Questions(UserNameCapitalized, userScore);
            System.out.println();
            questions.getData();
            System.out.println();
            quizPrompt(counter, true, UserNameCapitalized, questions);
        }
    }

    private static void quizPrompt(int counter, boolean stop, String userName, Questions questions) throws FileNotFoundException {
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
                    data.put(userName, questions.getUserScore());
                    editFile(data);
                    stop = false;
                } else {
                    System.out.println("\nWrong answer, Please Type (y/x)!");
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Wrong answer, Please Type (y/x):");
            }
        } while (stop);
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
    }

    private static void editFile(LinkedHashMap < String, Integer > data) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePath));

        for (Map.Entry < String, Integer > entry: data.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            printWriter.println(k + " " + v);
        }

        printWriter.close();
    }

    public static String convert(String str) {

        // Create a char array of given String
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {

            // If first character of a word is found
            if (i == 0 && ch[i] != ' ' ||
                    ch[i] != ' ' && ch[i - 1] == ' ') {

                // If it is in lower-case
                if (ch[i] >= 'a' && ch[i] <= 'z') {

                    // Convert into Upper-case
                    ch[i] = (char)(ch[i] - 'a' + 'A');
                }
            }

            // If apart from first character
            // Any one is in Upper-case
            else if (ch[i] >= 'A' && ch[i] <= 'Z')

                // Convert into Lower-Case
                ch[i] = (char)(ch[i] + 'a' - 'A');
        }

        // Convert the char array to equivalent String
        return new String(ch);
    }
}