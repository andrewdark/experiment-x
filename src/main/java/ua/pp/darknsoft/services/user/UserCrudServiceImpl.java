package ua.pp.darknsoft.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.models.User;
import ua.pp.darknsoft.repositories.UserRepository;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserCrudServiceImpl implements UserCrudService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

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
    public User create(String username, String password) {
        User user = new User(username, bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
