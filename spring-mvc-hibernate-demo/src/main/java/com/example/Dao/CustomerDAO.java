package com.example.Dao;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getAllCustomer();
    public Customer createCustomer(Customer customer);
    public void updateCustomer(int id);
}
