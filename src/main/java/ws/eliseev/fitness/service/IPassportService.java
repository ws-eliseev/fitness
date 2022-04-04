package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Document;
import ws.eliseev.fitness.model.Passport;

import java.util.List;
import java.util.Optional;

public interface IPassportService {

    /**
     * @return Возвращаем список всех Document-ов из базы данных
     */
    List<Passport> getAllPassport();

    /**
     * @param passport Добавляем/изменяем в базе данных новый документ
     */
    Passport saveOrUpdatePassport(Passport passport);

    /**
     * @param id Получаем Document по id из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<Passport> getPassportById(Long id);


    /**
     * @param id Удаляем Document из базы данных
     */
    void deletePassportById(Long id);
}

