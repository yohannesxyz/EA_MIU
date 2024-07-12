package bank.integration.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AccountChangeEvent {
@Id
@GeneratedValue
    private long id;

    private Date date;
    private double amount;
    private String description;
    private String fromAccountNumber;
    private String toAccountNumber;

    public AccountChangeEvent() {
    }

    public AccountChangeEvent( double amount, String description
                       ) {


        this.amount = amount;
        this.description = description;

    }

    public AccountChangeEvent( double amount, String description, String fromAccountNumber, String toAccountNumber
            ) {

        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }


}
