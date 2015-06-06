package monster;

import java.util.ArrayList;
import java.util.List;

public class Pool {
    public class WMEntry {
        private String      rawWord;
        private int         refCount;

        public void         weHaveUsedAWord()
        { refCount++; }

    }

    public int              getSize()
        { return words.size(); }
    public List<String>     getList()
        { return words; }

    public void             insertWord(String word)
    {
        words.add(word);
    }

    private List<String>            words = new ArrayList();
}
