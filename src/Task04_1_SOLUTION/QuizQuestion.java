package Task04_1_SOLUTION;

import java.util.Random;

public class QuizQuestion {

    //private static int count;
    public int num1 = 0;
    public int num2 = 0;

    public String mathOp;
    public double answer = 0;

    public QuizQuestion() {
        this.getQuestion();
    }

    public QuizQuestion(int i, int j) {
        this.num1 = i;
        this.num2 = j;
        this.mathOp = "+";
        this.getResult();
    }

    /**
     * Create new question
     */
    public void getQuestion() {
        this.num1 = this.generateNumber();
        this.num2 = this.generateNumber();
        this.mathOp = this.generateOperator();
        while (mathOp.equals("/") && num2 == 0) {
            this.num2 = this.generateNumber();
        }
        this.getResult();

    }

    /**
     * Randomly generate an integer between 0 to 100
     *
     * @return
     */
    public int generateNumber() {
        Random generator = new Random();
        int i = generator.nextInt(100);
        return i;
    }

    public String generateOperator() {
        Random generator = new Random();
        int i = generator.nextInt(4);
        String mo;
        switch (i) {
            case 0:
                //this.answer = num1 + num2;
                mo = "+";
                break;
            case 1:
                //this.answer = num1 - num2;
                mo = "-";
                break;
            case 2:
                //this.answer = num1 * num2;
                mo = "*";
                break;
            default:
                //this.answer = 1.0 * num1 / num2;
                mo = "/";
                break;

        }
        return mo;

    }

    public void getResult() {

        switch (mathOp) {
            case "+":
                this.answer = num1 + num2;
                //     mo=MathOperation.ADD; 
                break;
            case "-":
                this.answer = num1 - num2;
                break;

            case "*":
                this.answer = num1 * num2;
                break;
            default:
                this.answer = 1.0 * num1 / num2;
                break;
        }

    }

    @Override
    public boolean equals(Object obj) {

        return obj != null && obj instanceof QuizQuestion
                && ((QuizQuestion) obj).num1 == (this.num1)
                && ((QuizQuestion) obj).num2 == (this.num2)
                && ((QuizQuestion) obj).mathOp.equals(this.mathOp);
    }

    @Override
    public int hashCode() {
        String s = this.num1 + this.mathOp + this.num2;

        //System.out.println(s);
        return s.hashCode();
    }

}
