package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.eliseev.fitness.model.Passport;

public interface IPassportRepository extends JpaRepository<Passport, Long> {
}
