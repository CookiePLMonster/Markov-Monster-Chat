import junit.framework.TestCase;
import monster.Pool;

import java.util.List;

public class PoolTest extends TestCase {
    private Pool pool;

    public void setUp() throws Exception {
        super.setUp();

        pool = new Pool();
        pool.insertWord("slowoA");
        pool.insertWord("slowoB");
        pool.insertWord("slowoC");
    }

    public void testGetSize() throws Exception {
        assertEquals(pool.getSize(), 3);
    }

    public void testGetList() throws Exception {
        List<String> list = pool.getList();

        assertEquals(list.get(2), "slowoC");
        assertEquals(list.get(0), "slowoA");
    }
}