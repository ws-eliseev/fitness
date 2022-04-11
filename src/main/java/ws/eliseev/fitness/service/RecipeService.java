package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.RecipeDto;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.repository.IRecipeRepository;
import ws.eliseev.fitness.util.mapper.IRecipeMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {

    private final IRecipeRepository recipeRepository;

    private final IRecipeMapper recipeMapper;


    @Override
    public List<RecipeDto> fetchRecipeList() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdateRecipe(RecipeDto recipeDto) {recipeRepository.save(recipeMapper.mapToModel(recipeDto));
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
}
