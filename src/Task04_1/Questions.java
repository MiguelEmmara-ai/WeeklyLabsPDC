package Task04_1;

import java.text.DecimalFormat;
import java.util.*;

/**
 * <h1>User Class</h1>
 * Randomly generate a math
 * Question, and check whether the user can provide the correct answer.
 *
 * @author  Miguel Emmara - 18022146
 * @since   17/03/2021
 */
public class Questions {
    private static final Scanner scanner = new Scanner(System.in);
    private String userName;
    private int number1;
    private int number2;
    private float number1Float;
    private float number2Float;
    private int userScore;
    private final Random random;
    private DecimalFormat decimalFormat;
    private final ArrayList < String > numberOfQuestions = new ArrayList < > ();

    public Questions(String userName, int userScore) {
        random = new Random();
        decimalFormat = new DecimalFormat("##.##");
        this.userName = userName;
        this.userScore = userScore;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = random.nextInt(number1);;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = random.nextInt(number2);;
    }

    public float getNumber1Float() {
        return number1Float;
    }

    public void setNumber1Float(float number1Float) {
        this.number1Float = random.nextFloat() * (number1Float) + 0;
    }

    public float getNumber2Float() {
        return number2Float;
    }

    public void setNumber2Float(float number2Float) {
        this.number2Float = random.nextFloat() * (number2Float) + 0;
    }

    public void getData() {
        System.out.println("User Name: " + getUserName());
        System.out.println("Score: " + getUserScore());
    }

    public void startQuiz() {
        ArrayList<Float> correctAnswer = new ArrayList<Float>();
        String randomOperator;
        int range = 100;

        for (int i = 0; i < 10; i++) {
            int operator = random.nextInt(4);
            setNumber1(range);
            setNumber2(range);
            setNumber1Float(range);
            setNumber2Float(range);
            switch (operator) {
                case 0:
                    randomOperator = "+";
                    numberOfQuestions.add(getNumber1() + " " + randomOperator + " " + getNumber2());
                    correctAnswer.add((float) (getNumber1() + getNumber2()));
                    break;
                case 1:
                    randomOperator = "-";
                    numberOfQuestions.add(getNumber1() + " " + randomOperator + " " + getNumber2());
                    correctAnswer.add((float) (getNumber1() - getNumber2()));
                    break;
                case 2:
                    randomOperator = "*";
                    numberOfQuestions.add(getNumber1() + " " + randomOperator + " " + getNumber2());
                    correctAnswer.add((float) (getNumber1() * getNumber2()));
                    break;
                case 3:
                    randomOperator = "/";
                    numberOfQuestions.add(decimalFormat.format(getNumber1Float()) + " " + randomOperator + " " +
                            decimalFormat.format(getNumber2Float()) + "\nIn 2 Decimal Place\n");
                    correctAnswer.add((float)(Math.round((getNumber1Float() / getNumber2Float()) * 100.0) / 100.0));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }

        }

        for (int j = 0; j < 10; j++) {
            System.out.println(numberOfQuestions.get(j));
            checkAnswer(correctAnswer.get(j), true);
        }

    }

    private void checkAnswer(float correctAnswer, boolean validation) {
        String userAnswer;
        while (validation) {
            try {
                // To Display The Answer
                //System.out.println("\nAnswer Is: " + correctAnswer + "\n");
                System.out.print("Answer: ");
                userAnswer = scanner.nextLine();

                float x = Float.parseFloat(userAnswer);

                if (x == correctAnswer) {
                    System.out.println("\nCorrect!");
                    System.out.println("+10 Points\n");
                    this.userScore += 10;
                } else {
                    System.out.println("\nWrong Answer!");
                    System.out.println("Answer Is: " + correctAnswer);
                    System.out.println("-10 Points\n");
                    this.userScore -= 10;

                }
                validation = false;

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid input!");
            }
        }
    }
}