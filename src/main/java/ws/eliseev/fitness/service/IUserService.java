package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.User;
import java.util.List;


public interface IUserService {
    /**
     * Возвращаем список всех User-ов из базы данных
     *
     * @return
     */
    List<User> getAllUser();
    /**
     * Добавляем/изменяем в базе данных нового User-а
     *
     * @param user
     * @return
     */
    User saveUser(User user);
    /**
     * Получаем User-а по id из базы данных
     *
     * @param id
     * @return
     */
    User getUserById(Long id);
    /**
     * Получаем User-а по его username из базы данных
     *
     * @param username
     * @return
     */
    User getByUserName(String username);
    /**
     * Получаем User-а по его email из базы данных
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);
    /**
     * Получаем User-а по номеру его телефона из базы данных
     *
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);
    /**
     * Удаляем User-а из базы данных
     *
     * @param id
     */
    void deleteUserById(Long id);
}
