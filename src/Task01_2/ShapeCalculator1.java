package Task01_2;

/**
 * <h1>ShapeCalculator1</h1>
 * First Main Function to test the functionality of the code
 *
 * @author  Miguel Emmara - 18022146
 * @since   03/03/2021
 */
public class ShapeCalculator1 {
    public static void main(String[] args) {
        Circle cirObj = new Circle(2.5);
        Rectangle recObj = new Rectangle(12,16.5);
        Square squObj = new Square(3.3);

        cirObj.calculateArea();
        recObj.calculateArea();
        squObj.calculateArea();

        cirObj.printInfo();
        recObj.printInfo();
        squObj.printInfo();

    }
}
