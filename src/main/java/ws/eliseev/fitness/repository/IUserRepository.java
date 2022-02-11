package ws.eliseev.fitness.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.User;


@Repository
@Profile("dev")
public interface IUserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User  findUsersByEmail(String email);

    User findUsersByPhone(String phone);
}
