package ws.eliseev.fitness.service;

import java.util.List;
import java.util.Optional;

public interface IRecipeService {
    //Вывести список всех рецептов
    public List<Recipe> fetchRecipeList();
    //Сохранить или обновить рецепт
    public Recipe saveOrUpdateRecipe(Recipe recipe);
    //Найти рецепт по Id
    public Optional<Recipe> fetchRecipeById(Long departmentId);
    //Найти все подходящие рецепты по имени
    public List<Recipe> fetchRecipeByName(String name);
    //Удалить рецепт по Id
    public void deleteRecipeById(Long recipeId);
}
