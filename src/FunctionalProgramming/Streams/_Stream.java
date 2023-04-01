package FunctionalProgramming.Streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static FunctionalProgramming.Streams._Stream.Gender.MALE;
import static FunctionalProgramming.Streams._Stream.Gender.FEMALE;
import static FunctionalProgramming.Streams._Stream.Gender.PREFER_NOT_TO_SAY;

class _Stream {

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

    LongStream longStream;
    IntStream intStream;

    longStream = IntStream.of(1, 2, 3).mapToLong(x -> x+1);
    longStream.forEach(System.out::println);

    intStream = IntStream.range(1, 4).map(x -> x+1).filter(x -> x<3);
    intStream.forEach(System.out::println);

    System.out.println();

    Stream<Integer> integerStream;
    integerStream = IntStream.range(1, 4)
            .map(x -> x+1)
            .boxed();

    integerStream.forEach(System.out::println);


  }
}
