package WeeklyTasks.Task04_1_SOLUTION;

public class User {

    private String username;
    private int score = 0;

    public User(String un, int sc) {
        this.score = sc;
        this.username = un;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
