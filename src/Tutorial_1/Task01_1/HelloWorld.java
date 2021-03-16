package Tutorial_1.Task01_1;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Student student = new Student("Miguel", 20);
        System.out.println("Student name: " + student.getName() + "\nAge: " + student.getAge());

    }
}
