package Hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    @DisplayName("check if a game is won when the right word is guessed")
    void isGameWon_whenWordIsGuessed_gameWon() {
        String word = game.getWord();
        for (int i = 0; i < word.length(); i++)
            isLetterPreviouslyGuessed(word.charAt(i));
        asserTrue(game.isGameWon());
    }
    
    @Test
    @DisplayName("check if isLetterPreviouslyGuessed returns false when the same letter is passed twice.")
    void isLetterPreviouslyGuessed_whenTheSameLetterIsPassesTwice_Fail(char c) {
        assertTrue(isLetterPreviouslyGuessed('a'));
        assertFalse(isLetterPreviouslyGuessed('a'));
    }
}