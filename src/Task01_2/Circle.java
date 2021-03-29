package WeeklyTasks.Task01_2;

/**
 * <h1>Circle Class</h1>
 * Circle Subclass From Shape used to calculate the area of the Circle.
 * PI * (R2)
 *
 * @author  Miguel Emmara - 18022146
 * @since   03/03/2021
 */
public class Circle extends Shape {
    static final double PI = Math.PI;
    public double r;
    double answer;

    public Circle(double r) {
        super("Circle");
        this.r = r;
    }

    @Override
    public void calculateArea() {
        answer = PI * Math.pow(r, 2);
        this.area = answer;
    }
}
