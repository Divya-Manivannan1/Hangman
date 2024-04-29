package Hangman;

public class Game {
    private UserInput charInput = new UserInput();
    private final String word = Library.getRandomWord();
    private boolean[] lettersGuessedInWord = new boolean[word.length()];
    private byte lives = 8;
    private boolean gameWon = false;

    public String getWord() {
        return word;
    }

    private void move() {
        byte letterPosition = 0;
        Display.printWord(word, lettersGuessedInWord);
        char ch = charInput.getInput();
        if (ch != '*') {
            letterPosition = (byte) word.indexOf(ch, letterPosition);
            if (letterPosition == -1)
                lives--;
            while (letterPosition != -1) {
                lettersGuessedInWord[letterPosition] = true;
                letterPosition = (byte) word.indexOf(ch, letterPosition + 1);
            }
        }
    }

    public boolean game() {
        while (!gameWon && lives > 0) {
            Display.clearConsole();
            Display.printHangman(lives);
            move();
            gameWon = true;
            for (boolean isGuessed : lettersGuessedInWord) {
                if (!isGuessed) {
                    gameWon = false;
                    break;
                }
            }
        }
        return gameWon;
    }
}
