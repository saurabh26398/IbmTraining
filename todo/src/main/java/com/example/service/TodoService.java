package com.example.service;

import com.example.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getTodos();
    public void createTodo(Todo id);
    public Todo getTodo(int id);
    public void deleteTodo(int id);


}
