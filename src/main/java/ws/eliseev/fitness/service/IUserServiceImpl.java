package ws.eliseev.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IUserServiceImpl implements IUserService {

    private final IUserRepository repository;
    @Autowired
    public IUserServiceImpl(IUserRepository repository) {
        this.repository = repository;
    }

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
    public User getByUserName(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findUsersByEmail(email);
    }

    @Override
    public User getUserByPhone(String phone) {
        return repository.findUsersByPhone(phone);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.findById(id);
    }
}
