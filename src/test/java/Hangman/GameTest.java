package Hangman;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("check if a game is not won when initialized")
    void isGameWon_initially_gameNotWon() {
        assertFalse(game.isGameWon());
    }

    @Test
    @DisplayName("check if isLetterPreviouslyGuessed returns true when a letter is passed for the first time.")
    void isLetterPreviouslyGuessed_whenALetterIsPassesForTheFirstTime_Pass() {
        assertFalse(game.isLetterPreviouslyGuessed('A'));
    }

    @Test
    @DisplayName("check if isLetterPreviouslyGuessed returns false when the same letter is passed twice.")
    void isLetterPreviouslyGuessed_whenTheSameLetterIsPassesTwice_Fail() {
        assertFalse(game.isLetterPreviouslyGuessed('A'));
        assertTrue(game.isLetterPreviouslyGuessed('A'));
    }
}