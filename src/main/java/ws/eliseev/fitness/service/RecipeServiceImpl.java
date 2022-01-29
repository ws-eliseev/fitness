package ws.eliseev.fitness.service;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.repository.RecipeRepository;

import java.util.List;
import java.util.Objects;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> fetchRecipeList() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe fetchRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId).get();
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
    public Recipe updateRecipe(Long departmentId, Recipe recipe) {
        Recipe recDB = recipeRepository.findById(recipe.getId()).get();
        if (Objects.nonNull(recipe.getName()) &&
                !"".equalsIgnoreCase(recipe.getName())) {
            recDB.setName(recipe.getName());
        }
        if (Objects.nonNull(recipe.getDisckript()) &&
                !"".equalsIgnoreCase(recipe.getDisckript())) {
            recDB.setDisckript(recipe.getDisckript());
        }
        if (Objects.nonNull(recipe.getCustName()) &&
                !"".equalsIgnoreCase(recipe.getCustName())) {
            recDB.setCustName(recipe.getCustName());
        }
        return recipeRepository.save(recDB);
    }

}
