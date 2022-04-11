package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.RecipeDto;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.model.User;

@Mapper(componentModel = "spring")
public interface IRecipeMapper {
    /**
     * метод преобразования объекта в DTO
     * @param recipe сущность Recipe
     * @return объект типа DTO
     */
    RecipeDto mapToDto(Recipe recipe);

    /**
     * метод преобразования объекта в entity
     * @param recipeDto объект RecipeDto
     * @return сущность User
     */
    Recipe mapToModel(RecipeDto recipeDto);
}
