package SetImplementation;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // Creating a LinkedHashSet
        // Maintains insertion order unlike HashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Adding elements
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Mango");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Grapes");

        // Duplicate element (ignored)
        linkedHashSet.add("Apple");

        // Printing the LinkedHashSet
        System.out.println("LinkedHashSet (Maintains Insertion Order):");
        System.out.println(linkedHashSet);

        // Checking if element exists
        System.out.println("Contains Mango? " + linkedHashSet.contains("Mango"));

        // Removing an element
        linkedHashSet.remove("Orange");
        System.out.println("After removing Orange: " + linkedHashSet);

        // Iterating over elements
        System.out.println("\nIterating over elements:");
        for (String fruit : linkedHashSet) {
            System.out.println(fruit);
        }
    }
}

/*
📘 Document: LinkedHashSet in Java

🔹 What is LinkedHashSet?
   - A Set implementation backed by LinkedHashMap.
   - Stores unique elements (no duplicates).
   - Maintains insertion order (unlike HashSet which is unordered).

🔹 Internal Working
   - Internally uses LinkedHashMap with elements as keys and a dummy value.
   - Hashing provides uniqueness, doubly linked list maintains order.

🔹 Why LinkedHashSet is Used?
   - When you want uniqueness + order of insertion.
   - Example: Maintaining unique logins in the order they occurred.

🔹 Advantages
   - Maintains order of elements.
   - Fast operations: add, remove, contains → O(1) average.
   - Eliminates duplicates automatically.

🔹 Disadvantages
   - Slightly more memory than HashSet due to linked list pointers.
   - Slower than HashSet in some cases.

🔹 When to Use LinkedHashSet?
   - When you want to avoid duplicates but still keep insertion order.
   - Example: Recent user searches, maintaining visited pages in order.
*/
