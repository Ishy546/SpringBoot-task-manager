package com.ismael.taskmanager.controllers;

import com.ismael.taskmanager.DTOs.TaskRequestDTO;
import com.ismael.taskmanager.entities.Task;
import com.ismael.taskmanager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid TaskRequestDTO dto){
        Task task = taskService.createTask(dto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    //get all tasks
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    //get a task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
    }
    // Update a task (simple example, assuming full update)
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody @Valid TaskRequestDTO dto) {
        try {
            Task updatedTask = taskService.updateTask(id, dto);
            return ResponseEntity.ok(updatedTask);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.existsById(id)) {
            taskService.deleteTaskById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
