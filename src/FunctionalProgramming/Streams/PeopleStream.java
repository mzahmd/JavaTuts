package FunctionalProgramming.Streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static FunctionalProgramming.Streams.PeopleStream.Gender.MALE;
import static FunctionalProgramming.Streams.PeopleStream.Gender.FEMALE;
import static FunctionalProgramming.Streams.PeopleStream.Gender.PREFER_NOT_TO_SAY;

class PeopleStream {

  enum Gender {
    MALE,
    FEMALE,
    PREFER_NOT_TO_SAY
  }

  record Person(String name, Gender gender){

    @Override
    public String toString() {
      return "Person {name='" + name + "', gender=" + gender + "}";
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


    Function<Person, String> name = Person::name;
    ToIntFunction<String> length = String::length;
    people.stream().map(name)
            .mapToInt(length)
            .forEach(System.out::println);

    System.out.println();

    boolean gender = people.stream()
            .noneMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender));
    System.out.println(gender);

    System.out.println();

  }
}
