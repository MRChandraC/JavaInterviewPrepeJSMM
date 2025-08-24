package Java.ListImplementation;

import java.util.*;

/*
ArrayList is Unlike array, it will shrink and size of it's is not fixed, it is backed by Dynamic Array


 */
public class ArrayListDemo {
    public static void main(String[] args) {

        // 1. Create ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Mango");
        System.out.println("After adding: " + list);

        // 3. Add at index
        list.add(2, "Orange");
        System.out.println("After inserting at index 2: " + list);

        // 4. Get element
        System.out.println("Element at index 1: " + list.get(1));

        // 5. Update element (set)
        list.set(1, "Blueberry");
        System.out.println("After updating index 1: " + list);

        // 6. Remove by index
        list.remove(2);
        System.out.println("After removing index 2: " + list);

        // 7. Remove by object
        list.remove("Mango");
        System.out.println("After removing 'Mango': " + list);

        // 8. Check contains
        System.out.println("Contains Apple? " + list.contains("Apple"));

        // 9. Size of list
        System.out.println("Size: " + list.size());

        // 10. Iterating (for loop)
        System.out.print("For loop: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 11. Iterating (enhanced for loop)
        System.out.print("Enhanced for loop: ");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 12. Iterating (Iterator)
        System.out.print("Iterator: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 13. Sublist
        list.add("Pineapple");
        list.add("Grapes");
        System.out.println("Sublist (1,3): " + list.subList(1, 3));

        // 14. Sorting
        java.util.Collections.sort(list);
        System.out.println("Sorted: " + list);

        // 15. Sorting in reverse order
        java.util.Collections.sort(list, Collections.reverseOrder());
        System.out.println("Reverse Sorted: " + list);

        // 16. Convert to Array
        String[] arr = list.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(arr));

        // 17. Clear list
        list.clear();
        System.out.println("After clear: " + list + ", size: " + list.size());
    }
}
