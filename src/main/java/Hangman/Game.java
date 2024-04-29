package Hangman;

public class Game {
    private UserInput charInput = new UserInput();
    private final String word = Library.getRandomWord();
    private boolean[] lettersGuessedInWord = new boolean[word.length()];
    private byte lives = 8;
    private boolean gameWon = false;
    private int score = 0;

    public String getWord() {
        return word;
    }

    private void move() {
        byte letterPosition = 0;
        Display.printWord(word, lettersGuessedInWord);
        char ch = charInput.getInput();
        if (ch != '*') {
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
