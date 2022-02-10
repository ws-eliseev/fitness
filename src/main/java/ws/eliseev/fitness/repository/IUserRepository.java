package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User  findUsersByEmail(String email);

    User findUsersByPhone(String phone);

}
