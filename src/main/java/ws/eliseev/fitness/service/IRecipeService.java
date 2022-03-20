package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface IRecipeService {
    /**
     * Вывести список всех рецептов
     */
    List<Recipe> fetchRecipeList();

    /**
     * Сохранить или обновить рецепт
     *
     * @param recipe - название рецепта
     */
    Recipe saveOrUpdateRecipe(Recipe recipe);

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

    /**
     * Найти подходящие рецепты по времени приема пищи
     *
     * @param meal - время приема пищи
     */
    List<Recipe> fetchRecipeByMeals(String meal);

    /**
     * Найти подходящие рецепты по времени приема пищи и рейтингу
     *
     * @param meal - время приема пищи
     * @param rating - рейтинг рецепта
     */
    List<Recipe> fetchRecipeByMealsAndRating(String meal, int rating);
}
