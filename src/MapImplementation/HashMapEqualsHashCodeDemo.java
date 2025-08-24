package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 ========================================================
 📘 Internal Working of HashMap with hashCode() & equals()
 ========================================================

  How HashMap Works:
   1. When you call put(key, value):
      - It calculates hashCode() of the key → decides which bucket to store in.
      - If two keys have the same hashCode (collision), then equals() is used
        to check if they are actually the same key.
      - If equals() returns true → value is updated (no duplicate key).
      - If equals() returns false → it is treated as a different entry (stored separately).

   2. When you call get(key):
      - It calculates the hashCode of the key → goes to the correct bucket.
      - Then checks with equals() to find the exact entry.

  Why Override hashCode() and equals()?
   - If we don’t override:
     - Different objects (with same data) will have different hashCodes (default is memory address).
     - HashMap will treat them as DIFFERENT keys.
     - So duplicates (logically same) will be allowed.

   - If we override properly:
     - HashMap will treat objects with same data as SAME key.
     - Prevents duplicate logical entries.
 ========================================================
*/

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //  Case 1: Comment out equals & hashCode → duplicates allowed
    // Case 2: Uncomment equals & hashCode → logical uniqueness enforced

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class HashMapEqualsHashCodeDemo {
    public static void main(String[] args) {

        Map<Employee, String> employeeMap = new HashMap<>();

        Employee e1 = new Employee(101, "Alice");
        Employee e2 = new Employee(101, "Alice"); // logically same as e1

        // Adding both to HashMap
        employeeMap.put(e1, "Developer");
        employeeMap.put(e2, "Manager"); // should ideally replace previous

        System.out.println("HashMap Content: " + employeeMap);

        // Testing retrieval
        System.out.println("Get using e1: " + employeeMap.get(e1));
        System.out.println("Get using e2: " + employeeMap.get(e2));

        /*
         ========================================================
          If equals() & hashCode() are NOT overridden:
            Output →
            HashMap Content: {Employee{id=101, name='Alice'}=Developer, Employee{id=101, name='Alice'}=Manager}
            Get using e1: Developer
            Get using e2: Manager
            (Two different entries → HashMap failed to recognize duplicate)

          If equals() & hashCode() ARE overridden:
            Output →
            HashMap Content: {Employee{id=101, name='Alice'}=Manager}
            Get using e1: Manager
            Get using e2: Manager
            (Only one entry → duplicate prevented, value updated)
         ========================================================
        */
    }
}
