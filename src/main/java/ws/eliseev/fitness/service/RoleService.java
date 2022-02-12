package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ws.eliseev.fitness.dto.RoleDTO;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.repository.IRoleRepository;
import ws.eliseev.fitness.util.mapper.IRoleMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Profile("dev")
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;
    private final IRoleMapper roleMapper;

    public void saveRole(RoleDTO roleDTO) {
        roleRepository.save(roleMapper.mapToModel(roleDTO));
    }

    public Optional<RoleDTO> findRoleById(Long id) {
        Optional<Role> gotRole = roleRepository.findById(id);
        return gotRole.map(roleMapper::mapToDTO);
    }

    public Optional<RoleDTO> findRoleByName(String name) {
        Optional<Role> gotRole = roleRepository.findByName(name);
        return gotRole.map(roleMapper::mapToDTO);
    }

    public List<RoleDTO> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.mapToListDTO(roles);
    }

    @Transactional
    public Optional<RoleDTO> updateRole(RoleDTO roleDTO) {
        if (roleRepository.findById(roleDTO.getId()).isPresent()) {
            roleRepository.save(roleMapper.mapToModel(roleDTO));
            return roleRepository.findById(roleDTO.getId()).map(roleMapper::mapToDTO);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<RoleDTO> deleteRoleById(Long id) {
        Optional<Role> gotRole = roleRepository.findById(id);
        if (gotRole.isPresent()) {
            roleRepository.deleteById(id);
            return gotRole.map(roleMapper::mapToDTO);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<RoleDTO> deleteRoleByName(String name) {
        Optional<Role> gotRole = roleRepository.findByName(name);
        if (gotRole.isPresent()) {
            roleRepository.deleteByName(name);
            return gotRole.map(roleMapper::mapToDTO);
        } else {
            return Optional.empty();
        }
    }
}
