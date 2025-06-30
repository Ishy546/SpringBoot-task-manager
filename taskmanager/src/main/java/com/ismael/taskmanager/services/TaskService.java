package com.ismael.taskmanager.services;

import com.ismael.taskmanager.DTOs.TaskRequestDTO;
import com.ismael.taskmanager.entities.Task;
import com.ismael.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    //Gives me that task repo, so I can make use of those methods that come with it
    @Autowired
    private TaskRepository taskRepository;
    public Task updateTask(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setStatus(dto.getStatus());
        task.setDueDate(dto.getDueDate());

        return taskRepository.save(task);
    }
    public Task createTask(TaskRequestDTO dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setStatus(dto.getStatus());
        task.setDueDate(dto.getDueDate());
        // Store the pizza in the fridge (database)
        return taskRepository.save(task);//save a new task
    }
    // Find tasks by status
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    // Find tasks due before a certain date/time
    public List<Task> getTasksDueBefore(LocalDateTime date) {
        return taskRepository.findByDueDateBefore(date);
    }

    // Find tasks by category ID
    public List<Task> getTasksByCategoryId(Long categoryId) {
        return taskRepository.findByCategoryId(categoryId);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Check if a task exists by ID
    public boolean existsById(Long id) {
        return taskRepository.existsById(id);
    }

    // Count total tasks
    public long countTasks() {
        return taskRepository.count();
    }

    // Delete a task by ID
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    // Delete a given task entity
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    // Delete all tasks
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }
}