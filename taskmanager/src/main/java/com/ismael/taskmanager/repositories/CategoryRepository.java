package com.ismael.taskmanager.repositories;

import com.ismael.taskmanager.entities.Category;
import com.ismael.taskmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}
