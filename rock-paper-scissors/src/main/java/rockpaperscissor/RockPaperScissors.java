package rockpaperscissor;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        // create an array list to hold options ["R', "P", "S"]
        // prompt user w/ menu options
        // if user quits; just return
        // lowercase all user's responses
        // math random function to randomize options
        // for computer choice; when play against computer, it goes first
        // when playing human to human first user's name entered will go first
        // need to keep track of ties(computer)/wins/loses
        // play again/show menu when game over
        // timer (interface)
        // menu (interface)
        // tracking player game history

        // Create and Display menu
        Menu mainMenu = new Menu("Main");
        mainMenu.showMenuOptions(mainMenu.getMenuType());

        // create Scanner Class
        Scanner scanner = new Scanner(System.in);
        // display greeting and create main/starter menu
        System.out.println(mainMenu.showGreeting());
        System.out.println(mainMenu.showMenuOptions(mainMenu.getMenuType()));
        // get user's options
        String response = scanner.nextLine();
        mainMenu.getResponse(response.toLowerCase());
        // close scanner
        scanner.close();
        // Create players based on menu option

        // play game!


    }
}
