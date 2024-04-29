package Hangman;

import Hangman.Display.Display;
import Hangman.Library.Library;
import Hangman.UserInput.UserInput;

public class Game {
    private final UserInput charInput;
    private final String word;
    private final boolean[] lettersGuessedInWord;
    private byte lives;
    private boolean gameWon;
    private int score;
    private final boolean[] lettersGuessed;

    Game() {
        word = Library.getRandomWord();
        lives = 8;
        score = 0;
        lettersGuessedInWord = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '-' || word.charAt(i) == ' ')
                lettersGuessedInWord[i] = true;
        }
        lettersGuessed = new boolean[26];
        gameWon = false;
        charInput = new UserInput();
    }

    public String getWord() {
        return word;
    }

    private void move() {
        byte letterPosition = 0;
        char ch = charInput.getInput();
        if (ch != '*') {
            if (isLetterPreviouslyGuessed(ch)) {
                System.out.println("You have already guessed this letter! Please guess a new letter!");
                ch = charInput.getInput();
            }
            letterPosition = (byte) word.indexOf(ch, letterPosition);
            if (letterPosition == -1) {
                lives--;
                score -= 10;
            }
            while (letterPosition != -1) {
                lettersGuessedInWord[letterPosition] = true;
                letterPosition = (byte) word.indexOf(ch, letterPosition + 1);
                score += 10;
            }
        }
    }

    public boolean game() {
        while (!gameWon && lives > 0) {
            Display.clearConsole();
            Display.printHangman(lives);
            System.out.println("Your score is: " + score);
            Display.printLettersGuessed(lettersGuessed);
            Display.printWord(word, lettersGuessedInWord);
            move();
            gameWon = isGameWon();
        }
        return gameWon;
    }

    public boolean isGameWon() {
        for (boolean isGuessed : lettersGuessedInWord) {
            if (!isGuessed) return false;
        }
        return true;
    }

    public boolean isLetterPreviouslyGuessed(char ch) {
        boolean letterAlreadyGuessed = lettersGuessed[(int) ch - 65];
        if (!letterAlreadyGuessed)
            lettersGuessed[(int) ch - 65] = true;
        return lettersGuessed[(int) ch - 65];
    }
}
