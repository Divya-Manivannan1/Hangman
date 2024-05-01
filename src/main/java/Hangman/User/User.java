package Hangman.User;

public class User {
    private final String name;
    private final String password;

    protected User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    protected String getName() {
        return name;
    }

    protected String getPassword() {
        return password;
    }
}
