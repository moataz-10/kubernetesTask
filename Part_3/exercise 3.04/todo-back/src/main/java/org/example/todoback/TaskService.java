package org.example.todoback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    public List<String> getAllTasks() {
        List<Task> tasks = taskRepo.findAll();
        List<String> todos = new ArrayList<>(); // Use a local list
        for (Task task : tasks) {
            todos.add(task.getTask());
        }
        return todos;
    }

    public void addTask(String todo) {
        Task newTask = new Task();
        newTask.setTask(todo);
        taskRepo.save(newTask);
    }
}
