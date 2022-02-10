package ws.eliseev.fitness.service;

import ws.eliseev.fitness.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    /**
     * Метод, позволяющий сохранить роль.
     *
     * @param roleDTO сохраняемая роль.
     */
    void saveRole(RoleDTO roleDTO);

    /**
     * Метод, позволяющий найти роль по Id.
     *
     * @param id идентификатор искомой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<RoleDTO> findRoleById(Long id);

    /**
     * Метод, позволяющий найти роль по имени.
     *
     * @param name имя искомой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<RoleDTO> findRoleByName(String name);

    /**
     * Метод, позволяющий найти все роли.
     *
     * @return Коллекция (List) ролей.
     */
    List<RoleDTO> findAllRoles();

    /**
     * Метод, позволяющий обновить роль.
     *
     * @param roleDTO DTO обновляемой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<RoleDTO> updateRole(RoleDTO roleDTO);

    /**
     * Метод, позволяющий удалить роль по Id.
     *
     * @param id идентификатор удаляемой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<RoleDTO> deleteRoleById(Long id);

    /**
     * Метод, позволяет удалить роль по имени.
     *
     * @param name имя удаляемой роли.
     * @return Optional, в котором может храниться либо роль, либо null.
     */
    Optional<RoleDTO> deleteRoleByName(String name);
}
