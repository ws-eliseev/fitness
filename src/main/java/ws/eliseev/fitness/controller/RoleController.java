package ws.eliseev.fitness.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.dto.RoleDTO;
import ws.eliseev.fitness.service.IRoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<Role> createRole(@RequestBody Role createdRole) {
        roleService.saveOrUpdateRole(createdRole);
        final Optional<Role> gotRole = roleService.findRoleByName(createdRole.getName());
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(presentedRole, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/roleById/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        final Optional<Role> gotRole = roleService.findRoleById(id);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(presentedRole, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/roleByName/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable("name") String name) {
        final Optional<Role> gotRole = roleService.findRoleByName(name);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(presentedRole, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/updateRole")
    public ResponseEntity<Role> updateRoleById(@RequestBody Role updatedRole) {
        roleService.saveOrUpdateRole(updatedRole);
        final Optional<Role> gotRole = roleService.findRoleById(updatedRole.getId());
        return gotRole.map(
                        presentedRole -> new ResponseEntity<>(presentedRole, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Role> deleteRoleById(@PathVariable("id") Long id) {
        final Optional<Role> gotRole = roleService.findRoleById(id);
        roleService.deleteRoleById(id);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(presentedRole, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Role> deleteRoleById(@PathVariable("name") String name) {
        final Optional<Role> gotRole = roleService.findRoleByName(name);
        roleService.deleteRoleByName(name);
        return gotRole.map(
                presentedRole -> new ResponseEntity<>(presentedRole, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
