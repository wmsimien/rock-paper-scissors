package rockpaperscissor;

public class OpenerMenu extends Menu {

    // constructor
    public OpenerMenu (String type, String text) {
        super(type, text);
    }

    @Override
    public  String showMenuOptions(String menuType) {
        String heading = "  Opening MENU\n";
        heading += "=============\n" ;
        heading += "1.  Type 'human' for two players to play.\n";
        heading += "2.  Type 'computer' for one player to play against the Computer.\n";

        heading += "3.  Type 'quit' to stop playing the game.\n";
        return heading;
    }

    public String getResponse(String response) {

        String options = "";
        switch(response) {
            case "human":
            case "h":
                options = "Please enter the usernames for player 1 and player 2, separately.";
                break;
            case "computer":
            case "c":
                options = "Please enter the usernames for player 1.";
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
