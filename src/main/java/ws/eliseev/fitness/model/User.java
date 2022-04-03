package ws.eliseev.fitness.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.*;

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
public class User {

    /* Первичный ключ с генерацией значения из последовательности, 8 байт */
    @Id
    @SequenceGenerator(name = "user_gen", sequenceName = "fit_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @Column(name = "ID")
    private Long id;

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

    /* Класс соответствующий полю sex */
    @RequiredArgsConstructor
    @Getter
    public enum Sex {
        MALE ("male"),
        FEMALE ("female");

        private final String title;
    }

    /* Коллекция ролей пользователя для реализации связи "многие ко многим" */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FIT_USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    /** Поле для хранения журнала пользователя, связь OneToOne*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "JOURNAL_ID", referencedColumnName = "ID")
    private Journal journal;
}
