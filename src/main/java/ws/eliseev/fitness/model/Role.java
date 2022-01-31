package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity @Table(name = "roles")
@Getter @Setter
@NoArgsConstructor
public class Role {
    @Id
    // Need? @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return this.getName().equals(role.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }
}
