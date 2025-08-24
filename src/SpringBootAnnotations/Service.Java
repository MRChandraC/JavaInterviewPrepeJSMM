import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

/*
 *  User Entity
 * - A User can have multiple Bookings (OneToMany)
 * - A User can have one Profile (OneToOne)
 */
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(nullable = false, unique = true)
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false)
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    // 🔹 One User → One Profile (Bi-directional)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile profile;

    // 🔹 One User → Many Bookings
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    // 🔹 Many Users ↔ Many Roles (Join Table)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles", // intermediate table
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}

/*
 *  Profile Entity
 * - Each User has exactly one Profile (OneToOne)
 */
@Entity
@Table(name = "profiles")
@Data
class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id") // foreign key in profile table
    private User user;
}

/*
 *  Booking Entity
 * - Each Booking belongs to one User (ManyToOne)
 * - Each Booking is linked to one Hotel (ManyToOne)
 */
@Entity
@Table(name = "bookings")
@Data
class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingDate;

    // Many bookings → one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Many bookings → one hotel
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}

/*
 *  Hotel Entity
 * - One Hotel can have many Bookings (OneToMany)
 */
@Entity
@Table(name = "hotels")
@Data
class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;

    private String city;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}

/*
 *  Role Entity
 * - Many Users ↔ Many Roles
 */
@Entity
@Table(name = "roles")
@Data
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
