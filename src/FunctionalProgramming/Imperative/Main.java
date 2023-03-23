package FunctionalProgramming.Imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static FunctionalProgramming.Imperative.Main.Gender.FEMALE;
import static FunctionalProgramming.Imperative.Main.Gender.MALE;


class Main {
  enum Gender {
    MALE,
    FEMALE,
  }

  static class Person {
    private final String name;
    private final Gender gender;

    Person(String name, Gender gender) {
      this.name = name;
      this.gender = gender;
    }

    String getName() {
      return name;
    }

    Gender getGender() {
      return gender;
    }

    @Override
    public String toString() {
      return "Person [name: " + this.name + " gender: " + this.gender + "]";
    }
  }

  public static void main(String[] args) {
    List<Person> people = List.of(
            new Person("Peter", MALE),
            new Person("Alice", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("John", MALE)
    );

    // add all female person in a List

    // Imperative approach
    System.out.println("// Imperative approach");
    List<Person> femalePeople = new ArrayList<>();

    for (Person person : people) {
      if (FEMALE.equals(person.gender)) {
        femalePeople.add(person);
      }
    }

    for (Person female : femalePeople) {
      System.out.println(female);
    }

    //Declarative approach
    System.out.println("// Declarative approach");

    Predicate<Person> onlyFemale = person -> FEMALE.equals(person.gender);
    femalePeople = people.stream().filter(onlyFemale)
            .collect(Collectors.toList());
    femalePeople.forEach(System.out::println);

  }
}
