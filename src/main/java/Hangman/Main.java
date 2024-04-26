package Hangman;

public class Main {
    public static void main(String[] args) {
        boolean gameWon = false;
        UserOptions mainMenu = new UserOptions(new String[]{"Play a new Game", "Checkout the rules", "Quit"});
        byte mainMenuOption = 0;
        Rules gameRules = new Rules();
        while (mainMenuOption != 3) {
            mainMenuOption = mainMenu.getOption();
            switch (mainMenuOption) {
                case 1:

                    break;
                case 2:
                    gameRules.printRules();
                    break;
            }
        }
    }
}
