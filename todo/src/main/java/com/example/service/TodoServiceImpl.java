package com.example.service;

import com.example.dao.TodoDao;
import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("todoService")
public class TodoServiceImpl implements TodoService {
    private final TodoDao todoDao;

    @Autowired
    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public List<Todo> getTodos() {
        return todoDao.getTodos();
    }

    @Override
    public void createTodo(Todo todo) {
        todoDao.createTodo(todo);
    }

    @Override
    public Todo getTodo(int id) {
        return todoDao.getTodo(id);
    }

    @Override
    public void deleteTodo(int id) {
          todoDao.deleteTodo(id);
    }
}
