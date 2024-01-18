package struct;

import java.util.*;

/**
 * This is LRU implementation which takes advantage of using Singly Linked List,
 * relying on sentinel nodes that enables using one-side links.
 *
 * (And also sentinels simplify all hard-weighted edge case checks)
 *
 */
public class LRUCache4<K, V> {

    private static final int CACHE_CAPACITY = 3;

    private Map<K, V> cache = new HashMap<>(CACHE_CAPACITY);
    private SinglyLinkedList<K> addAccessSequence = new SinglyLinkedList<>();

    public void put(K key, V value) {
        cache.put(key, value);
        addAccessSequence.add(key);
        if (cache.size() > CACHE_CAPACITY) {
            K removedKey = addAccessSequence.removeFirst();
            cache.remove(removedKey);
        }
    }

    public V get(K key) {
        V value = cache.get(key);
        addAccessSequence.remove(key);
        addAccessSequence.add(key);
        return value;
    }

    public V evict(K key) {
        V value = cache.remove(key);
        addAccessSequence.remove(key);
        return value;
    }

    public int size() {
        return cache.size();
    }

    /**
     * Make a dumb implementation for getting values.
     * It would be much better to make this class Iterable, as I did SinglyLinkedList, and return back
     * Iterator instead of Collection
     *
     * Also, if we don't care about the order of elements being returned, we can simply call cache.values()
     */
    public Collection<V> values() {
        List<V> result = new ArrayList<>();
        for (Object key : addAccessSequence) {
            result.add(cache.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        LRUCache4<Integer, String> cache = new LRUCache4<>();

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
