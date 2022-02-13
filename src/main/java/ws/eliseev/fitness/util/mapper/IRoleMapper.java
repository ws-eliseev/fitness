package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.RoleDTO;
import ws.eliseev.fitness.model.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    /**
     * Метод, позволяющий конвертировать Entity в DTO объект.
     *
     * @param role Сущность, полученная из БД или подлежащая сохранению.
     * @return объект RoleDTO с полями id и name.
     */
    RoleDTO mapToDTO(Role role);

    /**
     * Метод, позволяющий конвертировать DTO объект в Entity.
     *
     * @param roleDTO объект с полями id и name.
     * @return сущность, полученная из БД или подлежащая сохранению.
     */
    Role mapToModel(RoleDTO roleDTO);

    /**
     * Метод, позволяющий конвертировать коллекцию Entities в коллекцию объектов DTO.
     *
     * @param roles коллекция сущностей, полученных из БД.
     * @return коллекция объектов DTO с полями id и name.
     */
    List<RoleDTO> mapToListDTO(List<Role> roles);
}
