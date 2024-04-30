package com.example.todoapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Weixin Liu
 */

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "admin", "Learn AWS", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(++todosCount, "admin", "Learn DevOps", LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(++todosCount, "admin", "Learn Azure", LocalDate.now().plusMonths(3), false));

    }

    public List<Todo> findByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
