package co.devskills.app.dto;

import java.util.UUID;

public class TransactionRequest {
    private UUID account_id;
    private int amount;

    public UUID getAccount_id() {
        return account_id;
    }

    public void setAccount_id(UUID account_id) {
        this.account_id = account_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
