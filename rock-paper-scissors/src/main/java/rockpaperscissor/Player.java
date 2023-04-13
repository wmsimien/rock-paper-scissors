package rockpaperscissor;

import java.util.ArrayList;

public abstract class Player {
    // create private members
    private int id;
    private String userName;
    private int wins;
    private int loses;
    private int numberOfMoves;
    private ArrayList<String> gameMoves;

    // constructors
    public Player(){}
    public Player(String userName) {
        this.userName = userName;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public ArrayList<String> getGameMoves() {
        return gameMoves;
    }

    public void setGameMoves(ArrayList<String> gameMoves) {
        this.gameMoves = gameMoves;
    }

    public void makeMove() {// make into an abstract method
        System.out.println("Make your randomize move...");
    }

    @Override
    public String toString() {
        return getUserName();
    }
}
