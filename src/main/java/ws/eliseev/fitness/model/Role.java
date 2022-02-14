package ws.eliseev.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
 * Класс для хранения информации о роли (правах) пользователе в программе и в БД
 * @author Кончалов Роман
 */

@Entity
@Table(name = "FIT_ROLE")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    /* Первичный ключ с генерацией значения по возрастанию, 8 байт */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;

    /* Наименование роли с префиксом "ROLE_", не более 255 символов */
    @Column (name = "NAME")
    private String name;

    /* Конструктор для удобного заполнения тестовыми данными */
    @Builder
    private Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Коллекция пользователей обладающих данной ролью для реализации связи "многие ко многим" */
    @JsonIgnore
    @Audited
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
