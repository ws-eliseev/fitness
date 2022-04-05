package ws.eliseev.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String meals;

    private int rating;

    private String image;
}
