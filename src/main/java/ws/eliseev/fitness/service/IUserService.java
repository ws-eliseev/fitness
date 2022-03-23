package ws.eliseev.fitness.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ws.eliseev.fitness.dto.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для обращения к репозиторию
 * @see ws.eliseev.fitness.repository.IUserRepository
 * @author Зыков Артем
 */
public interface IUserService extends UserDetailsService {

    /**
     * @return Возвращаем список всех User-ов из базы данных
     */
    List<UserDto> getAllUser();

    /**
     * @param user Добавляем/изменяем в базе данных нового User-а
     */
    void saveUserOrUpdate(UserDto user);

    /**
     * @param id Получаем User-а по id из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<UserDto> getUserById(Long id);

    /**
     * @param username Получаем User-а по его username из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<UserDto> getByUserName(String username);

    /**
     * @param email Получаем User-а по его email из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<UserDto> getUserByEmail(String email);

    /**
     * @param phone Получаем User-а по номеру его телефона из базы данных
     * @return Возвращаем User-а по номеру его телефона
     */
    Optional<UserDto> getUserByPhone(String phone);

    /**
     * @param id Удаляем User-а из базы данных
     */
    void deleteUserById(Long id);
}
