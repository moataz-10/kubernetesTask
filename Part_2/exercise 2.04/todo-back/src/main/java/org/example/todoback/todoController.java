package org.example.todoback;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin // Allow requests from the frontend
public class todoController {
    private List<String> todos;
    public todoController(){
        todos = new ArrayList<>();
    }

    @GetMapping("/todos")
    public List<String> getTodos() {
        return todos;
    }

    @PostMapping("/todos")
    public void addTodo(@RequestBody String todo) {
        todos.add(todo);
        System.out.println("Added todo: " + todo);
    }
}
