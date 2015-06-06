package monster;

public class Monster {
    public enum MonsterMode {
        MODE_UNDEFINED,
        MODE_DICTIONARY,
        MODE_TEXT
    }

    private MonsterMode     mode;
    private int             gramSize;

    private Pool            wordsPool = new Pool();
    private MarkovGen       chains = new MarkovGen();

    public void             readTextFiles ( String [] fileNames )
    {

    }

    void generateStats ()
    {

    }

    public void readDictionaryFiles(String[] fileNames)
    {

    }
    public void generateDictionaryFile(String fileName)
    {

    }

    public void readChatLine(String line)
    {
        String[]    words = line.split("\\s");
        int         curWord = wordsPool.getSize();
        for ( int i = 0; i < words.length; i++ ) {
            if ( !words[i].isEmpty() )
                wordsPool.insertWord(words[i]);
        }

        // Konstruujemy łańcuchy
        chains.appendChains(wordsPool, words);
    }

    public String generateNextChatLine()
    {

        // TODO: DO
        return "";
    }
}
