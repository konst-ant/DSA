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
 * Implement a method parameterized with type K, which performs sorting of array K[], and use that method
 * to sort 'persons' array above by 'name' and by 'age'.
 *
 */

class GenericSort{

    private static class Person{
        public String name;
        public int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    public static <T> void sortByKind(T[] array, Comparator<? super T> comparator){
        Arrays.sort(array, comparator);
    }

    public static void main(String[] args){
        Person[] persons = {
                new Person("Alice", 30),
                new Person("Peter", 28),
                new Person("Bruce", 20),
                new Person("John", 20),
                new Person("Jane", 25),
        };

        sortByKind(persons, Comparator.comparing(person -> person.name));
        printPersons(persons);

        sortByKind(persons, Comparator.comparingInt(person -> person.age));
        printPersons(persons);
    }

    private static void printPersons(Person[] persons){
        for(Person person : persons){
            System.out.println("Name: " + person.name + ", Age: " + person.age);
        }
    }
}
