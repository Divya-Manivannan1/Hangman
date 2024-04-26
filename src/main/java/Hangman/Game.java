package Hangman;

public class Game {
    private UserInput charInput = new UserInput();
    private final String word = Library.getRandomWord();
    private boolean[] lettersGuessedInWord = new boolean[word.length()];
    private byte lives = 8;
    private boolean gameWon = false;

    private void move() {
        byte letterPosition = 0;
        Display.printWord(word, lettersGuessedInWord);
        char ch = charInput.getChar();
        if (ch != '*') {
            letterPosition = (byte) word.indexOf(ch, letterPosition);
            if (letterPosition == -1)
                lives--;
            while (letterPosition != -1) {
                lettersGuessedInWord[letterPosition] = true;
                letterPosition = (byte) word.indexOf(ch, letterPosition);
            }
        }
    }

    public void game() {
        while (!gameWon) {
            move();
            gameWon = true;
            for (boolean isGuessed : lettersGuessedInWord) {
                if (!isGuessed) {
                    gameWon = false;
                    break;
                }
            }
        }
    }
}
