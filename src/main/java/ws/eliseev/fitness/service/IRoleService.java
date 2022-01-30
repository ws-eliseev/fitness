package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Role;

import java.util.List;

public interface IRoleService {
    void saveRole(Role role);
    Role getRoleByID(int id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    void deleteRoleById(int id);
    void deleteRoleByName(String name);
}
