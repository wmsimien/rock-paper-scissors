package rockpaperscissor;

public class SketchMenu extends Menu {

    // constructor
    public SketchMenu (String type, String text) {
        super(type, text);
    }

    @Override
    public  String showMenuOptions(String menuType) {
        String heading = "  Player MENU\n";
        heading += "===============\n" ;
        heading += "1.  Player, your turn.\n";
        switch (menuType) {
            case "Sketch":
                heading += "2.  Please enter R, P, or S.\n";
                break;
            default:
        }

        heading += "3.  Type 'quit' to stop playing the game.\n";
        return heading;
    }

    public String getResponse(String response) {

        String options = "";
        switch(response) {
            case "human":
                options = "Please enter the usernames for Player 1.";
                break;
            case "human2":
                options = "Please enter the usernames for Player 2.";
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
