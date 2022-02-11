package ws.eliseev.fitness.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "FIT_RECIPE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "UNIQUE_RECIPE_FIELD")
    private String uniqueRecipeField;

    @Column(name = "CALORIES")
    private int calories;

    @Column(name = "PROTEINS")
    private int proteins;

    @Column(name = "FAT")
    private int fat;

    @Column(name = "CARBOHYDRATES")
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