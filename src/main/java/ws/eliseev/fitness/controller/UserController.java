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
        log.debug("All Users{}", userList);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        if (user != null) {
            service.saveUser(user);
            log.debug("The user is saved in the database{}", user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        log.debug("Unsuccessful");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (user != null) {
            service.saveUser(user);
            log.debug("User updated{}", user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        log.debug("Unsuccessful");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        Optional<User> user = service.getUserById(id);
        if (user.isEmpty()) {
            log.debug("User with id=" + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.getUserById(id);
        log.debug("User id{}}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUseName(@PathVariable(value = "username") String username) {
        User userName = service.getByUserName(username);
        if (userName.getUsername().isEmpty()) {
            log.debug("");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.getByUserName(username);
        log.debug("");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable(value = "email") String email) {
        User usersByEmail = service.getUserByEmail(email);
        if (usersByEmail.getEmail().isEmpty()) {
            log.debug("");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.getUserByEmail(email);
        log.debug("");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{phone}")
    public ResponseEntity<User> getUserByPhone(@PathVariable(value = "phone") String phone) {
        User userByPhone = service.getUserByPhone(phone);
        if (userByPhone.getPhone().isEmpty()) {
            log.debug("User phone not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.getUserByPhone(phone);
        log.debug("User phone {}", phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable(value = "id") Long id) {
        Optional<User> user = service.getUserById(id);
        log.debug("Deleting User{}", user);
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
