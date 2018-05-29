package service;

import DAO.PlayerDao;
import entity.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Override
    @Transactional
    public List<Deposit> getCustomers() {
        return playerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Deposit theCustomer) {

        playerDao.saveCustomer(theCustomer);

    }

    @Override
    @Transactional
    public Deposit getCustomer(int theId) {

        return playerDao.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        playerDao.deleteCustomer(theId);
    }

    @Override
    @Transactional
    public List<Deposit> searchCustomers(Integer theSearchName) {
        return playerDao.searchCustomers(theSearchName);
    }

    @Override
    @Transactional
    public BigDecimal sumOfExactCustomerDeposits(Integer playerId) {
        return playerDao.sumOfExactCustomerDeposits(playerId);
    }
}
