package FunctionalProgramming.Streams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class _Stream {

  public static void main(String[] args) {
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
