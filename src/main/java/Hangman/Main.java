package Hangman;

import Hangman.Display.Display;
import Hangman.Display.Rules;
import Hangman.UserInput.UserOptions;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        UserOptions mainMenu = new UserOptions(new String[]{"Play a new Game", "Checkout the rules", "Quit"});
        byte mainMenuOption = 0;
        Rules gameRules = new Rules();
        while (mainMenuOption != 3) {
            mainMenuOption = mainMenu.getOption();
            switch (mainMenuOption) {
                case 1:
                    if (game.game())
                        Display.printSuccessMessage();
                    else
                        Display.printFailureMessage(game.getWord());
                    break;
                case 2:
                    gameRules.printRules();
                    break;
            }
        }
    }
}
