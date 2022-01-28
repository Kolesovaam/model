package web.model.Dao;

import web.model.models.Role;

import java.util.Set;

public interface RoleDao {
    void setRole(Role role);
    Set<Role> getAllRoles();
    Role getRoleByName(String name);
}
