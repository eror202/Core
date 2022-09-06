package ru.smirnov;


import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        Map<Object, Long> groupingMap = Arrays.stream(RAW_DATA).distinct()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        groupingMap.forEach((key, value) ->
        {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });

        System.out.println("**************************************************");

        System.out.println(findPairOfNumbers(Arrays.asList(3, 4, 2, 7), 10));
        System.out.println("**************************************************");

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false

    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"),
            new Person(1, "Harry"),
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static boolean fuzzySearch(String expected, String stringToSearch) {
        int index = 0;
        for (int i = 0; i < stringToSearch.length(); i++) {
            if (expected.charAt(index) == stringToSearch.charAt(i)) {
                index++;
            }
            if (index == expected.length()) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findPairOfNumbers(List<Integer> array, int expected) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (array.get(i) + array.get(j) == expected) {
                    result.add(array.get(i));
                    result.add(array.get(j));
                    return result;
                }
            }
        }
        return null;
    }

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}


