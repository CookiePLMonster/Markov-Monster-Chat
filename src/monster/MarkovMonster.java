package monster;

import java.util.ArrayList;
import java.util.List;

public class MarkovMonster implements Monster {
    public void readTextFiles(String[] fileNames) {

    }

    void generateStats() {

    }

    public void readDictionaryFiles(String[] fileNames) {

    }

    public void generateDictionaryFile(String fileName) {

    }

    @Override
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

    @Override
    public String generateChatLine() {
        // Generujemy odpowiedź z ostatnich wpisów w Pool
        List<String> prefix = new ArrayList();
        int         tmpListSize = wordsPool.getSize();

        for ( int i = -prefixSize; i < 0; i++  )
            prefix.add(wordsPool.getList().get(tmpListSize + i));

        String  response = chains.generateSuffix(wordsPool, prefix);

        return response;
    }

    private int prefixSize = 1;   // Temp

    private Pool wordsPool = new Pool();
    private MarkovGen chains = new MarkovGen();
}
