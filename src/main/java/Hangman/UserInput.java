package Hangman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static byte getByte(byte max) {
        byte num = 0;
        try {
            num = scanner.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("The value you have entered is not a number");
            scanner.next();
        }
        if (num > max || num < 0)
            num = 0;
        return num;
    }

    public static void main(String[] args) {
        int num;
        while (true) {
            num = getByte((byte) 4);
            System.out.println("no is" + num);
        }
    }

}
