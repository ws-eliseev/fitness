package ws.eliseev.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.repository.IUserRepository;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;
    @Autowired
    public IUserServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<User> getAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return iUserRepository.getById(id);
    }

    @Override
    public User getByUserName(String username) {
        return iUserRepository.getUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return iUserRepository.getUserByEmail(email);
    }

    @Override
    public User getUserByPhone(String phone) {
        return iUserRepository.getUserByPhone(phone);
    }

    @Override
    public void deleteUserById(Long id) {
        iUserRepository.deleteById(id);
    }
}
