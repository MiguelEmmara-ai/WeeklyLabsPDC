package Task04_1_SOLUTION;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MathQuiz2 {

    private final HashMap<String, User> users;
    private final String fileName;

    public MathQuiz2() {
        this.fileName = "./resources/T04_users.txt";
        this.users = new HashMap();
        this.getUsers(fileName);
    }

    public static void main(String[] args) {

        MathQuiz2 qm = new MathQuiz2();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String s = scanner.nextLine();
        User u = qm.checkUser(s);
        Game aGame = new Game(u);
        qm.updateScore(u);
        System.out.println(u.getUsername() + ", your score is: " + u.getScore());
    }

    public void getUsers(String fn) {
        FileInputStream fin;
        try {
            fin = new FileInputStream(fn);
            Scanner fileScanner = new Scanner(fin);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                User u = new User(st.nextToken(), Integer.parseInt(st.nextToken()));
                this.users.put(u.getUsername(), u);
            }
            fin.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public User checkUser(String un) {
        User u;

        if (this.users.containsKey(un)) {
            u = this.users.get(un);
            System.out.println("Your current score: " + u.getScore());
        } else {
            u = new User(un, 0);
            this.users.put(un, u);

        }
        return u;

    }

    public void updateScore(User user) {
        this.users.put(user.getUsername(), user);
        try {
            FileOutputStream fOut = new FileOutputStream(this.fileName);
            PrintWriter pw = new PrintWriter(fOut);
            for (User u : this.users.values()) {
                pw.println(u.getUsername() + " " + u.getScore());
            }
            pw.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
