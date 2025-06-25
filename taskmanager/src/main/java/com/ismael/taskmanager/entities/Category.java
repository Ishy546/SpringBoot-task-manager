package com.ismael.taskmanager.entities;
//for grouping tasks

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required")
    @Size(max = 50, message = "Category name must be less than 50 characters")
    @Column(nullable=false, unique=true, length =50)
    private String name;

    @Size(max=200, message = "Description must be less than 200 characters")
    private String description;
//One to many says that the one category has many tasks, cascade means if you do crud to a catagory, you crud tasks
    @OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//tasks won't be loaded from the database unless you do a getter
    private List<Task> tasks = new ArrayList<>();
    public Category(){}

    public Category(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}


