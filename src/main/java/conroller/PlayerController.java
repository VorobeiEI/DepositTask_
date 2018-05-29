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

@Controller
@RequestMapping("/deposit")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Deposit> theCustomers = playerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);

        return "list-deposit";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Deposit theCustomer = new Deposit();
        theModel.addAttribute("player", theCustomer);
        return "update-form";
    }

    @PostMapping("/saveDeposit")
    public String saveCustomer(@ModelAttribute("player") Deposit theCustomer) {

        theCustomer.setDate(new Date(System.currentTimeMillis()));
        playerService.saveCustomer(theCustomer);
        return "redirect:/deposit/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {

        Deposit theCustomer = playerService.getCustomer(theId);
        theModel.addAttribute("player", theCustomer);
        return "update-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId,
                                 Model theModel) {
        playerService.deleteCustomer(theId);

        return "redirect:/deposit/list";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchPlayerId")
                                          Integer theSearchName, Model themodel) {
        List<Deposit> theCustomers = playerService.searchCustomers(theSearchName);
        BigDecimal sumOfCustomersDepo = playerService.sumOfExactCustomerDeposits(theSearchName);

        themodel.addAttribute("customers", theCustomers);
        themodel.addAttribute("deposums", sumOfCustomersDepo);

        return "list-deposit";
    }
}

