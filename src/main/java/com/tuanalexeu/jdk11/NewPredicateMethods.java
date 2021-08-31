package com.tuanalexeu.jdk11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NewPredicateMethods {

    private static final List<Person> people =
            new ArrayList<>(Arrays.asList(new Person(11), new Person(19)));

    /**
     * A static not method has been added to the Predicate interface.
     * We can use it to negate an existing predicate, much like the negate method.
     */
    public static void not() {
        jdk8Way();
        jdk11Way();
    }

    /**
     * We are forced to let go of method reference if we need to negate the predicate
     */
    public static void jdk8Way() {

        // predicate
        List<Person> filtered = people.stream()
                .filter(Person::isAdult)
                .collect(Collectors.toList());

        // negated predicate
        List<Person> filtered2 = people.stream()
                .filter(p -> !p.isAdult())
                .collect(Collectors.toList());

    }


    public static void jdk11Way() {
        // negated predicate using Predicate.not()
        List<Person> filtered2 = people.stream()
                .filter(Predicate.not(Person::isAdult))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        not();
    }

    public static class Person {

        private static final int ADULT_AGE = 18;

        private int age;

        public Person(int age) {
            this.age = age;
        }

        public boolean isAdult() {
            return age >= ADULT_AGE;
        }
    }

}
