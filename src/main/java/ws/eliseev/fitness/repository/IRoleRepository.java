package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Role;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    /**
     * Метод, позволяющий получить роль из БД по имени.
     *
     * @param name имя искомой роли.
     * @return Optional, в котором либо объект роли, либо null.
     */
    Optional<Role> findByName(String name);

    /**
     * Метод, позволяющий удалить роль из БД по имени.
     *
     * @param name имя удаляемой роли.
     */
    void deleteByName(String name);
}
