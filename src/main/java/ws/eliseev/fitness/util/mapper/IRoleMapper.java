package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.RoleDto;
import ws.eliseev.fitness.model.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    /**
     * Метод, позволяющий конвертировать Entity в DTO объект.
     *
     * @param role Сущность, полученная из БД или подлежащая сохранению.
     * @return объект RoleDto с полями id и name.
     */
    RoleDto mapToDTO(Role role);

    /**
     * Метод, позволяющий конвертировать DTO объект в Entity.
     *
     * @param roleDTO объект с полями id и name.
     * @return сущность, полученная из БД или подлежащая сохранению.
     */
    Role mapToModel(RoleDto roleDTO);

    /**
     * Метод, позволяющий конвертировать коллекцию Entities в коллекцию объектов DTO.
     *
     * @param roles коллекция сущностей, полученных из БД.
     * @return коллекция объектов DTO с полями id и name.
     */
    List<RoleDto> mapToListDTO(List<Role> roles);
}
