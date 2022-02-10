package ws.eliseev.fitness.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.User;


@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User  findUsersByEmail(String email);

    User findUsersByPhone(String phone);
}
