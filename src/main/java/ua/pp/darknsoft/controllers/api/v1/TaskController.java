package ua.pp.darknsoft.controllers.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.services.task.TaskService;

@RestController
@RequestMapping(value = "/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

}
