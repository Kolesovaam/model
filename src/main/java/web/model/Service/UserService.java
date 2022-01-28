package web.model.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void setUser(User user);
    User getUser(long id);
    void updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();
    User getUserByLogin(String login);
}
