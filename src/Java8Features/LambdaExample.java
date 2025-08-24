package Java8Features;

import java.util.*;

public class LambdaExample {
    public static void main(String[] args) {
        // Create a list of names
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Daisy");

        /**
         * ✅ Sorting WITHOUT Lambda (using Anonymous Inner Class)
         * - Before Java 8, we had to create an object of Comparator
         * - This leads to verbose and boilerplate code
         */
        Collections.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b); // Natural order sorting (alphabetical)
            }
        });
        System.out.println("Sorted with Anonymous class: " + names);

        /**
         * ✅ Sorting WITH Lambda Expression (Java 8 Feature)
         * - Removes the need for anonymous class
         * - (a, b) -> a.compareTo(b) is a shorthand for the same logic
         * - Much more concise and readable
         */
        names = Arrays.asList("John", "Alice", "Bob", "Daisy"); // Reset the list
        Collections.sort(names, (a, b) -> a.compareTo(b)); // Lambda replaces Comparator
        System.out.println("Sorted with Lambda: " + names);

        /**
         * 🔹 Output:
         * Sorted with Anonymous class: [Alice, Bob, Daisy, John]
         * Sorted with Lambda: [Alice, Bob, Daisy, John]
         *
         * 🔹 Use Cases of Lambda:
         * - Simplify code when using functional interfaces
         * - Useful in Streams, forEach loops, Runnable/Callable, etc.
         */
    }
}
