package monster;

import java.util.*;

public class MarkovGen {
   /*private class GenData
    {
        int             prefixIndex;

    }*/

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

    // Multimapa prefix-suffixy
    Map<List<String>, List<String>> chainsMap = new HashMap();
}
