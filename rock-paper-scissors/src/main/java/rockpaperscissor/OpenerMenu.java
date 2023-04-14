package rockpaperscissor;

public class OpenerMenu extends Menu {

    // constructor
    public OpenerMenu (String type, String text) {
        super(type, text);
    }

    /**
     * This method will handle the opening/starter menu options
     * @param menuType
     * @return
     */
    @Override
    public  String showMenuOptions(String menuType) {
        String heading = "  Opening MENU\n";
        heading += "===============\n" ;
        heading += "1.  Type 'human' for two players to play.\n";
        heading += "2.  Type 'computer' for one player to play against the Computer.\n";

        heading += "3.  Type 'quit' to stop playing the game.\n";
        return heading;
    }

    /**
     * This method will handle the player responses based on menu options
     * @param response
     * @return
     */
    public String getResponse(String response) {
        return null;
    }
}
