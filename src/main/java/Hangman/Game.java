package Hangman;

import Hangman.Display.Display;
import Hangman.Library.Library;
import Hangman.UserInput.UserInput;

public class Game {
    private UserInput charInput = new UserInput();
    private final String word;
    private boolean[] lettersGuessedInWord;
    private byte lives;
    private boolean gameWon = false;
    private int score = 0;
    private final boolean[] lettersGuessed = new boolean[26];

    Game(){
        word = Library.getRandomWord();
        lives = 8;
        lettersGuessedInWord
    }

    public String getWord() {
        return word;
    }

    private void move() {
        byte letterPosition = 0;
        Display.printWord(word, lettersGuessedInWord);
        char ch = charInput.getInput();
        if (ch != '*') {
            lettersGuessed[(int) ch - 65] = true;
            letterPosition = (byte) word.indexOf(ch, letterPosition);
            if (letterPosition == -1) {
                lives--;
                score -= 10;
            }
            while (letterPosition != -1 && !lettersGuessedInWord[letterPosition]) {
                lettersGuessedInWord[letterPosition] = true;
                letterPosition = (byte) word.indexOf(ch, letterPosition + 1);
                score += 10;
            }
        }
    }

    public boolean game() {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '-' || word.charAt(i) == ' ')
                lettersGuessedInWord[i] = true;
        }
        while (!gameWon && lives > 0) {
            Display.clearConsole();
            Display.printHangman(lives);
            System.out.println("Your score is: " + score);
            Display.printLettersGuessed(lettersGuessed);
            move();
            gameWon = isGameWon();
        }
        return gameWon;
    }

    private boolean isGameWon() {
        for (boolean isGuessed : lettersGuessedInWord) {
            if (!isGuessed) return false;
        }
        return true;
    }
}
