package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRecipeRepository extends JpaRepository <Recipe, Long> {
    /**
     * Найти все рецепты подходящие по названию
     * @param name - название рецепта
     */
    List<Recipe> findAllByName(String name);
}
