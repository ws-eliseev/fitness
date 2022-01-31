package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.service.IRoleService;

import java.util.List;

@Tag(name = "Role", description = "Role API")
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Operation(summary = "Create role", tags = "role")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Created role",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Role.class))
                            )
                    }
            )
    })
    @PostMapping("/createRole")
    public void createRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @Operation(summary = "Get role by id", tags = "role")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found role by id",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Role.class))
                            )
                    }
            )
    })
    @GetMapping("/roleById/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") int id) {
        return new ResponseEntity<>(roleService.getRoleByID(id), HttpStatus.OK);
    }

    @Operation(summary = "Get role by name", tags = "role")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found role by name",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Role.class))
                            )
                    }
            )
    })
    @GetMapping("/roleByName/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }

    @Operation(summary = "Get all roles", tags = "role")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found all roles",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Role.class))
                            )
                    }
            )
    })
    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @Operation(summary = "Update role", tags = "role")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updated role",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Role.class))
                            )
                    }
            )
    })
    @PutMapping("/updateRole")
    public ResponseEntity<Role> updateRoleById(@RequestBody Role updatedRole) {
        roleService.saveRole(updatedRole);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @Operation(summary = "Delete role by id", tags = "role")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted role",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Role.class))
                            )
                    }
            )
    })
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Role> deleteRoleById(@PathVariable("id") int id) {
        Role deletedRole = roleService.getRoleByID(id);
        roleService.deleteRoleById(id);
        return new ResponseEntity<>(deletedRole, HttpStatus.OK);
    }

    @Operation(summary = "Delete role by name", tags = "role")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted role",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Role.class))
                            )
                    }
            )
    })
    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Role> deleteRoleById(@PathVariable("name") String name) {
        Role deletedRole = roleService.getRoleByName(name);
        roleService.deleteRoleByName(name);
        return new ResponseEntity<>(deletedRole, HttpStatus.OK);
    }
}
