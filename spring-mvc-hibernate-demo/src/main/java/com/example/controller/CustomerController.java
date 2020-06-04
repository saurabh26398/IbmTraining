package com.example.controller;


import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    Scanner sc=new Scanner(System.in);
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/listCustomer")
    public String listCustomer(Model model)
    {
        model.addAttribute("customers",customerService.getAllCustomer());
        return "list-customer";
    }
    @RequestMapping("/showForm")
    public String addCustomer(Model model)
    {
        model.addAttribute("customer", new Customer());
        return "add-customer-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("customer") Customer Customer,Model model){
           model.addAttribute("customers",customerService.createCustomer(new Customer(Customer.getFirstName(),Customer.getLastName(),Customer.getEmail())));
           return "saved-customer";
    }
   /* public void updateCustomer(Model model)
    {
        model.addAttribute("Status", customerService.updateCustomer(1));

    }*/
}