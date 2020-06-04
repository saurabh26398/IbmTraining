package com.example.service;

import com.example.entity.Customer;


   import java.util.List;

    public interface CustomerService {
        public List<Customer> getAllCustomer();
        public Customer createCustomer(Customer customer);
        public void updateCustomer(int id);



    }

