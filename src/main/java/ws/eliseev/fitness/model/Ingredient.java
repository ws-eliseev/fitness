package ws.eliseev.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "FIT_INGREDIENT")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    /** Поле id - Первичный ключ, генерация IDENTITY*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Поле наименования ингредиента */
    @Column(name="NAME")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<Recipe> recipes;

}