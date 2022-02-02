package ws.eliseev.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.service.IUserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final IUserServiceImpl iUserService;

    @Autowired
    public UserController(IUserServiceImpl iUserService) {
        this.iUserService = iUserService;
    }

    /**
     * Возвращаем список всех User-ов из базы данных
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(iUserService.getAllUser(), HttpStatus.OK);
    }

    /**
     * Добавляем в базу данных нового User-а
     * @param user
     * @return
     */
    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.OK);
    }

    /**
     * Изменяем данные User-а в базу данных
     * @param user
     * @return
     */
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.OK);
    }

    /**
     * Получаем User-а по id из базы данных
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(iUserService.getUserById(id), HttpStatus.OK);
    }

    /**
     * Получаем User-а по его username из базы данных
     * @param username
     * @return
     */
    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByUseName(@PathVariable String username) {
        return new ResponseEntity<>(iUserService.getByUserName(username), HttpStatus.OK);
    }

    /**
     * Получаем User-а по его email из базы данных
     * @param email
     * @return
     */
    @GetMapping("/users/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(iUserService.getUserByEmail(email), HttpStatus.OK);
    }

    /**
     * Получаем User-а по номеру его телефона из базы данных
     * @param phone
     * @return
     */
    @GetMapping("/users/{phone}")
    public ResponseEntity<User> getUserByPhone(@PathVariable String phone) {
        return new ResponseEntity<>(iUserService.getUserByPhone(phone), HttpStatus.OK);
    }

    /**
     * Удаляем User-а из базы данных
     * @param id
     */
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        iUserService.deleteUserById(id);
    }
}
