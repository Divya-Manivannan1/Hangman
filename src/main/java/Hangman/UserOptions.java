package Hangman;

public class UserOptions extends UserInput {
    public String[] options;

    public UserOptions(String[] options) {
        this.options = options;
    }

    public void setOption(String option, byte index) {
        if (index < options.length && index >= 0)
            options[index] = option;
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