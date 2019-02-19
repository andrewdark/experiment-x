package ua.pp.darknsoft.services.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.models.Task;
import ua.pp.darknsoft.repositories.TaskRepository;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Page<Task> getAll(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task create(Task task) {
        if (task.getId() != null) {
            task.setId(null);
        }
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task currentTask) {
        return taskRepository.save(currentTask);
    }

    @Override
    public Optional<Task> findNextUncompletedTask(Long userId) {
        //should search for unsolved tasks with given userID. if found, should fetch first not solved. if not found,
        //should return
        return Optional.empty();
    }
}
