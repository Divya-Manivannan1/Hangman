package Hangman.User;

import Hangman.UserInput.UserInput;

import java.util.ArrayList;

public class GameUserList {
    private final ArrayList<GameUser> gameUsers;
    private int currentUserIndex;
    private final UserInput stringInput;

    public GameUserList() {
        this.gameUsers = new ArrayList<>();
        currentUserIndex = -1;
        stringInput = new UserInput();
    }

    public Leaderboard[] getLeaderboard() {
        Leaderboard[] leaderboard = new Leaderboard[gameUsers.size()];
        for (int i = 0; i < gameUsers.size(); i++) {
            leaderboard[i] = new Leaderboard(gameUsers.get(i).getName(), gameUsers.get(i).getHighScore());
        }
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
                System.out.println("User signed in " + currentUserIndex);
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

    public boolean verifyPassword(String password) {
        return gameUsers.get(currentUserIndex).getPassword().equals(password);
    }

}
