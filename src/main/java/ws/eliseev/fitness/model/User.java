package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USER")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @Column(name = "ID")
    private Long id; //Not 'long' because it will be used in the generic for CrudRepository interface

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "AGE")
    private int age;

    @Column(name = "SEX")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @RequiredArgsConstructor
    @Getter
    public enum Sex {
        MALE ("male"),
        FEMALE ("female");

        private final String title;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();
}
