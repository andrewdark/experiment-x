package ua.pp.darknsoft.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.models.User;
import ua.pp.darknsoft.repositories.UserRepository;
import ua.pp.darknsoft.security.model.UserPrincipal;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository
                   .findByUsername(username)
                   .orElseThrow(() -> new UsernameNotFoundException("User " + username + "not found"));

    return UserPrincipal.build(user);
  }
}
