package ua.pp.darknsoft.services.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.pp.darknsoft.models.User;
import ua.pp.darknsoft.services.errors.UsernameExistsException;

public interface UserService {

    Page<User> getAll(Pageable page);

    Page<User> getAllEnabled(Pageable page);

    Page<User> getAllDisabled(Pageable page);

    void createUser(String username, String password) throws UsernameExistsException;
}
