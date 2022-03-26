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
     * Получить рецепты, удовлетворяющие заданным критериям
     *
     * @return лист рецептов по запросу
     */
    List<Recipe> findAll();

    List<Recipe> search(String q);
}
