package Task03_2;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class User {
    private static final Scanner scanner = new Scanner(System.in);
    private String userName;
    private int userScore;
    private Random random;
    private DecimalFormat decimalFormat;

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

    public void startQuiz() {
        random = new Random();
        decimalFormat = new DecimalFormat("##.##");
        int number1 = random.nextInt(100);
        int number2 = random.nextInt(100);
        float number1Float = random.nextFloat() * (100) + 0;
        float number2Float = random.nextFloat() * (100) + 0;
        float correctAnswer;
        int operator = random.nextInt(4);
        String userAnswer;
        String randomOperator;
        boolean validation = true;

        switch (operator) {
            case 0:
                randomOperator = "+";
                System.out.println(number1 + " " + randomOperator + " " +  +number2);
                correctAnswer = number1 + number2;
                break;
            case 1:
                randomOperator = "-";
                System.out.println(number1 + " " + randomOperator + " " +  +number2);
                correctAnswer = number1 - number2;
                break;
            case 2:
                randomOperator = "*";
                System.out.println(number1 + " " + randomOperator + " " +  +number2);
                correctAnswer = number1 * number2;
                break;
            case 3:
                randomOperator = "/";
                System.out.println(decimalFormat.format(number1Float) + " " + randomOperator + " " +  decimalFormat.format(number2Float));
                correctAnswer = (float) (Math.round((number1Float / number2Float) * 100.0) / 100.0);
                System.out.println("In 2 Decimal Place");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        while (validation) {
            try {
                // TO Display The Answer
                //System.out.println("Answer Is: " + correctAnswer);
                System.out.print("Answer: ");
                userAnswer = scanner.nextLine();

                float x = Float.parseFloat(userAnswer);

                if (x == correctAnswer) {
                    System.out.println("\nCorrect!");
                    System.out.println("+10 Points\n");
                    this.userScore += 10;
                    validation = false;
                } else {
                    System.out.println("\nWrong Answer!");
                    validation = true;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid input!");
            }
        }
    }
}