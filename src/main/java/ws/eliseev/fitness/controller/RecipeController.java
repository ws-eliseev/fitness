package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.service.RecipeService;

import javax.validation.Valid;
import java.util.List;
@Tag(name = "Recipe", description = "Recipe API")
@RestController
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(summary = "Saves recipe", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved recipe",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
                    })
    })
    @PostMapping("/recipes")
    public Recipe saveRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @Operation(summary = "Gets all recipes", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all recipes",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
                    })
    })
    @GetMapping("/recipes")
    public List<Recipe> fetchRecipeList() {
        return recipeService.fetchRecipeList();
    }

    @Operation(summary = "Gets recipe by ID", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found recipe by ID",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
                    })
    })
    @GetMapping("/recipes/{id}")
    public Recipe fetchRecipeById(@PathVariable("id") Long recipeId) {
        return recipeService.fetchRecipeById(recipeId);
    }

    @Operation(summary = "Deletes recipes by ID", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted recipe",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
                    })
    })
    @DeleteMapping("/recipes/{id}")
    public String deleteRecipeById(@PathVariable("id") Long recipeId) {
        recipeService.deleteRecipeById(recipeId);
        return "Recipe deleted. (OK)";
    }

    @Operation(summary = "Updates recipe by ID", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated recipe",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
                    })
    })
    @PutMapping("/recipes/{id}")
    public Recipe updateRecipe(@PathVariable("id") Long recipeId, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipeId, recipe);
    }

    @Operation(summary = "Gets all recipes by name", tags = "recipe")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all recipes found by defined name",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))
                    })
    })
    @GetMapping("/recipes/name/{name}")
    public List<Recipe> fetchDepByName(@PathVariable("name") String name) {
        return recipeService.fetchRecipeByName(name);

    }
}
