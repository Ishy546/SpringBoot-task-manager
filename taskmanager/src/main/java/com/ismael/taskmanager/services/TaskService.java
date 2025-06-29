package com.ismael.taskmanager.services;

import com.ismael.taskmanager.DTOs.TaskRequestDTO;
import com.ismael.taskmanager.entities.Task;
import com.ismael.taskmanager.repositories.CategoryRepository;
import com.ismael.taskmanager.repositories.TaskRepository;
import com.ismael.taskmanager.repositories.UserRepository;
import com.ismael.taskmanager.entities.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    //Gives me that task repo, so I can make use of those methods that come with it
    @Autowired
    private TaskRepository taskRepository;

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
}