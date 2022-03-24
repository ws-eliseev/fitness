package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.BodyCharacteristics;

/**
 * SpringData CRUD репозиторий для сущности {@link BodyCharacteristics}
 *
 * @author Tsoy Roman
 */

@Repository
public interface IBodyCharRepository extends JpaRepository<BodyCharacteristics, Long> {
}
