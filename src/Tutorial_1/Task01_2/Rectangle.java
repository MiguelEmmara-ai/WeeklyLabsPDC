package Tutorial_1.Task01_2;

/**
 * <h1>Rectangle</h1>
 * Rectangle Subclass from Shape used to calculate the area of the Rectangle
 * Width * Length
 *
 * @author  Miguel Emmara - 18022146
 * @since   03/03/2021
 */
public class Rectangle extends Shape {
    public double width;
    public double length;
    double answer;

    public Rectangle(double width, double length) {
        super("Rectangle");
        this.width = width;
        this.length = length;
    }

    @Override
    public void calculateArea() {
        answer = this.width * this.length;
        this.area = answer;
    }
}
