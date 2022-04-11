package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.dto.RecipeDto;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.service.IRecipeService;
import ws.eliseev.fitness.util.mapper.IRecipeMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Recipe", description = "Recipe API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {

    private final IRecipeService recipeService;

    private final IRecipeMapper recipeMapper;

    /**
     * Сохраняет или обновляет рецепт в базе данных
     *
     * @param recipeDto - Основной Entity рецепт
     */
    @Operation(summary = "Saves recipe", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved recipe"
            )
    })
    @PostMapping()
    public ResponseEntity<RecipeDto> saveRecipe(@Valid @RequestBody RecipeDto recipeDto) {
        recipeService.saveOrUpdateRecipe(recipeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Get all Users", tags = "Получить списка всех рецептов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка"),
            @ApiResponse(responseCode = "404", description = "Список пользователей не найден")})
    public ResponseEntity<List<RecipeDto>> showAllUsers() {
        List<RecipeDto> recipeList = recipeService.fetchRecipeList();
        if (recipeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipeList, HttpStatus.OK);
    }

    /**
     * Получает рецепт по ID
     *
     * @param recipeId - Идентификационный номер рецепта в БД
     */
    @Operation(summary = "Gets recipe by ID", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found recipe by ID"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Recipe>> fetchRecipeById(@PathVariable("id") Long recipeId) {
        return ResponseEntity.ok(recipeService.fetchRecipeById(recipeId));
    }

    /**
     * Удаляет рецепт из БД по ID
     *
     * @param recipeId - Идентификационный номер рецепта в БД
     */
    @Operation(summary = "Deletes recipes by ID", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted recipe")
    })
    @DeleteMapping("/{id}")
    public String deleteRecipeById(@PathVariable("id") Long recipeId) {
        recipeService.deleteRecipeById(recipeId);
        return "Recipe deleted. (OK)";
    }

    /**
     * Получает все рецепты по совпадению названия
     *
     * @param name - Название рецепта
     */
    @Operation(summary = "Gets all recipes by name", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all recipes found by defined name"
            )
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Recipe>> fetchDepByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(recipeService.fetchRecipeByName(name));
    }
}
