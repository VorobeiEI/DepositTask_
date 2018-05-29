package DAO;


import entity.Deposit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;

@Repository
public class PlayerDAOImpl implements PlayerDao {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Deposit> getCustomers() {

        Session currentsession = sessionFactory.getCurrentSession();
        Query theQuery = currentsession.createQuery("from Deposit order by sumOfDeposit");

        List<Deposit> customers = theQuery.list();


        return customers;
    }

    @Override
    public void saveCustomer(Deposit theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Deposit getCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Deposit theCustomer = currentSession.get(Deposit.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        //get the current hiber session

        Session currennSession = sessionFactory.getCurrentSession();

        //delete the object with the ptimary ID

        Deposit theCustomer = currennSession.get(Deposit.class, theId);
        currennSession.delete(theCustomer);

    }

    @Override
    public List<Deposit> searchCustomers(Integer theSearchPlayerId) {
        //get the current hiber session

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        // only search by name if theSearchName is not empty

        if (theSearchPlayerId != null) {
            // search for firstName or lastName ... case insensitive
            theQuery = currentSession.createQuery
                    ("from Deposit where playerId =:playerId");
            theQuery.setParameter("playerId", theSearchPlayerId);

        } else {
            // theSearchName is empty  just get all customers
            theQuery = currentSession.createQuery("from Deposit order by playerId");
        }

        // execute query and get result list

        List<Deposit> customers = theQuery.list();


        return customers;
    }

    @Override
    public BigDecimal sumOfExactCustomerDeposits(Integer theSearchPlayerId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        if (theSearchPlayerId != null) {
            theQuery = currentSession.createQuery("select sum(sumOfDeposit) from Deposit where playerId =:playerId");
            theQuery.setParameter("playerId", theSearchPlayerId);
        } else {
            theQuery = currentSession.createQuery("select sum(sumOfDeposit) from Deposit");
        }

        BigDecimal sum = (BigDecimal) theQuery.uniqueResult();

        return sum;
    }
}
