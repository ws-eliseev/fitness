package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Recipe;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IRecipeService {
    /**
     * Вывести список всех рецептов
     */
    public List<Recipe> fetchRecipeList();

    /**
     * Сохранить или обновить рецепт
     *
     * @param recipe - название рецепта
     */
    public Recipe saveOrUpdateRecipe(@Valid Recipe recipe);

    /**
     * Найти рецепт по Id
     *
     * @param recipeId - идентификационный номер рецепта в бд
     */
    public Optional<Recipe> fetchRecipeById(Long recipeId);

    /**
     * Найти все подходящие рецепты по имени
     *
     * @param name - название рецепта в БД
     */
    public List<Recipe> fetchRecipeByName(String name);

    /**
     * Удалить рецепт по Id
     *
     * @param recipeId - идентификационный номер рецепта в бд
     */
    public void deleteRecipeById(Long recipeId);

}
