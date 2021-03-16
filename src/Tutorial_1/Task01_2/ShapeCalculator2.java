package Tutorial_1.Task01_2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * <h1>ShapeCalculator2</h1>
 * Command-Line User Interface / Character User Interface
 *
 * @author  Miguel Emmara - 18022146
 * @since   03/03/2021
 */
public class ShapeCalculator2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean quit = true;

        System.out.println("Welcome to Shape Calculator!");
        System.out.println("=======================");

        while (quit) {
            try {

                System.out.println("\nPlease select:\n" +
                        "(1) Rectangle\n" +
                        "(2) Circle\n" +
                        "(3) Square\n" +
                        "(4) Close");

                System.out.print("\nEnter your choice: ");
                int userInput = scanner.nextInt();
                scanner.nextLine();

                switch (userInput) {
                    case 1:
                        System.out.println("\nRectangle Calculator Chosen");
                        System.out.println("Please fill the information below to calculate Area Of Rectangle");
                        System.out.print("\nWidth: ");
                        double width = scanner.nextDouble();
                        System.out.print("\nLength: ");
                        double length = scanner.nextDouble();

                        Rectangle recObj = new Rectangle(width, length);
                        recObj.calculateArea();
                        printWithDelays(".....\n", TimeUnit.MILLISECONDS, 500);
                        recObj.printInfo();
                        break;
                    case 2:
                        boolean validation = true;
                        System.out.println("\nCircle Calculator Chosen");
                        System.out.println("Please fill the information below to calculate Area Of Circle");

                        do {
                            System.out.print("\nRadius: ");
                            double r = scanner.nextDouble();

                            if (r >= 1) {
                                Circle cirObj = new Circle(r);
                                cirObj.calculateArea();
                                printWithDelays(".....\n", TimeUnit.MILLISECONDS, 500);
                                cirObj.printInfo();
                                validation = false;
                            }
                            else {
                                System.err.println("Error, radius cannot be 0 (zero)");
                                System.err.flush();
                            }
                        } while (validation);
                        break;
                    case 3:
                        System.out.println("\nSquare Calculator Chosen");
                        System.out.println("Please fill the information below to calculate Area Of Square");
                        System.out.print("\nSide: ");
                        double side = scanner.nextDouble();

                        Square squObj = new Square(side);
                        squObj.calculateArea();
                        printWithDelays(".....\n", TimeUnit.MILLISECONDS, 500);
                        squObj.printInfo();
                        break;
                    case 4:
                        System.out.println("See ya!");
                        quit = false;
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Wrong Input");
                System.err.flush();
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Invalid input. Not an integer");
                System.err.flush();
                scanner.nextLine();
            }
        }
    }

    public static void printWithDelays(String data, TimeUnit unit, long delay) throws InterruptedException {
        System.out.print("\nComputing");
        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }
}