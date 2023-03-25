package FunctionalProgramming.FunctionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

  static boolean isPhoneNumberValid(String phoneNumber) {
    return phoneNumber.startsWith("07");
  }

  static Predicate<String> isPhoneNumberValidPredicate =
          phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

  static Predicate<String> containsNumber3 =
          phoneNumber -> phoneNumber.contains("3");


  static BiPredicate<String, String> containsNumber4AndStartsWith7 =
          (x, y) -> x.contains("4") && y.startsWith("7");

  public static void main(String[] args) {

    System.out.println("Predicate: ");
    System.out.println(isPhoneNumberValid("07088792369"));
    System.out.println(isPhoneNumberValidPredicate.test("07088792369"));

    System.out.println(isPhoneNumberValid("0088792369"));
    System.out.println(isPhoneNumberValidPredicate.test("0088792369"));

    System.out.println("containsNumber3: " + containsNumber3.test("123"));
    System.out.println("containsNumber3: " + containsNumber3.test("456"));

    System.out.println();

    System.out.println("BiPredicate: ");
    System.out.println(containsNumber4AndStartsWith7.test("123", "2432"));
    System.out.println(containsNumber4AndStartsWith7.test("234", "711"));


  }


}
