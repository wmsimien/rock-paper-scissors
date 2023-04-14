package rockpaperscissor;

public class SketchMenu extends Menu {

    // constructor
    public SketchMenu (String type, String text) {
        super(type, text);
    }

    /**
     * This method will handle the display for various menus
     * @param menuType
     * @return
     */
    @Override
    public  String showMenuOptions(String menuType) {
        String heading = "  Player MENU\n";
        heading += "===============\n" ;

        switch (menuType) {
            case "Sketch":
                heading += "1.  Please enter R, P, or S.\n";
                heading += "2.  Type 'quit' to stop playing the game.\n";
                break;
            default:
        }

        return heading;
    }

    /**
     * This method will handle the responses based on menu options
     * @param response
     * @return
     */
    public String getResponse(String response) {

        String options = "";
        switch(response) {
            case "human":
                options = "Please enter the username for Player 1.";
                break;
            case "human2":
                options = "Please enter the username for Player 2.";
                break;
            case "computer":
                options = "Computer will play...\n";
                options += "Please enter your username Player 1.";
                break;
            case "quit":
            case "q":
                options = "Ah...stop game";
                break;
            default:
                options = "Please make a correct selection.";
        }
        return options;
    }
}
