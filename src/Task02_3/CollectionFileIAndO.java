package Task02_3;

import java.io.*;
import java.util.*;

/**
 * <h1>Task 2.3 Collection and File I/O!</h1>
 * The program loads the existing marks from scores.txt without overwriting the
 * content in the file.
 *
 * The program prompts the user to input a student name (first name only) and
 * his/her exam mark.
 *
 * The program then checks whether the mark of the student was recorded
 * already.
 *
 * If the record is existing already, the program checks whether the user wants
 * to overwrite the record. If so, the record will be overwritten; otherwise,
 * prompt for the next input.
 *
 * The program will quit after the user inputs an "x".
 *
 * @author  Miguel Emmara - 18022146
 * @version 1.0
 * @since   10/03/2021
 */
public class CollectionFileIAndO {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String filePath = "./resources/T02_scores.txt";

    public static void main(String[] args) {
        LinkedHashMap < String, Integer > data = new LinkedHashMap <> ();

        try {
            readFile(data);

            modifyScorePrompt(data);

            editFile(data);

        } catch (FileNotFoundException e) {
            System.err.println("Error, cannot read the file.");
        }

    }

    /**
     * If the record is existing already, the program checks whether the user wants
     * to overwrite the record. If so, the record will be overwritten; otherwise,
     * prompt for the next input.
     * @param data This is the first parameter, LinkedHasMap containing the data of the score, first name and score
     */
    private static void editFile(LinkedHashMap < String, Integer > data) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePath));

        for (Map.Entry < String, Integer > entry: data.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            printWriter.println(k + " " + v);
        }

        printWriter.close();

        System.out.println("\ndata inside " + filePath + " has been updated!");
    }

    /**
     * This method is used to get user input and check whether or not the mark of the student was recorded already.
     * @param data This is the first parameter, LinkedHasMap containing the data of the score, first name and score
     */
    private static void modifyScorePrompt(LinkedHashMap < String, Integer > data) throws FileNotFoundException {
        int score;
        String studentFirstName;
        char userAnswer = 0;
        boolean quit = true;

        do {
            System.out.println("\nPlease Enter the following data below, type 'x' to exit the application");
            System.out.print("Student First Name: ");
            studentFirstName = scanner.nextLine();

            while (studentFirstName.isEmpty() || studentFirstName.contains(" ")) {
                System.out.println("Please enter a valid name!");
                System.out.print("Student First Name: ");
                studentFirstName = scanner.nextLine();
            }

            if (studentFirstName.equalsIgnoreCase("x")) {
                System.out.println("\nGoodbye!\n");
                quit = false;
                continue;
            }
            System.out.print("Student Score: ");

            try {
                score = scanner.nextInt();
                scanner.nextLine();

                if (score < 0 || score > 100) {
                    System.err.print("Please enter the score between 0 -> 100\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.err.print("Please enter the score between 0 -> 100\n");
                System.err.flush();
                scanner.nextLine();
                continue;
            }

            String firstName = studentFirstName.substring(0, 1).toUpperCase();
            firstName += studentFirstName.substring(1).toLowerCase();

            if (data.containsKey(firstName)) {
                System.out.println("\nStudent name " + firstName + " already exist inside " + filePath);
                System.out.println("Would you like to overwrite the records for " + firstName + "?: ");
                boolean overwrite = true;

                while (overwrite) {
                    try {
                        System.out.print("yes (y) or No (n): ");
                        userAnswer = Character.toLowerCase(scanner.next().charAt(0));
                        scanner.nextLine();

                        if (!(userAnswer == 'y' || userAnswer == 'n')) {
                            throw new IllegalArgumentException();
                        }
                        overwrite = false;
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        System.err.println("Enter y or n");
                    }
                }

                if (userAnswer == 'y') {
                    data.replace(firstName, score);
                }

            } else {
                data.putIfAbsent(firstName, score);
            }

        } while (quit);

        System.out.println("#New Score Data#\n");
        readFile(data);
        /*for (Map.Entry < String, Integer > e: data.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());*/

        scanner.close();
    }

    /**
     * This method is used to Read File.
     * @param data This is the first parameter, LinkedHasMap containing the data of the score, first name and score
     */
    private static void readFile(LinkedHashMap < String, Integer > data) throws FileNotFoundException{
        int score;
        String studentFirstName;
        Scanner scanner2 = new Scanner(new BufferedReader(new FileReader(filePath)));

        while (scanner2.hasNext()) {
            studentFirstName = scanner2.next();
            score = scanner2.nextInt();

            data.put(studentFirstName, score);
        }
        scanner2.close();

        System.out.println(filePath + "\n");
        for (Map.Entry < String, Integer > e: data.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }
}
