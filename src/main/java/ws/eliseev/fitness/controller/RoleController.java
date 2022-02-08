package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.dto.RoleDTO;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.service.IRoleService;
import ws.eliseev.fitness.util.mapper.IRoleMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
@Tag(name = "Role", description = "CRUD операции с ролями")
@Log4j2
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
    @Operation(summary = "Создание роли")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно создана"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос")})
    public ResponseEntity<RoleDTO> createRole(@RequestBody @NonNull RoleDTO createdRoleDTO) {
        final Optional<Role> gotRole = roleService.saveRole(roleMapper.mapToModel(createdRoleDTO));
        log.info("Create role");
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
    @Operation(summary = "Получение роли по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно получена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Long id) {
        final Optional<Role> gotRole = roleService.findRoleById(id);
        log.info("Get role by id");
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
    @Operation(summary = "Получение роли по имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно получена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> getRoleByName(@PathVariable("name") String name) {
        final Optional<Role> gotRole = roleService.findRoleByName(name);
        log.info("Get role by name");
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
    @Operation(summary = "Получение всех ролей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роли успешно получены"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос")})
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<Role> allRoles = roleService.findAllRoles();
        log.info("Get all roles");
        return new ResponseEntity<>(roleMapper.mapToListDTO(allRoles), HttpStatus.OK);
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
        final Optional<Role> gotRole = roleService.updateRole(roleMapper.mapToModel(updatedRoleDTO));
        log.info("Update role");
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
    @Operation(summary = "Удаление роли по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно удалена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable("id") Long id) {
        final Optional<Role> gotRole = roleService.deleteRoleById(id);
        log.info("Delete role by id");
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
    @Operation(summary = "Удаление роли по имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль успешно удалена"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Роль не найдена")})
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable("name") String name) {
        final Optional<Role> gotRole = roleService.deleteRoleByName(name);
        log.info("Delete role by name");
        return gotRole.map(
                        presentedRole -> new ResponseEntity<>(roleMapper.mapToDTO(presentedRole), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
