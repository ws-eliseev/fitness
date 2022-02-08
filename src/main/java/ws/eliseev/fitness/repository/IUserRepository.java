package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.eliseev.fitness.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
}
