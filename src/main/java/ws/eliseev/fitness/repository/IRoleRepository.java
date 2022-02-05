package ws.eliseev.fitness.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);
    List<Role> findAllRoles();
    void deleteByName(String name);
}
