package monster;

import java.util.*;

public class MarkovGen {
    public void         appendChains(Pool pool, String[] newWords, int prefixSize)
    {
        // łączymy nowe stringi ze starymi łańcuchami
        List<String>        wordsToChain = new ArrayList();
        int                 poolSize = pool.getSize();
        if ( poolSize >= prefixSize ) // Mamy z czego utworzyć prefix?
        {
           // Dopełniamy listę słowami wcześniej wczytanymi
            for ( int i = -prefixSize; i < 0; i++ )
                wordsToChain.add(pool.getList().get(pool.getSize()+i));
        }

        // Dopełniamy nowymi słowami
        wordsToChain.addAll(Arrays.asList(newWords));

        // Składamy łańcuchy z tablicy wordsToChain
        for ( int i = 0, j = wordsToChain.size() - prefixSize; i < j; i++ )
        {
            List    key = new ArrayList(wordsToChain.subList(i, i + prefixSize));

            // Jeśli wpis już istnieje, dodajemy nowy wpis do multimapy
            // Jeśli nie, tworyzmy wpis
            if ( chainsMap.containsKey(key) )
                chainsMap.get(key).add(wordsToChain.get(i + prefixSize));
            else {
                List value = new ArrayList();
                value.add(wordsToChain.get(i + prefixSize));
                chainsMap.put(key, value);
            }
           // chainsMap.put(, wordsToChain.get(i + prefixSize) ));

        }
    }

    public String generateSuffix(Pool pool, List<String> prefix)
    {
        Random      rand = new Random();
        if ( chainsMap.size() > 0 ) {
            if (chainsMap.containsKey(prefix)) {
                List<String> suffixes = chainsMap.get(prefix);
                return suffixes.get(rand.nextInt(suffixes.size()));
            }

            // Losujemy całkowicie losowy suffix
            Object[] suffixes = chainsMap.values().toArray();
            List<String>    randSuffix =  (List<String>)suffixes[rand.nextInt(suffixes.length)];
            return randSuffix.get(rand.nextInt(randSuffix.size()));
        }

        // Nie mamy zadnych łańcudhów, odpowiadamy losowym słowem
        return pool.getList().get(rand.nextInt(pool.getSize()));
    }

    public int getSize()
    {
        int n = 0;
        for ( Map.Entry<List<String>, List<String>> l : chainsMap.entrySet() )
            n += l.getValue().size();

        return n;
    }

    // Multimapa prefix-suffixy
    Map<List<String>, List<String>> chainsMap = new HashMap();
}
