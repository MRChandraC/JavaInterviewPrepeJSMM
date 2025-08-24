package Java;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Creating a TreeMap
        // Keys are sorted automatically in natural ascending order
        Map<Integer, String> treeMap = new TreeMap<>();

        // Adding key-value pairs
        treeMap.put(105, "Mango");
        treeMap.put(101, "Apple");
        treeMap.put(103, "Banana");
        treeMap.put(104, "Orange");
        treeMap.put(102, "Grapes");

        // Printing the TreeMap (Notice: Keys sorted automatically)
        System.out.println("TreeMap (Keys in Sorted Order):");
        System.out.println(treeMap);

        // Accessing elements
        System.out.println("Get key 103 → " + treeMap.get(103));

        // Removing a key
        treeMap.remove(104);
        System.out.println("After removing key 104: " + treeMap);

        // Iterating over entries
        System.out.println("\nIterating over entries:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Example of first and last key
        System.out.println("\nFirst Key → " + ((TreeMap<Integer, String>) treeMap).firstKey());
        System.out.println("Last Key → " + ((TreeMap<Integer, String>) treeMap).lastKey());
    }
}

/*
📘 Document: TreeMap in Java

🔹 What is TreeMap?
   - A Map implementation based on Red-Black Tree.
   - Stores key-value pairs but sorts keys in natural order (ascending).
   - Allows custom ordering using Comparator.

🔹 Why TreeMap is Used?
   - When you want a Map where keys are always in sorted order.
   - Example: maintaining a leaderboard, dictionary, phonebook.

🔹 Advantages of TreeMap
   - Maintains sorted order of keys.
   - Provides methods like firstKey(), lastKey(), higherKey(), lowerKey().
   - Good for range queries (subMap, headMap, tailMap).

🔹 Disadvantages
   - Slower than HashMap & LinkedHashMap (O(log n) for put/get/remove).
   - Cannot store null key (throws NullPointerException).

🔹 When to Use TreeMap?
   - When you need automatic sorting of keys.
   - Example: Student ranking, word dictionary, stock prices ordered by time.
*/
