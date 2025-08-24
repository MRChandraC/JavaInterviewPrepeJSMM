package Java;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Creating a LinkedHashMap
        // Unlike HashMap, LinkedHashMap maintains insertion order
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // Adding key-value pairs
        linkedHashMap.put(101, "Apple");
        linkedHashMap.put(105, "Mango");
        linkedHashMap.put(103, "Banana");
        linkedHashMap.put(104, "Orange");
        linkedHashMap.put(102, "Grapes");

        // Printing the LinkedHashMap
        System.out.println("LinkedHashMap (Maintains Insertion Order):");
        System.out.println(linkedHashMap);

        // Accessing elements
        System.out.println("Get key 103 → " + linkedHashMap.get(103));

        // Removing a key
        linkedHashMap.remove(104);
        System.out.println("After removing key 104: " + linkedHashMap);

        // Iterating over entries
        System.out.println("\nIterating over entries:");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

/*
📘 Document: LinkedHashMap in Java

🔹 What is LinkedHashMap?
   - A Map implementation that stores key-value pairs like HashMap.
   - Maintains insertion order (or access order if configured).
   - Backed internally by a Hash table + Doubly Linked List of entries.

🔹 Why LinkedHashMap is Used?
   - When you need fast lookup (O(1) like HashMap).
   - AND you also care about maintaining insertion order.

🔹 Advantages of LinkedHashMap
   - Maintains order of elements (insertion or access).
   - Faster iteration compared to HashMap (because linked list maintains order).
   - Useful for predictable ordering in output.

🔹 Disadvantages
   - Slightly slower than HashMap due to extra linked list maintenance.
   - More memory overhead (stores doubly-linked list pointers).

🔹 When to Use LinkedHashMap?
   - When you want HashMap performance but with predictable order.
   - Example: Caches (like LRU Cache uses access-order LinkedHashMap).
   - Example: Maintaining insertion order while still having fast lookup.
*/
