package ws.eliseev.fitness.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.model.SecurityUser;
import ws.eliseev.fitness.repository.IUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository iUserRepository;

    public UserDetailsServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = iUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return SecurityUser.fromUser(user);
    }
}
