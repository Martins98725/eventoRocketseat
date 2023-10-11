package br.icaromartins.todolisticaro.user.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaksController {
    @Autowired
    private ITaskRepository repository;
    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel){
        var task = this.repository.save(taskModel);
        return task;
    }
}
