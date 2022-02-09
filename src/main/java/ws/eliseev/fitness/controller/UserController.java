package ws.eliseev.fitness.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
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
@Profile("dev")
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        if (user != null) {
            service.saveUser(user);
            log.debug("The user is saved in the database");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        log.debug("Unsuccessful");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (user != null) {
            service.saveUser(user);
            log.debug("User updated");
            return new ResponseEntity<>(HttpStatus.OK);
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
        log.debug("User id{}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUseName(@PathVariable(value = "username") String username) {
        Optional<User> userName = service.getByUserName(username);
        if (userName.isEmpty()) {
            log.debug("Username not found{}", userName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("Username{}", userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable(value = "email") String email) {
        Optional<User> userEmail = service.getUserByEmail(email);
        if (userEmail.isEmpty()) {
            log.debug("Email not found{}", userEmail);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("Email{}", email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{phone}")
    public ResponseEntity<User> getUserByPhone(@PathVariable(value = "phone") String phone) {
        Optional<User> userPhone = service.getUserByPhone(phone);
        if (userPhone.isEmpty()) {
            log.debug("Phone number not found{}", userPhone);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("Phone number{}", phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable(value = "id") Long id) {
        if (id == null) {
            log.debug("User with id not found{}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteUserById(id);
        log.debug("User deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
