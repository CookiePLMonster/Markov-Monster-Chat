package monster;

public class Monster {
    public enum MonsterMode {
        MODE_UNDEFINED,
        MODE_DICTIONARY,
        MODE_TEXT
    }

    private MonsterMode mode;
    private int prefixSize = 1;   // Temp

    private Pool wordsPool = new Pool();
    private MarkovGen chains = new MarkovGen();

    public void readTextFiles(String[] fileNames) {

    }

    void generateStats() {

    }

    public void readDictionaryFiles(String[] fileNames) {

    }

    public void generateDictionaryFile(String fileName) {

    }

    public void readChatLine(String line) {
        String[] words = line.split("\\s");

        // Konstruujemy łańcuchy
        chains.appendChains(wordsPool, words, prefixSize);

        //int         curWord = wordsPool.getSize();
        for (String i : words) {
            if (!i.isEmpty())
                wordsPool.insertWord(i);
        }
    }

    public String generateNextChatLine() {

        // TODO: DO
        return "";
    }
}
