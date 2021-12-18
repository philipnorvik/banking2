package co.devskills.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

//cant be named Transaction becouse of sql statements
@Entity
public class Activity implements Serializable {

    @Id
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column
    private int amount;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    public UUID getTransactionId() {
        return UUID.fromString(transactionId);
    }

    public Account getAccount() {
        return account;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Activity(Account account, int amount) {
        this.account= account;
        this.amount = amount;
        this.transactionId = UUID.randomUUID().toString();
    }

    public Activity() {
    }
}
