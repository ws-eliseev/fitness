package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.service.IRecipeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Recipe", description = "Recipe API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {

    private final IRecipeService recipeService;

    /**
     * Сохраняет или обновляет рецепт в базе данных
     *
     * @param recipe - Основной Entity рецепт
     */
    @Operation(summary = "Saves recipe", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved recipe"
            )
    })
    @PostMapping()
    public ResponseEntity<Recipe> saveRecipe(@Valid @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.saveOrUpdateRecipe(recipe));

    }

    /**
     * Получает список всех рецептов
     */
    @Operation(summary = "Gets all recipes", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all recipes"
            )
    })
    @GetMapping()
    public ResponseEntity<List<Recipe>> fetchRecipeList() {
        return ResponseEntity.ok(recipeService.fetchRecipeList());
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

    /**
     * Получает все рецепты по совпадению времени приема пищи
     *
     * @param meal - время приема пищи
     */
    @Operation(summary = "Get all recipes by meal", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all recipes found by defined meal"
            )
    })
    @GetMapping("/meal")
    public ResponseEntity<List<Recipe>> fetchByMeals(@RequestParam("meal") String meal) {
        return ResponseEntity.ok(recipeService.fetchRecipeByMeals(meal));
    }

    /**
     * Получает все рецепты по времени приема пищи и райтингу
     *
     * @param meal - время приема пищи
     * @param rating - рейтинг рецепта
     */
    @Operation(summary = "Get all recipes by meals and ratings", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all recipes found by defined meals and ratings"
            )
    })
    @GetMapping("/by_meal_and_rating")
    public ResponseEntity<List<Recipe>> fetchRecipesByMealsAndRatings(@RequestParam("meal") String meal,
                                                                      @RequestParam("rating") int rating){
        return ResponseEntity.ok(recipeService.fetchRecipeByMealsAndRating(meal, rating));
    }
}
