package FunctionalProgramming.Streams;

import java.util.List;

import static FunctionalProgramming.Streams._Stream.Gender.FEMALE;
import static FunctionalProgramming.Streams._Stream.Gender.MALE;

class _Stream {

  enum Gender {
    MALE,
    FEMALE
  }

  record Person(String name, Gender gender){}


  public static void main(String[] args) {
    List<Person> people = List.of(
            new Person("Peter", MALE),
            new Person("Alice", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("John", MALE)
    );



  }
}
