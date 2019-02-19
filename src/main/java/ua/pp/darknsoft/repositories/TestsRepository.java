package ua.pp.darknsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pp.darknsoft.models.Test;

import java.util.Collection;

@Repository
public interface TestsRepository extends JpaRepository<Test, Long> {

    //query should be checked
    Collection<Test> findByTask_Id(Long taskId);
}
