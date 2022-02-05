package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.eliseev.fitness.model.Recipe;

import java.util.List;

public interface IRecipeRepository extends JpaRepository <Recipe, Long> {
    /**
     * Найти все рецепты подходящие по названию
     * @param name - название рецепта
     */
    List<Recipe> findAllByName(String name);
}
