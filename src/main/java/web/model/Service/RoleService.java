package web.model.Service;

import web.model.models.User;
import web.model.models.Role;

import java.util.Set;

public interface RoleService {

    void setRole(Role role);
    Set<Role> getAllRoles();
    Role getRoleByName(String name);
    void updateUser(User user);
}

