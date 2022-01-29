package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.eliseev.fitness.model.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository <Recipe, Long> {
    //Найти все рецепты по имени
    List<Recipe> findAllByName(String name);
}
