package SetImplementation;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet (No duplicates, No guaranteed order)
        Set<String> hashSet = new HashSet<>();

        // Adding elements
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Mango");
        hashSet.add("Orange");
        hashSet.add("Banana"); // Duplicate, will be ignored

        // Printing HashSet (Notice: Order is not guaranteed)
        System.out.println("HashSet Elements:");
        System.out.println(hashSet);

        // Checking existence
        System.out.println("Contains 'Mango'? → " + hashSet.contains("Mango"));

        // Removing an element
        hashSet.remove("Orange");
        System.out.println("After removing 'Orange': " + hashSet);

        // Iterating over elements
        System.out.println("\nIterating over HashSet:");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }
    }
}

/*
📘 Document: HashSet in Java

🔹 What is HashSet?
   - A Set implementation backed by HashMap (only keys stored).
   - Stores unique elements (no duplicates).
   - No guaranteed order of elements.

🔹 Why HashSet is Used?
   - To store unique data without worrying about order.
   - Example: Maintaining a collection of unique student IDs, emails, usernames.

🔹 Advantages of HashSet
   - Provides constant-time performance O(1) for add, remove, contains (on average).
   - Automatically eliminates duplicates.

🔹 Disadvantages
   - Does not maintain insertion order.
   - Allows one null element only.

🔹 When to Use HashSet?
   - When you want uniqueness and don’t care about ordering.
   - Example: Ensuring unique user logins, filtering duplicate words from a text.
*/
