package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.UserDTO;
import ws.eliseev.fitness.model.User;

/**
 * Преобразование сущности User в DTO
 * @see User
 * @see UserDTO
 * @author Зыков Артем
 */
@Mapper(componentModel = "spring")
public interface IUserMapper {

    /**
     * метод преобразования объекта в DTO
     * @param entity сущность User
     * @return объект типа DTO
     */
    UserDTO maoToDto(User entity);

    /**
     * метод преобразования объекта в entity
     * @param dto объект UserDTO
     * @return сущность User
     */
    User mapToModel(UserDTO dto);
}
