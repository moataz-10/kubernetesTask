package org.example.todoback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping("/todos")
    public List<String> getTodos() {
        return taskService.getAllTasks();
    }

    @PostMapping("/todos")
    public void addTodo(@RequestBody String todo) {
        if(todo.length()<=140){
            taskService.addTask(todo);
            System.out.println("Added todo: " + todo);
        }else{
            System.out.println("Unallowed String, it must be less than 140");
        }
    }
}
