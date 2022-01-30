package ws.eliseev.fitness.service;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.repository.IRoleRepository;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public Role getRoleByID(int id) {
        return roleRepository.getById(id);
    }

    public Role getRoleByName(String name) {
        return roleRepository.getByName(name);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void deleteRoleById(int id) {
        roleRepository.deleteById(id);
    }

    public void deleteRoleByName(String name) {
        roleRepository.deleteByName(name);
    }
}

