package Java8Features;

@FunctionalInterface
interface MyFunctionalInterface {
    void sayHello();   // Only one abstract method allowed

    // You can also add default or static methods
    default void greet() {
        System.out.println("Hello from default method!");
    }

    static void staticMethod() {
        System.out.println("Hello from static method!");
    }
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Lambda implementing functional interface
        MyFunctionalInterface obj = () -> System.out.println("Hello from Lambda!");

        obj.sayHello();      // Calls Lambda implementation
        obj.greet();         // Calls default method
        MyFunctionalInterface.staticMethod(); // Calls static method
    }
}
