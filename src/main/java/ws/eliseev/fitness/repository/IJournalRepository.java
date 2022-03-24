package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Journal;

/**
 * SpringData CRUD репозиторий для сущности {@link Journal}
 *
 * @author Tsoy Roman
 */

@Repository
public interface IJournalRepository extends JpaRepository<Journal, Long> {
}
