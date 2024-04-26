package Hangman;

public class UserOptions {
    public String[] options;
    private final UserInput userInput = new UserInput();

    public String[] getOptions() {
        return options;
    }

    public UserOptions(String[] options) {
        this.options = options;
    }

    public void setOptions(String option, byte index) {
        if (index < options.length && index >= 0)
            options[index] = option;
    }

    public byte getOption() {
        System.out.println("Please select a valid option");
        Display.printUserOptions(options);
        byte optionNum = 0;
        while (optionNum == 0) {
            optionNum = userInput.getByte((byte) options.length);
        }
        return optionNum;
    }
}