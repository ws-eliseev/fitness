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

    /** Поле id - Первичный ключ, генерация IDENTITY*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    /** Поле наименования рецепта */
    @Column(name = "NAME", nullable = false)
    private String name;


    /** Поле имени уникального  рецепта */
    @Column(name = "UNIQUE_RECIPE_FIELD")
    private String uniqueRecipeField;

    /** Поле количества калорий */
    @Column(name = "CALORIES")
    private int calories;

    /** Поле количества белков */
    @Column(name = "PROTEINS")
    private int proteins;

    /** Поле количества жиров */
    @Column(name = "FAT")
    private int fat;

    /** Поле количества углеводов */
    @Column(name = "CARBOHYDRATES")
    private int carbohydrates;

    /** Поле для указания ингредиентов */
    @ManyToMany
    @JoinTable(
            name = "FIT_RECIPE_INGREDIENT"
            , joinColumns = @JoinColumn(name = "RECIPE_ID")
            , inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    private Set <Ingredient> ingredients = new HashSet<>() ;


    /** Поле изображения рецепта */
    @Column(name = "IMAGE")
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return calories == recipe.calories && proteins == recipe.proteins && fat == recipe.fat && carbohydrates == recipe.carbohydrates && Objects.equals(id, recipe.id) && Objects.equals(name, recipe.name) && Objects.equals(uniqueRecipeField, recipe.uniqueRecipeField) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(image, recipe.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, uniqueRecipeField, calories, proteins, fat, carbohydrates, ingredients, image);
    }
}