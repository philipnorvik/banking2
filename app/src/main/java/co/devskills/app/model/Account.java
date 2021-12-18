package co.devskills.app.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Account implements Serializable {
    @Id
    private String accountId;

    @Column
    private int balance;


    public int getBalance() {
        return balance;
    }

    public Account(String accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public UUID getAccountId() {
        return UUID. fromString(accountId);
    }

    public Account() {
        this.accountId = UUID.randomUUID().toString();
    }
}
