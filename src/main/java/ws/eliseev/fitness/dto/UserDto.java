package ws.eliseev.fitness.dto;

import lombok.*;
import ws.eliseev.fitness.model.Address;
import ws.eliseev.fitness.model.Passport;

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
