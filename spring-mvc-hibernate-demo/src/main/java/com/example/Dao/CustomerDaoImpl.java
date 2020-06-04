package com.example.Dao;

import com.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

import java.util.List;
@Repository("customerDAO")
public class CustomerDaoImpl implements CustomerDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomer() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Customer");
        return query.getResultList();
    }
    @Transactional
    @Override
    public Customer createCustomer(Customer customer) {
        Session session=sessionFactory.getCurrentSession();
        session.save(customer);
        return customer;
    }

    @Override
    public void updateCustomer(int id) {

    }
}
