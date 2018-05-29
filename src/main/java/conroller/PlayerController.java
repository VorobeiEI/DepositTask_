package conroller;

import entity.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import service.PlayerService;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by JackSparrow on 5/3/2017.
 */
@Controller
@RequestMapping("/deposit")
public class PlayerController {

    //need to inject customer service, dependency injection
    @Autowired
    private PlayerService playerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){

        //get customers from the service
        List<Deposit> theCustomers = playerService.getCustomers();

        //add customers to srping MVC model
        theModel.addAttribute("customers", theCustomers);

        return "list-deposit";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind  form data
        Deposit theCustomer = new Deposit();
        theModel.addAttribute("player", theCustomer);
        return "update-form";
    }

    @PostMapping("/saveDeposit")
    public String saveCustomer(@ModelAttribute("player") Deposit theCustomer){

        //save the customer using service
        theCustomer.setDate(new Date(System.currentTimeMillis()));
        playerService.saveCustomer(theCustomer);
        return "redirect:/deposit/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel){

        // get the customer from our service

        Deposit theCustomer = playerService.getCustomer(theId);
        //set customer as a model attribute to pre populate the form
        theModel.addAttribute("player", theCustomer);
        //send over to our form
        return "update-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId,
                                 Model theModel){
        //delete the customer
        playerService.deleteCustomer(theId);

        return "redirect:/deposit/list";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchPlayerId")
                                  Integer theSearchName, Model themodel){
        //search cutomer from the service
        List<Deposit> theCustomers= playerService.searchCustomers(theSearchName);
        BigDecimal sumOfCustomersDepo = playerService.sumOfExactCustomerDeposits(theSearchName);

        //add the customers to the model

        themodel.addAttribute("customers", theCustomers);
        themodel.addAttribute("deposums", sumOfCustomersDepo);

        return "list-deposit";
    }
}

