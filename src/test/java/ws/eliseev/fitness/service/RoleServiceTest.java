package ws.eliseev.fitness.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ws.eliseev.fitness.dto.RoleDTO;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RoleServiceTest {

    @Autowired
    private IRoleService roleService;

    @Test
    void saveRole() {
        RoleDTO createdRoleDTO = new RoleDTO();
        createdRoleDTO.setName("ROLE_TEST");

        roleService.saveRole(createdRoleDTO);

        RoleDTO foundedRoleDTO = roleService.findRoleByName("ROLE_TEST").get();
        assertEquals("ROLE_TEST", foundedRoleDTO.getName());
    }

    @Test
    void updateRole() {
        RoleDTO updatedRoleDTO = roleService.findRoleByName("ROLE_TEST").get();
        updatedRoleDTO.setName("ROLE_TEST-UPDATED");

        roleService.updateRole(updatedRoleDTO);

        RoleDTO foundedRoleDTO = roleService.findRoleByName("ROLE_TEST-UPDATED").get();
        assertEquals("ROLE_TEST-UPDATED", foundedRoleDTO.getName());
    }

    @Test
    void deleteRole() {
        roleService.deleteRoleByName("ROLE_TEST-UPDATED");
        assertEquals(Optional.empty(), roleService.findRoleByName("ROLE_TEST-UPDATED"));
    }
}
