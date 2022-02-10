package ws.eliseev.fitness.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.service.IUserService;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService service;

    @GetMapping()
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> userList = service.getAllUser();
        if (userList.isEmpty()) {
            log.debug("No users found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("All Users");
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        service.saveUser(user);
        log.debug("The user is saved in the database");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public void updateUser(@RequestBody User user) {
        log.debug("Unsuccessful");
        service.saveUser(user);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        Optional<User> user = service.getUserById(id);
        if (user.isEmpty()) {
            log.debug("User with id=" + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("User id{}", id);
        return ResponseEntity.of(user);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<User>> getUserByUseName(@PathVariable(value = "username") String username) {
        Optional<Optional<User>> userName = Optional.of(service.getByUserName(username));
        log.debug("Username{}", userName);
        return ResponseEntity.of(userName);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable(value = "email") String email) {
        Optional<Optional<User>> userEmail = Optional.of(service.getUserByEmail(email));
        log.debug("Email{}", email);
        return ResponseEntity.of(userEmail);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Optional<User>> getUserByPhone(@PathVariable(value = "phone") String phone) {
        Optional<Optional<User>> userPhone = Optional.of(service.getUserByPhone(phone));
        log.debug("Phone number{}", phone);
        return ResponseEntity.of(userPhone);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long id) {
        service.deleteUserById(id);
        log.debug("User deleted");
    }
}
