package web.model.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.model.Dao.RoleDao;
import web.model.models.Role;
import web.model.models.User;


import java.util.HashSet;
import java.util.Set;

@Service("roleService")
public class RoleServicelmpl implements RoleService {

    private final RoleDao roleDao;


    public RoleServicelmpl(@Qualifier("roleDao")RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void setRole(Role role) {
        roleDao.setRole(role);
    }
    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    public void updateUser(User user){
        Set<Role> temp = new HashSet<>();
        user.getRoles().forEach(role -> temp.add(getRoleByName(role.getName())));
        user.setRoles(temp);
    }
}
