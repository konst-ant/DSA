package struct;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * LRU cache with explicit jungling of elements within LinkedHashMap
 *
 */
public class LRUCache2<K, V> {

    private static final int MAX_CACHE_SIZE = 3;

    /**
     * here we stupidly call default constructor, to explicitly maintain re-putting the accessed key.
     * more smartly we could use constructor with boolean access flag parameter, as done in LRUCache class
     */
    private LinkedHashMap<K, V> cache = new LinkedHashMap<>(MAX_CACHE_SIZE);

    public void put(K key, V value) {
        cache.put(key, value);
        if (cache.size() > MAX_CACHE_SIZE) {
            cache.remove(cache.keySet().iterator().next());
        }
    }

    public V get (K key) {
        // remove() as get() is returning null on absent key
        V result = cache.remove(key);
        if (result != null)
            cache.put(key, result);

        return result;
    }

    public V evict(K key) {
        return cache.remove(key);
    }

    public Collection<V> values() {
        return cache.values();
    }

    public int size() {
        return cache.size();
    }

    public static void main(String[] args) {
        LRUCache2<Integer, String> cache = new LRUCache2<>();

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
//        cache.evict(8);
        System.out.println("Cache size: " + cache.size());
        System.out.println("Cache content: ");
        cache.values().forEach(System.out::println);
    }

}
