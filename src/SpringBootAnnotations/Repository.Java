///* import org.springframework.data.jpa.repository.*;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.List;
//
////  Marks this interface as a Repository bean
//// - Specialization of @Component
//// - Enables exception translation (e.g., DB exceptions → Spring DataAccessException)
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    /*
//     * Spring Data JPA provides methods automatically:
//     * - save(), findById(), findAll(), deleteById() ...
//     * Based on JpaRepository<User, Long>
//     */
//
//    // ---------------- Custom Queries ----------------
//
//    /*
//     * @Query
//     * - Allows custom JPQL or native SQL queries
//     * - Example: Find users by name
//     */
//    @Query("SELECT u FROM User u WHERE u.name = :name")
//    List<User> findUsersByName(String name);
//
//    /*
//     * @Query (native = true)
//     * - Run raw SQL instead of JPQL
//     */
//    @Query(value = "SELECT * FROM users u WHERE u.email = :email", nativeQuery = true)
//    User findByEmailNative(String email);
//
//    /*
//     * @Modifying
//     * - Required for update/delete queries
//     * - Must be used with @Transactional
//     */
//    @Modifying
//    @Transactional
//    @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
//    int updateUserName(Long id, String name);
//
//    /*
//     * Derived Query Method
//     * - Spring auto-generates query by parsing method name
//     */
//    List<User> findByEmailContaining(String keyword);  // LIKE %keyword%
//}
//
///*
// *  Example of enabling repositories in a config class
// */
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@EnableJpaRepositories(basePackages = "com.example.demo.repository")
//// Scans given package for @Repository interfaces
//class JpaConfig {
//}
//
//
//