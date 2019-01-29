package ua.pp.darknsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darknsoft.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Boolean existsByTaskName(String taskName);
}
