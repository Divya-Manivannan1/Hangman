package Hangman;

public class Game {
    private UserInput charInput = new UserInput();
    private final String word = Library.getRandomWord();
    private boolean[] lettersGuessedInWord = new boolean[word.length()];
    private byte lives = 8;
    private char ch = 0;

    private void move() {
        Display.printWord(word, lettersGuessedInWord);
        ch = charInput.getChar();
        if (ch != '*') {
            byte letterPosition = (byte) word.indexOf(ch, letterPosition);
            if (letterPosition == -1)
                lives--;
            while (letterPosition != -1) {
                lettersGuessedInWord[letterPosition] = true;
                letterPosition = (byte) word.indexOf(ch, letterPosition);
            }
        }
    }

    public void game() {

    }
}
