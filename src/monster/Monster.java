package monster;

import java.io.File;

public interface Monster {
    void setGramSize(int size);
    void readChatLine(String line);
    String generateChatLine();
    void readTextFile(String filePath);
    void generateTextFile(File file);

    int countWords();
    int countGrams();
}
