package Task03_2;

import java.util.Scanner;

public class MathQuiz {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int userScore = 0;
        boolean stop = false;
        System.out.println("Math Quiz");
        System.out.println("=========");

        System.out.print("\n\nWhat Is Your Name: ");
        String userName = scanner.nextLine();
        User user = new User(userName,userScore);

        System.out.println();
        user.getData();

        System.out.println();
        while (!stop) {
            stop = user.startQuiz(scanner);
        }

        System.out.println("\nMath Quiz Finished!\n");
        user.getData();

    }
}
