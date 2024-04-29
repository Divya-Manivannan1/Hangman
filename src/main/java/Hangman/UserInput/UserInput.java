package Hangman.UserInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private final static Scanner scanner = new Scanner(System.in);

    protected byte getInput(byte max) {
        // This function will return the user input if it is between 1 and max. Else, it will return.
        byte num = 0;
        try {
            num = scanner.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("The value you have entered is not a number");
            scanner.next();
        }
        if (num > max || num <= 0) {
            num = 0;
            System.out.println("Please enter a valid number");
        }
        return num;
    }

    public char getInput() {
        // This function will return a Capital letter or *
        char ch;
        ch = scanner.next().charAt(0);
        if (Character.isLetter(ch)) {
            ch = Character.toUpperCase(ch);
        } else {
            System.out.println("The value you have entered is not a letter. Please enter a valid option");
            ch = '*';
        }
        return ch;
    }

}