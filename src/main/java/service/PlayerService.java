package service;

import entity.Deposit;

import java.math.BigDecimal;
import java.util.List;

public interface PlayerService {

    public List<Deposit> getCustomers();

    void saveCustomer(Deposit theCustomer);

    public Deposit getCustomer(int theId);

    public void deleteCustomer(int theId);

    List<Deposit> searchCustomers(Integer theSearchName);

    BigDecimal sumOfExactCustomerDeposits(Integer playerId);
}
