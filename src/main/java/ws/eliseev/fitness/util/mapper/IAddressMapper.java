package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.AddressDto;
import ws.eliseev.fitness.model.Address;

/**
 * Преобразование сущности Address в DTO
 *
 * @author Мельник Андрей
 * @see Address
 * @see AddressDto
 */
@Mapper(componentModel = "spring")
public interface IAddressMapper {

    /**
     * метод преобразования объекта в DTO
     *
     * @param entity сущность Address
     * @return объект типа DTO
     */
    AddressDto mapToDto(Address entity);

    /**
     * метод преобразования объекта в entity
     *
     * @param dto объект AddressDto
     * @return сущность Address
     */
    Address mapToModel(AddressDto dto);
}
