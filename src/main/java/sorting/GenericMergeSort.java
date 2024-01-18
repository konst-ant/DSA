package sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * You are given array of Person objects:
 *
 * Person[] persons = new Person[5];
 *
 * persons[0] = new Person("Alice", 30);
 * persons[1] = new Person("Peter", 28);
 * persons[2] = new Person("Bruce", 20);
 * persons[3] = new Person("John", 20);
 * persons[4] = new Person("Jane", 25);
 *
 * class Person {
 * 	public String name;
 * 	public int age;
 * }
 *
 * Implement a parameterized method, which performs sorting of array of arbitrary type K[] with merge-sort algorithm, and use that method
 * to sort persons array by 'name' and by 'age'.
 *
 * public static <K> void mergeSort(K[] S, Comparator<K> comp)
 *
 */

public class GenericMergeSort {

    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Alice", 30);
        persons[1] = new Person("Peter", 28);
        persons[2] = new Person("Bruce", 20);
        persons[3] = new Person("John", 20);
        persons[4] = new Person("Jane", 25);

        mergeSort(persons, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
//                return o1.name.compareTo(o2.name);


                if (o1.age < o2.age) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (Person e : persons) {
            System.out.println(e);
        }

    }

    /** Merge contents of arrays S1 and S2 into properly sized array S. */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i+j] = S1[i++];                     // copy ith element of S1 and increment i
            else
                S[i+j] = S2[j++];                     // copy jth element of S2 and increment j
        }
    }

    /** Merge-sort contents of array S. */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return;                        // array is trivially sorted
        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);   // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);   // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp);                      // sort copy of first half
        mergeSort(S2, comp);                      // sort copy of second half
        // merge results
        merge(S1, S2, S, comp);               // merge sorted halves back into original
    }

    private static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            StringBuilder result = new StringBuilder(name);
            result.append(", " + age);
            return result.toString();
        }
    }
}
