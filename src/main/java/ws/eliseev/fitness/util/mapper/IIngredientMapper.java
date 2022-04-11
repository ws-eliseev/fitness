package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.IngredientDto;
import ws.eliseev.fitness.model.Ingredient;

@Mapper(componentModel = "spring")
public interface IIngredientMapper {

    /**
     * метод преобразования объекта в DTO
     * @param ingredient сущность Ingredient
     * @return объект типа DTO
     */
    IngredientDto mapToDto(Ingredient ingredient);
    /**
     * метод преобразования объекта в entity
     * @param ingredientDto объект IngredientDto
     * @return сущность User
     */
    Ingredient mapToModel(IngredientDto ingredientDto);
}
