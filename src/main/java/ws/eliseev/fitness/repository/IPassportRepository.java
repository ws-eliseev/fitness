package ws.eliseev.fitness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Passport;

@Repository
public interface IPassportRepository extends JpaRepository<Passport, Long> {
}
