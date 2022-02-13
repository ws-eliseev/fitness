package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.UserDTO;
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
public class UserService implements IUserService {

    private final IUserRepository repository;

    private final IUserMapper iUserMapper;

    @Override
    public List<UserDTO> getAllUser() {
        return repository.findAll().stream()
                .map(iUserMapper::maoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUserOrUpdate(UserDTO user) {
        repository.save(iUserMapper.mapToModel(user));
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.getById(id)));
    }

    @Override
    public Optional<UserDTO> getByUserName(String username) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.findByUsername(username)));
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.findUsersByEmail(email)));
    }

    @Override
    public Optional<UserDTO> getUserByPhone(String phone) {
        return Optional.ofNullable(iUserMapper.maoToDto(repository.findUsersByPhone(phone)));
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
