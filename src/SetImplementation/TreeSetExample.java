package Java;

import java.util.TreeSet;
import java.util.Set;

public class TreeSetExample {
    public static void main(String[] args) {
        // Creating a TreeSet
        // Stores elements in sorted (ascending) order
        Set<String> treeSet = new TreeSet<>();

        // Adding elements
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Orange");
        treeSet.add("Grapes");

        // Duplicate element (ignored)
        treeSet.add("Apple");

        // Printing the TreeSet
        System.out.println("TreeSet (Sorted Order):");
        System.out.println(treeSet);

        // Checking if element exists
        System.out.println("Contains Mango? " + treeSet.contains("Mango"));

        // Removing an element
        treeSet.remove("Orange");
        System.out.println("After removing Orange: " + treeSet);

        // Iterating over elements
        System.out.println("\nIterating over elements:");
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }
    }
}

/*
📘 Document: TreeSet in Java

🔹 What is TreeSet?
   - A NavigableSet implementation based on TreeMap.
   - Stores unique elements (no duplicates).
   - Maintains **sorted order** (natural order or custom Comparator).

🔹 Internal Working
   - Backed by a Red-Black Tree (self-balancing binary search tree).
   - Each insertion ensures the tree remains balanced.
   - Provides log(n) time complexity for add, remove, and contains.

🔹 Why TreeSet is Used?
   - When you need uniqueness + sorting.
   - Example: Maintaining a sorted leaderboard, ranking system.

🔹 Advantages
   - Elements are always in sorted order.
   - Provides fast search, insert, delete → O(log n).
   - Supports navigation methods like higher(), lower(), ceiling(), floor().

🔹 Disadvantages
   - Slower than HashSet/LinkedHashSet due to tree balancing.
   - Cannot store null key (throws NullPointerException).

🔹 When to Use TreeSet?
   - When you want to store unique elements in **sorted order**.
   - Example: Word dictionary, storing student names alphabetically, sorted IDs.
*/
