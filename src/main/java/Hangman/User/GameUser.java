package Hangman.User;

import Hangman.Game;

public class GameUser extends User {
    private int highScore = 0;
    private Game currentGame;

    public GameUser(String name, String password) {
        super(name, password);
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        if (this.highScore < highScore)
            this.highScore = highScore;
    }

    public void setLastPlayedGame(Game newGame) {
        currentGame = newGame;
    }

    public boolean isCurrentGameCompleted() {
        if (currentGame == null)
            return true;
        return currentGame.isGameWon();
    }

    public boolean checkLastPlayedGame(Game game) {
        return currentGame.equals(game);
    }
}
