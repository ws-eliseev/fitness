package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Address;
import ws.eliseev.fitness.model.Document;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    /**
     * @return Возвращаем список всех Адресов из базы данных
     */
    List<Address> getAllAddress();

    /**
     * @param address Добавляем/изменяем в базе данных новый адрес
     */
   Address saveOrUpdateAddress(Address address);

    /**
     * @param id Получаем Address по id из базы данных
     * @return Возвращаем полученный Address
     */
    Optional<Address> getAddressById(Long id);


    /**
     * @param id Удаляем Address из базы данных
     */
    void deleteAddressById(Long id);
}
