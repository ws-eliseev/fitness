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
        return (List<User>) repository.findAll();
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> getByUserName(String username) {
        return Optional.ofNullable(repository.findByUsername(username));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(repository.findUsersByEmail(email));
    }

    @Override
    public Optional<User> getUserByPhone(String phone) {
        return Optional.ofNullable(repository.findUsersByPhone(phone));
    }

    @Override
    public void deleteUserById(Long id) {
        repository.findById(id);
    }
}
