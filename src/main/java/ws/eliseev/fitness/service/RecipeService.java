package ws.eliseev.fitness.service;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.repository.IRecipeRepository;
import ws.eliseev.fitness.repository.search.RecipeSearch;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeService implements IRecipeService {

    private final IRecipeRepository recipeRepository;
    private final RecipeSearch recipeSearch;


    public RecipeService(IRecipeRepository recipeRepository, RecipeSearch recipeSearch) {
        this.recipeRepository = recipeRepository;
        this.recipeSearch = recipeSearch;
    }

    @Override
    public List<Recipe> fetchRecipeList() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe saveOrUpdateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> fetchRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId);
    }

    @Override
    public List<Recipe> fetchRecipeByName(String name) {
        return recipeRepository.findAllByName(name);
    }

    @Override
    public void deleteRecipeById(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> search(String query) {
        return recipeSearch.search(query);
    }


//    @Override
//    public List<Recipe> fetchRecipeByMeals(String meal) {
//        return recipeRepository.findAllByMeals(meal);
//    }
//
//    @Override
//    public List<Recipe> fetchRecipeByMealsAndRating(String meal, int rating) {
//        return recipeRepository.findAllByMealsAndRating(meal, rating);
//    }
}
