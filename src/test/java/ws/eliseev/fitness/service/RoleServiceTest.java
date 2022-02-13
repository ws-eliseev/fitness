package ws.eliseev.fitness.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ws.eliseev.fitness.dto.RoleDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RoleServiceTest {

    @Autowired
    private IRoleService roleService;

    @Test
    void saveRole() {
        RoleDTO createdRoleDTO = new RoleDTO(1L, "ROLE_USER");
        roleService.saveRole(createdRoleDTO);
        RoleDTO foundedRoleDTO = roleService.findRoleByName("ROLE_USER").get();
        assertEquals(createdRoleDTO.getName(), foundedRoleDTO.getName());
    }
}