package rockpaperscissor;

public abstract class Menu {
    // private members
    private String menuType;
    private String menuText;

    // constructor
    public Menu(){}

    public Menu(String menuType, String menuText) {
        this.menuType = menuType;
        this.menuText = menuText;
    }

    // create getters and setters
    public String getMenuType() {
        return menuType;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String showGreeting() {
        return getMenuText();
        //"\nHello And Welcome To ROCK\uD83E\uDEA8 PAPER\uD83D\uDCC4 SCISSORS✂\uFE0F!!\n";
    }

    /**
     *
     * @param menuType
     * @return
     */
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

    /**
     *
     * @param response
     * @return
     */
    public abstract String getResponse(String response);
//    {
//        System.out.println(response);
//        String options = "";
//        switch(response) {
//            case "human":
//            case "h":
//                options = "Please enter the usernames for player 1 and player 2, separately.";
////                System.out.println("Create human players");
//                break;
//            case "computer":
//            case "c":
//                options = "Please enter the usernames for player 1.";
////                System.out.println("Create one human and computer players");
//                break;
//            case "quit":
//            case "q":
//                options = "Ah...stop game";
////                System.out.println("Ah...stop game");
//                break;
//            default:
//                options = "Please make a correct selection.";
////                System.out.println("Please make a correct selection.");
//        }
//        return "";
//    }

    public void setOptions(String options) {
        System.out.println("What are options to be displayed?  Man vs Man; Man vs Computer; Man Quits");
    }

}
