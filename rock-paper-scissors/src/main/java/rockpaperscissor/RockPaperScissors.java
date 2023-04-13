package rockpaperscissor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        // instantiate class
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        List<String> gameOptions = Arrays.asList("R", "P", "S");
        String gameMessage = "";

        // create an array list to hold options ["R', "P", "S"]

        // if user quits; just return

        // math random function to randomize options
        // for computer choice; when play against computer, it goes first

        // need to keep track of ties(computer)/wins/loses
        // play again/show menu when game over
        // timer (interface)
        // error handling interfaces (check for mortal responses like name, etc.)
        // menu (class)
        // tracking player game history

        // Create and Display menu
        OpenerMenu openerMenu = new OpenerMenu("Opener",
                "\nHello And Welcome To ROCK\uD83E\uDEA8 PAPER\uD83D\uDCC4 SCISSORS✂\uFE0F!!\n");

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
       // play?
        if (gameMessage.contains("stop")) {
            scanner.close();
        } else {
            System.out.println(gameMessage);
            // check opening menu response is correct
            String player1 = scanner.nextLine();
            gameMessage = checkName(player1);
            System.out.println(gameMessage);
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
                    System.out.println(gameMessage);
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
                            System.out.println(rockPaperScissors.playGame(mortal1, mortal2, sketchMenu));
                        }
                    }

                } else {
                    // display start menu again??
                }
            }
        }
        // close scanner
        scanner.close();
    }

    /**
     *
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
//        System.out.println("player1: " + p1 + ", " + "player2: " + p2);

        ArrayList<String> play1List = new ArrayList<>();
        ArrayList<String> play2List = new ArrayList<>();
        // need to check response
        String response = scanner.nextLine();
        System.out.println(p1.getUserName() + ":  " + p1.checkMoves(response.toLowerCase()));
                //p1.checkMoves(scanner.nextLine().toLowerCase());
//        System.out.println(response);
        if (response.contains("Incorrect")) {
            // give player another chance; else quit game
            response = p1.checkMoves(scanner.nextLine().toLowerCase());
        }
        if (response.toLowerCase() == "quit") {
            // give player another chance; else quit game
            System.out.println("Good-Bye!");;
            scanner.close();
        } else {
            // update mortal 1
            play1List.add(response);
            p1.setGameMoves(play1List);
            // next player
            response = scanner.nextLine();
            System.out.println(p2.getUserName() + ":  " + p2.checkMoves(response.toLowerCase()));
            play2List.add(response);
            p2.setGameMoves(play2List);
            // check win/lose options
//            System.out.println("mortal1:  " + p1.getGameMoves());
//            System.out.println("mortal2:  " + p2.getGameMoves());

            // call method to check for winner
            gamer = checkWinLose(p1, p2);
//                    play1List.get(play1List.size()-1), play2List.get(play2List.size()-1));


        }
        scanner.close();
        return gamer;
    }

    /**
     *
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
        }
        return winner;
    }

    /** This method will check if the something has been entered as a username,
     * spaces count; if 'quit' has been entered, the game will stop/quit.
     *
     * @param name
     * @return : message
     */
    public static String checkName(String name) {
        String msg = "play";
        if (name.length() == 0) msg = "Please enter player's userName.";
        if (name.toLowerCase() == "quit") msg = "quit";
        return msg;
    }
}
