/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeeklyTasks.Task02_1;

/**
 * <h1>Task 2.1 Dogs</h1>
 * Dogs Class
 *
 * @author  Miguel Emmara - 18022146
 * @version 1.0
 * @since   09-03-2021
 */
public class Dogs {
    private String name;
    private String color;

    // Can be fixed  by editing the constructor as well
    /*public Dogs(String name, String color) {
        if (name == null) {
            this.name = "Default Name";
        } else {
            this.name = name;
            this.color = color;
        }
    }*/

    public Dogs(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
