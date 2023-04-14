package rockpaperscissor;

import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        // instantiate class
        RockPaperScissors rockPaperScissors = new RockPaperScissors();

        // need to keep track of ties(computer)/wins/loses
        // error handling interfaces (check for mortal responses like name, etc.)
        // tracking player game history

        // Create and Display menu
        OpenerMenu openerMenu = new OpenerMenu("Opener",
                "\nHello And Welcome To ROCK\uD83E\uDEA8 PAPER\uD83D\uDCC4 SCISSORS✂\uFE0F!!\n");

        // call method executed the game
        rockPaperScissors.runRockPaperScissors(openerMenu);
    }

    /**
     * This method handle all game play
     * @param openerMenu
     * @return
     */
    public String runRockPaperScissors(OpenerMenu openerMenu) {
        // handle game messages
        String gameMessage = "play";
        // create Scanner Class
        Scanner scanner = new Scanner(System.in);

        // display greeting and create main/starter menu
        System.out.println(openerMenu.showGreeting());
        System.out.println(openerMenu.showMenuOptions(openerMenu.getMenuType()));

        // get user's options
        SketchMenu sketchMenu = new SketchMenu("Sketch", "\nROCK\uD83E\uDEA8 PAPER\uD83D\uDCC4 SCISSORS✂\uFE0F!!\n");

        String response = scanner.nextLine();
        gameMessage = sketchMenu.getResponse(response.toLowerCase());

        // check selection is correct
        while (gameMessage.contains("selection")) {
            System.out.println(openerMenu.showMenuOptions(openerMenu.getMenuType()));
            response = scanner.nextLine();
            gameMessage = sketchMenu.getResponse(response.toLowerCase());
        }
        // mortal vs mortal play or mortal vs computer play?
        if (gameMessage.contains("stop")) {
            scanner.close();
        } else if (gameMessage.contains("Computer")) {
            System.out.println("Mortal vs Computer");
            // create mortal play and call computerPlay method
            // create human player 1
            System.out.println(sketchMenu.getResponse("computer"));
            String player1 = scanner.nextLine();
            gameMessage = checkName(player1);
            // check if player1 username entered
            while (player1.length() == 0) {
                player1 = scanner.nextLine();
                gameMessage = checkName(player1);
            }
            // checking to ensure player name entered or play wants to quit
            if (gameMessage.contains("quit") || player1.contains("quit")) {
                scanner.close();
            } else {
                Mortal mortal1 = new Mortal(player1);
                System.out.println(computerPlay(mortal1, sketchMenu));
            }
        } else {
            System.out.println(gameMessage);
            // check opening menu response is correct
            String player1 = scanner.nextLine();
            gameMessage = checkName(player1);
            // check if player1 username entered
            while (player1.length() == 0) {
                player1 = scanner.nextLine();
                gameMessage = checkName(player1);
            }
            // still checking for valid player name or msg
            if (gameMessage.contains("quit") || player1.contains("quit")) {
                scanner.close();
            } else {
                // create human player 1
                Mortal mortal1 = new Mortal(player1);
                if (mortal1.checkName(player1) == "play") {
                    System.out.println(sketchMenu.getResponse("human2"));
                    String player2 = scanner.nextLine();
                    gameMessage = checkName(player2);
                    // check if player2 username entered
                    while (player1.length() == 0) {
                        player1 = scanner.nextLine();
                        gameMessage = checkName(player1);
                    }
                    if (gameMessage.contains("quit") || player1.contains("quit")) {
                        scanner.close();
                    } else {
                        // create human player 2
                        Mortal mortal2 = new Mortal(player2);
                        if (mortal2.checkName(player2) == "play") {
                            // play game!
                            System.out.println(playGame(mortal1, mortal2, sketchMenu));
                        }
                    }
                }
            }
        }
        // close scanner
        scanner.close();
        return gameMessage;
    }
    /**
     *This method will handle playing of mortal to mortal play
     * @param p1
     * @param p2
     * @param menu
     * @return
     */
    public String playGame(Mortal p1, Mortal p2, SketchMenu menu) {
        String gamer = "";
        System.out.println(menu.showGreeting());
        Scanner scanner = new Scanner(System.in);
        System.out.println(menu.showMenuOptions(menu.getMenuType()));
        // create player arraylist
        ArrayList<String> play1List = new ArrayList<>();
        ArrayList<String> play2List = new ArrayList<>();
        // need to check response
        String response = scanner.nextLine();
        System.out.println(p1.getUserName() + ":  " + p1.checkMoves(response.toLowerCase()));
        // check response of player
        if (response.contains("Incorrect")) {
            // give player another chance; else quit game
            response = p1.checkMoves(scanner.nextLine().toLowerCase());
        }
        if (response.toLowerCase().equals("quit")) {
            // give player another chance; else quit game
            System.out.println("Good-Bye!");;
            scanner.close();
        } else {
            // update mortal 1
            play1List.add(response);
            p1.setGameMoves(play1List);
            // next player; check response
            response = scanner.nextLine();
            System.out.println(p2.getUserName() + ":  " + p2.checkMoves(response.toLowerCase()));
            play2List.add(response);
            p2.setGameMoves(play2List);
            // call method to check for winner
            gamer = checkWinLose(p1, p2);
        }
        scanner.close();
        return gamer;  // Winner
    }

    /**
     * This method will handle checking for winner/loser in throws; each throw is a game
     * @param p1 : Mortal Player 1
     * @param p2 : Mortal Player 2
     * @return : Winning message
     */
    public String checkWinLose(Mortal p1, Mortal p2) {
        // obtain player's last play
        String p1Play = p1.getGameMoves().get(p1.getGameMoves().size()-1);
        String p2Play = p2.getGameMoves().get(p2.getGameMoves().size()-1);
        String winner = "";
        if ((p1Play.equals("r") && p2Play.equals("s")) ||
                (p1Play.equals("p") && p2Play.equals("r")) ||
                (p1Play.equals("s") && p2Play.equals("p"))) {
           winner = p1.getUserName();
           // set player's data
            p1.setWins(p1.getWins()+1);
            p2.setLoses(p2.getLoses()+1);
            // phrase
            if (p1Play.equals("r")) {
                winner += " WINS, ROCK\uD83E\uDEA8 CRUSHES SCISSORS✂\uFE0F.";
            } else if (p1Play.equals("p")){
                winner += " WINS, PAPER\uD83D\uDCC4 COVERS ROCK\uD83E\uDEA8.";
            } else {
                winner += " WINS, SCISSORS✂\uFE0F CUT PAPER\uD83D\uDCC4.";
            }
        } else if ((p2Play.equals("r") && p1Play.equals("s")) ||
                (p2Play.equals("p") && p1Play.equals("r")) ||
                (p2Play.equals("s") && p1Play.equals("p"))) {
            winner = p2.getUserName();
            // set player's data
            p2.setWins(p2.getWins()+1);
            p1.setLoses(p1.getLoses()+1);
            // phrase
            if (p2Play.equals("r")) {
                winner += " WINS!, ROCK\uD83E\uDEA8 CRUSHES SCISSORS✂\uFE0F.";
            } else if (p2Play.equals("p")){
                winner += " WINS!, PAPER\uD83D\uDCC4 COVERS ROCK\uD83E\uDEA8.";
            } else {
                winner += " WINS!, SCISSORS✂\uFE0F CUT PAPER\uD83D\uDCC4.";
            }
        } else {  // tie
            winner = "It's a tie, No Winner!  Play again?";
        }
        return winner;
    }

    /**
     * This method will check if the something has been entered as a username,
     * spaces count, this is before the player is created; if 'quit' has been entered, the game will stop/quit.
     *
     * @param name
     * @return : message
     */
    public String checkName(String name) {
        String msg = "play";
        if (name.length() == 0) msg = "Please enter player's userName.";
        if (name.toLowerCase() == "quit") msg = "quit";
        return msg;
    }

    public  String computerPlay(Mortal mortalPlayer, SketchMenu menu) {
        // create array list of computer options
        List<String> gameOptions = Arrays.asList("r", "p", "s");

        // according to java 8 docs
        // use Random class to generate a random index
        // use nextInt w/ upper bound between 0 (inclusive)
        // and specified value (exclusive)
        Random random = new Random();
        int index = random.nextInt(3);
        String computerChoice = gameOptions.get(index);

        String gamerMsg = "";
        System.out.println(menu.showGreeting());
        Scanner scanner = new Scanner(System.in);
        System.out.println(menu.showMenuOptions(menu.getMenuType()));

        // create player arraylist
        ArrayList<String> play1List = new ArrayList<>();
        // need to check response
        String response = scanner.nextLine();
        // check response of player
        if (response.contains("Incorrect")) {
            // give player another chance; else quit game
            response = mortalPlayer.checkMoves(scanner.nextLine().toLowerCase());
        }
       // check user does not want to quit/stop game
        if (response.toLowerCase().equals("quit")) {
            // give player another chance; else quit game
            System.out.println("Good-Bye!");;
            scanner.close();
        } else {
            System.out.println(mortalPlayer.getUserName() + ":  " + mortalPlayer.checkMoves(response.toLowerCase()));
            // update mortal 1
            play1List.add(response);
            mortalPlayer.setGameMoves(play1List);
            // call method to check for winner
            gamerMsg = checkAgainstComputer(computerChoice, mortalPlayer);
        }
        // close scanner and return message
        scanner.close();
        return gamerMsg;
    }

    /**
     * This method will determine winner/loser between computer and mortal play
     * @param cc : computer's choice
     * @param mp : mortal player
     * @return
     */
    public String checkAgainstComputer(String cc, Mortal mp) {
        // obtain player's last play
        String mPlay = mp.getGameMoves().get(mp.getGameMoves().size()-1);
        String winMsg = "";
        if ((cc.equals("r") && mPlay.equals("s")) ||
                (cc.equals("p") && mPlay.equals("r")) ||
                (cc.equals("s") && mPlay.equals("p"))) {
            winMsg = "Computer";
            // set mortal player's data
            mp.setLoses(mp.getLoses() + 1);
            // phrase
            if (cc.equals("r")) {
                winMsg += " WINS, ROCK\uD83E\uDEA8 CRUSHES SCISSORS✂\uFE0F.";
            } else if (cc.equals("p")){
                winMsg += " WINS, PAPER\uD83D\uDCC4 COVERS ROCK\uD83E\uDEA8.";
            } else {
                winMsg += " WINS, SCISSORS✂\uFE0F CUT PAPER\uD83D\uDCC4.";
            }
        }  else if ((mPlay.equals("r") && cc.equals("s")) ||
                (mPlay.equals("p") && cc.equals("r")) ||
                (mPlay.equals("s") && cc.equals("p"))) {
            winMsg = mp.getUserName();
            // set player's data
            mp.setWins(mp.getWins()+1);
            // phrase
            if (mPlay.equals("r")) {
                winMsg += " WINS!, ROCK\uD83E\uDEA8 CRUSHES SCISSORS✂\uFE0F.";
            } else if (mPlay.equals("p")){
                winMsg += " WINS!, PAPER\uD83D\uDCC4 COVERS ROCK\uD83E\uDEA8.";
            } else {
                winMsg += " WINS!, SCISSORS✂\uFE0F CUT PAPER\uD83D\uDCC4.";
            }
        } else {  // tie
            winMsg = "It's a tie";
        }
        return winMsg;
    }
}
