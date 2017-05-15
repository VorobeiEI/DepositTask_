package service;

import entity.Customer;

import java.util.List;

/**
 * Created by JackSparrow on 5/10/2017.
 */
public interface CustomerService {

    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId) ;

    public void deleteCustomer(int theId);
}
