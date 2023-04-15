package rockpaperscissor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Mortal extends Player implements MortalCheck, Tracker {


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

    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    @Override
    public String[] readHistory(String fileName) throws IOException {
        String[] data = new String[4];
        // according to Java 8 docs, object used locate a file
        Path pathToFile = Paths.get(fileName);
//        System.out.println(pathToFile);
        // according to Java 8 docs, reads text from a character input stream
        BufferedReader bufferedReader;
        // let's attempt the reading of the file
        try {
            // read file content w/ given URI (meaning the local path of file)
            bufferedReader = new BufferedReader(new FileReader(Paths.get(pathToFile.toUri()).toFile()));
            // reads a single line from file
            String currentLine = bufferedReader.readLine();
            // while !EOF, read next line
            while(currentLine != null) {
                // create a string array
                data = currentLine.split(",");

                // read next line of text
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }

    /**
     * This method will write each played game's data to the user's file
     * @param fileName : name of file holding user's gaming data
     * @param fileData : gaming data to write to file
     * @throws IOException
     */
    @Override
    public void writeHistory(String fileName, String fileData) throws IOException{
        // according to Java 8 docs, writes text to a character output stream
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName), Charset.forName("UTF-8"), StandardOpenOption.APPEND, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            writer.write(fileData, 0, fileData.length());
        } catch(IOException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}
