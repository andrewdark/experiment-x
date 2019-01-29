package ua.pp.darknsoft.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.models.AppUser;

public interface AppUserService {

    Page<AppUser> getAll(Pageable page);

    Page<AppUser> getAllEnabled(Pageable page);

    Page<AppUser> getAllDisabled(Pageable page);

    @Transactional(readOnly = true)
    Boolean isExists(AppUser appUser);

    @Transactional(readOnly = true)
    Boolean isExists(String username);

    AppUser createAppUser(AppUser appUserForm);

    AppUser createAppUser(String username, String password);
}
