package WeeklyTasks.Task01_2;

import java.text.DecimalFormat;

/**
 * <h1>Shape Class</h1>
 * Parent Class of of all the shapes.
 *
 * @author  Miguel Emmara - 18022146
 * @since   03/03/2021
 */
public abstract class Shape {
    public String shapeName = "";
    public double area = 0;
    DecimalFormat df_obj = new DecimalFormat("#.###");

    public Shape(String name) {
        this.shapeName = name;
    }

    public void printInfo() {
        /*System.out.println(this.shapeName);
        System.out.println(this.area);*/

        System.out.println("Area of the " + this.shapeName + " is: " + df_obj.format(this.area));


    }

    public void setName(String newName) {
        this.shapeName = newName;
    }

    //please be noted that this is an abstract function
    public abstract void calculateArea();
}
