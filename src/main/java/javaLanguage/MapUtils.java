package javaLanguage;

import java.util.*;

public class MapUtils {

    /**
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return Map with determined Map.Entry iteration order, according to sorted values
     *         (duplicates ok)
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map,
                                                                             Comparator<? super V> comparator) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(comparator));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    /**
     *
     * @param map
     * @return SortedSet of Map.Entry sorted by value, however if values have duplicates they are removed
     *         (random element will be present in result)
     */
    public static SortedSet<Map.Entry<Integer, Integer>> sortByValueRemoveDuplicates(Map<Integer, Integer> map) {
        SortedSet<Map.Entry<Integer, Integer>> result = new TreeSet<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        if (o1.getValue() < o2.getValue()) {
                            return 1;
                        } else if (o1.getValue() > o2.getValue()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
        );
        result.addAll(map.entrySet());
        return result;
    }
}
