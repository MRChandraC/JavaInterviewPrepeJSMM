package Java8Features;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        // ---------------------------
        // 1. Creating Optional objects
        // ---------------------------

        // Empty Optional (no value)
        Optional<String> emptyOpt = Optional.empty();

        // Optional with a non-null value
        Optional<String> nonEmptyOpt = Optional.of("Hello Java 8");

        // Optional with a value that could be null
        Optional<String> nullableOpt = Optional.ofNullable(null); // safe

        // ---------------------------
        // 2. Checking value presence
        // ---------------------------

        // isPresent() returns true if value exists
        if (nonEmptyOpt.isPresent()) {
            System.out.println("Value exists: " + nonEmptyOpt.get());
        }

        // ifPresent() executes lambda if value exists
        nonEmptyOpt.ifPresent(val -> System.out.println("ifPresent Value: " + val));

        // ---------------------------
        // 3. Providing default values
        // ---------------------------

        // orElse() → returns value if present, otherwise given default
        System.out.println("orElse example: " + nullableOpt.orElse("Default Value"));

        // orElseGet() → similar but takes a Supplier (lazy evaluation)
        System.out.println("orElseGet example: " + nullableOpt.orElseGet(() -> "Generated Default"));

        // orElseThrow() → throws exception if value is missing
        try {
            System.out.println(nullableOpt.orElseThrow(() -> new IllegalArgumentException("No value found")));
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // ---------------------------
        // 4. Transforming values
        // ---------------------------

        // map() → transforms the value if present
        Optional<String> upperOpt = nonEmptyOpt.map(String::toUpperCase);
        System.out.println("Mapped to upper: " + upperOpt.orElse("Empty"));

        // flatMap() → similar to map but expects Optional return
        Optional<Integer> lengthOpt = nonEmptyOpt.flatMap(val -> Optional.of(val.length()));
        System.out.println("Length of value: " + lengthOpt.orElse(0));

        // ---------------------------
        // 5. Filtering values
        // ---------------------------
        Optional<String> filterOpt = nonEmptyOpt.filter(val -> val.startsWith("Hello"));
        System.out.println("Filter result: " + filterOpt.orElse("Does not match"));

        Optional<String> failedFilterOpt = nonEmptyOpt.filter(val -> val.startsWith("Bye"));
        System.out.println("Failed filter result: " + failedFilterOpt.orElse("No match"));
    }
}
