package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.dto.RoleDTO;
import ws.eliseev.fitness.service.IRoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
@Tag(name = "Role", description = "CRUD операции с ролями")
@Log4j2
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    /**
     * Метод контроллера, позволяющий сохранить роль в БД.
     *
     * @param createdRoleDTO DTO сохраняемой роли.
     */
    @PostMapping("/createRole")
    @Operation(summary = "Создание роли")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно создана"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос")})
    public void createRole(@RequestBody RoleDTO createdRoleDTO) {
        roleService.saveRole(createdRoleDTO);
        log.info("Create user: [{}]", createdRoleDTO);
    }

    /**
     * Метод контроллера, позволяющий получить роль по id.
     *
     * @param id идентификатор получаемой роли.
     * @return ResponseEntity получаемой роли, параметризованная RoleDTO.
     */
    @GetMapping("/roleById/{id}")
    @Operation(summary = "Получение роли по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно получена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Long id) {
        Optional<RoleDTO> foundRoleDTO = roleService.findRoleById(id);
        if (foundRoleDTO.isPresent()) {
            RoleDTO presentedRole = foundRoleDTO.get();
            log.info("Get role with id {} : [{}]", id, presentedRole);
            return ResponseEntity.ok(presentedRole);
        } else {
            log.info("Get role with id {} : not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Метод контроллера, позволяющий получить роль по имени.
     *
     * @param name имя получаемой роли.
     * @return ResponseEntity получаемой роли, параметризованная RoleDTO.
     */
    @GetMapping("/roleByName/{name}")
    @Operation(summary = "Получение роли по имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно получена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> getRoleByName(@PathVariable("name") String name) {
        Optional<RoleDTO> foundRoleDTO = roleService.findRoleByName(name);
        if (foundRoleDTO.isPresent()) {
            RoleDTO presentedRole = foundRoleDTO.get();
            log.info("Get role with name {} : [{}]", name, presentedRole);
            return ResponseEntity.ok(presentedRole);
        } else {
            log.info("Get role with name {} : not found", name);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Метод контроллера, позволяющий получить все роли.
     *
     * @return ResponseEntity получаемых ролей, параметризованная ListDTO.
     */
    @GetMapping("/allRoles")
    @Operation(summary = "Получение всех ролей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роли успешно получены"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос")})
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roleDTOS = roleService.findAllRoles();
        log.info("Get all roles, size: {}", roleDTOS.size());
        return ResponseEntity.ok(roleDTOS);
    }

    /**
     * Метод контроллера, позволяющий обновить роль в БД.
     *
     * @param updatedRoleDTO DTO обновляемой роли.
     * @return ResponseEntity обновляемой роли, параметризованная RoleDTO.
     */
    @PutMapping("/updateRole")
    @Operation(summary = "Обновление роли")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно обновлена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> updateRoleById(@RequestBody @NonNull RoleDTO updatedRoleDTO) {
        Optional<RoleDTO> updatedRole = roleService.updateRole(updatedRoleDTO);
        if (updatedRole.isPresent()) {
            RoleDTO presentedRole = updatedRole.get();
            log.info("Update role: [{}] - success", presentedRole);
            return ResponseEntity.ok(presentedRole);
        } else {
            log.info("Update role: not found");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Метод контроллера, позволяющий удалить роль из БД по id.
     *
     * @param id идентификатор удаляемой роли.
     * @return ResponseEntity удаляемой роли, параметризованная RoleDTO.
     */
    @DeleteMapping("/deleteById/{id}")
    @Operation(summary = "Удаление роли по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно удалена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable("id") Long id) {
        Optional<RoleDTO> deletedRole = roleService.deleteRoleById(id);
        if (deletedRole.isPresent()) {
            RoleDTO presentedRole = deletedRole.get();
            log.info("Delete role with id {} : [{}]", id, presentedRole);
            return ResponseEntity.ok(presentedRole);
        } else {
            log.info("Delete role with id {} : not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Метод контроллера, позволяющий удалить роль из БД по имени.
     *
     * @param name имя удаляемой роли.
     * @return ResponseEntity удаляемой роли, параметризованная RoleDTO.
     */
    @DeleteMapping("/deleteByName/{name}")
    @Operation(summary = "Удаление роли по имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно удалена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> deleteRoleByName(@PathVariable("name") String name) {
        Optional<RoleDTO> deletedRole = roleService.deleteRoleByName(name);
        if (deletedRole.isPresent()) {
            RoleDTO presentedRole = deletedRole.get();
            log.info("Delete role with name {} : [{}]", name, presentedRole);
            return ResponseEntity.ok(presentedRole);
        } else {
            log.info("Delete role with name {} : not found", name);
            return ResponseEntity.notFound().build();
        }
    }
}
