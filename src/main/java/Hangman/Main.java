package Hangman;

import Hangman.Display.Display;
import Hangman.Display.Rules;
import Hangman.User.GameUserList;
import Hangman.UserInput.UserOptions;

public class Main {
    public static void main(String[] args) {
        UserOptions splashMenu = new UserOptions(new String[]{"Sign in", "Sign up", "Exit Game"});
        UserOptions mainMenu = new UserOptions(new String[]{"Play a new Game", "Checkout the rules", "View leaderboard", "Sign out"});
        byte splashMenuOption = 0;
        byte mainMenuOption = 0;
        Rules gameRules = new Rules();
        GameUserList users = new GameUserList();

        Display.printIntro();
        while (splashMenuOption != 3) {
            splashMenuOption = splashMenu.getOption();
            switch (splashMenuOption) {
                case 1:
                    System.out.println("Sign in");
                    users.signIn();
                    break;
                case 2:
                    System.out.println("SIGN UP");
                    users.signUp();
                    break;
            }

            if (users.getCurrentUserIndex() >= 0) {

                while (mainMenuOption != 4) {
                    mainMenuOption = mainMenu.getOption();
                    switch (mainMenuOption) {
                        case 1:
                            if (users.getGame().game())
                                Display.printSuccessMessage();
                            else
                                Display.printFailureMessage(users.getGame().getWord());
                            users.setHighScore();
                            users.setNewGame();
                            break;
                        case 2:
                            gameRules.printRules();
                            break;
                        case 3:
                            Display.printLeaderboard(users.getLeaderboard());
                            break;
                        case 4:
                            users.signOut();
                    }
                }
                mainMenuOption = 0;
            }
        }
    }
}
