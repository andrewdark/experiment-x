package ua.pp.darknsoft.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.services.errors.UsernameExistsException;
import ua.pp.darknsoft.models.Authority;
import ua.pp.darknsoft.models.AuthorityName;
import ua.pp.darknsoft.models.User;
import ua.pp.darknsoft.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Transactional(readOnly = true)
    @Override
    public Page<User> getAll(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public Page<User> getAllEnabled(Pageable page) {
        return userRepository.findAllByEnabled(true, page);
    }

    @Override
    public Page<User> getAllDisabled(Pageable page) {
        return userRepository.findAllByEnabled(false, page);
    }

    @Override
    public void createUser(String username, String password) {
        final User user = new User();

        userRepository
                .findByUsername(username)
                .ifPresentOrElse(
                    (u)-> {throw new UsernameExistsException("Username '" + username + "' already exists.");},
                    () -> {
                      user.setUsername(username);
                      user.setPassword(encoder.encode(password));

                      Set<Authority> authorities = new HashSet<>();
                      Authority authority = new Authority();
                      authority.setName( AuthorityName.ROLE_USER);
                      authorities.add(authority);
                      user.setAuthorities(authorities);});

        userRepository.save(user);
    }
}
