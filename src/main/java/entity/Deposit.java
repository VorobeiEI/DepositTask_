package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "playerId")
    private int playerId;

    @Column(name = "date")
    private Date date;

    @Column(name = "sumOfDeposit")
    private BigDecimal sumOfDeposit;


    public Deposit() {
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

    public BigDecimal getDeposit() {
        return sumOfDeposit;
    }

    public void setDeposit(BigDecimal sumOfdeposit) {
        this.sumOfDeposit = sumOfdeposit;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "playerId=" + playerId +
                ", date='" + date + '\'' +
                ", lastName='" + sumOfDeposit + '\'' +
                '}';
    }
}
