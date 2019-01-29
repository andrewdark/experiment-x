package ua.pp.darknsoft.controllers.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.models.Level;
import ua.pp.darknsoft.models.Task;
import ua.pp.darknsoft.services.TaskService;

import java.util.*;

@RestController
@RequestMapping(value = "/api/v1")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Task>> getAllTasks(Pageable pageable) {
        return new ResponseEntity<Page<Task>>(taskService.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> getOneById(@PathVariable Long id) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isEmpty()) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> create(@RequestBody Task task) {
        if (taskService.isTaskExist(task)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Task>(taskService.create(task), HttpStatus.CREATED);
    }

    @PutMapping(path = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isEmpty()) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        Task currentTask = optionalTask.get();
        currentTask.setDescription(task.getDescription());
        currentTask.setSignature(task.getSignature());
        currentTask.setLevel(task.getLevel());
        currentTask.setTags(task.getTags());
        currentTask.setTaskName(task.getTaskName());
        taskService.update(currentTask);
        return new ResponseEntity<>(currentTask, HttpStatus.OK);
    }

    @DeleteMapping(path = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/level")
    public ResponseEntity<List<Level>> getLevels() {

        return new ResponseEntity<List<Level>>(Arrays.asList(Level.values()), HttpStatus.OK);
    }
}
