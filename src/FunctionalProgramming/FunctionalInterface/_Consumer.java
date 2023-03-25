package FunctionalProgramming.FunctionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

class _Consumer {

  private static class Customer {
    private final String customerName;
    private final String customerPhoneNumber;

    Customer(String customerName, String customerPhoneNumber) {
      this.customerName = customerName;
      this.customerPhoneNumber = customerPhoneNumber;
    }
  }


  static void greetCustomer(Customer customer) {
    System.out.println("Hello " + customer.customerName +
            ", thanks for registering for phone number " +
            customer.customerPhoneNumber);
  }

  static Consumer<Customer> greetCustomerConsumer =
          customer -> System.out.println("Hello " + customer.customerName +
                  ", thanks for registering for phone number " +
                  customer.customerPhoneNumber);

  static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
    System.out.println("Hello " + customer.customerName +
            ", thanks for registering for phone number " +
            (showPhoneNumber ? customer.customerPhoneNumber : "****"));
  }

  static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
          System.out.println("Hello " + customer.customerName +
                  ", thanks for registering for phone number " +
                  (showPhoneNumber ? customer.customerPhoneNumber : "****"));

  public static void main(String[] args) {
    Customer peter = new Customer("Peter", "76836826537");
    Customer maria = new Customer("Maria", "82739864234");

    System.out.println("Consumer:");
    greetCustomer(peter);
    greetCustomerConsumer.accept(peter);
    System.out.println();
    greetCustomer(maria);
    greetCustomerConsumer.accept(maria);

    System.out.println();

    System.out.println("BiConsumer:");
    greetCustomerV2(maria, false);
    greetCustomerConsumerV2.accept(maria, false);
    System.out.println();
    greetCustomerV2(peter, true);
    greetCustomerConsumerV2.accept(peter, true);

  }
}
