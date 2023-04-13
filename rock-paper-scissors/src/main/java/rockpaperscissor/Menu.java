package rockpaperscissor;

public class Menu {
    // private members
    private String menuType;

    // constructor
    public Menu(){}
    public Menu(String menuType) {
        this.menuType = menuType;
    }

    // create getters and setters
    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String showGreeting() {
        return "\nHello And Welcome To ROCK\uD83E\uDEA8 PAPER\uD83D\uDCC4 SCISSORS✂\uFE0F!!\n";
    }

    public String showMenuOptions(String menuType) {
        String heading = "  MAIN MENU\n";
        heading += "=============\n" ;
        switch (menuType) {
            case "History-2":
                heading += "1.  Show game stats for Player 1.\n";
                heading += "2.  Show game stats for Player 2.\n";
                break;
            case "History-1":
                heading += "1.  Show game stats for Player 1.\n";
                break;
            case "Main":
                heading += "1.  Type 'human' for two players to play.\n";
                heading += "2.  Type 'computer' for one player to play against the Computer.\n";
//                System.out.println("Create for me a main menu w/ options");
                break;
            case "Play":
                heading += "1.  Same players, play again?\n";
                heading += "2.  Show Players Game Stats.\n";
//                System.out.println("Create for me a play menu w/ options");
                break;
            default:
                break;
        }
        heading += "3.  Type 'quit' to stop playing the game.\n";
        return heading;
    }

    public void getResponse(String response) {
//        System.out.println(response);
        switch(response) {
            case "human":
            case "h":
                System.out.println("Create human players");
                break;
            case "computer":
            case "c":
                System.out.println("Create one human and computer players");
                break;
            case "quit":
            case "q":
                System.out.println("Ah...stop game");
                break;
            default:
                System.out.println("Please make a correct selection.");
        }
    }

    public void setOptions(String options) {
        System.out.println("What are options to be displayed?  Man vs Man; Man vs Computer; Man Quits");
    }

}
