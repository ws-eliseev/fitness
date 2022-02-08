package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IUserServiceImpl implements IUserService {

    private final IUserRepository repository;

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Optional<User> getByUserName(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return repository.findUsersByEmail(email);
    }

    @Override
    public Optional<User> getUserByPhone(String phone) {
        return repository.findUsersByPhone(phone);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.findById(id);
    }
}
