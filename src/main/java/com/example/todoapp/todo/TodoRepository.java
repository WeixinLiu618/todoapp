package com.example.todoapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Weixin Liu
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}
