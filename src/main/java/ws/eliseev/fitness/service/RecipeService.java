package ws.eliseev.fitness.service;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.repository.IRecipeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService implements IRecipeService {

    private final IRecipeRepository recipeRepository;

    public RecipeService(IRecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> fetchRecipeList() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe saveOrUpdateRecipe( Recipe recipe) {
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
    public List<Recipe> search(String q) {
        return search(q);
    }
}
