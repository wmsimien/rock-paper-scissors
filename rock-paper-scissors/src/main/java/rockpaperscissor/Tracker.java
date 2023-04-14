package rockpaperscissor;

import java.io.IOException;

public interface Tracker {
    /**
     * Method to read from a file.
     * @param fileName
     * @return
     */
    String[] readHistory(String fileName) throws IOException;

    /**
     * Method to write to a file
     * @param fileName
     */
    void writeHistory(String fileName, String fileDat) throws IOException;





}
