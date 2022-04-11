package ws.eliseev.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {

    private Long id;

    private String name;

    private String uniqueRecipeField;

    private int calories;

    private int proteins;

    private int fat;

    private int carbohydrates;

    /**
     * Поле для указания ингредиентов
     */
    @ManyToMany
    @JoinTable(
            name = "FIT_RECIPE_INGREDIENT"
            , joinColumns = @JoinColumn(name = "RECIPE_ID")
            , inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    private Set<IngredientDto> ingredients;

    private String image;

}
