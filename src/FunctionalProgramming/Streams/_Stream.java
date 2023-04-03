package FunctionalProgramming.Streams;

import java.util.List;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class _Stream {

  public static void main(String[] args) {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Stream.iterate(1, x -> x+1)
            .map(x -> x*10)
            .limit(10)
            .forEach(x -> System.out.print(x + " "));
    // Output: 10 20 30 40 50 60 70 80 90 100

    System.out.println('\n');

    integerList.stream()
            .filter(x -> x>5)
            .forEach(x -> System.out.print(x + " "));
    // Output: 6, 7, 8, 9, 10

    System.out.println('\n');

    IntStream intStream = IntStream.range(1, 4)
            .map(x -> x+1)
            .filter(x -> x<3);
    intStream.forEach(x -> System.out.print(x + " "));
    // Output: 2

    System.out.println('\n');

    // Convert IntStream to a LongStream
    LongStream longStream = IntStream.of(1, 2, 3)
            .mapToLong(x -> x+1);
    longStream.forEach(x -> System.out.print(x + " "));
    // Output: 2, 3, 4

    System.out.println('\n');

    // Convert IntStream to a Stream<Integer>
    IntStream.range(1, 4)
            .map(x -> x+1)
            .boxed()
            .forEach(x -> System.out.print(x + " "));
    // Output: 2, 3, 4

    System.out.println('\n');

    // Convert IntStream to a Stream<Integer>
    IntStream.range(1, 4)
            .mapToObj(x -> x+1)
            .forEach(x -> System.out.print(x + " "));
    // Output: 2, 3, 4

    System.out.println('\n');

    // remove all duplicates
    int[] array = {1, 1, 2, 3, 4, 5, 6, 3, 2, 2, 2, 3, 3, 4, 4, 6, 8, 9 , 0, 7, 5, 4};
    Set<Integer> integerSet = Arrays.stream(array).boxed().collect(Collectors.toSet());
    System.out.println(integerSet);

    System.out.println('\n');


    System.out.println("reduce:");
    System.out.println("With Identity");
    int reduceOutput;

    reduceOutput = IntStream.range(1,11).reduce(1, (int identity, int y) -> identity);
    System.out.println("Mein Output 1: " + reduceOutput);
    // Output: 1

    reduceOutput = IntStream.range(1,11).reduce(1, (int identity, int iterate) -> iterate);
    System.out.println("Mein Output 2: " + reduceOutput);
    // Output: 10

    reduceOutput = IntStream.range(1,11).reduce(1, (int identity, int iterate) -> iterate+100);
    System.out.println("Mein Output 3: " + reduceOutput);
    // Output: 110

    // reduceOutput = IntStream.range(1,3).reduce(1, (int identity, int iterate) -> identity+iterate);
    reduceOutput = IntStream.range(1,3).reduce(1, Integer::sum);
    System.out.println("Mein Output 4: " + reduceOutput);
    // Output: 4

    System.out.println();

    System.out.println("Without Identity");
    OptionalInt optionalIntOutput;

    optionalIntOutput = IntStream.range(1,11).reduce((result, iterate) -> iterate);
    System.out.println("Mein Output 1: " + (optionalIntOutput.isPresent() ? optionalIntOutput.getAsInt() : "No Value"));
    // Output: 10

    optionalIntOutput = IntStream.range(1,11).reduce((result, iterate) -> result);
    System.out.println("Mein Output 2: " + (optionalIntOutput.isPresent() ? optionalIntOutput.getAsInt() : "No Value"));
    // Output: 1

    optionalIntOutput = IntStream.range(1,5).reduce((result, iterate) -> result + 10);
    System.out.println("Mein Output 3: " + (optionalIntOutput.isPresent() ? optionalIntOutput.getAsInt() : "No Value"));
    // Output: 31

    optionalIntOutput = IntStream.range(3,5).reduce((result, iterate) -> iterate + 10);
    System.out.println("Mein Output 4: " + (optionalIntOutput.isPresent() ? optionalIntOutput.getAsInt() : "No Value"));
    // Output: 14

    optionalIntOutput = IntStream.range(3,5).reduce(Integer::sum);
    System.out.println("Mein Output 5: " + (optionalIntOutput.isPresent() ? optionalIntOutput.getAsInt() : "No Value"));
    // Output: 7

    System.out.println("\n");
    System.out.println("Finish !!!");
  }
}
