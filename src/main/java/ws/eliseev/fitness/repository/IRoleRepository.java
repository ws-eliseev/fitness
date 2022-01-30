package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role getByName(String name);
    void deleteByName(String name);
}
