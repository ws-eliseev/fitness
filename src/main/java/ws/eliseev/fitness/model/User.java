package ws.eliseev.fitness.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/*
 * Класс для хранения информации о пользователе в программе и в БД
 * @author Кончалов Роман
 */

@Entity
@Table(name = "FIT_USER")
@Setter
@Getter
@Audited
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    /* Первичный ключ с генерацией значения из последовательности, 8 байт */
    @Id
    @SequenceGenerator(name = "user_gen", sequenceName = "fit_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @Column(name = "ID")
    private Long id;

    public User(String username, String password, Set<Role> roles) {
    }

    /* Уникальное имя пользователя, не более 255 символов */
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    /* Пароль пользователя в незашифрованном виде, не более 255 символов */
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    /* Имя пользователя, не более 255 символов */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /* Фамилия пользователся, не более 255 символов */
    @Column(name = "LAST_NAME")
    private String lastName;

    /* Электронная почта пользователя, не более 255 символов */
    @Column(name = "EMAIL")
    private String email;

    /* Номер телефон не более, 255 символов */
    @Column(name = "PHONE")
    private String phone;

    /* Числовое значение возраста, 4 байта */
    @Column(name = "AGE")
    private int age;

    /* Значеие пола принимающее значение MALE или FEMALE */
    @Column(name = "SEX")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /* Класс соответствующий полю sex */
    @RequiredArgsConstructor
    @Getter
    public enum Sex {
        MALE ("male"),
        FEMALE ("female");

        private final String title;
    }

    /* Коллекция ролей пользователя для реализации связи "многие ко многим" */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FIT_USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @Fetch(FetchMode.JOIN)
    private Set<Role> roles;

    /**
     * формирование строки с ролями
     */
    public String getCustomRoles() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Role role : getRoles()) {
            stringBuilder.append(role.getName());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
