package ws.eliseev.fitness.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.dto.RoleDTO;
import ws.eliseev.fitness.service.IRoleService;
import ws.eliseev.fitness.util.mapper.IRoleMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;
    private final IRoleMapper roleMapper;

    /**
     * Метод контроллера, позволяющий сохранить роль в БД.
     *
     * @param createdRoleDTO DTO сохраняемой роли.
     * @return ResponseEntity сохраняемой роли, параметризованная RoleDTO.
     */
    @PostMapping("/createRole")
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO createdRoleDTO) {
        final Optional<Role> gotRole = roleService.saveOrUpdateRole(roleMapper.mapToModel(createdRoleDTO));
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(roleMapper.mapToDTO(presentedRole), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    /**
     * Метод контроллера, позволяющий получить роль по id.
     *
     * @param id идентификатор получаемой роли.
     * @return ResponseEntity получаемой роли, параметризованная RoleDTO.
     */
    @GetMapping("/roleById/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Long id) {
        final Optional<Role> gotRole = roleService.findRoleById(id);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(roleMapper.mapToDTO(presentedRole), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    /**
     * Метод контроллера, позволяющий получить роль по имени.
     *
     * @param name имя получаемой роли.
     * @return ResponseEntity получаемой роли, параметризованная RoleDTO.
     */
    @GetMapping("/roleByName/{name}")
    public ResponseEntity<RoleDTO> getRoleByName(@PathVariable("name") String name) {
        final Optional<Role> gotRole = roleService.findRoleByName(name);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(roleMapper.mapToDTO(presentedRole), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    /**
     * Метод контроллера, позволяющий получить все роли.
     *
     * @return ResponseEntity получаемых ролей, параметризованная ListDTO.
     */
    @GetMapping("/allRoles")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return new ResponseEntity<>(roleMapper.mapToListDTO(roleService.findAllRoles()), HttpStatus.OK);
    }

    /**
     * Метод контроллера, позволяющий обновить роль в БД.
     * @param updatedRoleDTO DTO обновляемой роли.
     * @return ResponseEntity обновляемой роли, параметризованная RoleDTO.
     */
    @PutMapping("/updateRole")
    public ResponseEntity<RoleDTO> updateRoleById(@RequestBody RoleDTO updatedRoleDTO) {
        roleService.saveOrUpdateRole(roleMapper.mapToModel(updatedRoleDTO));
        final Optional<Role> gotRole = roleService.findRoleById(updatedRoleDTO.getId());
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(roleMapper.mapToDTO(presentedRole), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    /**
     * Метод контроллера, позволяющий удалить роль из БД по id.
     *
     * @param id идентификатор удаляемой роли.
     * @return ResponseEntity удаляемой роли, параметризованная RoleDTO.
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable("id") Long id) {
        final Optional<Role> gotRole = roleService.deleteRoleById(id);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(roleMapper.mapToDTO(presentedRole), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    /**
     * Метод контроллера, позволяющий удалить роль из БД по имени.
     *
     * @param name имя удаляемой роли.
     * @return ResponseEntity удаляемой роли, параметризованная RoleDTO.
     */
    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable("name") String name) {
        final Optional<Role> gotRole = roleService.deleteRoleByName(name);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(roleMapper.mapToDTO(presentedRole), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
