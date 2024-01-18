package struct;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * LRU cache based on native LinkedHashMap behavior
 */
public class LRUCache extends LinkedHashMap<Integer, String> {

    private static final int MAX_CACHE_SIZE = 3;

    public LRUCache() {
        super(MAX_CACHE_SIZE, 0.75F, true);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();

        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
//        cache.get(1);
        cache.put(4, "four");
        System.out.println("Cache size: " + cache.size());
        System.out.println("Cache content: ");
        cache.values().forEach(System.out::println);

        cache.put(5, "five");
        cache.put(6, "six");
        cache.put(7, "seven");
        cache.put(8, "eight");
        cache.put(9, "nine");
        System.out.println("Cache size: " + cache.size());
        System.out.println("Cache content: ");
        cache.values().forEach(System.out::println);
    }
}
