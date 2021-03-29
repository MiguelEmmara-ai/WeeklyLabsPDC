package Miguel.Corporation;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String[] ansiColor = {"\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m","\u001B[34m", "\u001B[35m" };

    public static void main(String[] args) {
        printTriangles();
    }

    private static void printTriangles() {
        Scanner scanner = new Scanner(System.in);
        getUserInput(scanner);
    }

    private static void getUserInput(Scanner scanner) {
        boolean success = true;
        do {

            try {
                System.out.print("How Tall? ");
                int tall = scanner.nextInt();
                int baseSize = tall - 3;

                if (tall >= 3) {
                    System.out.println();
                    printTriangle(tall);
                    printBase(baseSize);
                    System.out.println();
                    printPresents();
                    System.out.println();
                    printMessage();
                    success = false;
                } else {
                    System.out.println("Invalid! Must Be Greater Than " + tall + "!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid! Please Input a Number!");
                scanner.nextLine();
            }
        } while (success);
    }

    private static void printBase(int baseSize) {
        for (int i = 0; i < baseSize; i++) {
            System.out.print(" ");
        }
        System.out.println("_| |_");
        for (int i = 0; i < baseSize; i++) {
            System.out.print(" ");
        }
        System.out.println("\\___/");
    }

    private static void printTriangle(int tall) {
        int count = 0;
        for (int i = 0; i < tall; i++) {
            for (int j = 0; j < tall - 1 - i; j++)
                System.out.print(" ");
            for (int k = 0; k < (i + 1); k++) {
                if (count % 2 == 0) {
                    System.out.print(ansiColor[2] + "* " + ANSI_RESET);
                } else {
                    System.out.print(ansiColor[1] + "* " + ANSI_RESET);
                }

                count++;
            }
            System.out.println();
        }
    }

    private static void printPresents() {
        char[] randomPresents = {'!','@','#','$','%','^','&','*','-','='};

        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            System.out.print("\\|/ ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(ansiColor[random.nextInt(5)] + "[" + randomPresents[random.nextInt(9)]
                    + "] " + ANSI_RESET);
        }
    }

    private static void printMessage() {
        System.out.println("\nHappy end-of-semester holidays!");
    }
}