package ws.eliseev.fitness.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.User;

import java.util.Optional;

@Repository
@Profile("dev")
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Optional<User>  findUsersByEmail(String email);

    Optional<User>  findUsersByPhone(String phone);
}
