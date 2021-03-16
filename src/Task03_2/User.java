package Task03_2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class User {
    private String userName;
    private int userScore;
    private Random random;

    public User(String userName, int userScore) {
        this.userName = userName;
        this.userScore = userScore;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void getData() {
        System.out.println("User Name: " + getUserName());
        System.out.println("Score: " + getUserScore());
    }

    public boolean startQuiz(Scanner scanner) {
        random = new Random();
        float number1 = 0 + (100) * random.nextFloat();
        float number2 = 0 + (100) * random.nextFloat();
        float correctAnswer;
        int operator = random.nextInt(4);
        String userAnswer;
        String randomOperator;
        boolean isCorrect = true;

        switch (operator) {
            case 0:
                randomOperator = "+";
                correctAnswer = 1;
                break;
            case 1:
                randomOperator = "-";
                correctAnswer = 1;
                break;
            case 2:
                randomOperator = "*";
                correctAnswer = 1;
                break;
            case 3:
                randomOperator = "/";
                correctAnswer = 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        System.out.println(number1 + " " + randomOperator + " " +  +number2);

        do {
            System.out.println(correctAnswer);
            System.out.print("Answer: ");
            userAnswer = scanner.nextLine();
            //float answer = Integer.parseInt(userAnswer);

            System.out.println("user Input is: " + userAnswer);
            if (userAnswer.equalsIgnoreCase("x")) {
                break;
            }

            /*if (answer == correctAnswer) {
                System.out.println("\nCorrect!");
                System.out.println("+10 Points\n");
                this.userScore += 10;
                isCorrect = false;
            } else {
                System.out.println("\nWrong Answer!");
            }*/

            /*try {
                System.out.println(correctAnswer);
                System.out.print("Answer: ");
                userAnswer = scanner.nextLine();
                float answer = Integer.parseInt(userAnswer);

                System.out.println("user Input is: " + userAnswer);
                if (userAnswer.equalsIgnoreCase("x")) {
                    break;
                }

                if (answer == correctAnswer) {
                    System.out.println("\nCorrect!");
                    System.out.println("+10 Points\n");
                    this.userScore += 10;
                    isCorrect = false;
                } else {
                    System.out.println("\nWrong Answer!");
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid input!");
            }*/

        } while (isCorrect);
        return true;
    }
}