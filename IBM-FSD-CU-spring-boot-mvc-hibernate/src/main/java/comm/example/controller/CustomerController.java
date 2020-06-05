package comm.example.controller;

import comm.example.model.Customer;
import comm.example.service.CustomerService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.PresentationDirection;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/listCustomer")
    public String listCustomer(Model model) {
        model.addAttribute("customers",customerService.getCustomers());
        return "customer-list";

    }

    @RequestMapping("/showForm")
    public String addCustomer(Model model)
    {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }
    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer Customer, BindingResult theBindingResult){
        if (theBindingResult.hasErrors()){
            return "add-customer";
        }
        else {
            customerService.createCustomer(Customer);
            return "redirect:/customer/listCustomer";
        }
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("customerId") int customerId)
    {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/listCustomer";
    }
    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model)
    {
        Customer theCustomer = customerService.getCustomer(customerId);
        model.addAttribute("customer", theCustomer);
        return "add-customer";
    }
    @RequestMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer)
    {
        customerService.createCustomer(customer);
        return "redirect:/customer/listCustomer";
    }

}
