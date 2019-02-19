package ua.pp.darknsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pp.darknsoft.models.Authority;
import ua.pp.darknsoft.models.AuthorityName;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Authority, Long>{
    Optional<Authority> findByName(AuthorityName name);
}
