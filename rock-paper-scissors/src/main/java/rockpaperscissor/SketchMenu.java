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
//        heading += "1.  Please enter R, P, or S.\n";
        switch (menuType) {
            case "Sketch":
                heading += "1.  Please enter R, P, or S.\n";
//                heading += "2.  Please enter R, P, or S.\n";
                heading += "2.  Type 'quit' to stop playing the game.\n";
                break;
            default:
        }

        return heading;
    }

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
                options = "Computer play...\n";
                options += "Please enter the username for Player 1.";
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
