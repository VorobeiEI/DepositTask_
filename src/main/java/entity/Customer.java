package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by JackSparrow on 5/3/2017.
 */
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private int playerId;

    @Column(name = "date")
    private Date date;

    @Column(name = "sum_of_deposit")
    private BigDecimal sumOfDeposit;


    public Customer() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getSumOfDeposit() {
        return sumOfDeposit;
    }

    public void setSumOfDeposit(BigDecimal sumOfDeposit) {
        this.sumOfDeposit = sumOfDeposit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + date + '\'' +
                ", lastName='" + sumOfDeposit + '\'' +
                '}';
    }
}
