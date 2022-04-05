package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ws.eliseev.fitness.dto.RecipeDto;
import ws.eliseev.fitness.model.Recipe;

@Mapper(componentModel = "spring")
@Component
public interface IRecipeMapper {

    RecipeDto mapToDto(Recipe recipe);

    Recipe mapToModel(RecipeDto recipeDto);
}
