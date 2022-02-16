package ws.eliseev.fitness.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ws.eliseev.fitness.dto.RoleDto;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RoleServiceTest {

    @Autowired
    private IRoleService roleService;

    @Test
    void saveRole() {
        RoleDto createdRoleDto = new RoleDto();
        createdRoleDto.setName("ROLE_TEST123");

        Optional<RoleDto> createdRole = roleService.saveRole(createdRoleDto);
        createdRole.ifPresent(roleDto -> assertEquals("ROLE_TEST123", roleDto.getName()));
    }

    @Test
    void updateRole() {
        RoleDto updatedRoleDTO = roleService.findRoleByName("ROLE_TEST123").get();
        updatedRoleDTO.setName("ROLE_TEST-UPDATED");

        roleService.updateRole(updatedRoleDTO);

        RoleDto foundedRoleDTO = roleService.findRoleByName("ROLE_TEST-UPDATED").get();
        assertEquals("ROLE_TEST-UPDATED", foundedRoleDTO.getName());
    }

    @Test
    void deleteRole() {
        roleService.deleteRoleByName("ROLE_TEST-UPDATED");
        assertEquals(Optional.empty(), roleService.findRoleByName("ROLE_TEST-UPDATED"));
    }
}
