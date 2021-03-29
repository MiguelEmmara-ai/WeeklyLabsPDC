package Task04_1_SOLUTION;

import java.util.HashSet;
import java.util.Scanner;

public class Game {

    private final HashSet<QuizQuestion> questions;
    private final User aUser;

    public Game(User u) {
        this.questions = new HashSet();
        this.aUser = u;
        this.doQuestions();

    }

    public void doQuestions() {

        String answer;
        Scanner sc = new Scanner(System.in);
        while (this.questions.size() < 10) {
            this.questions.add(new QuizQuestion());

        }

        System.out.println("Enter your answer as a number. Press 'X' to quit.");

        for (QuizQuestion question : this.questions) {
            System.out.println(question.num1 + " " + question.mathOp + " " + question.num2 + "=?");
            do {
                answer = sc.nextLine();
            } while (!this.isValidAnswer(answer));

            if (answer.equalsIgnoreCase("x")) {
                break;
            }
            if (Math.abs(Double.parseDouble(answer) - question.answer) <= 0.01) {
                this.aUser.setScore(aUser.getScore() + 10);
                System.out.println("Correct!");
            } else {
                this.aUser.setScore(aUser.getScore() - 10);
                System.out.println("Wrong!");
            }
        }
    }

    public boolean isValidAnswer(String answer) {
        try {
            Double.parseDouble(answer);
        } catch (NumberFormatException e) {
            if (answer.equalsIgnoreCase("x")) {
                return true;
            }
            System.out.println("Invalid Input. \n Please input your answer again: ");
            return false;
        }
        return true;
    }
}
