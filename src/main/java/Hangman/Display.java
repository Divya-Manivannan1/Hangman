package Hangman;

public class Display {
    public static void printWord(String word, boolean[] guessedRight) {
        for (int i = 0; i < guessedRight.length; i++) {
            if (guessedRight[i])
                System.out.print(word.charAt(i));
            else
                System.out.print("_");
        }
        System.out.println();
    }

    public static void printIntro() {
        System.out.println("=================================================");
        System.out.println("<<<<<<<< WELCOME TO DIVYA'S HANGMAN GAME >>>>>>>>");
        System.out.println("=================================================");
    }

    public static void printUserOptions(String[] userOptions) {
        for (byte i = 0; i < userOptions.length; i++) {
            System.out.println("Option " + (i + 1) + ": " + userOptions[i]);
        }
    }

    public static void printHangman(byte livesLeft) {
        switch (livesLeft) {
            case 8:
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("------");
                break;
            case 7:
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
                break;
            case 6:
                System.out.println("  |----------");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
                break;
            case 5:
                System.out.println("  |----------");
                System.out.println("  |    O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
                break;
            case 4:
                System.out.println("  |----------");
                System.out.println("  |    O");
                System.out.println("  |    |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
                break;
            case 3:
                System.out.println("  |----------");
                System.out.println("  |    O");
                System.out.println("  |   /|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
                break;
            case 2:
                System.out.println("  |----------");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
                break;
            case 1:
                System.out.println("  |----------");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |   /");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
                break;
            default:
                System.out.println("  |----------");
                System.out.println("  |    O");
                System.out.println("  |   /|\\");
                System.out.println("  |   / \\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("------");
        }
        System.out.println("Lives left: " + livesLeft);
    }

    public static void printSuccessMessage() {
        System.out.println("Congratulations!! You have found the right word!!");
    }

    public static void printFailureMessage(String word) {
        System.out.println("Oh No!! You've run out of lives!!");
        System.out.println("Better luck nest time!!");
        System.out.println("The actual work was " + word);
    }

}
