package Hangman.User;

public class User {
    private String name;
    private String password;

    protected User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getPassword() {
        return password;
    }

    protected boolean setPassword(String password) {
        if (this.password.equals(password)) {
            System.out.println("The new password cannot be the same as the old password");
            return false;
        }
        this.password = password;
        return true;
    }
}
