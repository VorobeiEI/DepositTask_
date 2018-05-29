package DAO;


import entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by JackSparrow on 5/3/2017.
 */
@Repository
public class CustomerDAOImpl implements CustomerDao {


    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get the current hiber session
        Session currentsession = sessionFactory.getCurrentSession();
        //create a query...sort by the last name
        Query theQuery = currentsession.createQuery("from Customer order by sumOfDeposit");
        //execute query and get result list

        List<Customer> customers = theQuery.list();


        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //save customer to the DB

        currentSession.saveOrUpdate(theCustomer);


    }

    @Override
    public Customer getCustomer(int theId) {
        //get the current hibernate session

        Session currentSession = sessionFactory.getCurrentSession();

        //retreive the object from the DB using the primaty ID

        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        //get the current hiber session

        Session currennSession = sessionFactory.getCurrentSession();

        //delete the object with the ptimary ID

        Customer theCustomer = currennSession.get(Customer.class, theId);
        currennSession.delete(theCustomer);

    }

    @Override
    public List<Customer> searchCustomers(Integer theSearchName) {
        //get the current hiber session

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        // only search by name if theSearchName is not empty

        if(theSearchName !=null){
            // search for firstName or lastName ... case insensitive
            theQuery=currentSession.createQuery
                    ("from Customer where playerId =:playerId");
            theQuery.setParameter("playerId", theSearchName);

        }else{
            // theSearchName is empty  just get all customers
            theQuery=currentSession.createQuery("from Customer order by playerId");
        }

        // execute query and get result list

        List<Customer> customers = theQuery.list();


        return customers;
    }
}
