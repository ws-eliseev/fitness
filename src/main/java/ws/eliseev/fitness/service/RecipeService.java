package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Recipe;

import java.util.List;

public interface RecipeService {
    //Вывести список всех рецептов
    public List<Recipe> fetchRecipeList();
    //Сохранить рецепт
    public Recipe saveRecipe(Recipe recipe);
    //Найти рецепт по Id
    public Recipe fetchRecipeById(Long departmentId);
    //Найти все подходящие рецепты по имени
    public List<Recipe> fetchRecipeByName(String name);
    //Удалить рецепт по Id
    public void deleteRecipeById(Long recipeId);
    //Обновить рецепт
    public Recipe updateRecipe(Long departmentId, Recipe recipe);
}
