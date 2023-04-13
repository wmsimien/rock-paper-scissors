package rockpaperscissor;

public class Mortal extends Player implements MortalCheck {


    // constructor
    public Mortal(String name) {
        super(name);
    }

    @Override
    public String checkName(String name) {
        if (name.length() == 0) return "Please enter player's userName.";
        if (name.toLowerCase() == "quit") return "quit";
        return "play";
    }

    @Override
    public String checkMoves(String action) {
        String move = "";
        switch(action) {
            case "r":
                move = "ROCK:  \uD83E\uDEA8";
                break;
            case "p":
                move = "PAPER:  \uD83D\uDCC4";
                break;
            case "s":
                move = "SCISSORS:  ✂\uFE0F";
                break;
            case "quit":
                move = "quit";
                break;
            default:
               move = "Incorrect option entered.  Try again or type 'quit' to end game.";
        }
        return move;
    }
}
