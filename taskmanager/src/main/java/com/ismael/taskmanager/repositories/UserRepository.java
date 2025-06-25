package com.ismael.taskmanager.repositories;

import com.ismael.taskmanager.entities.Category;
import com.ismael.taskmanager.entities.Task;
import com.ismael.taskmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String name);
}
