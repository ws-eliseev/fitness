package ws.eliseev.fitness.dto;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ws.eliseev.fitness.model.Role;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * DTO объект от сущности User
 * @see ws.eliseev.fitness.model.User
 * @author Зыков Артем
 */
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private int age;

    private Sex sex;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FIT_USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @Fetch(FetchMode.JOIN)
    private Set<Role> roles;
    private PassportDto   passport;

    private AddressDto address;

    private String   photo;


    @RequiredArgsConstructor
    @Getter
    public enum Sex {
        MALE ("male"),
        FEMALE ("female");

        private final String title;
    }
}
