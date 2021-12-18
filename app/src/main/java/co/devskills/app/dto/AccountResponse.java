package co.devskills.app.dto;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.UUID;


@JsonTypeName("Account")
public class AccountResponse {
    private UUID accountId;
    private int balance;

    @JsonProperty("account_id")
    public UUID getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    public AccountResponse(UUID accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
}
