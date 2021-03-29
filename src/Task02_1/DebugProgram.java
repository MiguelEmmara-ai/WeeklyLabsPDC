package Task02_1;

/**
 * <h1>Task 2.1 DebugProgram</h1>
 * Find a bug in this program
 * There was TWO issues in this program
 *
 * @author  Miguel Emmara - 18022146
 * @version 1.0
 * @since   09-03-2021
 */
public class DebugProgram {

    public static void main(String[] args) {
        DebugProgram dp = new DebugProgram();
        dp.bugMethod();
    }

    public void bugMethod() {
        //There are TWO issues in this program
        //Make a breakpoint at any line in the for loop
        //Observe the variables and figure out the issues
        Dogs d1 = new Dogs("doggy1 ", "white");
        Dogs d2 = new Dogs(" doggy2", "black");
        Dogs d3 = new Dogs("doggy3 ", "white");
        Dogs d4 = new Dogs(" doggy4", "yellow");
        //Dogs d5 = new Dogs(null, "black and white");
        Dogs d5 = new Dogs("doggy5", "black and white");

        Dogs[] dogArray = new Dogs[]{d1, d2, d3, d4, d5};

        for (Dogs dogs : dogArray) {
            String dogName = dogs.getName();
            System.out.println(dogName.trim());
        }
    }
}
