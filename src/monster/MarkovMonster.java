package monster;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MarkovMonster implements Monster {

    @Override
    public void readTextFile(String filePath) {
        try {
            Charset charset = Charset.forName("UTF-8");
            BufferedReader  reader = new BufferedReader( new InputStreamReader(new FileInputStream(filePath), charset));

            // Czytamy plik słowo po słowie
            String      line;
            while ( (line = reader.readLine()) != null ) {
                System.out.println(line);   // Debug
                readChatLine(line);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateTextFile(File file)
    {
        try {
            FileWriter writer = new FileWriter(file);

            for ( String s : wordsPool.getList() )
                writer.append(s + " ");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readChatLine(String line) {
        // Dostawiamy kropkę, jesli wiadomość się na niej nie kończy
        if ( !line.endsWith(".") && !line.endsWith("!") && !line.endsWith("?") )
            line = line.concat(".");

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

        for ( int i = -Math.min(prefixSize, tmpListSize); i < 0; i++  )
            prefix.add(wordsPool.getList().get(tmpListSize + i));

        StringBuilder       response = new StringBuilder();

        // Generujemy odpowiedź składając suffixy do końca 'zdania'
        while ( response.lastIndexOf(".") == -1 && response.lastIndexOf("?") == -1 && response.lastIndexOf("!") == -1 ) {
            String      suffix = chains.generateSuffix(wordsPool, prefix);
            response.append(suffix + " ");

            // Modyfikujemy prefix
            prefix.remove(0);
            prefix.add(suffix);
        }
        return response.toString();
    }

    @Override
    public int countWords()
    {
        return wordsPool.getSize();
    }

    @Override
    public int countGrams()
    {
        return chains.getSize();
    }

    private int prefixSize = 1;   // Temp

    private Pool wordsPool = new Pool();
    private MarkovGen chains = new MarkovGen();
}
