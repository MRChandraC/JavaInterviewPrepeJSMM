import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;

//  A REST controller in Spring Boot
@RestController  // Marks this class as a REST API controller (returns JSON/XML instead of views)
@RequestMapping("/api/users")  // Base URL for all APIs inside this controller
public class UserController {

    // GET → Fetch resource(s)
    @GetMapping("/{id}")  
    // Equivalent to: @RequestMapping(value="/{id}", method=RequestMethod.GET)
    // @PathVariable → Extract value from the URL
    public ResponseEntity<String> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Fetched user with id: " + id);
    }

    // GET → With query parameter
    @GetMapping
    // @RequestParam → Extract query parameters (?name=John)
    public ResponseEntity<String> getUserByName(@RequestParam String name) {
        return ResponseEntity.ok("Fetched user with name: " + name);
    }

    // POST → Create resource
    @PostMapping
    // @RequestBody → Maps request JSON to Java object
    public ResponseEntity<String> createUser(@RequestBody Map<String, Object> userData) {
        return new ResponseEntity<>("User created: " + userData, HttpStatus.CREATED);
    }

    // PUT → Update resource
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody Map<String, Object> userData) {
        return ResponseEntity.ok("User " + id + " updated with " + userData);
    }

    // PATCH → Partial update
    @PatchMapping("/{id}")
    public ResponseEntity<String> partialUpdateUser(@PathVariable Long id, @RequestBody Map<String, Object> userData) {
        return ResponseEntity.ok("User " + id + " partially updated with " + userData);
    }

    // DELETE → Remove resource
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok("User " + id + " deleted");
    }

// ✅ Exception Handling Example with Exception Hierarchy Inline Docs
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/error")
    public String throwError() {
        // Just for demo: we deliberately throw an exception
        throw new IllegalArgumentException("Invalid input provided!");
    }

    // ---------------- Exception Handling ----------------
    @ExceptionHandler(Exception.class)  
    /*
     * Exception Hierarchy in Java
     *
     * Throwable   <-- Root of all errors/exceptions
     *   ├── Error                (Serious issues from JVM, e.g., OutOfMemoryError)
     *   │      Not usually handled in controllers
     *   │
     *   └── Exception            (Things we CAN handle)
     *         ├── RuntimeException (Unchecked - programmer errors)
     *         │      ├── NullPointerException
     *         │      ├── IllegalArgumentException   <-- Example handled here
     *         │      ├── IllegalStateException
     *         │      └── DataAccessException (Spring-specific DB wrapper)
     *         │
     *         └── IOException     (Checked - must be declared/handled)
     *                ├── FileNotFoundException
     *                └── SocketException
     *
     *  Rule in Spring: 
     * - The MOST SPECIFIC @ExceptionHandler is chosen first.
     * - If none matches, then the generic Exception handler (@ExceptionHandler(Exception.class)) is used.
     */
    public ResponseEntity<String> handleError(Exception e) {
        return new ResponseEntity<>("Error occurred: " + e.getMessage(), 
                                    HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
