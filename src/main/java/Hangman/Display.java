package Hangman;

public class Display {
    public static void printWord(String word, boolean[] guessedRight) {
        for (int i = 0; i < guessedRight.length; i++) {
            char ch = word.charAt(i);
            if (guessedRight[i])
                System.out.print(word.charAt(i));
            else if (ch == ' ' || ch == '-')
                System.out.print(ch);
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

    public static void printLettersGuessed(boolean[] lettersGuessed) {
        System.out.print("Letters guessed: ");
        boolean hasAnyLetterBeenGuessed = false;
        for (int i = 0; i < lettersGuessed.length; i++) {
            if (lettersGuessed[i]) {
                hasAnyLetterBeenGuessed = true;
                System.out.print((char) (i + 65) + " ");
            }
        }
        System.out.println(hasAnyLetterBeenGuessed ? "" : "-");
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
        System.out.println("The right answer is " + word);
    }

    public static void clearConsole() {
       /* try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        */
    }
}
