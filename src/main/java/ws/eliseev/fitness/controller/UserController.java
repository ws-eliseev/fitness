package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.service.IUserService;
import ws.eliseev.fitness.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер реализует CRUD-операции над пользователем
 * @see UserService
 * @author Зыков Артем
 */
@Tag(name = "Users", description = "CRUD  операции над пользователями")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService service;

    @GetMapping()
    @Operation(summary = "Get all Users", tags = "Получить списка всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка"),
            @ApiResponse(responseCode = "404", description = "Список пользователей не найден")})
    public ResponseEntity<List<UserDto>> showAllUsers() {
        List<UserDto> userList = service.getAllUser();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Add new User", tags = "Создать пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Успешное создание пользователя"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    public ResponseEntity<UserDto> addNewUser(@RequestBody UserDto user) {
        service.saveUserOrUpdate(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    @Operation(summary = "Update User", tags = "Обновить пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные пользователя обновлены"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    public void updateUser(@RequestBody UserDto user) {
        service.saveUserOrUpdate(user);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get User by id", tags = "Получение пользователя по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") Long id) {
        Optional<UserDto> user = service.getUserById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(user);
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "Get User by username", tags = "Получение пользователя по 'username'")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    public ResponseEntity<Optional<UserDto>> getUserByUseName(@PathVariable(value = "username") String username) {
        Optional<Optional<UserDto>> userName = Optional.of(service.getByUserName(username));
        return ResponseEntity.of(userName);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get User by email", tags = "Получение пользователя по 'email'")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    public ResponseEntity<Optional<UserDto>> getUserByEmail(@PathVariable(value = "email") String email) {
        Optional<Optional<UserDto>> userEmail = Optional.of(service.getUserByEmail(email));
        return ResponseEntity.of(userEmail);
    }

    @GetMapping("/phone/{phone}")
    @Operation(summary = "Get User by phone", tags = "Получение пользователя по номеру телефона")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    public ResponseEntity<Optional<UserDto>> getUserByPhone(@PathVariable(value = "phone") String phone) {
        Optional<Optional<UserDto>> userPhone = Optional.of(service.getUserByPhone(phone));
        return ResponseEntity.of(userPhone);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User by id", tags = "Удаление пользователя по 'id'")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь удален"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    public void deleteUserById(@PathVariable(value = "id") Long id) {
        service.deleteUserById(id);
    }
}
