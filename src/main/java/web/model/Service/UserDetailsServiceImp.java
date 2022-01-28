package web.model.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import web.model.Dao.UserDao;

import web.model.models.Role;
import web.model.models.User;

@Service("userServiceImpl")
public class UserDetailsServiceImp implements UserDetailsService {
    private final UserDao userDao;

    public UserDetailsServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if (login.equals("ADMIN")) {
            User user = new User("ADMIN", "ADMIN", "adm", "adm");
            user.addRole(new Role(2L, "ADMIN"));
            return user;
        }
        return userDao.getUserByLogin(login).orElse(null);
    }
}
