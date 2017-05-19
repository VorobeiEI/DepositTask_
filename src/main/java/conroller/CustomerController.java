package conroller;

import DAO.CustomerDao;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import service.CustomerService;


import java.util.List;

/**
 * Created by JackSparrow on 5/3/2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject customer service, dependency injection
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){

        //get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        //add customers to srping MVC model
        theModel.addAttribute("customers", theCustomers);

        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind  form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        //save the customer using service
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel){

        // get the customer from our service

        Customer theCustomer = customerService.getCustomer(theId);
        //set customer as a model attribute to pre populate the form
        theModel.addAttribute("customer", theCustomer);
        //send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId,
                                 Model theModel){
        //delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName")
                                  String theSearchName, Model themodel){
        //search cutomer from the service
        List<Customer> theCustomers= customerService.searchCustomers(theSearchName);

        //add the customers to the model

        themodel.addAttribute("customers", theCustomers);

        return "list-customer";
    }
}

