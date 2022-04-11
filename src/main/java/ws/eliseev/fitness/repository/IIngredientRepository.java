package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.eliseev.fitness.model.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {
}
