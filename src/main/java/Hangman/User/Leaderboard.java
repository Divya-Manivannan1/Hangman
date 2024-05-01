package Hangman.User;

public class Leaderboard implements Comparable<Leaderboard> {
    private final String name;
    private final int highScore;

    public Leaderboard(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    public String getName() {
        return name;
    }

    public int getHighScore() {
        return highScore;
    }

    @Override
    public int compareTo(Leaderboard leaderboard1) {
        return leaderboard1.highScore - highScore;
    }
}
