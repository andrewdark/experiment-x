package ua.pp.darknsoft.services.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.models.User;

import java.util.Optional;

public interface UserCrudService {

    Page<User> getAll(Pageable page);

    Page<User> getAllEnabled(Pageable page);

    Page<User> getAllDisabled(Pageable page);

    User create(String username, String password);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);
}
