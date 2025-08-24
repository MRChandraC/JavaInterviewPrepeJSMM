package Java.ListImplementation;

import java.util.*;
/*
ArrayList is backed by a dynamic array, while LinkedList is backed by a doubly linked list (nodes).
ArrayList gives fast random access (get(index) is O(1)), but LinkedList access is slow (O(n)).
ArrayList insert/delete in middle is slow (needs shifting), while LinkedList insert/delete is fast (just pointer updates).
ArrayList uses less memory (only data), but LinkedList uses more memory (data + 2 references per node).
 */
public class LinkedListDemo {
    public static void main(String[] args) {

        // 1. Create LinkedList
        LinkedList<String> list = new LinkedList<>();

        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After adding: " + list);

        // 3. Add at specific index
        list.add(1, "Orange");
        System.out.println("After inserting at index 1: " + list);

        // 4. Add First and Last
        list.addFirst("Mango");
        list.addLast("Pineapple");
        System.out.println("After addFirst & addLast: " + list);

        // 5. Get elements
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));

        // 6. Update element
        list.set(2, "Blueberry");
        System.out.println("After updating index 2: " + list);

        // 7. Remove by index and object
        list.remove(3);
        list.remove("Apple");
        System.out.println("After removals: " + list);

        // 8. Remove first and last
        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst & removeLast: " + list);

        // 9. Contains check
        System.out.println("Contains Banana? " + list.contains("Banana"));

        // 10. Size
        System.out.println("Size: " + list.size());

        // 11. Iterating with for-each
        System.out.print("For-each: ");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 12. Iterator
        System.out.print("Iterator: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 13. Sort (using Collections)
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        // 14. Clear
        list.clear();
        System.out.println("After clear: " + list);
    }
}
