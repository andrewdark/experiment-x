package ua.pp.darknsoft.services.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.pp.darknsoft.models.Task;

import java.util.Optional;

public interface TaskService {
    Page<Task> getAll(Pageable pageable);

    Optional<Task> getTaskById(Long id);

    boolean isTaskExist(Task task);

    Task create(Task task);

    void deleteById(Long id);

    Task update(Task currentTask);
}
