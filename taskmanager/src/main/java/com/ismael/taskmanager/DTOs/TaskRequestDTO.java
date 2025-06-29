package com.ismael.taskmanager.DTOs;

import com.ismael.taskmanager.entities.Priority;
import com.ismael.taskmanager.entities.TaskStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class TaskRequestDTO {
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less that 100 characters")//validation for the user
    private String title;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @NotNull(message = "Status is required")
    private TaskStatus status;

    private Priority priority;

    @Future(message = "Due date must be in the future") // validation feature for the user that makes sure the date is in the future.
    private LocalDateTime dueDate;

    private Long categoryId;      // send just the ID, not full object
    private Long assignedToUserId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Long getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(Long assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
