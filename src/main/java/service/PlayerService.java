package service;

import entity.Deposit;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by JackSparrow on 5/10/2017.
 */
public interface PlayerService {

    public List<Deposit> getCustomers();

    void saveCustomer(Deposit theCustomer);

    public Deposit getCustomer(int theId) ;

    public void deleteCustomer(int theId);

    List<Deposit> searchCustomers(Integer theSearchName);

    BigDecimal sumOfExactCustomerDeposits (Integer playerId);
}
