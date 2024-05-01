package Hangman.User;

import Hangman.Game;

public class GameUser extends User {
    private int highScore;
    private Game currentGame;

    public GameUser(String name, String password) {
        super(name, password);
        highScore = 0;
        currentGame = new Game();
    }

    public void setCurrentGame() {
        currentGame = new Game();
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int score) {
        if (highScore < score)
            highScore = score;
        if (highScore == 0 & score < 0)
            highScore = score;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().getSimpleName().equals("GameUser")) {
            GameUser userObj = (GameUser) obj;
            return userObj.getName().equals(getName()) && userObj.getPassword().equals(getPassword());
        }
        return false;
    }
}
