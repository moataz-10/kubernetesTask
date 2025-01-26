package org.example.todoback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    public Task markAsDone(Integer id, Boolean done) {
        Optional<Task> optionalTodo = taskRepo.findById(id);
        if (optionalTodo.isPresent()) {
            Task todo = optionalTodo.get();
            todo.setDone(done); // Update the "done" field
            return taskRepo.save(todo); // Save the updated entity
        }
        return null;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public void addTask(Task todo) {
        taskRepo.save(todo);
    }

    public void testDb() {
        taskRepo.flush();
    }
}
