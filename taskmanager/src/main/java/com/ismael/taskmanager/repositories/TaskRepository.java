package com.ismael.taskmanager.repositories;

import com.ismael.taskmanager.entities.Task;
import com.ismael.taskmanager.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByStatus(String status);
    List<Task> findByDueDateBefore(LocalDateTime date);
    List<Task> findByCategoryId(Long categoryId);

}
