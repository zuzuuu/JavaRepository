package pl.mpas.advanced_programming.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
            new Person("Kasia", "B.", 21),
            new Person("Ola", "M.", 43),
            new Person("Gosia", "D.", 33)
        );

        //przez Comparable, zwykły sort (age)
        Collections.sort(persons);
        System.out.println(persons.toString());

        //sort z Comparatorem (po imieniu)
        Collections.sort(persons, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        System.out.println(persons.toString());

        //złożony Comparator - po nazwisku i po imieniu
        Collections.sort(persons, Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
        );
    }
}
