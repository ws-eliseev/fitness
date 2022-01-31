package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipe")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unique_recipe_field")
    private String uniqueRecipeField;

    @Column(name = "calories")
    private int calories;

    @Column(name = "proteins")
    private int proteins;

    @Column(name = "fat")
    private int fat;

    @Column(name = "carbohydrates")
    private int carbohydrates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return calories == recipe.calories && proteins == recipe.proteins && fat == recipe.fat && carbohydrates == recipe.carbohydrates && Objects.equals(name, recipe.name) && Objects.equals(uniqueRecipeField, recipe.uniqueRecipeField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uniqueRecipeField, calories, proteins, fat, carbohydrates);
    }
}