package FunctionalProgramming.FunctionalInterface;

import java.util.List;
import java.util.function.Supplier;

class _Supplier {

  static String represent() {
    return "(method) I am an represent";
  }

  static Supplier<String> representSupplier = () -> "I am an represent";

  static Supplier<List<String>> listOfRepresentSupplier =
          () -> List.of("I am an represent Number 1", "I am an represent Number 2");

  public static void main(String[] args) {
    System.out.println(represent());
    System.out.println(representSupplier.get());
    System.out.println();
    System.out.println(listOfRepresentSupplier.get());
    System.out.println(listOfRepresentSupplier.get().get(0));
    System.out.println(listOfRepresentSupplier.get().get(1));
  }
}
