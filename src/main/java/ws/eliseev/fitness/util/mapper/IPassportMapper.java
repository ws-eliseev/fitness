package ws.eliseev.fitness.util.mapper;


import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.PassportDto;
import ws.eliseev.fitness.model.Passport;

/**
 * Преобразование сущности Passport в DTO
 *
 * @author Мельник Андрей
 * @see Passport
 * @see PassportDto
 */
@Mapper(componentModel = "spring")
public interface IPassportMapper {

    /**
     * метод преобразования объекта в DTO
     *
     * @param entity сущность Passport
     * @return объект типа DTO
     */
    PassportDto mapToDto(Passport entity);

    /**
     * метод преобразования объекта в entity
     *
     * @param dto объект PassportDto
     * @return сущность Passport
     */
    Passport mapToModel(PassportDto dto);
}
