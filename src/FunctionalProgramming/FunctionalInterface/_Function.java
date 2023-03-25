package FunctionalProgramming.FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {


  static int incrementByOne(int number) {
    return number+1;
  }

  static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

  static int multiplyBy10(int number) {
    return 10 * number;
  }

  static Function<Integer, Integer> multiplyBy10Function = number -> 10 * number;


  static int incrementByOneAndMultiply(int number, int numberToMultiply) {
    return (number+1) * numberToMultiply;
  }

  static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
          (number, numberToMultiply) -> (number+1) * numberToMultiply;


  public static void main(String[] args) {
    int increment;

    // Function
    System.out.println("Function");

    increment = incrementByOne(1);
    System.out.println(increment);
    incrementByOneFunction.apply(1);
    System.out.println(increment);

    System.out.println(multiplyBy10(2));
    System.out.println(multiplyBy10(increment));
    System.out.println(multiplyBy10Function.apply(2));
    System.out.println(multiplyBy10Function.apply(increment));

    System.out.println();

    // BiFunction
    System.out.println("BiFunction");

    Function<Integer, Integer> incrementByOneAndMultiplyBy10Function =
            number -> incrementByOneFunction.andThen(multiplyBy10Function).apply(number);

    System.out.println(incrementByOneAndMultiplyBy10Function.apply(1));
    System.out.println(incrementByOneAndMultiply(1, 10));
    System.out.println(incrementByOneAndMultiplyBiFunction.apply(1, 10));


  }
}
