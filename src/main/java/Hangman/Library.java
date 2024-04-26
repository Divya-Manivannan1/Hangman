package Hangman;

import java.util.Random;

public class Library {

    private static final String[] wordBank = new String[]{"Elvis Presley", "Taylor Swift", "Rihanna", "George Harrison", "Kendrick Lamar", "Marlene Dietrich", "Ciara", "Shakira"};

    public static String getRandomWord() {
        Random rand = new Random();
        return wordBank[rand.nextInt(wordBank.length)].toUpperCase();
    }
}
