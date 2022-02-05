package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.repository.IRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;

    public Optional<Role> saveOrUpdateRole(Role role) {
        roleRepository.save(role);
        return findRoleByName(role.getName());
    }

    public Optional<Role> findRoleByID(Integer id) {
        return roleRepository.findById(id);
    }

    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> deleteRoleById(Integer id) {
        final Optional<Role> deletedOptionalRole = roleRepository.findById(id);
        roleRepository.deleteById(id);
        return deletedOptionalRole;
    }

    public Optional<Role> deleteRoleByName(String name) {
        final Optional<Role> deletedOptionalRole = roleRepository.findByName(name);
        roleRepository.deleteByName(name);
        return deletedOptionalRole;
    }
}
