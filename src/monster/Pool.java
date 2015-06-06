package monster;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

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

    public void             insertWord(String word)
    {
        words.add(word);
    }

    private List<String>            words = new ArrayList();
}
