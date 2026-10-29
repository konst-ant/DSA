package interview.m;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private static final int CACHE_SIZE = 100;

	private final LinkedHashMap<K, V> linkedHashMap;


	public LRUCache() {
		linkedHashMap = new LinkedHashMap<K, V>(100, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				// Note removeEldestEntry is called after element inserted into the map, so check by ">" not ==
				return size() > CACHE_SIZE;
			}
		};
	}

	public void add(K key, V value) {
		linkedHashMap.put(key, value);
	}

	public V get(K key) {
		return linkedHashMap.get(key);
	}

	public V evict(K key) {
		return linkedHashMap.remove(key);
	}

	public void clear() {
		linkedHashMap.clear();
	}
}




