package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    User saveUser(User user);

    User getUserById(Long id);

    User getByUserName(String username);

    User getUserByEmail(String email);

    User getUserByPhone(String phone);

    void deleteUserById(Long id);
}
