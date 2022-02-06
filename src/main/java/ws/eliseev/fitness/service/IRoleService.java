package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    /**
     * Метод, позволяющий сохранить или обновить роль.
     *
     * @param role Сохраняемая.обновляемая роль.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<Role> saveOrUpdateRole(Role role);

    /**
     * Метод, позволяющий найти роль по Id.
     *
     * @param id идентификатор искомой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<Role> findRoleById(Long id);

    /**
     * Метод, позволяющий найти роль по имени.
     *
     * @param name имя искомой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<Role> findRoleByName(String name);

    /**
     * Метод, позволяющий найти все роли.
     *
     * @return Коллекция (List) ролей.
     */
    List<Role> findAllRoles();

    /**
     * Метод, позволяющий удалить роль по Id.
     *
     * @param id идентификатор удаляемой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<Role> deleteRoleById(Long id);

    /**
     * Метод, позволяет удалить роль по имени.
     * @param name имя удаляемой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<Role> deleteRoleByName(String name);
}
