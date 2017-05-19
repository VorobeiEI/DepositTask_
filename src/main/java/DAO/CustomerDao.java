package DAO;

import entity.Customer;

import java.util.List;

/**
 * Created by JackSparrow on 5/3/2017.
 */
public interface CustomerDao {

    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

    List<Customer> searchCustomers(String theSearchName);
}
