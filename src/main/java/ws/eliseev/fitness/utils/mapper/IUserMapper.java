package ws.eliseev.fitness.utils.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.model.User;

/**
 * Преобразование сущности User в DTO
 * @see ws.eliseev.fitness.model.User
 * @see ws.eliseev.fitness.dto.UserDto
 * @author Зыков Артем
 */
@Mapper(componentModel = "spring")
public interface IUserMapper {

    /**
     * метод преобразования объекта в DTO
     * @param entity сущность User
     * @return объект типа DTO
     */
    UserDto maoToDto(User entity);

    /**
     * метод преобразования объекта в entity
     * @param dto объект UserDto
     * @return сущность User
     */
    User mapToModel(UserDto dto);
}
