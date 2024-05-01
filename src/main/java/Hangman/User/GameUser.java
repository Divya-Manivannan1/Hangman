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

    public Game getCurrentGame() {
        return currentGame;
    }

    public boolean isCurrentGameCompleted() {
        if (currentGame == null)
            return true;
        return currentGame.isGameWon();
    }

    public boolean checkLastPlayedGame(Game game) {
        return currentGame.equals(game);
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
