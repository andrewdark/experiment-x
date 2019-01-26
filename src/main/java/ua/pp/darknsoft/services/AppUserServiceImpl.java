package ua.pp.darknsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.models.AppUser;
import ua.pp.darknsoft.repositories.UserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional(readOnly = true)
    @Override
    public Page<AppUser> getAll(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public Page<AppUser> getAllEnabled(Pageable page) {
        return userRepository.findAllByEnabled(true, page);
    }

    @Override
    public Page<AppUser> getAllDisabled(Pageable page) {
        return userRepository.findAllByEnabled(false, page);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean isExists(AppUser appUser) {
        return userRepository.existsByUserName(appUser.getUserName().toLowerCase());
    }

    @Transactional(readOnly = true)
    public Boolean isExists(String username) {
        return userRepository.existsByUserName(username.toLowerCase());
    }

    @Override
    public AppUser createAppUser(AppUser appUserForm) {
        AppUser savedUser = new AppUser();
        appUserForm.setUserName(appUserForm.getUserName().toLowerCase());
        appUserForm.setEncryptedPassword(bCryptPasswordEncoder.encode(appUserForm.getEncryptedPassword()));
        if (!isExists(appUserForm))
            savedUser = userRepository.save(appUserForm);

        return savedUser;
    }

    @Override
    public AppUser createAppUser(String username, String password){
        AppUser user = new AppUser();
        user.setUserName(username.toLowerCase());
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(password));
        if (!isExists(username))
            return userRepository.save(user);
        return user;
    }

}
