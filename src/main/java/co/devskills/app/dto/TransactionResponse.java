package co.devskills.app.dto;

import java.util.UUID;

public class TransactionResponse {
    private UUID transaction_id;
    private UUID account_id;
    private long amount;

    public UUID getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(UUID transaction_id) {
        this.transaction_id = transaction_id;
    }

    public UUID getAccount_id() {
        return account_id;
    }

    public void setAccount_id(UUID account_id) {
        this.account_id = account_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public TransactionResponse(UUID transaction_id, UUID account_id, long amount) {
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.amount = amount;
    }
}
