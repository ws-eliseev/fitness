package ws.eliseev.fitness.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.service.IUserService;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService iUserService;

    @GetMapping()
    public ResponseEntity<List<User>> showAllUsers() {

        return new ResponseEntity<>(iUserService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> addNewUser(@RequestBody User user) {

        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        return new ResponseEntity<>(iUserService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUseName(@PathVariable String username) {

        return new ResponseEntity<>(iUserService.getByUserName(username), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {

        return new ResponseEntity<>(iUserService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/{phone}")
    public ResponseEntity<User> getUserByPhone(@PathVariable String phone) {

        return new ResponseEntity<>(iUserService.getUserByPhone(phone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {

        iUserService.deleteUserById(id);
    }
}
