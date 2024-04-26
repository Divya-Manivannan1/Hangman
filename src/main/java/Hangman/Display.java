package Hangman;

public class Display {
    public static void printWord(String word, boolean[] guessedRight){
        for(int i=0; i<guessedRight.length;i++){
            if(guessedRight[i])
                System.out.print(word.charAt(i));
            else
                System.out.print("_");
        }
        System.out.println();
    }
    public static void printIntro(){
        System.out.println("=================================================");
        System.out.println("<<<<<<<< WELCOME TO DIVYA'S HANGMAN GAME >>>>>>>>");
        System.out.println("=================================================");
    }
    public static void printUserOptions(String[] userOptions){
        for(byte i=0; i<userOptions.length; i++){
            System.out.println("Option "+(i+1)+": "+userOptions[i]);
        }
    }

    public static void main (String[] args){
        printIntro();
        printWord("Hello" , new boolean[]{false, true, false, false, true});
        printUserOptions(new String[]{"Hi", "hello"});
    }
}
