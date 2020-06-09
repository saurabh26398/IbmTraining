package com.example.dao;

import com.example.model.Todo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository("todoDao")
public class TodoDaoImpl implements TodoDao {
    private final EntityManager entityManager;

    @Autowired
    public TodoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Todo> getTodos() {

        Query query=entityManager.createQuery("FROM Todo");
        return query.getResultList();
    }
    @Override
    @Transactional
    public void createTodo(Todo todo) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        //  session.getTransaction().begin();
        session.saveOrUpdate(todo);
        //session.getTransaction().commit();


    }

    @Override
    @Transactional
    public Todo getTodo(int id) {
        return entityManager.find(Todo.class,id);
    }

    @Override
    @Transactional
    public void deleteTodo(int id) {
        entityManager.remove(getTodo(id));

    }
}