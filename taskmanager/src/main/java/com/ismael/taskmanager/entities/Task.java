package com.ismael.taskmanager.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name="tasks")
public class Task {

    @Id//assigns id columns to database
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tells your database: "Hey, automatically assign a new, unique ID to this task when you save it."
    private long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less that 100 characters")//validation for the user
    @Column(nullable = false, length = 100)//database constraint, the title cannot be empty, and has to be less than 100 characters
    private String title;

    @Size(max = 500, message = "Description must be less than 500 characters")
    @Column(length=500)
    private String description;

    @Enumerated(EnumType.STRING)//save the enum as its name in text form, so like todo
    @Column(nullable = false)
    private TaskStatus status = TaskStatus.TODO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority = Priority.MEDIUM;

    @Future(message = "Due date must be in the future") // validation feature for the user that makes sure the date is in the future.
    private LocalDateTime dueDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;//stores when the task was created

    private LocalDateTime updatedAt;//stores when task is last updated

    @PrePersist//runs automatically before saving a new task in the database
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate//runs automatically just before updating an existing task
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Task(String title){
        this.title = title;
        this.status=TaskStatus.TODO;
        this.priority = Priority.MEDIUM;
    }
    public Task(String title, String description){
        this(title);
        this.description=description;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // Many tasks can be assigned to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    // Add getters and setters for new fields
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public User getAssignedTo() { return assignedTo; }
    public void setAssignedTo(User assignedTo) { this.assignedTo = assignedTo; }
}

enum Priority {
    LOW, MEDIUM, HIGH
}




