package Hangman.User;

import Hangman.Game;
import Hangman.UserInput.UserInput;

import java.util.ArrayList;
import java.util.Collections;

public class GameUserList {
    private final ArrayList<GameUser> gameUsers;
    private int currentUserIndex;
    private final UserInput stringInput;

    public GameUserList() {
        this.gameUsers = new ArrayList<>();
        currentUserIndex = -1;
        stringInput = new UserInput();
    }

    public void setHighScore() {
        gameUsers.get(currentUserIndex).setHighScore(gameUsers.get(currentUserIndex).getCurrentGame().getScore());
    }

    public void setNewGame() {
        gameUsers.get(currentUserIndex).setCurrentGame();
    }

    public Game getGame() {
        return gameUsers.get(currentUserIndex).getCurrentGame();
    }

    public ArrayList<Leaderboard> getLeaderboard() {
        ArrayList<Leaderboard> leaderboard = new ArrayList<>();
        for (GameUser gameUser : gameUsers) {
            leaderboard.add(new Leaderboard(gameUser.getName(), gameUser.getHighScore()));
        }
        Collections.sort(leaderboard);
        return leaderboard;
    }

    public int getCurrentUserIndex() {
        return currentUserIndex;
    }

    public void signOut() {
        currentUserIndex = -1;
    }

    public void signUp() {
        String userName = stringInput.getInput("Username");
        int userIndex = findUser(userName);
        if (userIndex == -1) {
            boolean passwordMismatched = true;
            while (passwordMismatched) {
                String password = stringInput.getInput("Password");
                String confirmPassword = stringInput.getInput("Confirm Password");
                if (password.equals(confirmPassword)) {
                    currentUserIndex = gameUsers.size();
                    gameUsers.add(new GameUser(userName, password));
                    passwordMismatched = false;
                } else {
                    System.out.println("Confirm password and password do not match. Please try again.");
                }
            }
        } else {
            System.out.println("Username already exists. Please try using a different userName.");
            signUp();
        }
    }

    public void signIn() {
        String userName = stringInput.getInput("Username");
        int userIndex = findUser(userName);
        if (userIndex != -1) {
            String password = stringInput.getInput("Password");
            if (!gameUsers.get(userIndex).equals(new GameUser(userName, password))) {
                System.out.println("Wrong password!!");
            } else {
                currentUserIndex = userIndex;
            }
        } else {
            System.out.println("Sorry! User not found");
        }
    }

    public int findUser(String name) {
        for (int i = 0; i < gameUsers.size(); i++) {
            if (gameUsers.get(i).getName().equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

}
