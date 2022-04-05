package ws.eliseev.fitness.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.repository.IRecipeRepository;

import java.util.List;

@Component
@Profile("dev")
public class InitRecipe {

    private final IRecipeRepository recipeRepository;

    public InitRecipe(IRecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;

        Recipe recipe1 = new Recipe(1L,
                "Crepes with Fried Egg",
                "Salty, savory, filled, flat, fluffy protein pancakes",
                300, 36, 8, 13,
                "breakfast", 5, "Image_1");
        Recipe recipe2 = new Recipe(2L,
                "Chocolate protein pancakes",
                "Protein and chocolate, together at last",
                511, 62, 15, 30,
                "breakfast", 5, "Image_2");
        Recipe recipe3 = new Recipe(3L,
                "Scrambled eggs with wholegrain bread",
                "The breakfast classic",
                150, 8, 5, 17,
                "breakfast", 5, "Image_3");
        Recipe recipe4 = new Recipe(4L,
                "Protein pasta fredda",
                "Fresh pasta dish with shrimp",
                568, 63, 20, 29,
                "dinner", 5, "Image_4");
        Recipe recipe5 = new Recipe(5L,
                "Jackfruit tacos",
                "Vegan tacos you can make at home",
                184, 5, 7, 23,
                "dinner", 5, "Image_5");
        Recipe recipe6 = new Recipe(6L,
                "Creamy Noodles with Salmon",
                "so fresh, so savory, so simple",
                461, 15, 24, 44,
                "dinner", 5, "Image_6");

        List<Recipe> recipeList = List.of(recipe1, recipe2, recipe3, recipe4, recipe5, recipe6);

        recipeList.forEach(recipeRepository::save);
    }
}
