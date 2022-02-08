package ws.eliseev.fitness.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserRepository repository;

    @GetMapping()
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> userList = repository.findAll();
        if (userList.isEmpty()) {
            log.debug("No users found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        if (user != null) {
            repository.save(user);
            log.debug("The user is saved in the database");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        log.debug("Unsuccessful");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        if (user != null) {
            repository.save(user);
            log.debug("User updated");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        log.debug("Unsuccessful");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            log.debug("User with id=" + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.getById(id);
        log.debug("User id=" + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUseName(@PathVariable(value = "username") String username) {
        Optional<User> userName = repository.findByUserName(username);
        if (userName.isEmpty()) {
            log.debug("");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.findByUserName(username);
        log.debug("");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable(value = "email") String email) {
        Optional<User> usersByEmail = repository.findUsersByEmail(email);
        if (usersByEmail.isEmpty()) {
            log.debug("");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.findUsersByEmail(email);
        log.debug("");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{phone}")
    public ResponseEntity<User> getUserByPhone(@PathVariable(value = "phone") String phone) {
        Optional<User> userByPhone = repository.findUsersByPhone(phone);
        if (userByPhone.isEmpty()) {
            log.debug("");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.findUsersByPhone(phone);
        log.debug("");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable(value = "id") Long id) {
        if (id == null) {
            log.debug("User with id=" + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        log.debug("");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
