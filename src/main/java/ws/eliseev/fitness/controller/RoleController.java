package ws.eliseev.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.service.IRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/createRole")
    public void createRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @GetMapping("/roleById/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") int id) {
        return new ResponseEntity<>(roleService.getRoleByID(id), HttpStatus.OK);
    }

    @GetMapping("/roleByName/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }

    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @PutMapping("/updateRole")
    public ResponseEntity<Role> updateRoleById(@RequestBody Role updatedRole) {
        roleService.saveRole(updatedRole);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Role> deleteRoleById(@PathVariable("id") int id) {
        Role deletedRole = roleService.getRoleByID(id);
        roleService.deleteRoleById(id);
        return new ResponseEntity<>(deletedRole, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Role> deleteRoleById(@PathVariable("name") String name) {
        Role deletedRole = roleService.getRoleByName(name);
        roleService.deleteRoleByName(name);
        return new ResponseEntity<>(deletedRole, HttpStatus.OK);
    }
}
