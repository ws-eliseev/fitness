package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.repository.IUserRepository;
import ws.eliseev.fitness.util.mapper.IUserMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс реализует интерфейс доступа к репозиторию
 *
 * @author Зыков Артем
 * @see IUserService
 */
@RequiredArgsConstructor
@Service
public class UserService implements IUserService, UserDetailsService {

    private final IUserRepository repository;

    private final IUserMapper iUserMapper;

    @Override
    public List<UserDto> getAllUser() {
        return repository.findAll().stream()
                .map(iUserMapper::maoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUserOrUpdate(UserDto user) {
        repository.save(iUserMapper.mapToModel(user));
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.getById(id)));
    }

    @Override
    public Optional<UserDto> getByUserName(String username) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.findByUsername(username)));
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.findUsersByEmail(email)));
    }

    @Override
    public Optional<UserDto> getUserByPhone(String phone) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.findUsersByPhone(phone)));
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }
}
