package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ws.eliseev.fitness.dto.RoleDto;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.repository.IRoleRepository;
import ws.eliseev.fitness.util.mapper.IRoleMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;
    private final IRoleMapper roleMapper;

    @Transactional
    public Optional<RoleDto> saveRole(RoleDto roleDto) {
        if (roleRepository.findByName(roleDto.getName()).isPresent()) {
            return Optional.empty();
        } else {
            roleRepository.save(roleMapper.mapToModel(roleDto));
            return roleRepository.findByName(roleDto.getName()).map(roleMapper::mapToDTO);
        }
    }

    public Optional<RoleDto> findRoleById(Long id) {
        Optional<Role> gotRole = roleRepository.findById(id);
        return gotRole.map(roleMapper::mapToDTO);
    }

    public Optional<RoleDto> findRoleByName(String name) {
        Optional<Role> gotRole = roleRepository.findByName(name);
        return gotRole.map(roleMapper::mapToDTO);
    }

    public List<RoleDto> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.mapToListDTO(roles);
    }

    @Transactional
    public Optional<RoleDto> updateRole(RoleDto roleDTO) {
        if (roleRepository.findById(roleDTO.getId()).isPresent()) {
            roleRepository.save(roleMapper.mapToModel(roleDTO));
            return roleRepository.findById(roleDTO.getId()).map(roleMapper::mapToDTO);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<RoleDto> deleteRoleById(Long id) {
        Optional<Role> gotRole = roleRepository.findById(id);
        if (gotRole.isPresent()) {
            roleRepository.deleteById(id);
            return gotRole.map(roleMapper::mapToDTO);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<RoleDto> deleteRoleByName(String name) {
        Optional<Role> gotRole = roleRepository.findByName(name);
        if (gotRole.isPresent()) {
            roleRepository.deleteByName(name);
            return gotRole.map(roleMapper::mapToDTO);
        } else {
            return Optional.empty();
        }
    }
}
