package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Workout;

/**
 * SpringData CRUD репозиторий для сущности Workout
 * @author Корнеев Аркадий
 */
@Repository
public interface IWorkoutRepository extends JpaRepository<Workout, Long> {
}
