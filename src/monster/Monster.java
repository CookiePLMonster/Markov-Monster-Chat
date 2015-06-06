package monster;

import java.io.File;

public interface Monster {
    void readChatLine(String line);
    String generateChatLine();
    void readTextFile(File file);
    void generateTextFile(File file);

    int countWords();
    int countGrams();
}
