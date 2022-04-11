package ws.eliseev.fitness.service;

import ws.eliseev.fitness.dto.RecipeDto;
import ws.eliseev.fitness.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface IRecipeService {
    /**
     * Вывести список всех рецептов
     */
    List<RecipeDto> fetchRecipeList();

    /**
     * Сохранить или обновить рецепт
     *
     * @param recipeDto - название рецепта
     */
    void saveOrUpdateRecipe(RecipeDto recipeDto);

    /**
     * Найти рецепт по Id
     *
     * @param recipeId - идентификационный номер рецепта в бд
     */
    Optional<Recipe> fetchRecipeById(Long recipeId);

    /**
     * Найти все подходящие рецепты по имени
     *
     * @param name - название рецепта в БД
     */
    List<Recipe> fetchRecipeByName(String name);

    /**
     * Удалить рецепт по Id
     *
     * @param recipeId - идентификационный номер рецепта в бд
     */
    void deleteRecipeById(Long recipeId);

}
