import algorithm.LRUCache;
import org.junit.Test;

import java.util.Random;

public class LRUCacheTest {

    @Test
    public void testLRU() {
        int whileCount = 30;

        LRUCache lruCache = new LRUCache();

        while (whileCount > 0) {
            Random random = new Random();
            int key = random.nextInt(10);
            int multiplier = random.nextInt(10);
            int value = key * multiplier;

            System.out.println("before: key:" + key + "; value:" + value);
            lruCache.set(key, value);
            int getKey = random.nextInt(10);
            System.out.println("after: key:" + getKey + "; value:" + lruCache.get(getKey));
            whileCount--;
        }
        System.out.println(lruCache);
    }

}
