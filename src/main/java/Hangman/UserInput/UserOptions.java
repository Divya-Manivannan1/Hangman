package Hangman.UserInput;

import Hangman.Display.Display;

public class UserOptions extends UserInput {
    public String[] options;

    public UserOptions(String[] options) {
        this.options = options;
    }

    public byte getOption() {
        System.out.println("Please choose one of the following option:");
        Display.printUserOptions(options);
        byte optionNum = 0;
        while (optionNum == 0) {
            optionNum = getInput((byte) options.length);
        }
        return optionNum;
    }
}