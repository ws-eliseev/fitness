package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    /**
     *
     * @return Возвращаем список всех User-ов из базы данных
     */
    List<User> getAllUser();

    /**
     *
     * @param user Добавляем/изменяем в базе данных нового User-а
     */
    void saveUser(User user);

    /**
     *
     *
     * @param id Получаем User-а по id из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<User> getUserById(Long id);

    /**
     *
     * @param username Получаем User-а по его username из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<User> getByUserName(String username);

    /**
     *
     * @param email Получаем User-а по его email из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<User> getUserByEmail(String email);

    /**
     *
     * @param phone Получаем User-а по номеру его телефона из базы данных
     * @return Возвращаем User-а по номеру его телефона
     */
    Optional<User> getUserByPhone(String phone);

    /**
     *
     * @param id Удаляем User-а из базы данных
     */
    void deleteUserById(Long id);
}
