package FunctionalProgramming.FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {


  static int incrementByOne(int number) {
    return number + 1;
  }

  static Function<Integer, Integer> incrementByOneFunction =
          number -> number + 1;

  static Function<Integer, Integer> multiplyBy10Function =
          number -> 10 * number;



  static int incrementByOneAndMultiply(int number, int numberToMultiply) {
    return (number + 1) * numberToMultiply;
  }

  static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
          (number, numberToMultiply) -> (number + 1) * numberToMultiply;


  public static void main(String[] args) {
    int increment;
    int multiply;

    // Function
    System.out.println("Function");

    increment = incrementByOne(1);
    System.out.println(increment);

    increment = incrementByOneFunction.apply(1);
    System.out.println(increment);

    multiply = multiplyBy10Function.apply(increment);
    System.out.println(multiply);

    System.out.println();

    // BiFunction
    System.out.println("BiFunction");

    Function<Integer, Integer> incrementByOneAndMultiplyBy10Function =
            number -> incrementByOneFunction.andThen(multiplyBy10Function).apply(number);

    // Proto
    System.out.println(incrementByOneAndMultiplyBy10Function.apply(1));

    System.out.println(incrementByOneAndMultiply(1, 10));
    System.out.println(incrementByOneAndMultiplyBiFunction.apply(1, 10));

  }
}
