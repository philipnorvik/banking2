package co.devskills.app;

import co.devskills.app.dto.AccountResponse;
import co.devskills.app.dto.TransactionRequest;
import co.devskills.app.dto.TransactionResponse;
import co.devskills.app.model.Account;
import co.devskills.app.model.Activity;
import co.devskills.app.repository.BankService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class DefaultController {



    @Autowired
    BankService bankService;

    public DefaultController() {
    }

    @GetMapping(value = "/ping")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Healthcheck to make sure the service is up.",
            notes = "Healthcheck to make sure the service is up.")
    public String healthCheck(){
        return "pong";
    }


    @PostMapping(value = "/transactions")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get transactions",
            notes = "Get transactions")
    public TransactionResponse transactions(@RequestBody TransactionRequest transactionRequest) {
        Activity transaction = bankService.saveTransaction(transactionRequest);
        return new TransactionResponse(transaction.getTransactionId(),transaction.getAccount().getAccountId(),transaction.getAmount());
    }

    @GetMapping(value = "/transactions")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get transactions",
            notes = "Get transactions")
    public List<TransactionResponse> transactions(){
        return bankService.getAllTransactions().stream().map(t -> new TransactionResponse(t.getTransactionId(),t.getAccount().getAccountId(),t.getAmount())).collect(Collectors.toList());
    }

    @GetMapping(value = "/transactions/{transaction_id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "/transactions/{transaction_id}",
            notes = "/transactions/{transaction_id}")
    public TransactionResponse transaction(String transaction_id){
        Activity transaction = bankService.getTransaction(UUID.fromString(transaction_id));
        return new TransactionResponse(transaction.getTransactionId(),transaction.getAccount().getAccountId(),transaction.getAmount());
    }

    @GetMapping(value = "/accounts/{account_id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns the account data.",
            notes = "Returns the account data.")
    public AccountResponse accounts(String account_id){
        Account account = bankService.getAccount(UUID.fromString(account_id));
        return new AccountResponse(account.getAccountId(),account.getBalance());
    }
}
