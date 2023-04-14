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
    }

    /**
     * The method will handle various menu options
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

}
